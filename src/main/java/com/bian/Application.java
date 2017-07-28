package com.bian;

import com.bian.config.dataSources.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by Mr.Bi on 2017/2/23.
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
