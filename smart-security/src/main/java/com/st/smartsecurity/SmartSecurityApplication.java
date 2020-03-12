package com.st.smartsecurity;

import com.qs.common.core.CommonCoreConfig;
import com.qs.common.mysql.CommonMysqlConfig;
import com.qs.common.redis.CommonRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackageClasses = {
        CommonCoreConfig.class,
        CommonRedisConfig.class,
        CommonMysqlConfig.class,
        SmartSecurityApplication.class
})
@MapperScan("com.st.smartsecurity.mapper")
public class SmartSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartSecurityApplication.class, args);
    }

}
