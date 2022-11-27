package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Device;

import java.util.List;

public interface DeviceDAO {

    List<Device> findAll();
    Device findById(long id);
    void save(Device device);
    void update(Device device);
    void deleteById(long id);
}
