package zyy.campuscommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("zyy.campuscommunity.mapper")
@SpringBootApplication
@EnableCaching
public class CampuscommunityApplication{
	public static void main(String[] args) {
		SpringApplication.run(CampuscommunityApplication.class, args);
	}
}
