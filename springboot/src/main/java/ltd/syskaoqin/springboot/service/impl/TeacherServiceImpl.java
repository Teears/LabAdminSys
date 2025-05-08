package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Teacher;
import ltd.syskaoqin.springboot.dao.mapper.TeacherMapper;
import ltd.syskaoqin.springboot.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String,String> findTeaName(String openid) {
        return teacherMapper.findTeaName(openid);
    }

    @Override
    public Map<String, Object> findTeaInfo(String openid) {
        return teacherMapper.findTeaInfo(openid);
    }

    @Override
    public List<Map<String,String>> getAllTeacherList() {
        return teacherMapper.getAllTeacherList();
    }

    @Override
    public List<Map<String,String>> getTeacherListByContent(String content) {
        return teacherMapper.getTeacherListByContent(content);
    }

    @Override
    public Map<String, String> checkTeacher(String num, String labId) {
        return teacherMapper.checkTeacher(num,labId);
    }


    @Override
    public void insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public Teacher findTeacherInSys(String num) {
        return teacherMapper.findTeacherInSys(num);
    }

    @Override
    public void deleteTeacher(String num) {
        teacherMapper.deleteTeacher(num);
    }
}
