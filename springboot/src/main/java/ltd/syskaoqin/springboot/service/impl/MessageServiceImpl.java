package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Message;
import ltd.syskaoqin.springboot.dao.mapper.MessageMapper;
import ltd.syskaoqin.springboot.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @createTime 2021年03月22日14:27
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> stuGetMessageList(String openid, int day) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -day);
        Date startDate = cal.getTime();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");

        return messageMapper.stuGetMessageList(openid,sdf.format(startDate));
    }

    @Override
    public List<String> readedList(String openid) {
        return messageMapper.readedList(openid);
    }

    @Override
    public void insertMessageTag(String openid, String messageId) {
        messageMapper.insertMessageTag(openid,messageId);
    }

    @Override
    public void insertMessage(Message message) {
        messageMapper.insertMessage(message);
    }

    @Override
    public List<Message> selectMessageBySendId(String sendId) {
        return messageMapper.selectMessageBySendId(sendId);
    }

}
