package com.rahul.demosystem.demosystem.device;

import com.rahul.demosystem.demosystem.device.service.DeviceService;
import com.rahul.demosystem.demosystem.protocol.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rahul.demosystem.demosystem.protocol.Protocol;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository ;

    @Autowired
    DeviceService deviceService;

    @Autowired
    ProtocolRepository protocolRepository;



    //get a user by id
    @ResponseBody
    @GetMapping("/{deviceId}")
    public Device getDevice(@PathVariable ("deviceId") int deviceId)
    {
        Device device = deviceRepository.findById(deviceId).orElse(new Device());
        return device;
    }



    //view all users at once
    @ResponseBody
    @GetMapping("/all")
    public Iterable<Device> allDevice()
    {
        Iterable<Device> devices = deviceRepository.findAll();
        return devices;
    }


    //create a new device
    @PostMapping("/create")
    public Iterable<Device> createDevice(@RequestBody Device device)
    {

    	//If a user is assign to a device status will change
    	if(device.getUsers() != null)
    	{
    		device.setStatus(Status.Working);
    	}
    	
        deviceRepository.save(device);
        Iterable<Device> devices = deviceRepository.findAll();
        return devices;
    }


    //Assigning protocol to device via divice id
    @ResponseBody
    @PutMapping("/assignProtocol/{deviceId}")
    public Iterable<Device> assignProtocol(@PathVariable("deviceId") int deviceId, @RequestBody Protocol protocol) throws IOException {

        Device existingDevice = deviceRepository.findById(deviceId).orElse(null);

        //checks either device exist or not
        if(existingDevice == null)
            throw new IOException("Device doesn't exist");


        //assign protocol to device
        deviceService.assignProtocolToDevice(existingDevice , protocol);

        Iterable<Device> devices = deviceRepository.findAll();
        return devices;

    }


    //delete device by id
    @ResponseBody
    @DeleteMapping("delete/{deviceId}")
    public Iterable<Device> deleteDevice(@PathVariable ("deviceId") int deviceId)
    {
        deviceRepository.deleteById(deviceId);
        Iterable<Device> devices = deviceRepository.findAll();
        return devices;
    }


}
