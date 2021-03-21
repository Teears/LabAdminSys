package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabMapper
 * @Description TODO Lab映射Mapper
 * @createTime 2021年02月26日14:32
 */
@Mapper
public interface LabMapper {

    /**
     * 查找该用户目前关联的实验室，查找过程中只筛选user_lab中status=1的数据
     * @param openid openid
     * @return 返回实验室
     */
    Lab findLabByOpenid(@Param("openid") String openid);
}
