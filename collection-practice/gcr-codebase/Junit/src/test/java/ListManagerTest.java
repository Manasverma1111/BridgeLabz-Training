package Junit.src.test.java;

import Junit.src.main.java.org.example.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
//        ListManager listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        ListManager.addElements(list, 10);
        ListManager.addElements(list, 20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);

        ListManager.removeElement(list, 10);

        assertFalse(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    void testGetSize() {
        ListManager.addElements(list, 10);
        ListManager.addElements(list, 20);
        ListManager.addElements(list, 30);

        assertEquals(3, ListManager.getSize(list));

        ListManager.removeElement(list, 20);
        assertEquals(2, ListManager.getSize(list));
    }
}
