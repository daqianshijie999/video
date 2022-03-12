package shop.daqian.video.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.Category;
import shop.daqian.video.entity.Type;
import shop.daqian.video.entity.User;
import shop.daqian.video.mapper.TypeMapper;
import shop.daqian.video.utils.ResultUtil;
import shop.daqian.video.vo.Result;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/21 21:02
 */
@CrossOrigin
@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    TypeMapper typeMapper;

    /**
     * 获取视频全部类型
     * @return
     */
    @GetMapping
    public List<Type> getTypeList(){
        return typeMapper.getTypeList();
    }
    /**
     * 通过视频id查找类型：如电影(一对一)
     * @param name
     * @return
     */
    @PostMapping
    public ResultUtil save(@Param("name")String name) {
        try {
            typeMapper.save(name);
            return new ResultUtil(200, "添加成功");
        } catch (Exception e) {
            return new ResultUtil(500, "用户已存在或异常");
        }
    }

    /**
     * 通过type_id批量删除type
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResultUtil deleteTypeById(@PathVariable("ids") String ids){
        try {
            typeMapper.deleteTypeById(ids);
        } catch (Exception e) {
            //出异常
            return new ResultUtil(500,"删除失败");
        }
        return new ResultUtil(200,"删除成功");
    }

    /**
     * 通过id修改类型名称
     * @param param
     * @return
     */
    @PutMapping
    public ResultUtil updateByAccount(@RequestBody Type param){
        try {
        typeMapper.updateById(param);
        } catch (Exception e) {
            return new ResultUtil(500,"修改失败");
        }
        return new ResultUtil(200,"修改成功");
    }
}
