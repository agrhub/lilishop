package cn.lili.common.enums;

public enum OssType {
    /**
     * 阿里云oss
     */
    MINIO(0),

    /**
     * minio
     */
    ALI(1),
    ;

    private final Integer value;

    public Integer value() {
        return value;
    }

    OssType(Integer value) {
        this.value = value;
    }
}
