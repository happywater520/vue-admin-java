package gj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import gj.util.remark.Remark;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@TableName("admin")
public class AdminEntity {

    @NotNull
    @TableId(value = "admin_id", type = IdType.AUTO)
    @Remark("主键")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @TableField("admin_username")
    @Remark("用户名")
    private String username;

    @NotNull
    @Remark("密码")
    @TableField("admin_password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
