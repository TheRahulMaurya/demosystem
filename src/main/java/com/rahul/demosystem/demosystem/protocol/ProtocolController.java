package com.rahul.demosystem.demosystem.protocol;

import com.rahul.demosystem.demosystem.protocol.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/protocol")
public class ProtocolController {

    @Autowired
    ProtocolRepository protocolRepository;

    @Autowired
    ProtocolService protocolService;


    //get all protocols
    @ResponseBody
    @GetMapping("/all")
    public Iterable<Protocol> allProtocol()
    {
        Iterable<Protocol> protocols = protocolRepository.findAll();
        return protocols;
    }


    //create a protocol
    @PostMapping("/create")
    public Iterable<Protocol> createProtocol(@RequestBody Protocol protocol) throws IOException {

        protocolRepository.save(protocol);

        Iterable<Protocol> protocols = protocolRepository.findAll();
        return protocols;
    }



    //Lets update some protocols
    @PutMapping("/update")
    public Iterable<Protocol> updateTag(@RequestBody Protocol protocol) throws IOException {

        protocolService.protocolExistOrNot(protocol.getProtocolId());

        protocolRepository.save(protocol);

        Iterable<Protocol> protocols = protocolRepository.findAll();
        return protocols;
    }


    //Let's delete some protocols
    @DeleteMapping("/delete/{protocolId}")
    public Iterable<Protocol> deleteProtocol(@PathVariable("protocolId") int protocolId) throws IOException {

        protocolService.protocolExistOrNot(protocolId);

        protocolRepository.deleteById(protocolId);

        Iterable<Protocol> protocols = protocolRepository.findAll();
        return protocols;

    }
}
