package cn.jijl.mist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//定时任务
@EnableScheduling
//事务
@EnableTransactionManagement

@MapperScan("cn.jijl.mist.modules.mapper")
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class},
		scanBasePackages = {"cn.jijl.mist"})
public class MistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MistApplication.class, args);
	}

}
