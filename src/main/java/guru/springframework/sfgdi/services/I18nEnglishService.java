package guru.springframework.sfgdi.services;

public class I18nEnglishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
