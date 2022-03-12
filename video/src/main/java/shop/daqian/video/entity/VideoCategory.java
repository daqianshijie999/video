package shop.daqian.video.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author daqian
 * @create 2022/2/8 13:12
 */
@Data
public class VideoCategory implements Serializable {
    private Integer videoId; //视频id
    private Integer categoryId; //类别id
}
