package firstride.ridems.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RideConfig {
    @Bean
    public WebClient.Builder webClientBuild(){
        return WebClient.builder();
    }
}
