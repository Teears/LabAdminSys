package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Permission;
import ltd.syskaoqin.springboot.dao.mapper.PermissionMapper;
import ltd.syskaoqin.springboot.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @createTime 2021年02月23日11:25
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public Permission findByid(String id) {
        return permissionMapper.findByid(id);
    }

    @Override
    public List<Permission> findByRoleId(String roleId) {
        return permissionMapper.findByRoleId(roleId);
    }
}
