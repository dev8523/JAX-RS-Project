package org.debasish.infinite.messenger.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.debasish.infinite.messenger.database.DatabaseClass;
import org.debasish.infinite.messenger.model.Message;

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

	public String updateMessage(Message message) {
		Optional<Long> checkNull = Optional.ofNullable(message.getId());
		if (message.getId() <= 0 || !checkNull.isPresent()) {
			return "Invalid ID entered";
		} else {
			messages.put(message.getId(), message);
			return "Message updated with: " + message;
		}
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
