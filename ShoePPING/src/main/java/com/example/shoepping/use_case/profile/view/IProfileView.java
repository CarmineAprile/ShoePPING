package com.example.shoepping.use_case.profile.view;

import com.example.shoepping.bean.EmailBean;
import com.example.shoepping.bean.UsernameBean;

public interface IProfileView {

    void setLabels(UsernameBean usernameBean, EmailBean emailBean);
}
