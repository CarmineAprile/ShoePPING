package com.example.shoepping.dao.size_dao;

import com.example.shoepping.pattern.observer.ShoeSizeSubject;

import java.io.IOException;
import java.sql.SQLException;

public interface SizeDao {
    ShoeSizeSubject getSizeList(String model) throws SQLException, IOException, ClassNotFoundException;
}
