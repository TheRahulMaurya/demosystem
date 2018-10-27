package com.rahul.demosystem.demosystem.tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {


    //Return a Tag which is already exist with given description
    Optional<Tag> findByTagId( int tagId );

}
