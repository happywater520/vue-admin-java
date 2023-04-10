package gj.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gj.entity.ClassScoreEntity;
import gj.mapper.ClassScoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassScoreService extends ServiceImpl<ClassScoreMapper, ClassScoreEntity> {

    public List<Map<String, Object>> selectScore(Integer classId) {
        return baseMapper.selectScore(classId);
    }


    public List<Map<String, Object>> scoreDetail(Integer studentId) {
        return baseMapper.scoreDetail(studentId);
    }
}
