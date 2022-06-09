package org.xjh.learn.list;

public class LinkList<E> implements List<E> {

    private int size;
    private final Node<E> head;
    private final Node<E> tail;


    public LinkList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(head, null, null);
        head.next = tail;
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    /**
     * 查找指定位置的元素的前驱
     *
     * @param index 元素的索引
     * @return 元素的前驱
     */
    private Node<E> getNodePrev(int index) {
        checkIndex(index);
        Node<E> node = head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    /**
     * 检查索引是否合法
     *
     * @param index 元素的索引
     * @throws IndexOutOfBoundsException 如果索引超出范围
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 在末尾插入元素
     *
     * @param e 添加元素
     * @implNote 时间复杂度 O(1)
     */
    @Override
    public void add(E e) {
        Node<E> node = new Node<>(tail.prev, e, tail);
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * 在指定位置插入元素
     *
     * @param index 插入位置
     * @param e     插入元素
     * @throws IndexOutOfBoundsException 如果 index 小于 0 或者 index 大于 size
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public void add(int index, E e) {
        Node<E> node = getNodePrev(index);
        Node<E> newNode = new Node<>(node, e, node.next);
        node.next.prev = newNode;
        node.next = newNode;
        size++;
    }


    /**
     * 获取指定位置的元素
     *
     * @param index 指定位置
     * @return 返回指定位置的元素
     * @throws IndexOutOfBoundsException 如果指定位置越界
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> findNode = head;
        for (int i = 0; i < index + 1; i++) {
            findNode = findNode.next;
        }
        return findNode.item;
    }

    /**
     * 获取元素的位置
     *
     * @param e 指定元素
     * @return 元素的位置 如果没有找到返回-1
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public int get(E e) {
        int index = -1;
        Node<E> tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode = tempNode.next;
            if (tempNode.item.equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 指定位置
     * @return 被删除的元素
     * @throws IndexOutOfBoundsException 如果 index 小于 0 或者 index 大于 size
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public E remove(int index) {
        Node<E> node = getNodePrev(index).next;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
}
