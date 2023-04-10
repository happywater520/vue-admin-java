package gj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gj.entity.StudentClassEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface StudentClassMapper extends BaseMapper<StudentClassEntity> {

    Page<Map<String, Object>> getPage(@Param("page") Page<Object> page,
                                      @Param("studentId") Integer studentId);

}
