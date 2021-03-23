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

    /**
     * 通过openid找到学生基本信息
     * @param openid openid
     * @return Student
     */
    Student findStudentByOpenid(@Param("openid") String openid);

    /**
     * 通过学号删除学生，在学生退出实验室时调用
     * @param stuNum
     * @return
     */
    int deleteStudent(@Param("stuNum") String stuNum);
}
