package com.niit.collaboration_backend.test;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaboration_backend.dao.EventMasterDAO;
import com.niit.collaboration_backend.model.Blog;
import com.niit.collaboration_backend.model.EventMaster;

public class EventTest 
{
	private static 	AnnotationConfigApplicationContext context;
	private static EventMasterDAO eventmasterDao;
	private EventMaster event;
//	private static final Logger log = LoggerFactory.getLogger(BlogTest.class);

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration_backend");
		context.refresh();
		
		eventmasterDao =  (EventMasterDAO)context.getBean("eventmasterDao",EventMasterDAO.class);
		//userProfile =(UserProfile)context.getBean("userProfile");
	}
	
	//@Test
	 public void SaveEvent()
	 {
		event=new EventMaster();
	  event.setEventid(0);
	  event.setDescription("This is Event Added by Test Case");
	  event.setVenue("Mumbai");
	  event.setSubject("Test Class");
	  event.setEventdt(new Date().toString());
	  
	  assertEquals("Event Added", true,eventmasterDao.saveEvent(event));
	 }
	
	//@Test
	 public void getAllEvents()
	 {
	  	assertEquals("Events fetched Successfully ",1, eventmasterDao.getAllEvents('Y').size());
	 }
	
	//@Test
	public void getById()
	{
		event=eventmasterDao.getEventByID(1);
		assertEquals("event fetched Successfully ", eventmasterDao.getEventByID(1).getEventid(),event.getEventid());
	}
	//@Test
	 public void deleteEvent()
	 {
	  	assertEquals("Event deleted Successfully ",true, eventmasterDao.removeEvent(61));
	 }
	
}
