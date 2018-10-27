package com.rahul.demosystem.demosystem.device;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device , Integer> {

    Optional<Device> findByDeviceId(int deviceId);
}
