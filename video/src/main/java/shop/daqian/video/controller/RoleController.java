package shop.daqian.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.Role;
import shop.daqian.video.mapper.RoleMapper;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/9 14:49
 */
@CrossOrigin
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleMapper roleMapper;

    /**
     * 获取权限
     * @return
     */
    @GetMapping
    public List<Role> getRoles(){
        return roleMapper.getRoles();
    }

    @GetMapping("{uid}")
    public List<Role> findRoleByUid(@PathVariable("uid")String uid){
        System.out.println(uid);
        System.out.println(roleMapper.findRoleByUid(uid));
        return roleMapper.findRoleByUid(uid);
    }

}
