package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.GlobalData;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName InitGlobalDataService
 * @Description TODO 启动时将数据库数据加载到内存
 * @createTime 2021年02月20日15:49
 */
public interface GlobalDataService {
    /**
     * 启动时将数据库数据加载到内存
     * @return name content
     */
    List<GlobalData> findAllGlobalData();
}
