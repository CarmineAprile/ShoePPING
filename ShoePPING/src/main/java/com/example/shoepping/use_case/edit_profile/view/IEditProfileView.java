package com.example.shoepping.use_case.edit_profile.view;

import com.example.shoepping.model.User;

import java.io.IOException;

public interface IEditProfileView {

    void onEditProfileSuccess(User user) throws IOException;

    void onEditProfileError(String message, int codeError);
}
