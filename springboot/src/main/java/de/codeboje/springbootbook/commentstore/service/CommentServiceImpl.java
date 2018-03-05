package de.codeboje.springbootbook.commentstore.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import de.codeboje.springbootbook.model.Comment;
import de.codeboje.springbootbook.spamdetection.SpamDetector;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SpamDetector spamDetector;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	@Transactional
	public String put(Comment model) throws IOException {

		if (StringUtils.isEmpty(model.getId())) {
			model.setId(UUID.randomUUID().toString());
		}
		if (spamDetector.containsSpam(model.getUserName()) || spamDetector.containsSpam(model.getEmailAddress())) {
			model.setSpam(true);
		}

		final Comment dbModel = get(model.getId());
		if (dbModel != null) {
			dbModel.setUserName(model.getUserName());
			dbModel.setLastModificationDate(Calendar.getInstance().toInstant());
			commentRepository.save(dbModel);
		} else {
			model.setCreationDate(Calendar.getInstance().toInstant());
			model.setLastModificationDate(Calendar.getInstance().toInstant());
			commentRepository.save(model);
		}

		return model.getId();
	}

	@Override
	public List<Comment> list(String pageId) throws IOException {
		return commentRepository.findByPageId(pageId);
	}

	@Override
	public Comment get(String id) {
		return commentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Comment> listSpamComments(String pageId) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
