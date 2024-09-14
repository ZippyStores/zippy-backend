package com.zippystore.inventory.service.question;

import com.zippystore.inventory.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing questions in the quiz application.
 */
@Service
public interface QuestionService {

    /**
     * Retrieves all questions from the database.
     *
     * @return a list of all questions.
     */
    public List<Question> getAllQuestions();

    /**
     * Retrieves a question by its unique identifier.
     *
     * @param id the unique identifier of the question.
     * @return the question with the specified ID.
     * @throws jakarta.persistence.EntityNotFoundException if no question exists with the given ID.
     */
    Question getQuestionById(Integer id);

    /**
     * Updates an existing question in the database.
     *
     * @param question the question to be updated.
     * @return the updated question.
     */
    public Question updateQuestion(Integer id, Question question);

    /**
     * Creates a new question and saves it to the database.
     *
     * @param question the question to be created.
     * @return the created question with any generated ID or additional fields.
     */
    public Question createQuestion(Question question);

    /**
     * Deletes a question from the database by its ID.
     *
     * @param id the ID of the question to be deleted.
     */
    public void deleteQuestionById(int id);

    /**
     * Deletes a given question from the database.
     *
     * @param question the question to be deleted.
     */
    public void deleteQuestion(Question question);
}
