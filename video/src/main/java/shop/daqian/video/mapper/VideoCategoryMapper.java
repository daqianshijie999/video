package shop.daqian.video.mapper;

import org.springframework.stereotype.Repository;
import shop.daqian.video.entity.VideoCategory;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/9 9:05
 */
@Repository
public interface VideoCategoryMapper {
//暂时没用
    List<VideoCategory> getVideoTransformCategories();
}
