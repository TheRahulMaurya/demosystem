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

        Tag oldTag = tagRepository.findByTagId( tag.getTagId() ).orElse(null);

        // checking if role is given to someone or not
        if(oldTag != null)
            throw new IOException(" Role already given to someone...");

        return tag;
    }

    @Override
    public boolean isTagExist(int tagId){
        Tag existingTag = tagRepository
                        .findById(tagId)
                        .orElse(null);

        if(existingTag == null)
            return false;

        return true;
    }
}
