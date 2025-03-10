package com.quiz.dao;

import com.quiz.model.QuestionAnswer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface QuestionDao {

    List<QuestionAnswer> findAllActiveQuestionOptions(Connection connection) throws SQLException;

    Map<Integer,Integer> findAllQuestionAnswers(Connection connection) throws SQLException;

}
