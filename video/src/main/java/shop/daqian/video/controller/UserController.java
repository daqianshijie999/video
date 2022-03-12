package shop.daqian.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.User;
import shop.daqian.video.mapper.UserMapper;
import shop.daqian.video.utils.ResultUtil;
import shop.daqian.video.vo.Page;
import shop.daqian.video.vo.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author daqian
 * @create 2021/12/31 10:40
 */
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserMapper userMapper;


    /**
     * 获取全部用户
     * @return
     */
    @GetMapping
    public Result getUserAll(){
        return Result.success(userMapper.getUserAll());

    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping
    public ResultUtil save(@RequestBody User user){
        String account = userMapper.getUserAccountByAccount(user.getAccount());
        if (account==null){
            userMapper.save(user);
            return new ResultUtil(200,"添加成功");
        }
        return new ResultUtil(500,"用户已存在");
    }

    /**
     * 根据用户ids删除用户（批量删除）
     * @param ids
     */
    @DeleteMapping("{ids}")
    public ResultUtil deleteUserById(@PathVariable("ids") String ids){
        try {
            userMapper.deleteById(ids);
        } catch (Exception e) {
            //出异常
            return new ResultUtil(500,"删除失败");
        }
        //2、返回结果（成功：204，失败：500）
        return new ResultUtil(200,"删除成功");

    }

    /**
     * 用户修改
     * @param param
     * @return
     */
    @PutMapping
    public ResultUtil updateByAccount(@RequestBody User param){
        String account = userMapper.getUserAccountByAccount(param.getAccount());
        if (account==null){
            return new ResultUtil(405,"用户不存在");
        }
        try {
            userMapper.updateByAccount(param);
        } catch (Exception e) {
            //出异常
            return new ResultUtil(500,"修改失败");
        }
        //2、返回结果（成功：204，失败：500）
        return new ResultUtil(200,"修改成功");

    }
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public Page<User> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        Integer offset = (pageNum - 1) * pageSize;
        Map<String,Integer> map = new HashMap<>();
        map.put("offset",offset);
        map.put("pageSize",pageSize);
        List<User> userData = userMapper.findByPage(map);
        Page<User> page = new Page<>();
        page.setData(userData);
        Integer total = userMapper.countUser();
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return page;
    }

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userMapper.findById(id);
    }


}
