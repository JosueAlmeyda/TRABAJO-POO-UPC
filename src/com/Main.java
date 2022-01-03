package com;

import com.vistas.Login;

public class Main {

    public static void main(String[] args) {
        loadLogin();
        //test();
    }

    public static void loadLogin(){
        Login login = Login.getInstance();
        login.load();
    }
}
