package cz.uhk.ppro.inzeraty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppLauncher implements WebMvcConfigurer {

    public static void main(String[] args)  {
        SpringApplication.run(AppLauncher.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // namapovat URL / na view jmenem index (tedy pres view-resolver na /WEB-INF/jsp/index.jsp)
        registry.addViewController("/").setViewName("/main.html");
    }

}
