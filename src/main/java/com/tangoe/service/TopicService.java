package com.tangoe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangoe.dbmodel.Topic;
import com.tangoe.dbmodel.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> lstTopics = new ArrayList<>();
		topicRepository.findAll().forEach(lstTopics::add);
		return lstTopics;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public Topic getTopic(String id) {
		Optional<Topic> lOptionalTopic = topicRepository.findById(id);
		return lOptionalTopic.get();
	}

	public void updateTopic(String id, Topic topic) {

		topicRepository.save(topic);

	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
