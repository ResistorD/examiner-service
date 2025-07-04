package pro.skyjava.course2.examiner.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question target = new Question(question, answer);
        if (!questions.remove(target)) {
            throw new NoSuchElementException("Вопрос не найден");
        }
        return target;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NoSuchElementException("Нет доступных вопросов");
        }
        int index = random.nextInt(questions.size());
        return questions.stream()
                .skip(index)
                .findFirst()
                .orElseThrow(); // Это никогда не случится после проверки на isEmpty
    }
}
