package org.xjh.learn.list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private Object[] elementData;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 4;


    /**
     * 扩容函数
     *
     * @implNote 无边界检查 ，扩容为原来的2倍
     */
    private void grow() {
        capacity = capacity << 1;
        elementData = Arrays.copyOf(elementData, capacity);
    }


    /**
     * 缩小容量
     *
     * @implNote 无边界检查，需要调用方检测
     */
    private void shrink() {
        elementData = Arrays.copyOf(elementData, capacity >> 1);
        capacity = capacity >> 1;
    }

    /**
     * 检查指定位置是否合法
     *
     * @param index 指定位置
     * @throws IndexOutOfBoundsException 如果指定位置不合法
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }


    public ArrayList() {
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 末尾添加元素
     *
     * @param e 添加元素
     * @implNote 时间复杂度 O(1)
     */
    @Override
    public void add(E e) {
        if (size == capacity) {
            grow();
        }
        elementData[size++] = e;
    }

    /**
     * 指定位置添加元素
     *
     * @param index 指定位置
     * @param e     添加元素
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (size == capacity) {
            grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 指定位置
     * @return 返回指定位置的元素
     * @throws IndexOutOfBoundsException 如果指定位置越界
     * @implNote 时间复杂度 O(1)
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        //noinspection unchecked
        return (E) elementData[index];
    }

    /**
     * @param e 指定元素
     * @return 指定元素的索引 不存在返回-1
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public int get(E e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (e.equals(elementData[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * @param index 指定位置
     * @return 返回指定位置的元素
     * @throws IndexOutOfBoundsException 如果指定位置越界
     * @implNote 时间复杂度 O(n)
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked") E e = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
        if (size == capacity >> 1 && capacity > DEFAULT_CAPACITY) {
            shrink();
        }
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }
}
