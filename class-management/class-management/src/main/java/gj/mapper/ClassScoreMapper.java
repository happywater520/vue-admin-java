package gj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gj.entity.ClassScoreEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassScoreMapper extends BaseMapper<ClassScoreEntity> {

    List<Map<String, Object>> selectScore(@Param("classId") Integer classId);

    List<Map<String, Object>> scoreDetail(@Param("studentId") Integer studentId);
}
