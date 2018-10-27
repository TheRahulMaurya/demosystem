package com.rahul.demosystem.demosystem.tag.service;

import com.rahul.demosystem.demosystem.tag.Tag;

import java.io.IOException;

public interface TagService {

    Tag validateTag(Tag tag) throws IOException;

    boolean isTagExist(int tagId) ;
	

}
