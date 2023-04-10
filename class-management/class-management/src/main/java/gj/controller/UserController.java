package gj.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import gj.entity.AdminEntity;
import gj.entity.StudentEntity;
import gj.entity.TeacherEntity;
import gj.service.AdminService;
import gj.service.StudentService;
import gj.service.TeacherService;
import gj.util.formatting.ServiceResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    StudentService studentService;

    @Resource
    TeacherService teacherService;

    @Resource
    AdminService adminService;

    @RequestMapping("login")
    public ServiceResponseBody login(String userName, String password, Integer userType) {
        int userId = 0;
        String name = "";
        if (userType == 1) {
            QueryWrapper<StudentEntity> sectionQueryWrapper = new QueryWrapper<>();
            sectionQueryWrapper.eq("student_number", userName);
            StudentEntity one = studentService.getOne(new LambdaQueryWrapper<StudentEntity>()
                    .eq(StudentEntity::getNumber, userName));
            if (one == null) {
                return ServiceResponseBody.error("用户不存在");
            }
            if (!one.getPassword().equals(password)) {
                return ServiceResponseBody.error("密码错误");
            }
            name = one.getName();
            userId = one.getId();
        } else if (userType == 2) {
            TeacherEntity one = teacherService.getOne(new LambdaQueryWrapper<TeacherEntity>().eq(TeacherEntity::getNumber, userName));
            if (one == null) {
                return ServiceResponseBody.error("用户不存在");
            }
            if (!one.getPassword().equals(password)) {
                return ServiceResponseBody.error("密码错误");
            }
            name = one.getName();
            userId = one.getId();
        } else if (userType == 3) {
            LambdaQueryWrapper<AdminEntity> eq = new LambdaQueryWrapper<AdminEntity>().eq(AdminEntity::getAdmin_username, userName);
//            AdminEntity one = adminService.getOne(eq);
            Map<String, Object> map = adminService.getMap(eq);
            if (map == null) {
                return ServiceResponseBody.error("用户不存在");
            }
            if (!map.get("admin_password").equals(password)) {
                return ServiceResponseBody.error("密码错误");
            }
            name = (String)map.get("admin_username");
            userId = (int)map.get("admin_id");
//            userId = one.getId();
        }
        String finalName = name;
        int finalUserId = userId;
        return ServiceResponseBody.success(new HashMap<String, Object>(){{
            put("userName", finalName);
            put("userId", finalUserId);
            put("userType", userType);
        }});
    }

}
