package org.example.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.io.Serializable;

@SessionScoped
public class SessionService implements Serializable {
    private int count;

    public int getCount() {
        return ++count;
    }

    @PostConstruct
    public void init(){
        System.out.println("session object created");
    }

    @PreDestroy
    public void kill(){
        System.out.println("session object killed");
    }
}