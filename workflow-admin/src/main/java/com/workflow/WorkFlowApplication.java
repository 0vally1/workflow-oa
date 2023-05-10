package com.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author workflow
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class WorkFlowApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(WorkFlowApplication.class, args);
        System.out.println("启动成功");
    }
}
