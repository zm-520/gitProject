package zm.demo.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * APP用户表(AppUser)表实体类
 *
 * @author makejava
 * @since 2023-03-03 14:16:42
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("app_user")
public class AppUser  {
    @TableId
    private String id;

    //用户名昵称
    private String name;
    //邮箱
    private String email;
    //手机号
    private String phone;
    //性别(0：男; 1:女)
    private String gender;
    //密码
    private String password;
    //年龄
    private Integer age;
    
    private Date createTime;
    
    private Date updateTime;



}


