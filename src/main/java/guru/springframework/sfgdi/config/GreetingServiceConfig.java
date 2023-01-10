package guru.springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishService;
import guru.springframework.sfgdi.services.I18nSpanishService;
import guru.springframework.sfgdi.services.PrimaryInjectedGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingServiceImpl;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishService i18nSpanishService() {
        return new I18nSpanishService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishService i18nService() {
        return new I18nEnglishService();
    }

    @Primary
    @Bean
    PrimaryInjectedGreetingService primaryInjectedGreetingService() {
        return new PrimaryInjectedGreetingService();
    }

    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService() {
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingServiceImpl propertyInjectedGreetingServiceImpl() {
        return new PropertyInjectedGreetingServiceImpl();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

}
