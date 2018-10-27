package com.rahul.demosystem.demosystem.tag;

import com.rahul.demosystem.demosystem.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/tag")
public class TagController {
	
	@Autowired
	TagRepository tagRepository;

	@Autowired
	TagService tagService;
	
	//Get all users
	@GetMapping("/all")
	public Iterable<Tag> allTag()
	{
		Iterable<Tag> tags = tagRepository.findAll();
		return tags;
	}


	//Create a new tag
	@PostMapping("/create")
	public Iterable<Tag> createTag( @RequestBody Tag tag) throws IOException {

		tagService.validateTag(tag);

		tagRepository.save(tag);
		Iterable<Tag> tags = tagRepository.findAll();
		return tags;
	}



	//Let's update existing tag
	@PutMapping("/update")
	public Iterable<Tag> updateTag(@RequestBody Tag tag) throws IOException{

		//checking for the existence of tag
		if(!tagService.isTagExist(tag.getTagId()))
			throw new IOException("Tag doesn't exist which you want to update..");

		tagRepository.save(tag);

		//Just for convenience
		Iterable<Tag> tags = tagRepository.findAll();
		return tags;
	}

	//Let's remove some tags
	@DeleteMapping("/delete/{tagId}")
	public Iterable<Tag> deleteTag(@PathVariable("tagId") int tagId) throws IOException
	{
		//checking for the existence of tag
		if(!tagService.isTagExist(tagId))
			throw new IOException("Tag that you want to delete doesn't exist");

		tagRepository.deleteById(tagId);

		Iterable<Tag> tags = tagRepository.findAll();
		return tags;
	}


}
