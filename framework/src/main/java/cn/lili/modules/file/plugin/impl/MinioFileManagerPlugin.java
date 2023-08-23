package cn.lili.modules.file.plugin.impl;

import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.modules.system.entity.dto.OssSetting;
import io.minio.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class MinioFileManagerPlugin extends FileManagerPluginImpl {

    /**
     * 获取oss client
     *
     * @return
     */
    private MinioClient getOssClient() {
        OssSetting ossSetting = getSetting();

        MinioClient minioClient = MinioClient.builder().endpoint(ossSetting.getEndPoint())
                .credentials(ossSetting.getAccessKeyId(), ossSetting.getAccessKeySecret())
                .build();
        try{
            if(!minioClient.bucketExists(BucketExistsArgs.builder().bucket(ossSetting.getBucketName()).build())) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(ossSetting.getBucketName()).build());
            }
        }catch (Exception e){

        }

        return minioClient;
    }

    /**
     * 获取配置前缀
     *
     * @return
     */
    private String getUrlPrefix() {
        OssSetting ossSetting = getSetting();
        return ossSetting.getEndPoint() + "/" + ossSetting.getBucketName() + "/";
    }

    @Override
    public String pathUpload(String filePath, String key) {
        return null;
    }

    @Override
    public String inputStreamUpload(InputStream inputStream, String key, String contentType) {
        OssSetting ossSetting = getSetting();
        MinioClient minioClient = getOssClient();
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(ossSetting.getBucketName())
                            .contentType(contentType)
                            .stream(inputStream, inputStream.available(), -1)
                            .object(key)
                            .build()
            );

        } catch (Exception e) {
            log.error("minio上传文件错误：", e);
            return null;
        } finally {
        }
//        try{
//            StatObjectResponse statObjectResponse =
//                    minioClient.statObject(
//                            StatObjectArgs.builder()
//                                    .bucket(ossSetting.getBucketName())
//                                    .object(key).build()
//                    );
//        }catch (Exception e){
//
//        }

        return getUrlPrefix() + key;
    }

    @Override
    public void deleteFiles(List<String> keys) {
        OssSetting ossSetting = getSetting();
        MinioClient ossClient = getOssClient();

        try {
            for(String key : keys){
                try{
                    ossClient.removeObject(RemoveObjectArgs.builder().object(key).bucket(ossSetting.getBucketName()).build());
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            log.error("minio上传文件错误：", e);
            throw new ServiceException(ResultCode.OSS_DELETE_ERROR);
        }
    }

    /**
     * 删除文件
     *
     * @param objectName 文件名称
     * @throws Exception https://docs.minio.io/cn/java-client-api-reference.html#removeObject
     */
    @Override
    public void deleteFile(String objectName) {
        OssSetting ossSetting = getSetting();
        MinioClient minioClient = getOssClient();
        try{
            minioClient.removeObject(RemoveObjectArgs.builder().object(objectName).bucket(ossSetting.getBucketName()).build());
        }catch (Exception e){

        }
    }

    /**
     * 获得上传的URL
     * @param objectName
     */
    public String getPresignedObjectUrl(String objectName){
        OssSetting ossSetting = getSetting();
        MinioClient minioClient = getOssClient();
        try {
            String presignedObjectUrl = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder().bucket(ossSetting.getBucketName()).object(objectName).expiry(10, TimeUnit.MINUTES).method(Method.PUT).build());
            return presignedObjectUrl;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(ResultCode.OSS_EXCEPTION_ERROR);
        }
    }
}
