import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Examples")
public class SpringBatchApplication {

    public static void main(String[] args) {
        System.out.println("Hi");
        SpringApplication.run(SpringBatchApplication.class, args);
    }

}
