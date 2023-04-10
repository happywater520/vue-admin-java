package gj.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gj.entity.StudentEntity;
import gj.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceImpl<StudentMapper, StudentEntity> {

}
