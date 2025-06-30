package pro.skyjava.course2.examiner.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.skyjava.course2.examiner.domain.Question;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void add_ShouldAddQuestion() {
        Question q = service.add("What is Java?", "A programming language");
        assertTrue(service.getAll().contains(q));
    }

    @Test
    void remove_ShouldRemoveExistingQuestion() {
        Question q = service.add("Q1", "A1");
        Question removed = service.remove("Q1", "A1");
        assertEquals(q, removed);
        assertFalse(service.getAll().contains(q));
    }

    @Test
    void remove_ShouldThrowIfNotFound() {
        assertThrows(NoSuchElementException.class, () -> service.remove("Q2", "A2"));
    }

    @Test
    void getAll_ShouldReturnAllAddedQuestions() {
        Question q1 = service.add("Q1", "A1");
        Question q2 = service.add("Q2", "A2");
        Collection<Question> all = service.getAll();
        assertTrue(all.contains(q1));
        assertTrue(all.contains(q2));
        assertEquals(2, all.size());
    }

    @Test
    void getRandomQuestion_ShouldReturnOneOfAddedQuestions() {
        Question q1 = service.add("Q1", "A1");
        Question q2 = service.add("Q2", "A2");
        Question random = service.getRandomQuestion();
        assertTrue(random.equals(q1) || random.equals(q2));
    }

    @Test
    void getRandomQuestion_ShouldThrowIfEmpty() {
        assertThrows(NoSuchElementException.class, () -> service.getRandomQuestion());
    }
}
