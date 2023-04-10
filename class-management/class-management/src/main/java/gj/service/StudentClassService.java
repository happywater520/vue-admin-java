package gj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gj.entity.StudentClassEntity;
import gj.entity.StudentEntity;
import gj.mapper.StudentClassMapper;
import gj.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentClassService extends ServiceImpl<StudentClassMapper, StudentClassEntity> {

    public Page<Map<String, Object>> getPage(Page<Object> page, Integer studentId) {
        return baseMapper.getPage(page, studentId);
    }
}
