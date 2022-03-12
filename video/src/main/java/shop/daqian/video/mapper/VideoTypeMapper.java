package shop.daqian.video.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import shop.daqian.video.entity.VideoType;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/21 22:21
 */
@Repository
public interface VideoTypeMapper {
    /**
     * 根据视频id查找类型如:电影、电视剧(一对一)
     * @param vid
     * @return
     */
    @Select("select * from video_type where video_id=#{vid}")
    List<VideoType> findUrlByVid(int vid);

//    select count(*) from video_type where video_id = 3
    @Select("select * from video_type where video_id=#{vid}")
    int findCountByVid(int vid);

}
