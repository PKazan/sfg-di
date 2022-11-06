package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.PrimaryInjectedGreetingService;

@Controller
public class MyController {
    private final PrimaryInjectedGreetingService primaryInjectedGreetingService;

    public MyController(PrimaryInjectedGreetingService primaryInjectedGreetingService) {
        this.primaryInjectedGreetingService = primaryInjectedGreetingService;
    }

    public String sayHello() {
        return primaryInjectedGreetingService.sayGreeting();
    }
}
