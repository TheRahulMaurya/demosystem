package com.rahul.demosystem.demosystem.protocol.service;

import com.rahul.demosystem.demosystem.protocol.Protocol;
import com.rahul.demosystem.demosystem.protocol.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProtocolServiceImpl implements ProtocolService{

    @Autowired
    ProtocolRepository protocolRepository;


    @Override
    public void protocolExistOrNot(int protocolId) throws IOException {

        //checking if protocol exists or not
        Protocol existingProtocol = protocolRepository
                                    .findById(protocolId)
                                    .orElse(null);

        if(existingProtocol == null)
        {
            throw new IOException("There is no exixting protocol to update.");
        }


    }
}
