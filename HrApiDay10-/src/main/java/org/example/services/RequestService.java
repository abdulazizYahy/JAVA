package org.example.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RequestScoped
public class RequestService {
    private int count;

    public int getCount() {
        return ++count;
    }
    @PostConstruct
    public void init(){
        System.out.println("request object created");
    }

    @PreDestroy
    public void kill(){
        System.out.println("request object killed");
    }
}