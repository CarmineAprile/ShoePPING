package com.example.shoepping.dao.report_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.report.ReportList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ReportDao implements IReportDao {
    @Override
    public ReportList getReportList() throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getReport(conn);
    }
}
