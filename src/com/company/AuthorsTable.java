package com.company;

import com.company.DBProvider;
import java.util.*;

public class AuthorsTable extends DBProvider {



    public List<AuthorsDto> GetAuthors() {
        ArrayList<AuthorsDto> authors = new ArrayList<AuthorsDto>();
        List<Map<String, Object>> rows = GetStatement("SELECT * FROM Authors");

        for (int i = 0; i < rows.size(); i++) {

            Map<String, Object> row = rows.get(i);
            String Id = row.get("Id").toString();
            String Name = row.get("Name").toString();
            AuthorsDto author = new AuthorsDto(Id, Name);
            authors.add(author);
        }

        return authors;
    }

}
