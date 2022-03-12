package shop.daqian.video.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author daqian
 * @create 2022/2/9 14:37
 */
@Data
public class Role implements Serializable {
    private Integer roleId; //角色id
    private String roleName; //角色名
    private String roleAuthority; //角色权限

}
