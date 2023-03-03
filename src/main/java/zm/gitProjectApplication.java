package zm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zm.demo.mapper")
public class gitProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(gitProjectApplication.class);
    }
}
