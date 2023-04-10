package gj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import gj.util.remark.Remark;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("class")
public class ClassEntity {

    @TableId(value = "class_id", type = IdType.AUTO)
    @Remark("主键")
    private Integer id;

    @TableField("teacher_id")
    @Remark("任课老师id")
    private Integer teacherId;


    @Remark("班级名称")
    @TableField("class_name")
    private String name;

    @Remark("课堂情况")
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
