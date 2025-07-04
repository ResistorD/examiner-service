package pro.skyjava.course2.examiner.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.ExaminerService;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        int totalAvailable = questionServices.stream()
                .mapToInt(s -> s.getAll().size())
                .sum();

        if (amount > totalAvailable) {
            throw new IllegalArgumentException("Запрошено больше вопросов, чем есть в базе");
        }

        Set<Question> result = new HashSet<>();
        Random random = new Random();

        while (result.size() < amount) {
            QuestionService service = questionServices.get(random.nextInt(questionServices.size()));
            Question question = service.getRandomQuestion();
            result.add(question);
        }

        return result;
    }
}
