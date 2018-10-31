package com.rahul.demosystem.demosystem.device.service;

import com.rahul.demosystem.demosystem.device.Device;
import com.rahul.demosystem.demosystem.protocol.Protocol;

import java.io.IOException;

public interface DeviceService {


    boolean assignProtocolToDevice(Device device , Protocol protocol) throws IOException;
}
