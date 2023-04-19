package gj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import gj.util.remark.Remark;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("teacher")
public class TeacherEntity {

    @NotNull
    @Remark("主键")
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer id;

//    @Length(min = 12, max = 12, message = "工号长度必须为12位")
    @TableField("teacher_number")
    @Remark("工号")
    private String number;

    @NotBlank(message = "教师姓名不能为空")
    @TableField("teacher_name")
    @Remark("教师姓名")
    private String name;

    @NotNull
    @Remark("密码")
    @TableField("teacher_password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
