package shop.daqian.video.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.Video;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/8 16:25
 */
@Repository
public interface VideoMapper {


    /**
     * 获取视频（联合查询）全部信息接口
     * @return
     */
    @Select("<script>"+"select * from video"
            +"<if test='title!=null'>where title like CONCAT('%',#{title},'%')</if>"
            +"order by video_id</script>"
    )
    @Results(id = "videoCategoryMap",value = {
            @Result(id = true,column = "video_id",property = "videoId"),
            @Result(property = "categories",column = "video_id",many = @Many(select =
                    "shop.daqian.video.mapper.CategoryMapper.findCategoryByVid",fetchType = FetchType.LAZY)),
            @Result(property = "videoTypes",column = "video_id",many = @Many(select =
                    "shop.daqian.video.mapper.VideoTypeMapper.findUrlByVid",fetchType = FetchType.LAZY))
    })
    List<Video> getVideoAll(String keyword);

    @Select("select * from video where video_id in (select * from banner)")
    @Results(id = "videoCategoryMap1",value = {
            @Result(id = true,column = "video_id",property = "videoId"),
            @Result(property = "categories",column = "video_id",many = @Many(select =
                    "shop.daqian.video.mapper.CategoryMapper.findCategoryByVid",fetchType = FetchType.LAZY)),
            @Result(property = "videoTypes",column = "video_id",many = @Many(select =
                    "shop.daqian.video.mapper.VideoTypeMapper.findUrlByVid",fetchType = FetchType.LAZY))
    })
    List<Video> getVideoByBanner();

    /**
     * 视频实体类添加接口
     * @param video
     */
    @Transactional
    @Insert("insert into video(image,title,region,create_time,upload_time,content,director,category,user_id) " +
            "VALUES(#{image},#{title},#{region},#{createTime},CURRENT_TIME,#{content},#{director},#{category},#{userId})")
    void save(Video video);
}
