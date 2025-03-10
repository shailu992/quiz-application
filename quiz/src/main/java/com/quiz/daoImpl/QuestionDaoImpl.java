package com.quiz.daoImpl;

import com.quiz.dao.QuestionDao;
import com.quiz.model.QuestionAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public List<QuestionAnswer> findAllActiveQuestionOptions(Connection connection) throws SQLException {

        List<QuestionAnswer> questionAnswers = new ArrayList<>();

        StringBuilder findQuery = new StringBuilder();

        findQuery.append("SELECT ")
                .append(" q.question,q.question_id, ")
                .append(" GROUP_CONCAT(a.answer_id ORDER BY a.answer_id SEPARATOR '---') AS answer_ids, ")
                .append(" GROUP_CONCAT(a.answer ORDER BY a.answer_id SEPARATOR '---') AS answers ")
                .append(" FROM quiz.question q ")
                .append(" JOIN quiz.answer_options ao ON q.question_id = ao.question_id ")
                .append(" JOIN quiz.answer a ON ao.answer_id = a.answer_id ")
                .append(" WHERE q.is_active = 1 AND a.is_active = 1 ")
                .append(" GROUP BY q.question,q.question_id order by q.question_id");


        try (PreparedStatement preparedStatement = connection.prepareStatement(findQuery.toString())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                QuestionAnswer questionAnswer = new QuestionAnswer();
                questionAnswer.setQuestionId(Integer.valueOf(resultSet.getString("QUESTION_ID")));
                questionAnswer.setQuestion(resultSet.getString("QUESTION"));
                questionAnswer.setAnswer(resultSet.getString("ANSWERS"));
                questionAnswer.setAnswerId(resultSet.getString("ANSWER_IDS"));
                questionAnswers.add(questionAnswer);
            }
        }

        return questionAnswers;
    }

    @Override
    public Map<Integer, Integer> findAllQuestionAnswers(Connection connection) throws SQLException {

        Map<Integer, Integer> questionAnswers = new HashMap<>();

        StringBuilder findQuery = new StringBuilder();

        findQuery.append("SELECT QA.QUESTION_ID, QA.ANSWER_ID ")
                .append("FROM QUESTION_ANSWER QA ")
                .append("JOIN QUESTION Q ON QA.QUESTION_ID = Q.QUESTION_ID AND Q.IS_ACTIVE = 1 ")
                .append("JOIN ANSWER_OPTIONS AO ON AO.ANSWER_ID = QA.ANSWER_ID AND AO.IS_ACTIVE = 1");

        String query = findQuery.toString();


        try (PreparedStatement preparedStatement = connection.prepareStatement(findQuery.toString())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer questionId = Integer.valueOf(resultSet.getString("QUESTION_ID"));
                Integer answerId = Integer.valueOf(resultSet.getString("ANSWER_ID"));
                questionAnswers.put(questionId, answerId);
            }
        }


        return questionAnswers;
    }
}
