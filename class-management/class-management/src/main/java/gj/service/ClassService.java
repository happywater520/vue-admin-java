package gj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gj.entity.ClassEntity;
import gj.mapper.ClassMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassService extends ServiceImpl<ClassMapper, ClassEntity> {
    public IPage<Map<String, Object>> studentClass(Page<Object> page, Integer studentId) {
        return baseMapper.studentClass(page, studentId);
    }

    public IPage<Map<String, Object>> getAddClassPage(Page<Object> page, Integer studentId) {
        return baseMapper.getAddClassPage(page, studentId);
    }

    public IPage<Map<String, Object>> teacherClass(Page<Object> page, Integer teacherId, String name) {
        return baseMapper.teacherClass(page, teacherId, name);
    }

    public List<Map<String, Object>> classStudent(Integer classId) {
        return baseMapper.classStudent(classId);
    }

    public List<Map<String, Object>> addClassStudent(Integer classId) {
        return baseMapper.addClassStudent(classId);
    }

    public List<Map<String, Object>> classScore(Integer classId, String studentName) {
        return baseMapper.classScore(classId, studentName);
    }

    public IPage<Map<String, Object>> adminClass(Page<Object> page, String name, String teacherName) {
        return baseMapper.adminClass(page, name, teacherName);
    }
}
