package shop.daqian.video.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author daqian
 * @create 2021/12/31 10:42
 */
@Data
//@TableName("user")
public class User implements Serializable {
//    @TableId(type = IdType.AUTO)
    private Integer userId; //用户id
//    @TableField(value = "account")
    private String account; //用户账号唯一
    private String password; //用户密码
    private String email; //用户邮箱
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date registerTime; //用户注册时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date lastLoginTime; //最后登录时间
    private int status; //用户状态
    private Integer telephone; //用户电话
    private List<Role> roles; //拥有的角色
}
