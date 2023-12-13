package br.edu.ifsul.cstsi.lpoo_objetivo_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LpooObjetivo5Application {

    public static void main(String[] args) {
        SpringApplication.run(LpooObjetivo5Application.class, args);
        HomeController.main(null);

    }
}
