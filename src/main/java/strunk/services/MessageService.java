package strunk.services;

import java.util.List;

import strunk.models.Message;
import strunk.repositories.MessageRepository;
import strunk.repositories.MessageRepositoryImpl;

public class MessageService {
	
	public void addMessage(Message message) {
		MessageRepository repo = new MessageRepositoryImpl();
		repo.addMessage(message);
	}
	
	public List<Message> getAllMessages() {
		MessageRepository repo = new MessageRepositoryImpl();
		return repo.getAllMessages();
	}

}