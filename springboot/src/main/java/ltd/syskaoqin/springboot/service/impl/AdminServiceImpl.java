package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Admin;
import ltd.syskaoqin.springboot.dao.mapper.AdminMapper;
import ltd.syskaoqin.springboot.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/10日18:49
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByNum(String userNumber) {
        return adminMapper.findAdminByNum(userNumber);
    }
}
