package gj.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import gj.entity.ClassScoreEntity;
import gj.service.ClassScoreService;
import gj.util.formatting.ServiceResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/classScore")
public class ClassScoreController {

    @Resource
    ClassScoreService classScoreService;

    @RequestMapping("applyClassScore")
    public ServiceResponseBody applyClassScore(@RequestBody ClassScoreEntity classScoreEntity) {
        classScoreEntity.setStatus(0);
        classScoreEntity.setCreateTime(LocalDateTime.now());
        classScoreService.save(classScoreEntity);
        return ServiceResponseBody.successMessage("申请成功！");
    }

    @RequestMapping("myScore")
    public ServiceResponseBody myScore(Integer classId, Integer studentId) {
        return ServiceResponseBody.success(classScoreService.list(new LambdaQueryWrapper<ClassScoreEntity>().eq(ClassScoreEntity::getClassId, classId).eq(ClassScoreEntity::getStudentId, studentId)));
    }

    @RequestMapping("selectScore")
    public ServiceResponseBody selectScore(Integer classId) {
        return ServiceResponseBody.success(classScoreService.selectScore(classId));
    }

    @RequestMapping("scoreDetail")
    public ServiceResponseBody scoreDetail(Integer studentId) {
        return ServiceResponseBody.success(classScoreService.scoreDetail(studentId));
    }

    @RequestMapping("pass")
    public ServiceResponseBody pass(Integer id) {
        classScoreService.update(new LambdaUpdateWrapper<ClassScoreEntity>().eq(ClassScoreEntity::getId, id).set(ClassScoreEntity::getStatus, 2));
        return ServiceResponseBody.successMessage("审核成功");
    }

    @RequestMapping("noPass")
    public ServiceResponseBody noPass(Integer id) {
        classScoreService.update(new LambdaUpdateWrapper<ClassScoreEntity>().eq(ClassScoreEntity::getId, id).set(ClassScoreEntity::getStatus, 1));
        return ServiceResponseBody.successMessage("审核成功");
    }

}
