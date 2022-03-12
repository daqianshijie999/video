package shop.daqian.video.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author daqian
 * @create 2022/2/21 20:15
 */
@Data
public class Type implements Serializable {
    private Integer typeId; //类型id
    private String typeName; //类型name

}
