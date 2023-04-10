package gj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import gj.util.remark.Remark;

import java.time.LocalDateTime;

@TableName("class_score")
public class ClassScoreEntity {

    @TableId(value = "id", type = IdType.AUTO)
    @Remark("主键")
    private Integer id;
    @Remark("分数")
    private Integer score;
    @Remark("申请理由")
    private String reason;
    @Remark("班级id")
    @TableField("class_id")
    private Integer classId;
    @Remark("学生id")
    @TableField("student_id")
    private Integer studentId;

    @Remark("提交时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Remark("状态 0 未审核 1 未通过 2 通过")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
