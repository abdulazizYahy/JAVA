package org.example.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@ApplicationScoped
public class ApplicationService {
    private int count;

    public int getCount() {
        return ++count;
    }

    @PostConstruct
    public void init(){
        System.out.println(" object created");
    }

    @PreDestroy
    public void kill(){
        System.out.println(" object killed");
    }
}
