package com.zippystore.inventory.service.question;

import com.zippystore.inventory.models.Question;
import com.zippystore.inventory.repository.QuestionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the QuestionService interface for managing questions.
 */
@Service
@Data
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    /**
     * Retrieves all questions from the database.
     *
     * @return a list of all questions.
     */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * Retrieves a question by its unique identifier.
     *
     * @param id the unique identifier of the question.
     * @return the question with the specified ID.
     * @throws jakarta.persistence.EntityNotFoundException if no question exists with the given ID.
     */
    @Override
    public Question getQuestionById(Integer id) {
        return questionRepository.getReferenceById(id);
    }


    /**
     * Updates an existing question in the database.
     *
     * @param question the question to be updated.
     * @return the updated question.
     */
    @Override
    public Question updateQuestion(Integer id, Question question) {
        Optional<Question> existingQuestion = questionRepository.findById(id);
        if (existingQuestion.isPresent()) {
            return questionRepository.save(question);
        } else {
            throw new IllegalArgumentException("Question not found with id: " + question.getId());
        }
    }

    /**
     * Creates a new question and saves it to the database.
     *
     * @param question the question to be created.
     * @return the created question with any generated ID or additional fields.
     */
    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    /**
     * Deletes a question from the database by its ID.
     *
     * @param id the ID of the question to be deleted.
     */
    @Override
    public void deleteQuestionById(int id) {
        questionRepository.deleteById(id);
    }

    /**
     * Deletes a given question from the database.
     *
     * @param question the question to be deleted.
     */
    @Override
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }
}
