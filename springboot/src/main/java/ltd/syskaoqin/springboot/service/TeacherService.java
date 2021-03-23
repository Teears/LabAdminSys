package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Teacher;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName TeacherService
 * @Description TODO
 * @createTime 2021年03月21日22:03
 */
public interface TeacherService {

    /**
     * 获取某个实验室的负责老师
     * @param labId
     * @return
     */
    Teacher findTeacherByLabId(String labId);

    /**
     * 通过工号查找教师
     * @param teaNumber teaNumber
     * @return teacher
     */
    Teacher findTeacherByTeaNumber(String teaNumber);

}
