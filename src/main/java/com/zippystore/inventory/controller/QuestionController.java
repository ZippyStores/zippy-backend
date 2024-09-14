package com.zippystore.inventory.controller;

import com.zippystore.inventory.models.Question;
import com.zippystore.inventory.service.question.QuestionService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing questions in the quiz application.
 */
@RestController
@RequestMapping(value = "/question", produces = "application/json")
@Data
@Slf4j
public class QuestionController {

    @Autowired
    private final QuestionService questionService;

    /**
     * Retrieves all questions from the database.
     *
     * @return a list of all questions.
     */
    @GetMapping()
    public List<Question> getAllQuestions() {
        log.info("Fetching all questions");
        return questionService.getAllQuestions();
    }

    /**
     * Retrieves a specific question by its ID.
     *
     * @param id The ID of the question to retrieve.
     * @return The question with the specified ID.
     */
    @GetMapping(value = "/{id}")
    public Question getQuestionById(@PathVariable final Integer id) {
        log.info("Fetching question with id: [{}]", id);
        return questionService.getQuestionById(id);
    }

    /**
     * Updates an existing question.
     *
     * @param id       The ID of the question to update.
     * @param question The updated question object.
     * @return The updated question.
     */
    @PutMapping(value = "/{id}")
    public Question updateQuestion(
            @PathVariable final Integer id, @RequestBody final Question question) {
        log.info("Update question with question id : [{}]", question.getId());
        return questionService.updateQuestion(id, question);
    }

    /**
     * Creates a new question.
     *
     * @param question The question object to create.
     * @return The created question.
     */
    @PostMapping()
    public Question createQuestion(@RequestBody final Question question) {
        log.info("Creating question : [{}]", question);
        return questionService.createQuestion(question);
    }

    /**
     * Deletes a question by its ID.
     *
     * @param id The ID of the question to delete.
     */
    @DeleteMapping(value = "{id}")
    public void deleteQuestion(@PathVariable final Integer id) {
        log.info("Deleting the qeustion with id : [{}]", id);
        questionService.deleteQuestionById(id);
    }
}
