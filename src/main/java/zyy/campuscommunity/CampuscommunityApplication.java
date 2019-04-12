package zyy.campuscommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("zyy.campuscommunity.mapper")
@SpringBootApplication
public class CampuscommunityApplication{
	public static void main(String[] args) {
		SpringApplication.run(CampuscommunityApplication.class, args);
	}
}
