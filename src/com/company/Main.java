package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class Main {

    public static void main(String[] args) {

        Connection con = null;
     //   Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        String url = "jdbc:mysql://localhost:8889/test";
        String user = "root";
        String password = "root";


        try {

            con = DriverManager.getConnection(url, user, password);

            pst = con.prepareStatement("SELECT * FROM Authors");
            rs = pst.executeQuery();

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {

           System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                System.out.println(ex.getMessage());

            }
        }






    }
}
