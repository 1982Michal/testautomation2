package com.jsystems.api.ServiceDAO;

import com.jsystems.api.models.errorModels.TestUser;

import java.sql.Statement;
import java.sql.ResultSet;

public class UserServiceDao {


        public TestUser getOne(Long id) {
            String sql = "select * from testUsers where id = " + id;
            TestUser userTest = new TestUser();
            try {
                Statement statement = DatabaseConnector.getConnection().createStatement();
                ResultSet wynik = statement.executeQuery(sql);
                System.out.println(wynik.toString());

                while (wynik.next()) {
                    userTest.setId(wynik.getLong(1));
                    userTest.setName(wynik.getString(2));
                    userTest.setSurname(wynik.getString(3));
                }
                wynik.close();
                statement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return userTest;
        }
}
