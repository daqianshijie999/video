package shop.daqian.video.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.daqian.video.entity.Type;
import shop.daqian.video.entity.User;

import java.util.List;


/**
 * @Author daqian
 * @create 2022/2/21 20:51
 */
@Repository
public interface TypeMapper {

    @Transactional
    @Insert("insert into type(type_name) VALUE(#{typeName})")
    void save(String typeName);

    @Select("select * from type order by type_id")
    List<Type> getTypeList();

    @Transactional
    @Delete("delete from type where type_id in (${ids})")
    void deleteTypeById(String ids);

    @Transactional
    @Update("update type set type_name=#{typeName} where type_id = #{typeId}")
    void updateById(Type type);
}
