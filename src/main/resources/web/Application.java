package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@Configuration
@ComponentScan(value={"web"})
@EnableWebMvc
@EnableAutoConfiguration

public class Application extends SpringBootServletInitializer implements WebMvcConfigurer { 
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        String funName = "configureViewResolvers( ... ) " ; 
        //log.info( funName );
 
        //registry.jsp("/htmlviews/", ".jsp");
        registry.jsp("/html", ".html");
    }  

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}