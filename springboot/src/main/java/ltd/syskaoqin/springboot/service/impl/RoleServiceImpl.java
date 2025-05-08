package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Role;
import ltd.syskaoqin.springboot.dao.mapper.RoleMapper;
import ltd.syskaoqin.springboot.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @createTime 2021年02月23日11:57
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role findByid(String id) {
        return roleMapper.findByid(id);
    }
}
