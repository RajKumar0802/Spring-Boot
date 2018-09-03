package io.javaBrains.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.javaBrains.exception.TopicNotFoundException;
import io.javaBrains.model.Topic;
import io.javaBrains.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	private final List<Topic> topics = Arrays.asList(
			new Topic(101, "CoreJava", "CoreJava Description"),
			new Topic(102, "AdvJava", "AdvJava Description"),
			new Topic(103, "Spring", "Spring Description")
			);

	@Override
	public List<Topic> getAllTopics() {
		return topics;
	}

	@Override
	public Topic getTopicById(Integer id) {
		Optional<Topic> optional = topics.stream().filter(topic -> topic.getId().equals(id)).findFirst();
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new TopicNotFoundException("Topic not found for Id : "+id);
		}
	}

}
