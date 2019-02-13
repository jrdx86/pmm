package com.example.jordipc.spinnerdoble;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String name;


    public Client( String name) {
        this.name = name;

    }
    public long getId() { return id;
    }

    public void setId(int id) { this.id = id;
    }

    public String getName() { return name;
    }

    public void setName(String name) { this.name = name;
    }
}


