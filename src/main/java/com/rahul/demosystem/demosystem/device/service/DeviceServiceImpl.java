package com.rahul.demosystem.demosystem.device.service;

import com.rahul.demosystem.demosystem.device.Device;
import com.rahul.demosystem.demosystem.device.DeviceRepository;
import com.rahul.demosystem.demosystem.protocol.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceRepository deviceRepository;


    @Override
    public List<Protocol> assignProtocolToDevice(Device device, Protocol protocol) throws IOException {

        Date date = new Date();

        Date effectiveDate = protocol.getEffectiveDate();

        //checking if effective date has come or not
        if(date.before(effectiveDate))
            throw new IOException("Protocol is not valid will be valid after "+effectiveDate);


        //checking if protocol is assigned to someone or not
        Device deviceHavingProtocol = deviceRepository.findByProtocol(protocol).orElse(null);

        if(  deviceHavingProtocol != null )
            throw new IOException("Protocol is already assigned to someone");

        List<Protocol> protocolList = device.getProtocols();
        protocolList.add(protocol);

        return protocolList;

    }
}
