package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import org.springframework.stereotype.Service;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserAndLabService
 * @Description TODO
 * @createTime 2021年03月07日14:08
 */
public interface UserAndLabService {

    /**
     * 获取用户当前加入的实验室
     * @param openid openid
     * @return 当前加入的实验室以及加入时间等
     */
    UserAndLab selectByStuOpenid(String openid);

//    /**
//     * 获取教师当前加入的实验室
//     * @param openid openid
//     * @return 当前加入的实验室以及加入时间等
//     */
//    UserAndLab selectByTeaOpenid(String openid);

    /**
     * 获取加入这个实验室的学生人数，需要减去一个教师人数
     * @param labId
     * @return
     */
    int calculateLabTotal(String labId);
}
