package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a Singleton bean!!!");
    }

    public String getMyScope() {
        return "I'm a Singleton";
    }
}
