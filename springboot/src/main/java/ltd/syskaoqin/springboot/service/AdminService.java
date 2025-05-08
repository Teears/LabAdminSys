package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Admin;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/10日18:48
 */
public interface AdminService {

    /**
     * 用于管理员Check
     * @param userNumber userNumber
     * @return Admin
     */
    Admin findAdminByNum(String userNumber);

}
