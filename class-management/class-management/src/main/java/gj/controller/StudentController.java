package gj.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gj.entity.StudentEntity;
import gj.service.StudentService;
import gj.util.formatting.ServiceResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("page")
    public ServiceResponseBody page(Integer pageIndex, Integer pageSize, String studentName) {
        LambdaQueryWrapper<StudentEntity> eq = new LambdaQueryWrapper<>();
        if (studentName != null && !studentName.equals("")) {
            eq.eq(StudentEntity::getName, studentName);
        }
        return ServiceResponseBody.success(studentService.page(new Page<>(pageIndex, pageSize), eq));
    }

    @RequestMapping("save")
    public ServiceResponseBody save(@RequestBody StudentEntity studentEntity) {
        studentService.saveOrUpdate(studentEntity);
        return ServiceResponseBody.successMessage("操作成功");
    }

    @RequestMapping("delete")
    public ServiceResponseBody delete(Integer id) {
        studentService.removeById(id);
        return ServiceResponseBody.successMessage("删除成功");
    }
}
