package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentMapper
 * @Description TODO 学生Mapper
 * @createTime 2021年02月25日21:46
 */
@Mapper
public interface StudentMapper {
    /**
     * 通过学生学号找到学生
     * @param stuNumber 学生学号
     * @return Student
     */
    Student findStudentByStuNumber(@Param("stuNumber") String stuNumber);
}
