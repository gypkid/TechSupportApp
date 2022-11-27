package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.DeviceDAO;
import com.techsupport.api.models.Device;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    private DeviceDAO deviceDAO;

    public DeviceController(DeviceDAO deviceDAO){this.deviceDAO = deviceDAO;}

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public List<Device> findAll() { return deviceDAO.findAll(); }

    @RequestMapping(value="/devices/{id}", method = RequestMethod.GET)
    public Device findById(@PathVariable("id") long id){ return deviceDAO.findById(id); }

    @RequestMapping(value="/devices", method = RequestMethod.POST)
    public Device create(@RequestBody Device device){
        deviceDAO.save(device);
        return device;
    }

    @RequestMapping(value = "/devices", method = RequestMethod.PUT)
    public Device update(@RequestBody Device device){
        deviceDAO.update(device);
        return device;
    }

    @RequestMapping(value = "/devices/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") long id){
        deviceDAO.deleteById(id);
    }

}
