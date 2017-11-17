package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

           AuthorsTable at = new AuthorsTable();
           List<AuthorsDto> authors = at.GetAuthors();

           for(int i=0;i< authors.size(); i++){

               AuthorsDto author = authors.get(i);
               System.out.println(author.getId() + ": "  + author.getName());
            }






    }
}
