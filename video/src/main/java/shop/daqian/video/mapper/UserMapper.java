package shop.daqian.video.mapper;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author daqian
 * @create 2021/12/31 10:40
 */
@Repository
public interface UserMapper {

    @Select("select * from user order by user_id")
    @Results(id = "userRoleMap",value = {
            //id表示主键
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(property = "roles",column = "user_id",many = @Many(select =
                    "shop.daqian.video.mapper.RoleMapper.findRoleByUid",fetchType = FetchType.LAZY))
    })
    List<User> getUserAll();


    @Select("select account from user where account=#{account}")
    String getUserAccountByAccount(String account);

    @Transactional
    @Insert("insert into user(account,password,register_time,status) VALUES(#{account},#{password},CURRENT_TIME,0)")
    void save(User user);


    @Select(" select * from user limit #{offset},#{pageSize}")
    List<User> findByPage(Map<String,Integer> map);

    @Select("select count(user_id) from user")
    Integer countUser();

    @Transactional
    @Delete("delete from user where user_id in (${ids})")
    void deleteById(String ids);

    @Transactional
    @Update("update user set password=#{password},email=#{email},status=#{status} telephone=#{telephone} where account = #{account}")
    void updateByAccount(User user);

    @Select("select * from user where user_id = #{id}")
    User findById(Long id);
}
