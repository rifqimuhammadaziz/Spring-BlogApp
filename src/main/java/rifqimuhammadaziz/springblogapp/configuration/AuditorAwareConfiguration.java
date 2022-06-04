package rifqimuhammadaziz.springblogapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import rifqimuhammadaziz.springblogapp.utility.AuditorAwareImpl;

@Configuration
public class AuditorAwareConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
