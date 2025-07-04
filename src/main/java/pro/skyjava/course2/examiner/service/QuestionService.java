package pro.skyjava.course2.examiner.service;

import pro.skyjava.course2.examiner.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
