package org.akkuratnov.arbina.service;

import org.akkuratnov.arbina.database.DataBaseUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class ClientServiceImpl implements ClientService{

    private static Statement statement;
    private static ResultSet resultSet;

    @Autowired
    public ClientServiceImpl(DataBaseUse dataBaseUse){
        this.statement = dataBaseUse.getStatement();
    }

    @Override
    public ArrayList<Device> show() {
        ArrayList<Device> devices= new ArrayList<Device>();
        try {
            resultSet = statement.executeQuery("SELECT * from devices");
            while (resultSet.next()){
                Device device = new Device(resultSet.getInt("id_device"),
                        resultSet.getDate("date_create"));
                devices.add(device);
                System.out.println(resultSet.getInt("id_device") + " " +
                        resultSet.getDate("date_create"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return devices;
    }

    @Override
    public boolean create(Device device) {
        try {
            statement.executeUpdate("INSERT INTO devices(id_device, date_create) " +
                    "VALUES (" +  device.getId() +", '" + device.getDate() +"')");
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            statement.executeUpdate("DELETE FROM devices " +
                    "WHERE id_device = " + String.valueOf(id));
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }
}