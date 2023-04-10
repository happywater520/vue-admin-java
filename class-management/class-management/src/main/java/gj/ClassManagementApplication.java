package gj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "gj.mapper")
public class ClassManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassManagementApplication.class, args);
    }
// spring boot
// mvc
// mybatis
// mybatis plus
}
