package io.javaBrains.service;

import java.util.List;

import io.javaBrains.model.Topic;

public interface TopicService {

	List<Topic> getAllTopics();

	Topic getTopicById(Integer id);

}
