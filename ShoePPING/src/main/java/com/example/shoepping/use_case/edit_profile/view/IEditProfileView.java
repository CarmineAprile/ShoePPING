package com.example.shoepping.use_case.edit_profile.view;

import java.io.IOException;

public interface IEditProfileView {

    void onEditProfileSuccess() throws IOException;

    void onEditProfileError(String message, int codeError);
}
