package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.GlobalData;
import ltd.syskaoqin.springboot.dao.mapper.GlobalDataMapper;
import ltd.syskaoqin.springboot.service.GlobalDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName InitGlobalDataServiceImpl
 * @Description TODO
 * @createTime 2021年02月20日16:02
 */
@Service
public class GlobalDataServiceImpl implements GlobalDataService {
    @Resource
    private GlobalDataMapper globalDataMapper;

    @Override
    public List<GlobalData> findAllGlobalData() {
        return globalDataMapper.findAllGlobalData();
    }
}
