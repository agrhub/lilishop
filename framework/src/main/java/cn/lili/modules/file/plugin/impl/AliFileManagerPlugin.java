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
import cn.lili.modules.system.serviceimpl.SettingServiceImpl;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 阿里oss 文件操作
 *
 * @author Chopper
 */

@Component
@Slf4j
public class AliFileManagerPlugin extends FileManagerPluginImpl {

    /**
     * 获取oss client
     *
     * @return
     */
    private OSS getOssClient() {
        OssSetting ossSetting = getSetting();

        return new OSSClientBuilder().build(
                ossSetting.getEndPoint(),
                ossSetting.getAccessKeyId(),
                ossSetting.getAccessKeySecret());
    }

    /**
     * 获取配置前缀
     *
     * @return
     */
    private String getUrlPrefix() {
        OssSetting ossSetting = getSetting();
        return "https://" + ossSetting.getBucketName() + "." + ossSetting.getEndPoint() + "/";
    }

    @Override
    public String pathUpload(String filePath, String key) {
        OSS ossClient = getOssClient();
        try {
            ossClient.putObject(getSetting().getBucketName(), key, new File(filePath));
        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message: " + oe.getErrorMessage());
            log.error("Error Code:       " + oe.getErrorCode());
            log.error("Request ID:      " + oe.getRequestId());
            log.error("Host ID:           " + oe.getHostId());
            throw new ServiceException(ResultCode.OSS_EXCEPTION_ERROR);
        } catch (ClientException ce) {
            log.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message: " + ce.getMessage());
            throw new ServiceException(ResultCode.OSS_EXCEPTION_ERROR);
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            ossClient.shutdown();
        }
        ossClient.shutdown();
        return getUrlPrefix() + key;
    }

    @Override
    public String inputStreamUpload(InputStream inputStream, String key, String contentType) {
        OSS ossClient = getOssClient();
        try {
            ObjectMetadata meta = new ObjectMetadata();
            if(contentType == null){
                contentType = "image/jpg";
            }
            meta.setContentType(contentType);
            ossClient.putObject(getSetting().getBucketName(), key, inputStream, meta);
        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message: " + oe.getErrorMessage());
            log.error("Error Code:       " + oe.getErrorCode());
            log.error("Request ID:      " + oe.getRequestId());
            log.error("Host ID:           " + oe.getHostId());
            throw new ServiceException(ResultCode.OSS_EXCEPTION_ERROR);
        } catch (ClientException ce) {
            log.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message: " + ce.getMessage());
            throw new ServiceException(ResultCode.OSS_EXCEPTION_ERROR);
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            ossClient.shutdown();
        }
        ossClient.shutdown();
        return getUrlPrefix() + key;
    }

    @Override
    public void deleteFiles(List<String> keys) {
        OSS ossClient = getOssClient();

        try {
            ossClient.deleteObjects(
                    new DeleteObjectsRequest(getSetting().getBucketName()).withKeys(keys));
        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message: " + oe.getErrorMessage());
            log.error("Error Code:       " + oe.getErrorCode());
            log.error("Request ID:      " + oe.getRequestId());
            log.error("Host ID:           " + oe.getHostId());
            throw new ServiceException(ResultCode.OSS_DELETE_ERROR);
        } catch (ClientException ce) {
            log.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message: " + ce.getMessage());
            throw new ServiceException(ResultCode.OSS_DELETE_ERROR);
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            ossClient.shutdown();
        }
    }

    @Override
    public void deleteFile(String key) {
        OSS ossClient = getOssClient();

        try {
            ossClient.deleteObject(
                    new DeleteObjectsRequest(getSetting().getBucketName()).withKey(key));
        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message: " + oe.getErrorMessage());
            log.error("Error Code:       " + oe.getErrorCode());
            log.error("Request ID:      " + oe.getRequestId());
            log.error("Host ID:           " + oe.getHostId());
            throw new ServiceException(ResultCode.OSS_DELETE_ERROR);
        } catch (ClientException ce) {
            log.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message: " + ce.getMessage());
            throw new ServiceException(ResultCode.OSS_DELETE_ERROR);
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            ossClient.shutdown();
        }
    }
}
