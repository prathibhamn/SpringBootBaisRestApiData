package com.tangoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tangoe.dbmodel.Course;
import com.tangoe.dbmodel.Topic;
import com.tangoe.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService mCourseService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return mCourseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable String id, @PathVariable String courseId) {
		return mCourseService.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		mCourseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		mCourseService.updateCourse(courseId, course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		mCourseService.deleteTopic(courseId);
	}
}
