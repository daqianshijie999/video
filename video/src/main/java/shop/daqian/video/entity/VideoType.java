package shop.daqian.video.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author daqian
 * @create 2022/2/21 21:41
 */
@Data
public class VideoType implements Serializable {
    private Integer videoId; //视频id
    private String url; //视频地址
    private Integer sets; //电视剧集数
    private String description; //描述
}
