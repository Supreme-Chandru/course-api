package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	

	
public List<Course> getAllCourses(String topicId){
	
	
		List<Course> courses = new ArrayList<Course>();
		Iterable<Course> iterable = courseRepository.findByTopicId(topicId);
		Iterator<Course> iterator = iterable.iterator();
		while(iterator.hasNext()){
			courses.add(iterator.next());
		}
		return courses;
	}

public Course getCourse(String id) {
	
	return courseRepository.findOne(id);
	
	
}

public void addCourse(Course course) {
	
	
	courseRepository.save(course);
}

public void updateCourse(String id, Course course) {
	
	courseRepository.save(course);
	
}

public void deleteCourse(String id) {
	
	courseRepository.delete(id);
}
}
