package shop.daqian.video.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.Category;
import shop.daqian.video.mapper.CategoryMapper;
import shop.daqian.video.utils.ResultUtil;

import java.util.List;

/**
 * 视频类别
 * @Author daqian
 * @create 2022/2/8 10:51
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
//    @Qualifier("categoryMapper")
    CategoryMapper categoryMapper;

    /**
     * 获取全部视频类别
     * @return
     */
    @GetMapping
    public List<Category> getVideoCategories(){
    return categoryMapper.getVideoCategories();
}

    /**
     * 添加视频类别
     * @param category
     * @return
     */
    @PostMapping
    public ResultUtil save(@Param("categoryName") String category){

        String categoryByName = categoryMapper.getCategoryByName(category);
        if (categoryByName!=null){
            return new ResultUtil(405,"类别已存在，请换一个");
        }
        try {
            categoryMapper.save(category);
        }
        catch (Exception e){
            return new ResultUtil(500,"添加视频类别失败");
        }
        return new ResultUtil(200,"添加视频类别成功");
    }

    /**
     * 通过视频id查找类别
     * @param vId
     * @return
     */
    @GetMapping("{vId}")
    public List<Category> findCategoryByVid(@PathVariable("vId")String vId){
        return categoryMapper.findCategoryByVid(vId);

    }
}
