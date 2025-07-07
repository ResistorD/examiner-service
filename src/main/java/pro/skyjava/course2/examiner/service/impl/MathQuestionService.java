package pro.skyjava.course2.examiner.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.exception.MethodNotAllowedException;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Добавление математических вопросов не поддерживается");
    }

    @Override
    public Question remove(String question, String answer) {
        throw new MethodNotAllowedException("Удаление математических вопросов не поддерживается");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Просмотр всех математических вопросов не поддерживается");
    }

    @Override
    public Question getRandomQuestion() {
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        String question = a + " + " + b;
        String answer = String.valueOf(a + b);
        return new Question(question, answer);
    }
}
