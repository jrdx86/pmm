package com.example.jordipc.spinnerdoble;

public class Globals {
    public static final String DATABASE_NAME = "flights";
    public static final int DATABASE_VERSION = 4;

    public static final String TABLE_CLIENT_ID = "id";
    public static final String TABLE_CLIENT = "client";
    public static final String TABLE_CLIENT_NAME = "user";
    public static final String TABLE_CLIENT_PASSWORD = "password";

    public static final String TABLE_COUNTRY_ID = "id";
    public static final String TABLE_COUNTRY = "country";
    public static final String TABLE_COUNTRY_NAME = "country_name";
    public static final String TABLE_COUNTRY_CITY = "city";

    public static final String TABLE_COUNTRY_VISITED ="flight";
    public static final String TABLE_COUNTRY_VISITED_ID = "id";
    public static final String TABLE_COUNTRY_VISITED_COUNTRY_ID = "country_id";
    public static final String TABLE_COUNTRY_VISITED_CLIENT_ID = "client_id";


    public static final String CREATE_TABLE_CLIENT = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL )",
            TABLE_CLIENT,
            TABLE_CLIENT_ID,
            TABLE_CLIENT_NAME,
            TABLE_CLIENT_PASSWORD

    );

    public static final String CREATE_TABLE_COUNTRY = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL,"+
                    "%s TEXT NOT NULL)",
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID,
            TABLE_COUNTRY_NAME,
            TABLE_COUNTRY_CITY


    );

    public static final String CREATE_TABLE_COUNTRY_VISITED = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s))",

            TABLE_COUNTRY_VISITED,
            TABLE_COUNTRY_VISITED_ID,
            TABLE_COUNTRY_VISITED_COUNTRY_ID ,
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID,
            TABLE_COUNTRY_VISITED_CLIENT_ID,
            TABLE_CLIENT,
            TABLE_CLIENT_ID



    );

    public static final String FILL_TABLE_COUNTRY =
            String.format("INSERT INTO %s (%s, %s) VALUES " +
                            "('ESPAÑA', 'MADRID')," +
                            "('FRANCIA', 'PARIS')," +
                            "('ALEMANIA', 'BERLIN')",
                    TABLE_COUNTRY,
                    TABLE_COUNTRY_NAME,
                    TABLE_COUNTRY_CITY
            );







}
