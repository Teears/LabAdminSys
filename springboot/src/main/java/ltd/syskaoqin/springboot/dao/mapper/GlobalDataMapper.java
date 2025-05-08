package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.GlobalData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName GlobalDataMapper
 * @Description TODO 初始化常量映射Mapper
 * @createTime 2021年02月20日15:52
 */
@Mapper
public interface GlobalDataMapper {
    /**
     * 查询所有初始化常量
     * @return 查询结果列表
     */
    List<GlobalData> findAllGlobalData();
}
