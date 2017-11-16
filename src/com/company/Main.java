package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class Main {

    public static void WriteFile(String str){
        try {
            FileWriter fw = new FileWriter("authors.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

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

            String str = "";

            while (rs.next()) {

                Integer col1 = rs.getInt(1);
                String col2 = rs.getString(2);
                String text = col1 + ": " + col2 + "\r\n";

                System.out.println(text);

                str += text;
            }

            WriteFile(str);

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
