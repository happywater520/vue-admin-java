package gj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import gj.util.remark.Remark;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@TableName("student")
public class StudentEntity {
    @TableId(value = "student_id", type = IdType.AUTO)
    @Remark("主键")
    private Integer id;

    @Remark("学号")
    @TableField("student_number")
    private String number;

    @Remark("学生姓名")
    @TableField("student_name")
    private String name;

    @Remark("密码")
    @TableField("student_password")
    private String password;

    @Remark("性别")
    @TableField("student_sex")
    private Integer sex;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
