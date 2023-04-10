package gj.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import gj.entity.StudentClassEntity;
import gj.service.StudentClassService;
import gj.util.formatting.ServiceResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/studentClass")
public class StudentClassController {

    @Resource
    private StudentClassService studentClassService;

    @RequestMapping("dropOutOfClass")
    public ServiceResponseBody dropOutOfClass(Integer studentId, Integer classId) {
        studentClassService.remove(new LambdaQueryWrapper<StudentClassEntity>()
                .eq(StudentClassEntity::getStudentId, studentId)
                .eq(StudentClassEntity::getClassId, classId));
        return ServiceResponseBody.successMessage("退班成功！");
    }
}
