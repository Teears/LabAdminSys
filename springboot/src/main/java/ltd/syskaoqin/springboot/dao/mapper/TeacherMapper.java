package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName TeacherMapper
 * @Description TODO 教师Mapper
 * @createTime 2021年03月21日22:00
 */
@Mapper
public interface TeacherMapper {

    /**
     * 获取某个实验室的负责老师
     * @param labId labId
     * @return Teacher
     */
    Teacher findTeacherByLabId(@Param("labId") String labId);

    /**
     * 通过工号查找教师
     * @param teaNumber teaNumber
     * @return teacher
     */
    Teacher findTeacherByTeaNumber(@Param("teaNumber") String teaNumber);

    /**
     * 获取教师Name作为补充
     * @param openid openid
     * @return name
     */
    Map<String,String> findTeaName(@Param("openid") String openid);
}
