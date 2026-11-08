package org.example.model;

import java.util.UUID;

public class Member {
    private final String uniqueId;
    private final String name;

    public Member(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can not be null or blank.");
        }

        this.uniqueId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
