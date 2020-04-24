package org.akkuratnov.arbina.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component("dataBaseUse")
public class DataBaseUse {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    @PostConstruct
    public void ConnectionToDataBase(){
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.execute("create table devices (id_device int primary key, date_create date not null )");
            int rows = statement.executeUpdate("INSERT INTO devices(id_device, date_create) " +
                    "VALUES (1, '1998-10-01')," +
                    "(2, '2020-04-21'), (3, '2020-04-22')");

        } catch (SQLException | ClassNotFoundException throwables) {
        //} catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @PreDestroy
    public void CloseConection() throws SQLException {
        connection.close();
    }

    public Statement getStatement() {
        return statement;
    }
}
