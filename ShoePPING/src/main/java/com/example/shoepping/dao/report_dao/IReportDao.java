package com.example.shoepping.dao.report_dao;

import com.example.shoepping.model.report.ReportList;

import java.io.IOException;
import java.sql.SQLException;

public interface IReportDao {
    ReportList getReportList() throws SQLException, IOException, ClassNotFoundException;
}
