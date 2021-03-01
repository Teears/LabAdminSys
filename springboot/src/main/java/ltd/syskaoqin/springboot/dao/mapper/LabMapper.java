package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabMapper
 * @Description TODO
 * @createTime 2021年02月26日14:32
 */
@Mapper
public interface LabMapper {

    Lab findLabByOpenid(@Param("openid") String openid);
}
