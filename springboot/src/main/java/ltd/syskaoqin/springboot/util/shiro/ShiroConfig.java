package ltd.syskaoqin.springboot.util.shiro;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author Teears
 * @version 1.0.0
 * @ClassName ShiroConfig
 * @Description TODO
 * @createTime 2021年02月22日20:26
 */
@Configuration
public class ShiroConfig {
    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        System.out.println("shiroFilterFactoryBean run");
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(securityManager());
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/welogin/**", "anon");
        map.put("/bindId/**", "anon");
        map.put("/stu/**", "anon");
        map.put("/message/**", "anon");
        map.put("/feedback/**", "anon");
        map.put("/**", "anon");
//        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }

    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    /**
     * 下面的代码是添加注解支持
     */

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
