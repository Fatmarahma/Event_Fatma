package com.example.Fatma_Event;

import com.example.Fatma_Event.Config.RsaKeyProperties;
import org.hibernate.sql.results.jdbc.internal.ResultSetAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class FatmaEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(FatmaEventApplication.class, args);
	}

}
