package guru.springframework.sfgdi.services;

public class PrimaryInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean";
    }
}
