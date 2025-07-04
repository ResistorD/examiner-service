package pro.skyjava.course2.examiner.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.QuestionService;

import javax.management.openmbean.CompositeData;
import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}

