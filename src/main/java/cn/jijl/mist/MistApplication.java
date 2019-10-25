package cn.jijl.mist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.jijl.mist.modules.mapper")
public class MistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MistApplication.class, args);
	}

}
