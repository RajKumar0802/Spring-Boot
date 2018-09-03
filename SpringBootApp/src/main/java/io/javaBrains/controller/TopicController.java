/**
 * 
 */
package io.javaBrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javaBrains.model.Topic;
import io.javaBrains.service.TopicService;

/**
 * @author 28963
 *
 */
@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();	
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable Integer id) {
		return topicService.getTopicById(id);
	}

}
