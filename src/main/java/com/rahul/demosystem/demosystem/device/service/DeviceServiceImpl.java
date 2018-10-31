package com.rahul.demosystem.demosystem.device.service;

import com.rahul.demosystem.demosystem.device.Device;
import com.rahul.demosystem.demosystem.device.DeviceRepository;
import com.rahul.demosystem.demosystem.protocol.Protocol;
import com.rahul.demosystem.demosystem.protocol.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;


@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ProtocolRepository protocolRepository;


    @Override
    public boolean assignProtocolToDevice(Device device, Protocol protocol) throws IOException {

        Device existingDevice;
        Date date = new Date();

        Date effectiveDate = protocol.getEffectiveDate();

        //checking if effective date has come or not
        if(date.before(effectiveDate))
            throw new IOException("Protocol is not valid will be valid after "+effectiveDate);


        //checking if protocol is assigned to someone or not
        existingDevice = protocol.getDevice();

        if(  existingDevice != null )
            throw new IOException("Protocol is already assigned to someone");

        protocol.setDevice(device);

        protocolRepository.save(protocol);

        return true;

    }
}
