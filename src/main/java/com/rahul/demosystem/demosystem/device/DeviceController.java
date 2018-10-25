package com.rahul.demosystem.demosystem.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository ;


    @ResponseBody
    @RequestMapping(value="/create" , method = RequestMethod.POST)
    public Iterable<Device> createDevice(Device device)
    {

        deviceRepository.save(device);
        Iterable<Device> devices = deviceRepository.findAll();
        return devices;
    }

    @ResponseBody
    @RequestMapping(value="delete/{deviceId}" , method = RequestMethod.DELETE)
    public Iterable<Device> deleteDevice(@PathVariable ("deviceId") int deviceId)
    {
        deviceRepository.deleteById(deviceId);
        Iterable<Device> devices = deviceRepository.findAll();
        return devices;
    }

    @ResponseBody
    @RequestMapping(value="/{deviceId}" , method = RequestMethod.GET)
    public Device getDevice(@PathVariable ("deviceId") int deviceId)
    {
        Device device = deviceRepository.findById(deviceId).orElse(new Device());
        return device;
    }

    @ResponseBody
    @RequestMapping(value="/all" , method = RequestMethod.GET)
    public Iterable<Device> allDevice()
    {
        Iterable<Device> devices = deviceRepository.findAll();
        return devices;
    }
}
