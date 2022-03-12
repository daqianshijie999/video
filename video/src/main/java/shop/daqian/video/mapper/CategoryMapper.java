package shop.daqian.video.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.Category;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/8 10:48
 */
@Repository
public interface CategoryMapper {

    @Select("select * from category ORDER BY category_id ASC")
    List<Category> getVideoCategories();

    @Transactional
    @Insert("insert into category(category_name) VALUES(#{categoryName})")
    void save(String categoryName);


//根据类别名添加类别（用判断是否存在）
    @Select("select category_name from category where category_name = #{categoryName}")
    String getCategoryByName(String categoryName);


//    @Transactional
//    @Delete("delete from user where user_id in (${ids})")
//    void deleteById(String ids);

    /**
     * 根据视频id查找类别如:内地、革命
     * @param vid
     * @return
     */
    @Select("select * from category where category_id in (select category_id from video_category where video_id = #{vid})")
    @Results({
            @Result(id = true,column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName")
    })
    List<Category> findCategoryByVid(String vid);

}
