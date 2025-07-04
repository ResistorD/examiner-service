package pro.skyjava.course2.examiner.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    public MathQuestionService() {
        questions.add(new Question("2 + 2", "4"));
        questions.add(new Question("5 * 6", "30"));
        questions.add(new Question("10 - 3", "7"));
        questions.add(new Question("9 / 3", "3"));
        questions.add(new Question("√16", "4"));
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question remove(String question, String answer) {
        Question q = new Question(question, answer);
        if (!questions.remove(q)) {
            throw new IllegalArgumentException("Вопрос не найден: " + q);
        }
        return q;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("Нет доступных вопросов.");
        }
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                .findFirst()
                .orElseThrow();
    }
}
