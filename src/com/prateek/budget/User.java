package com.prateek.budget;

class User {
    private String name,id;
   public User(String name,String id) {
        this.name = name;
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
