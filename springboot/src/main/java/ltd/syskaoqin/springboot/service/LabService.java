package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Lab;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabService
 * @Description TODO 实验室相关操作
 * @createTime 2021年02月26日14:33
 */
public interface LabService {

    /**
     * 获取某用户目前关联的实验室
     * 如果是学生则是目前加入的实验室，如果是教师则是目前管理的所有实验室列表
     * @param openid openid
     * @return 实验室对象列表
     */
    List<Lab> findLabByOpenid(String openid);
}
