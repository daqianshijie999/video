package shop.daqian.video.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/8 10:36
 */
@Data
//@ToString
public class Video implements Serializable {
    private Integer videoId;//视频id
    private String image;//视频封面图片地址
    private String title;//视频名称
    private String region;//视频所属地区
    private Year createTime;//视频上映时间，年
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date uploadTime;//上传时间
    private String content;//视频简介
    private String director;//导演
    private String type;//类型
    private int userId;//用户id
    private float score;//评分
    //视频所属类别（外键，多对多）
    private List<Category> categories;//视频拥有的类别s，如内地、革命
    private List<VideoType> videoTypes; //一对多（电视剧）或一对一（电影）
}
