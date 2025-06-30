package pro.skyjava.course2.examiner.service;

import pro.skyjava.course2.examiner.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
