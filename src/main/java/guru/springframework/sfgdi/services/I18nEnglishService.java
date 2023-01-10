package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.annotation.Autowired;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;

public class I18nEnglishService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    @Autowired
    public I18nEnglishService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
