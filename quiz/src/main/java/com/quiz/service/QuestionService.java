package com.quiz.service;

import com.quiz.dto.QuestionAnswerDto;
import com.quiz.model.QuestionAnswer;
import com.quiz.serviceImpl.QuestionServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface QuestionService  {
    List<QuestionAnswerDto> findAllActiveQuestionOptions() throws SQLException;
    Map<Integer, Integer> findAllQuestionAnswers() throws SQLException;

}
