package com.example.shoepping.dao.size_dao;

import com.example.shoepping.pattern.observer.ShoeSizeList;

import java.io.IOException;
import java.sql.SQLException;

public interface SizeDao {
    ShoeSizeList getSizeList(String model) throws SQLException, IOException, ClassNotFoundException;
}
