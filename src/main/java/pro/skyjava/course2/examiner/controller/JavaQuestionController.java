package pro.skyjava.course2.examiner.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}


