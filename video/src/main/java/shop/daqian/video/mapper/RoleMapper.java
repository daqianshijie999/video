package shop.daqian.video.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.Role;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/9 14:41
 */
@Repository
public interface RoleMapper {

    @Select("select * from role ORDER BY role_id ASC")
    List<Role> getRoles();

    @Transactional
    @Insert("insert into role(role_name,role_authority) VALUES(#{roleName},#{roleAuthority})")
    void save(String categoryName);


//    //根据类别名添加类别（用判断是否存在）
//    @Select("select category_name from video_category where category_name = #{categoryName}")
//    String getCategoryByName(String categoryName);


//    @Transactional
//    @Delete("delete from user where user_id in (${ids})")
//    void deleteById(String ids);

    @Select("select * from role where role_id in (select role_id from user_role where user_id = #{uid})")
    @Results({
            @Result(id = true,column = "role_id",property = "roleId"),
            @Result(column = "role_name",property = "roleName"),
            @Result(column = "role_authority",property = "roleAuthority")
    })
    List<Role> findRoleByUid(String uid);
}
