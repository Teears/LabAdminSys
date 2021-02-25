package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentMapper
 * @Description TODO
 * @createTime 2021年02月25日21:46
 */
@Mapper
public interface StudentMapper {

    Student findStudentByStuNumber(@Param("stuNumber") String stuNumber);
}
