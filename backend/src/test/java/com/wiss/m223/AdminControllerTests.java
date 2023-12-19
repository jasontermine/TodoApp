package com.wiss.m223;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.wiss.m223.model.Status;
import com.wiss.m223.model.Todo;
import com.wiss.m223.model.Status.EStatus;
import com.wiss.m223.repository.TodoRepository;

/**
 * Diese Klasse enthält Tests für den AdminController.
 */
@SpringBootTest
public class AdminControllerTests {

    @Mock
    private TodoRepository todoRepository;

    /**
     * Testet die Methode getTodo.
     */
    @Test
    void testGetTodo() {

        // Arrange
        Todo todo1 = new Todo("Test 1", "Message für Test 1");
        Todo todo2 = new Todo("Test 2", "Message für Test 2", new Status(EStatus.STATUS_OFFEN));
        List<Todo> mockTodos = Arrays.asList(todo1, todo2);

        // Act
        when(todoRepository.findAll()).thenReturn(mockTodos);
        List<Todo> resultTodos = todoRepository.findAll();

        // Assert
        assertFalse(resultTodos.isEmpty(), "Erwartete List sollte nicht leer sein");
        assertEquals(2, resultTodos.size(), "Erwartete Listengrösse: 2");
    }

    /**
     * Testet den Konstruktor der Klasse Todo.
     */
    @Test
    void testTodoContructor() {
        // Arrange
        Todo todo = new Todo("Test 3", "Message für Test 3");
    
        // Act
        String name = todo.getName();
        String message = todo.getMessage();

        // Assert
        assertEquals("Test 3", name);
        assertEquals("Message für Test 3", message);
    }

}
