package com.example.shoepping.use_case.login.controller;


public interface ILoginController {

    // aggiungere gestione personalizzata dell'eccezione
    void onLogin(String username, String pass, boolean check) throws Exception;
}
