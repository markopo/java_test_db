package com.company;

public class AuthorsDto {

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    private String Id;
    private String Name;

    public AuthorsDto(String id, String name){

        Id = id;
        Name = name;

    }



}
