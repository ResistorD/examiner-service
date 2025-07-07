package pro.skyjava.course2.examiner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.skyjava.course2.examiner.domain.Question;
import pro.skyjava.course2.examiner.service.QuestionService;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.web.server.ResponseStatusException;

class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerService;
    private QuestionService questionService;

    private final Question q1 = new Question("Q1", "A1");
    private final Question q2 = new Question("Q2", "A2");
    private final Question q3 = new Question("Q3", "A3");

    @BeforeEach
    void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(List.of(questionService));
    }

    @Test
    void getQuestions_ShouldReturnCorrectAmount() {
        when(questionService.getAll()).thenReturn(Set.of(q1, q2, q3));

        var result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(q1) || result.contains(q2) || result.contains(q3));
    }

    @Test
    void getQuestions_ShouldReturnAllIfAmountEqualsSize() {
        when(questionService.getAll()).thenReturn(Set.of(q1, q2));

        var result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
    }

    @Test
    void getQuestions_ShouldThrowIfAmountTooLarge() {
        when(questionService.getAll()).thenReturn(Set.of(q1));

        assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(5));
    }
}
