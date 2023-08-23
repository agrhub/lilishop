package cn.lili.modules.file.serviceimpl;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import cn.lili.common.enums.OssType;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.common.security.AuthUser;
import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.SearchVO;
import cn.lili.modules.file.entity.File;
import cn.lili.modules.file.entity.dto.FileOwnerDTO;
import cn.lili.modules.file.mapper.FileMapper;
import cn.lili.modules.file.plugin.FileManagerPlugin;
import cn.lili.modules.file.plugin.impl.AliFileManagerPlugin;
import cn.lili.modules.file.plugin.impl.MinioFileManagerPlugin;
import cn.lili.modules.file.service.FileService;
import cn.lili.modules.system.entity.dos.Setting;
import cn.lili.modules.system.entity.dto.OssSetting;
import cn.lili.modules.system.entity.enums.SettingEnum;
import cn.lili.modules.system.service.SettingService;
import cn.lili.mybatis.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件管理业务层实现
 *
 * @author Chopper
 * @since 2020/11/26 17:50
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    @Autowired
    private SettingService settingService;
    private AliFileManagerPlugin aliFileManagerPlugin = new AliFileManagerPlugin();
    private MinioFileManagerPlugin minioFileManagerPlugin = new MinioFileManagerPlugin();

    @Override
    public FileManagerPlugin getFileManagerPlugin(){
        OssSetting ossSetting = getOssSetting();
        if(ossSetting.getOssType() == OssType.MINIO.value()){
            return minioFileManagerPlugin;
        }
        else{
            return aliFileManagerPlugin;
        }
    }

    @Override
    public OssSetting getOssSetting() {
        Setting setting = settingService.get(SettingEnum.OSS_SETTING.name());
        if (setting == null || StrUtil.isBlank(setting.getSettingValue())) {
            throw new ServiceException(ResultCode.OSS_NOT_EXIST);
        }
        OssSetting ossSetting = new Gson().fromJson(setting.getSettingValue(), OssSetting.class);
        return ossSetting;
    }

    @Override
    public void batchDelete(List<String> ids) {
        FileManagerPlugin fileManager = getFileManagerPlugin();
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(File::getId, ids);

        List<File> files = this.list(queryWrapper);
        List<String> keys = new ArrayList<>();
        files.forEach(item -> keys.add(item.getFileKey()));
        fileManager.deleteFiles(keys);
        this.remove(queryWrapper);
    }

    @Override
    public void batchDelete(List<String> ids, AuthUser authUser) {
        FileManagerPlugin fileManager = getFileManagerPlugin();
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(File::getId, ids);

        queryWrapper.eq(File::getUserEnums, authUser.getRole().name());
        //操作图片属性判定
        switch (authUser.getRole()) {
            case MEMBER:
                queryWrapper.eq(File::getOwnerId, authUser.getId());
                break;
            case STORE:
                queryWrapper.eq(File::getOwnerId, authUser.getStoreId());
                break;
            case MANAGER:
                break;
            default:
                throw new ServiceException(ResultCode.USER_AUTHORITY_ERROR);
        }
        List<File> files = this.list(queryWrapper);
        List<String> keys = new ArrayList<>();
        files.forEach(item -> keys.add(item.getFileKey()));
        fileManager.deleteFiles(keys);
        this.remove(queryWrapper);
    }

    @Override
    public IPage<File> customerPage(File file, SearchVO searchVO, PageVO pageVo) {
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(CharSequenceUtil.isNotEmpty(file.getName()), File::getName, file.getName())
                .like(CharSequenceUtil.isNotEmpty(file.getFileKey()), File::getFileKey, file.getFileKey())
                .like(CharSequenceUtil.isNotEmpty(file.getFileType()), File::getFileType, file.getFileType())
                .between(CharSequenceUtil.isNotEmpty(searchVO.getStartDate()) && CharSequenceUtil.isNotEmpty(searchVO.getEndDate()),
                        File::getCreateTime, searchVO.getStartDate(), searchVO.getEndDate());
        return this.page(PageUtil.initPage(pageVo), queryWrapper);
    }

    @Override
    public IPage<File> customerPageOwner(FileOwnerDTO ownerDTO, File file, SearchVO searchVO, PageVO pageVo) {
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CharSequenceUtil.isNotEmpty(ownerDTO.getOwnerId()), File::getOwnerId, ownerDTO.getOwnerId())
                .eq(File::getUserEnums, ownerDTO.getUserEnums())
                .like(CharSequenceUtil.isNotEmpty(file.getName()), File::getName, file.getName())
                .like(CharSequenceUtil.isNotEmpty(file.getFileKey()), File::getFileKey, file.getFileKey())
                .like(CharSequenceUtil.isNotEmpty(file.getFileType()), File::getFileType, file.getFileType())
                .between(CharSequenceUtil.isNotEmpty(searchVO.getStartDate()) && CharSequenceUtil.isNotEmpty(searchVO.getEndDate()),
                        File::getCreateTime, searchVO.getStartDate(), searchVO.getEndDate());
        return this.page(PageUtil.initPage(pageVo), queryWrapper);
    }
}