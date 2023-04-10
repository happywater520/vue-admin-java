package gj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gj.entity.ClassEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassMapper extends BaseMapper<ClassEntity> {

    Page<Map<String, Object>> getPage(@Param("page") Page<Object> page,
                                      @Param("name") String name,
                                      @Param("teacherName") String teacherName);

    Page<Map<String, Object>> studentClass(@Param("page") Page<Object> page, @Param("studentId") Integer studentId);

    Page<Map<String, Object>> getAddClassPage(@Param("page") Page<Object> page, @Param("studentId") Integer studentId);

    IPage<Map<String, Object>> teacherClass(@Param("page") Page<Object> page, @Param("teacherId") Integer teacherId, @Param("name") String name);

    List<Map<String, Object>> classStudent(@Param("classId") Integer classId);

    List<Map<String, Object>> addClassStudent(@Param("classId") Integer classId);

    List<Map<String, Object>> classScore(@Param("classId") Integer classId, @Param("studentName") String studentName);

    IPage<Map<String, Object>> adminClass(@Param("page") Page<Object> page, @Param("name") String name, @Param("teacherName") String teacherName);
}
