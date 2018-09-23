package com.tangoe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tangoe.dbmodel.Course;
import com.tangoe.dbmodel.CourseRepository;


@Service
public class CourseService {

	private CourseRepository mCourseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> lstCourses = new ArrayList<>();
		mCourseRepository.findByTopicId(topicId).forEach(lstCourses::add);
		return lstCourses;
	}

	public void addCourse(Course course) {
		mCourseRepository.save(course);
	}

	public Course getCourse(String id) {
		Optional<Course> lOptionalCourse = mCourseRepository.findById(id);
		return lOptionalCourse.get();
	}

	public void updateCourse(String id, Course course) {

		mCourseRepository.save(course);

	}

	public void deleteTopic(String id) {
		mCourseRepository.deleteById(id);
	}
}
