package com.example.shoepping.use_case.edit_profile.view;

import com.example.shoepping.bean.CheckedBean;
import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.UserBean;

import java.io.IOException;

public interface IEditProfileView {

    void onEditProfileSuccess(CheckedBean checkedBean, UserBean userNew) throws IOException;

    void onEditProfileError(MessageBean messageBean, CodeBean codeBean);
}
