package org.xjh.learn.list;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkListTest {

    private static final List<Integer> list = new LinkList<>();


    @Test
    @Order(0)
    void add() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
    }

    @Test
    @Order(10)
    void testAdd() {
        list.add(2, 3);
    }

    @Test
    @Order(20)
    void remove() {
        assertEquals(1, list.remove(0));
    }

    @Test
    @Order(30)
    void get() {
        assertEquals(3, list.get(1).intValue());
    }

    @Test()
    @Order(31)
    void testGet() {
        assertEquals(3, list.get(Integer.valueOf(5)));
    }

    @Test
    @Order(40)
    void size() {
        assertEquals(4, list.size());
    }

    @Test
    @Order(50)
    void clear() {
        list.clear();
    }


    @Test
    @Order(51)
    void isEmpty() {
        assertTrue(list.isEmpty());
    }


}