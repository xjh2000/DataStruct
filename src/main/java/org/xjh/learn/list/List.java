package org.xjh.learn.list;

public interface List<E> {

    /**
     * 在链表尾部添加元素
     *
     * @param e 添加元素
     */
    void add(E e);

    /**
     * 在链表指定位置添加元素
     *
     * @param index 指定位置
     * @param e     添加元素
     * @throws IndexOutOfBoundsException 如果指定位置不合法
     */
    void add(int index, E e);

    /**
     * 获取链表指定位置的元素
     *
     * @param index 指定位置
     * @return 返回指定位置的元素
     * @throws IndexOutOfBoundsException 如果指定位置越界
     */
    E get(int index);

    /**
     * 获取链表指定元素的位置
     *
     * @param e 指定元素
     * @return 返回指定元素的索引 不存在返回-1
     * @implNote 如果链表中存在多个相同元素，返回第一个元素的索引
     */
    int get(E e);

    /**
     * 删除链表指定位置的元素
     *
     * @param index 指定位置
     * @return 返回指定位置的元素
     */
    E remove(int index);

    /**
     * 获取链表的元素个数
     *
     * @return 返回链表的大小
     */
    int size();

    /**
     * 判断链表是否为空
     *
     * @return 返回链表是否为空
     */
    boolean isEmpty();

    /**
     * 清空链表
     */
    void clear();
}
