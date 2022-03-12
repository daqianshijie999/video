package shop.daqian.video.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author daqian
 * @create 2022/1/20 16:33
 */
@Component
public class QiNiuConfigBean {

    private static String accessKey ="hIRXrHaR-dHFrylIjllFVTRp9AplX-E9c9u_eAaR";
    private static String secretKey ="dYdGMbSYpVjTuPgAkrjU9XNbaLapU8N4IhGsFO7I";

    private static String imgBucket = "img-daqian";
    private static String imgDomain = "img.daqian.shop";

    private static String videoBucket = "Video-daqian";
    private static String videoDomain = "Video.daqian.shop";
    private static String protocol = "http://";

    public static String getAccessKey() {
        return accessKey;
    }

    public static void setAccessKey(String accessKey) {
        QiNiuConfigBean.accessKey = accessKey;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public static void setSecretKey(String secretKey) {
        QiNiuConfigBean.secretKey = secretKey;
    }

    public static String getImgBucket() {
        return imgBucket;
    }

    public static void setImgBucket(String imgBucket) {
        QiNiuConfigBean.imgBucket = imgBucket;
    }

    public static String getImgDomain() {
        return imgDomain;
    }

    public static void setImgDomain(String imgDomain) {
        QiNiuConfigBean.imgDomain = imgDomain;
    }

    public static String getVideoBucket() {
        return videoBucket;
    }

    public static void setVideoBucket(String videoBucket) {
        QiNiuConfigBean.videoBucket = videoBucket;
    }

    public static String getVideoDomain() {
        return videoDomain;
    }

    public static void setVideoDomain(String videoDomain) {
        QiNiuConfigBean.videoDomain = videoDomain;
    }

    public static String getProtocol() {
        return protocol;
    }

    public static void setProtocol(String protocol) {
        QiNiuConfigBean.protocol = protocol;
    }
}
