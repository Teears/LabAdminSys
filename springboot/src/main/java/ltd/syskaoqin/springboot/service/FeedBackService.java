package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.FeedBack;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName FeedBackService
 * @Description TODO
 * @createTime 2021年03月22日22:47
 */
public interface FeedBackService {

    /**
     * 插入一条反馈信息
     * @param feedBack feedback
     */
    void insertFeedBack(FeedBack feedBack);

    /**
     * 展示所有反馈信息
     * @return
     */
    List<FeedBack> selectAll();

    /**
     * admin获取feedback
     * @return
     */
    List<Map<String,String>> selectFeedBack();
}
