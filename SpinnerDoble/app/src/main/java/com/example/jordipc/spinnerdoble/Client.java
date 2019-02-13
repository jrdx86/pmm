package com.example.jordipc.spinnerdoble;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String name;
    private String password;


    public Client( String name, String password) {
        this.name = name;
        this.setPassword(password);

    }
    public long getId() { return id;
    }

    public void setId(int id) { this.id = id;
    }

    public String getName() { return name;
    }

    public void setName(String name) { this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


