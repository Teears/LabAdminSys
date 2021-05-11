package ltd.syskaoqin.springboot.component;

import ltd.syskaoqin.springboot.dao.entity.GlobalData;
import ltd.syskaoqin.springboot.service.GlobalDataService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName InitGlobalData
 * @Description TODO 启动时将数据库数据加载到内存,初始化诸如appid等如果嵌入代码会导致安全问题的常量，这个方法会在系统启动时执行
 * @createTime 2021年02月20日15:36
 */
@Component
public class InitGlobalData{

    @Resource
    private GlobalDataService globalDataService;

    public static Map<String,String> globalDataMap = new HashMap<>();

    @PostConstruct
    public void init() {
        List<GlobalData> list = globalDataService.findAllGlobalData();
        System.out.println(list);
        for (GlobalData globalData : list) {
            globalDataMap.put(globalData.getName(),globalData.getContent());
        }
    }
    @PreDestroy
    public void destroy(){
        System.out.println("系统运行结束");
    }
}
