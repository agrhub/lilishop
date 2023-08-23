package cn.lili.modules.file.plugin.impl;

import cn.hutool.core.util.StrUtil;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.common.utils.SpringContextUtil;
import cn.lili.modules.file.plugin.FileManagerPlugin;
import cn.lili.modules.system.entity.dos.Setting;
import cn.lili.modules.system.entity.dto.OssSetting;
import cn.lili.modules.system.entity.enums.SettingEnum;
import cn.lili.modules.system.service.SettingService;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.List;

public class FileManagerPluginImpl implements FileManagerPlugin {
    /**
     * 下一个初始化配置参数的时间
     * 这里为了防止多次调用redis，减少与redis的交互时间
     */
    private static Long nextInitSetting;

    /**
     * 暂时设定3分账请求一次设置
     */
    private static final Long INTERVAL = 60 * 3 * 1000L;

    /**
     * 静态设置，最快三分钟更新一次
     */
    private static OssSetting ossSetting;

    /**
     * 获取配置
     *
     * @return
     */
    protected OssSetting getSetting() {
        //如果没有配置，或者没有下次刷新时间，或者下次刷新时间小于当前时间，则从redis 更新一次
        SettingService settingService = (SettingService) SpringContextUtil.getBean("settingServiceImpl");
        if (ossSetting == null || nextInitSetting == null || nextInitSetting < System.currentTimeMillis()) {
            Setting setting = settingService.get(SettingEnum.OSS_SETTING.name());
            if (setting == null || StrUtil.isBlank(setting.getSettingValue())) {
                throw new ServiceException(ResultCode.OSS_NOT_EXIST);
            }
            nextInitSetting = System.currentTimeMillis() + INTERVAL;
            ossSetting = new Gson().fromJson(setting.getSettingValue(), OssSetting.class);
            return ossSetting;
        }
        return ossSetting;
    }

    @Override
    public String pathUpload(String filePath, String key) {
        return null;
    }

    @Override
    public String inputStreamUpload(InputStream inputStream, String key, String contentType) {
        return null;
    }

    @Override
    public void deleteFiles(List<String> keys) {

    }

    @Override
    public void deleteFile(String key) {

    }
}
