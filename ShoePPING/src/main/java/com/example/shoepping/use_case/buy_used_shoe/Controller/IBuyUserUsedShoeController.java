package com.example.shoepping.use_case.buy_used_shoe.Controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserUsedShoeController {

    void getCatalog() throws SQLException, IOException, ClassNotFoundException;
}
