package com.bob.dcits;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import io.swagger.annotations.Api;
import com.bob.dcits.annotation.rest.AnonymousGetMapping;
import com.bob.dcits.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 开启审计功能 -> @EnableJpaAuditing
 *
 * @author guoq
 * @date 2024/11/15 9:20:19
 */
@EnableAsync
@RestController
@Api(hidden = true)
@SpringBootApplication
@EnableTransactionManagement
//@EnableDiscoveryClient
//@NacosPropertySource(dataId = "smartBJ", autoRefreshed = true)
public class AppRun {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AppRun.class);
        // 监控应用的PID，启动时可指定PID路径：--spring.pid.file=/home/eladmin/app.pid
        // 或者在 bootstrap.yml 添加文件路径，方便 kill，kill `cat /home/eladmin/app.pid`
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    /**
     * 访问首页提示
     *
     * @return /
     */
    @AnonymousGetMapping("/")
    public String index() {
        return "Backend service started successfully";
    }
}
