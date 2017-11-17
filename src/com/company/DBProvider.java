package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class DBProvider {

    protected Connection Con = null;
    protected Statement St = null;
    protected ResultSet Rs = null;
    protected PreparedStatement Pst = null;

    protected String Url = "jdbc:mysql://localhost:8889/test";
    protected String User = "root";
    protected String Password = "root";


    public DBProvider(){

    }

    public DBProvider(String url, String user, String password) {

        if(url != null){
            Url = url;
        }

        if(user != null) {
            User = user;
        }

        if(password != null){
            Password = password;
        }


    }

    /**
     * "SELECT * FROM Authors"
     * @param sql
     */
    public List<Map<String, Object>> GetStatement(String sql) {

        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        try {

            Con = DriverManager.getConnection(Url, User, Password);
            Pst = Con.prepareStatement(sql);
            Rs = Pst.executeQuery();

            ResultSetMetaData metaData = Rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (Rs.next()) {

                HashMap columns = new HashMap();

                for (int i = 1; i <= columnCount; i++) {
                    columns.put(metaData.getColumnLabel(i), Rs.getObject(i));
                }

                rows.add(columns);

            }

            //      WriteFile(str);

        } catch (SQLException ex) {

        //    System.out.println(ex.getMessage());

        } finally {

            try {

                if (Rs != null) {
                    Rs.close();
                }

                if (Pst != null) {
                    Pst.close();
                }

                if (Con != null) {
                    Con.close();
                }

            } catch (SQLException ex) {

              //  System.out.println(ex.getMessage());

            }
        }

        return rows;

    }


}
