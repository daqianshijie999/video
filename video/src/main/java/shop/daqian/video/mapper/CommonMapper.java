package shop.daqian.video.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.User;

/**
 * @Author daqian
 * @create 2022/1/24 17:37
 */
@Repository
public interface CommonMapper {
    @Select("select * from user where account=#{account} and password=#{password}")
    User login(User user);


}
