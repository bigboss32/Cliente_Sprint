package Demostracion.Fondo_Voluntario_de_Pension;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*") // permite todos los orígenes
                        .allowedMethods("*")         // permite todos los métodos
                        .allowedHeaders("*")         // permite todos los headers
                        .allowCredentials(true);     // permite cookies/autenticación
            }
        };
    }
}
