package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Lab;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabService
 * @Description TODO
 * @createTime 2021年02月26日14:33
 */
public interface LabService {

    Lab findLabByOpenid(String openid);
}
