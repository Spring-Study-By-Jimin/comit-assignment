package project.comit.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackageClasses = {CreateUserPort.class, ExistsUserPort.class})
//@ComponentScan(basePackages = {"project.comit.shop.domain.user.port"})
//@ComponentScan({"project.comit.shop.domain.user.port"})
//@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "project.comit.shop.domain.user.port")
@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
