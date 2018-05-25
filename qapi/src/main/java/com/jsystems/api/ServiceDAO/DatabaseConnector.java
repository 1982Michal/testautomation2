package com.jsystems.api.ServiceDAO;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseConnector {
    package com.jsystems.service.jdbcService;

import java.sql.Connection;
import java.sql.DriverManager;

    public class DatabaseConnector {
        private static Connection connection = null;

        public static Connection getConnection() {
            if (connection == null) {
                initConnection();
            }
            return connection;
        }

        private static void initConnection() {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String user = "testuser";
                String pass = "testuser";
                connection = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
