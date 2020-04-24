package org.akkuratnov.arbina.service;

import java.awt.*;
import java.util.ArrayList;

public interface ClientService {

    ArrayList<Device> show();
    public boolean create(Device device);
    public boolean delete(int id);
}