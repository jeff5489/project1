package strunk.repositories;

import java.util.List;

import strunk.models.Message;

public interface MessageRepository {
	
	public Message getMessage(int id);
	public boolean addMessage(Message message);
	public List<Message> getAllMessages();
	public boolean updateMessage(Message message);
	public boolean deleteMessage(int id);

}
