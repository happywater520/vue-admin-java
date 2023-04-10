package gj.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gj.entity.TeacherEntity;
import gj.service.TeacherService;
import gj.util.formatting.ServiceResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping("page")
    public ServiceResponseBody page(Integer pageIndex, Integer pageSize, String teacherName) {
        LambdaQueryWrapper<TeacherEntity> eq = new LambdaQueryWrapper<>();
        if (teacherName != null && !teacherName.equals("")) {
            eq.eq(TeacherEntity::getName, teacherName);
        }
        return ServiceResponseBody.success(teacherService.page(new Page<>(pageIndex, pageSize), eq));
    }

    @RequestMapping("save")
    public ServiceResponseBody save(@RequestBody TeacherEntity teacherEntity) {
        teacherService.saveOrUpdate(teacherEntity);
        return ServiceResponseBody.successMessage("新增成功");
    }

    @RequestMapping("delete")
    public ServiceResponseBody delete(Integer id) {
        teacherService.removeById(id);
        return ServiceResponseBody.successMessage("删除成功");
    }

}
