package shop.daqian.video.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/8 10:43
 */
@Data
public class Category implements Serializable {
    private Integer categoryId; //类别id
    private String categoryName; //类别名

}
