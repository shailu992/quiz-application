package com.quiz.serviceImpl;

import com.quiz.common.DataSourceManager;
import com.quiz.daoImpl.QuestionDaoImpl;
import com.quiz.dto.QuestionAnswerDto;
import com.quiz.model.QuestionAnswer;
import com.quiz.service.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDaoImpl questionDao = new QuestionDaoImpl();

    private static final Logger logger = LogManager.getLogger(QuestionServiceImpl.class);

    @Override
    public List<QuestionAnswerDto> findAllActiveQuestionOptions() throws SQLException {
        Connection conn = null;
        List<QuestionAnswerDto> questionAnswerList = new ArrayList<>();

        try {
            conn = DataSourceManager.getDataSource().getConnection();

            List<QuestionAnswer> questionAnswers = questionDao.findAllActiveQuestionOptions(conn);

            if (questionAnswers != null && !questionAnswers.isEmpty()) {
                for (QuestionAnswer questionAnswer : questionAnswers) {
                    QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
                    questionAnswerDto.setQuestionId(questionAnswer.getQuestionId());
                    questionAnswerDto.setQuestion(questionAnswer.getQuestion());
                    questionAnswerDto.setAnswers(getAnswerDto(questionAnswer));
                    questionAnswerList.add(questionAnswerDto);
                }
            }


        } catch (SQLException sqlException) {
            logger.error("Exception while finding Active Question Options", sqlException.getMessage());
            conn.close();
            logger.error("Connection closed");

        }
        return questionAnswerList;
    }

    @Override
    public Map<Integer, Integer> findAllQuestionAnswers() throws SQLException {

        Connection conn = null;
        Map<Integer, Integer> questionMap = new HashMap<>();

        try {
            conn = DataSourceManager.getDataSource().getConnection();
            questionMap = questionDao.findAllQuestionAnswers(conn);

        } catch (SQLException sqlException) {
            logger.error("Exception while finding Question Answers", sqlException.getMessage());
            conn.close();
            logger.error("Connection closed");

        }
        return questionMap;
    }

    public List<QuestionAnswerDto.AnswerDto> getAnswerDto(QuestionAnswer questionAnswer) {
        List<QuestionAnswerDto.AnswerDto> list = new ArrayList<>();

        if (questionAnswer != null) {
            String answer = questionAnswer.getAnswer();
            String answerId = questionAnswer.getAnswerId();

            List<String> answers = List.of(answer.split("---"));
            List<String> answerIds = List.of(answerId.split("---"));

            if (answers != null && !answers.isEmpty()) {


                for (int i = 0; i < answers.size(); i++) {
                    QuestionAnswerDto.AnswerDto answerDto = new QuestionAnswerDto.AnswerDto();
                    String ans = answers.get(i);
                    String ansId = answerIds.get(i);
                    if (ans != null && ansId != null) {
                        answerDto.setAnswer(ans.trim());
                        answerDto.setAnswerId(Integer.valueOf(ansId.trim()));
                        list.add(answerDto);
                    }
                }

            }

        }

        return list;
    }
}
