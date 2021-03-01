package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.mapper.LabMapper;
import ltd.syskaoqin.springboot.service.LabService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<Lab> findLabByOpenid(String openid) {
        return labMapper.findLabByOpenid(openid);
    }
}
