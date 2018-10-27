package com.rahul.demosystem.demosystem.tag.service;

import com.rahul.demosystem.demosystem.tag.Tag;
import com.rahul.demosystem.demosystem.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag validateTag(Tag tag) throws IOException {

        Tag oldTag = tagRepository.findByDescription( tag.getDescription() ).orElse(null);

        if(oldTag != null)
            throw new IOException(" Description already exist..");


        return tag;
    }
}
