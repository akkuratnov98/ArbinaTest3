package org.akkuratnov.arbina.controllers;

import org.akkuratnov.arbina.service.ClientService;
import org.akkuratnov.arbina.service.ClientServiceImpl;
import org.akkuratnov.arbina.service.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public  ResponseEntity<?> showDevices() {
        ArrayList<Device> devices = clientService.show();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @PostMapping("/create-client")
    public ResponseEntity<?> createDevice(@RequestBody Device device) {
        return clientService.create(device) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable(name = "id") int id) {
        return clientService.delete(id) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
