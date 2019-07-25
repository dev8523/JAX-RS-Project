package org.debasish.infinite.messenger.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.debasish.infinite.messenger.database.DatabaseClass;
import org.debasish.infinite.messenger.model.Message;
import org.debasish.infinite.messenger.model.Profile;

public class MessageDaoImpl {
	 
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageDaoImpl() {
		messages.put(1L, new Message(1, "First Message", "Author1"));
		messages.put(2L, new Message(2, "Second Message", "Author2"));
		messages.put(3L, new Message(3, "Third Message", "Author3"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());		
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		} else {
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
