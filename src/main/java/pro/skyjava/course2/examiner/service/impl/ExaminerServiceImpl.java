package pro.skyjava.course2.examiner.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.ExaminerService;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;
    private final Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (questionServices.isEmpty()) {
            throw new IllegalStateException("Нет доступных сервисов вопросов.");
        }

        Set<Question> result = new HashSet<>();

        int safetyLimit = amount * 10; // на случай генераторов с ограниченным разнообразием
        int attempts = 0;

        while (result.size() < amount) {
            if (attempts++ > safetyLimit) {
                throw new IllegalArgumentException("Невозможно сгенерировать достаточно уникальных вопросов.");
            }
            QuestionService service = questionServices.get(random.nextInt(questionServices.size()));
            Question question = service.getRandomQuestion();
            result.add(question);
        }

        return result;
    }
}
