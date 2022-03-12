package shop.daqian.video.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.Banner;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/3/10 10:04
 */

@Repository
public interface BannerMapper {

    @Transactional
    @Insert("<script>"+"insert into banner(video_id) VALUES" +
            "<foreach collection='lists' item='item' index='index' separator=','>" +
            "(#{item.videoId}) </foreach>"+
            "</script>")
    void save(@Param("lists") List<Banner> lists);

    @Select("select * from banner order by video_id")
    List<Banner> getBannerList();

    @Transactional
    @Delete("delete from banner where video_id in (${ids})")
    void deleteBannerById(String ids);


}
