package pro.skyjava.course2.examiner.controller;

import org.springframework.web.bind.annotation.*;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
