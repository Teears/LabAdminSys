package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.FeedBack;
import ltd.syskaoqin.springboot.dao.mapper.FeedBackMapper;
import ltd.syskaoqin.springboot.service.FeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName FeedBackServiceImpl
 * @Description TODO
 * @createTime 2021年03月22日22:48
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Resource
    private FeedBackMapper feedBackMapper;

    @Override
    public void insertFeedBack(FeedBack feedBack) {
        feedBackMapper.insertFeedBack(feedBack);
    }

    @Override
    public List<FeedBack> selectAll() {
        return feedBackMapper.selectAll();
    }

    @Override
    public List<Map<String, String>> selectFeedBack() {
        return feedBackMapper.selectFeedBack();
    }
}
