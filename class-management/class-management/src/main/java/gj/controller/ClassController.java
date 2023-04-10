package gj.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gj.entity.ClassEntity;
import gj.entity.StudentClassEntity;
import gj.service.ClassService;
import gj.service.StudentClassService;
import gj.util.formatting.ServiceResponseBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Resource
    private ClassService classService;

    @Resource
    private StudentClassService studentClassService;

    @RequestMapping("create")
    public ServiceResponseBody create(@RequestBody ClassEntity entity) {
        classService.save(entity);
        return ServiceResponseBody.successMessage("创建成功");
    }

    @PutMapping
    public ServiceResponseBody update(@RequestBody @Validated ClassEntity entity) {
        classService.updateById(entity);
        return ServiceResponseBody.successMessage("更新成功");
    }

    @RequestMapping("studentClass")
    public ServiceResponseBody studentClass(Integer pageIndex, Integer pageSize, Integer studentId) {
        return ServiceResponseBody.success(classService.studentClass(new Page<>(pageIndex, pageSize), studentId));
    }

    @RequestMapping("getAddClassPage")
    public ServiceResponseBody getAddClassPage(Integer pageIndex, Integer pageSize, Integer studentId, String name, String teacherName) {
        return ServiceResponseBody.success(classService.getAddClassPage(new Page<>(pageIndex, pageSize), studentId));
    }

    @RequestMapping("addToClass")
    public ServiceResponseBody addToClass(@RequestBody StudentClassEntity studentClassEntity) {
        studentClassService.save(studentClassEntity);
        return ServiceResponseBody.successMessage("加入成功！");
    }

    @RequestMapping("teacherClass")
    public ServiceResponseBody teacherClass(Integer pageIndex, Integer pageSize, Integer teacherId, String name) {
        return ServiceResponseBody.success(classService.teacherClass(new Page<>(pageIndex, pageSize), teacherId, name));
    }

    @RequestMapping("classStudent")
    public ServiceResponseBody classStudent(Integer classId) {
        return ServiceResponseBody.success(classService.classStudent(classId));
    }

    @RequestMapping("addClassStudent")
    public ServiceResponseBody addClassStudent(Integer classId) {
        return ServiceResponseBody.success(classService.addClassStudent(classId));
    }

    @RequestMapping("classScore")
    public ServiceResponseBody classScore(Integer classId, String studentName) {
        return ServiceResponseBody.success(classService.classScore(classId, studentName));
    }

    @RequestMapping("addStudent")
    public ServiceResponseBody addStudent(@RequestBody List<StudentClassEntity> studentIds) {
        studentIds.forEach(studentClassEntity -> studentClassService.save(studentClassEntity));
        return ServiceResponseBody.success();
    }

    @RequestMapping("updateValues")
    public ServiceResponseBody updateValues(@RequestBody ClassEntity classEntity) {
        classService.update(new LambdaUpdateWrapper<ClassEntity>()
                .eq(ClassEntity::getId, classEntity.getId())
                .set(ClassEntity::getValue, classEntity.getValue()));
        return ServiceResponseBody.success();
    }

    @RequestMapping("adminClass")
    public ServiceResponseBody adminClass(Integer pageIndex, Integer pageSize, String name, String teacherName) {
        return ServiceResponseBody.success(classService.adminClass(new Page<>(pageIndex, pageSize), name, teacherName));
    }

}
