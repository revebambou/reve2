package com.uu;
 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author uuEstHorrible
 *
 */
@MapperScan("com.uu.mapper") //scan mapper
@SpringBootApplication
public class UuApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(UuApplication.class, args);
	}
}