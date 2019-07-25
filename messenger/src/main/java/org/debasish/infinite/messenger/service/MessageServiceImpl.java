package org.debasish.infinite.messenger.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.debasish.infinite.messenger.dao.MessageDaoImpl;
import org.debasish.infinite.messenger.model.Message;

@Path("/come")
public class MessageServiceImpl {

	MessageDaoImpl messageDao = new MessageDaoImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		
		return messageDao.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")	//here messageId is a variable
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) //provide same variable name as in@Path
	{	
		return messageDao.getMessage(id);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageDao.addMessage(message);
	}
	
	@PUT
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageID") long id, Message message) {
		message.setId(id);
		return messageDao.updateMessage(message);
	}
	
	@DELETE
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMesssage(@PathParam("msgId")long id) {
		messageDao.removeMessage(id);
	}
	
	
	
}
