package com.example.shoepping.use_case.profile;

import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface IProfileController {

    String onOrders(User user, boolean isChecked) throws SQLException, IOException, ClassNotFoundException;
}
