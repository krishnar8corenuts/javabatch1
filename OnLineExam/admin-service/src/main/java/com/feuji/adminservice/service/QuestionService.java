package com.feuji.adminservice.service;

import java.util.Set;

import com.feuji.adminservice.repo.QuestionRepository;
import com.feuji.adminservice.repo.SubjectRepository;
import com.feuji.commonmodel.Question;
import com.feuji.commonmodel.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	public Question addquestion(Question question, Long id) {
		Subject subject = subjectRepository.findById(id).get();
		question.setSubject(subject);
		question.setStatus("active");
		return questionRepository.save(question);
	}

	public Set<Question> getAllQuestions(Long id) {
		Set<Question> set = questionRepository.findBySubjectId(id);
		return set;
	}

	public Question updatequestions(Question question) {
		Question question1 = questionRepository.findById(question.getId()).get();
		question1.setContent(question.getContent());
		question1.setOptionA(question.getOptionA());
		question1.setOptionB(question.getOptionB());
		question1.setOptionC(question.getOptionC());
		question1.setOptionD(question.getOptionD());
		question1.setAnswer(question.getAnswer());
		question1.setQtype(question.getQtype());
		 return questionRepository.saveAndFlush(question1);
	}

	public Question getQuestionById(Long id) {

		return questionRepository.findById(id).get();
	}
	public void deleteQuestionById(Long id) {

		Question question = questionRepository.findById(id).get();
		question.setStatus("inactive");

		 questionRepository.saveAndFlush(question);
	}

}
