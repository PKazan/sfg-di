package guru.springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishService;
import guru.springframework.sfgdi.services.I18nSpanishService;
import guru.springframework.sfgdi.services.PrimaryInjectedGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingServiceImpl;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;

@Configuration
@ImportResource("classpath:sfgdi-config.xml")
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishService i18nSpanishService() {
        return new I18nSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryInjectedGreetingService primaryInjectedGreetingService() {
        return new PrimaryInjectedGreetingService();
    }

//    @Bean
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
