package com.tangoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tangoe.dbmodel.Topic;
import com.tangoe.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService mTopicService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return mTopicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return mTopicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		mTopicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		mTopicService.updateTopic(id, topic);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		mTopicService.deleteTopic(id);
	}
}
