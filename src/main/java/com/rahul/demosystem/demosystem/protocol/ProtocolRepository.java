package com.rahul.demosystem.demosystem.protocol;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends CrudRepository<Protocol , Integer> {
}
