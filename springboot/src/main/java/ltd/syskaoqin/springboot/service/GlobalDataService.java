package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.GlobalData;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName InitGlobalDataService
 * @Description TODO
 * @createTime 2021年02月20日15:49
 */
public interface GlobalDataService {
    List<GlobalData> findAllGlobalData();
}
