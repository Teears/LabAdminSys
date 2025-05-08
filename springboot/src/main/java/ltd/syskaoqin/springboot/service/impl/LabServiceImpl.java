package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.mapper.LabMapper;
import ltd.syskaoqin.springboot.service.LabService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabServiceImpl
 * @Description TODO
 * @createTime 2021年02月26日14:33
 */
@Service
public class LabServiceImpl implements LabService {
    @Resource
    private LabMapper labMapper;

    @Override
    public Lab findLabByStuOpenid(String openid) {
        return labMapper.findLabByStuOpenid(openid);
    }

    @Override
    public Lab findLabByLabId(String labId) {
        return labMapper.findLabByLabId(labId);
    }

    @Override
    public List<Lab> findLabByTeaOpenid(String openid) {
        return labMapper.findLabByTeaOpenid(openid);
    }

    @Override
    public int countStuInLab(String labId) {
        return labMapper.countStuInLab(labId);
    }

    @Override
    public void updateCheckTime(String labId, String checkin1, String checkin2, String checkout1, String checkout2) {
        labMapper.updateCheckTime(labId,checkin1,checkin2,checkout1,checkout2);
    }

    @Override
    public void updateLabInfo(String labId, String desc, String rule, String picUrl) {
        labMapper.updateLabInfo(labId,desc,rule,picUrl);
    }

    @Override
    public List<String> findStuListInLab(String labId) {
        return labMapper.findStuListInLab(labId);
    }

    @Override
    public List<Map<String, String>> selectTeaLab(String openid) {
        return labMapper.selectTeaLab(openid);
    }

    @Override
    public List<Map<String, String>> getAllLabList() {
        return labMapper.getAllLabList();
    }

    @Override
    public List<Map<String, String>> getLabListByContent(String content) {
        return labMapper.getLabListByContent(content);
    }

    @Override
    public void updateLabAdminInfo(Lab lab) {
        labMapper.updateLabAdminInfo(lab);
    }

    @Override
    public void addLab(Lab lab) {
        labMapper.addLab(lab);
    }

    @Override
    public void deleteLab(String id) {
        labMapper.deleteLab(id);
    }

}
