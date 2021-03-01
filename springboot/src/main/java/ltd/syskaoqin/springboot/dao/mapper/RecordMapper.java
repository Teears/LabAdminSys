package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RecordMapper
 * @Description TODO
 * @createTime 2021年02月26日16:12
 */
@Mapper
public interface RecordMapper {
    List<Record> findByOpenid(@Param("openid") String openid);

    Record findByOpenidAndDate(@Param("openid") String openid,@Param("checkDate") String checkDate);
}
