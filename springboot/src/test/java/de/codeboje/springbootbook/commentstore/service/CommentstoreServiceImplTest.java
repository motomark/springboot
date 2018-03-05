package de.codeboje.springbootbook.commentstore.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.codeboje.springbootbook.commentstore.service.CommentRepository;
import de.codeboje.springbootbook.commentstore.service.CommentService;
import de.codeboje.springbootbook.model.Comment;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class CommentstoreServiceImplTest {

	@Autowired
	private CommentService service;
	
	@Autowired
	private CommentRepository commentRepository;

	private Comment model;

	

	@Before
	public void setup() {
		model = new Comment();
		model.setUserName("testUser");
		model.setId("dqe345e456rf34rw");
		model.setPageId("product0815");
		model.setEmailAddress("example@example.com");
		commentRepository.deleteAll();
	}
	
	
	@Test
	public void testPutAndGet() throws IOException {
		service.put(model);

		Comment dbModel = service.get(model.getId());
		assertNotNull(dbModel);
		assertEquals(model.getId(), dbModel.getId());
		assertEquals(model.getPageId(), dbModel.getPageId());
		assertEquals(model.getEmailAddress(), dbModel.getEmailAddress());
		assertNotNull(dbModel.getLastModificationDate());
		assertNotNull(dbModel.getCreationDate());
		assertFalse(model.isSpam());
	}


	@Test
	public void testListNotFound() throws IOException {
		service.put(model);
		List<Comment> r = service.list("notfound");
		assertTrue(r.isEmpty());
	}

}
