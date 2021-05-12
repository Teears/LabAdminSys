package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.FeedBack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName FeedBackMapper
 * @Description TODO
 * @createTime 2021年03月22日22:46
 */
@Mapper
public interface FeedBackMapper {

    /**
     * 插入一条反馈信息
     * @param feedBack feedback
     */
    void insertFeedBack(FeedBack feedBack);

    /**
     * 展示所有反馈信息
     * @return openid表示nickname
     */
    List<FeedBack> selectAll();

    /**
     * 获取所有反馈
     * @return
     */
    List<Map<String,String>> selectFeedBack();
}
