package io.javaBrains.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.javaBrains.exception.TopicNotFoundException;
import io.javaBrains.model.Topic;
import io.javaBrains.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	private  List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic(101, "CoreJava", "CoreJava Description"),
			new Topic(102, "AdvJava", "AdvJava Description"),
			new Topic(103, "Spring", "Spring Description")
			));
	

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

	@Override
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	@Override
	public List<Topic> updateTopic(Topic topic, Integer id) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
		return topics;
	}

	@Override
	public List<Topic> deleteTopic(Integer id) {
		topics.removeIf(t -> t.getId().equals(id));
		return topics;
	}

}
