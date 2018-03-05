package de.codeboje.springbootbook.commentstore.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.codeboje.springbootbook.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, String> {
	
	//@Query("select a from Comment a where a.pageId = ?1")
	List<Comment> findByPageId(String pageId);

	List<Comment> findByPageIdAndSpamIsTrue(String pageId);

	
}
