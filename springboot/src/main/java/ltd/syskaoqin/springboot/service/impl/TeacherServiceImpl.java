package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Teacher;
import ltd.syskaoqin.springboot.dao.mapper.TeacherMapper;
import ltd.syskaoqin.springboot.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @createTime 2021年03月21日22:04
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findTeacherByLabId(String labId) {
        return teacherMapper.findTeacherByLabId(labId);
    }

    @Override
    public Teacher findTeacherByTeaNumber(String teaNumber) {
        return teacherMapper.findTeacherByTeaNumber(teaNumber);
    }
}
