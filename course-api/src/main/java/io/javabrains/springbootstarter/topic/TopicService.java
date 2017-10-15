package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework","Spring Framework Description"),
			new Topic("node", "Node Framework","Node Framework Description"),
			new Topic("java", "Java Framework","Java Framework Description")
			
			));
	
public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		Iterable<Topic> iterable = topicRepository.findAll();
		Iterator<Topic> iterator = iterable.iterator();
		while(iterator.hasNext()){
			topics.add(iterator.next());
		}
		return topics;
	}

public Topic getTopic(String id) {
	
	//topics.stream().filter(t -> t.getId().equals(id)).get();
	return topicRepository.findOne(id);
	
	/*
	 * for(int i=0;i<topics.size();i++){
		if(topics.get(i).getId().equals(id)){
			return topics.get(i);
		}
	}
	return null;
	*/
}

public void addTopic(Topic topic) {
	topicRepository.save(topic);
}

public void updateTopic(String id, Topic topic) {
	
	topicRepository.save(topic);
	/*
	for(int i=0;i<topics.size();i++){
		if(topics.get(i).getId().equals(id)){
			topic.setId(id);
			topics.set(i, topic);
			return;
		}
	}
	*/
}

public void deleteTopic(String id) {
	/*for(int i=0;i<topics.size();i++){
		if(topics.get(i).getId().equals(id)){
			topics.remove(i);
			return;
		}
	}*/
	
	topicRepository.delete(id);
}
}
