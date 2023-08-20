package com.reve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author reve
 *
 */
//@MapperScan("com.reve.mapper") //scan mapper
@SpringBootApplication // 声明该类是一个SpringBoot引导类
public class ReveApplication {

	// main是java程序的入口
	public static void main(String[] args) {
		// run方法：表示运行SpringBoot的引导类 run参数是SpringBoot引导类的字节码对象
		SpringApplication.run(ReveApplication.class);
		// 如果本类里面没有@SpringBootApplication注解，而BootSpringBoot里面有，则使用以下代码（一般不使用这种写法）
//		SpringApplication.run(BootSpringBoot.class);
	}

}
