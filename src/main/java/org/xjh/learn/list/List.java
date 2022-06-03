package org.xjh.learn.list;

public interface List<T> {

    /**
     * 在链表尾部添加元素
     *
     * @param t 添加元素
     */
    void add(T t);

    /**
     * 在链表指定位置添加元素
     *
     * @param index 指定位置
     * @param t     添加元素
     */
    void add(int index, T t);

    /**
     * 获取链表指定位置的元素
     *
     * @param index 指定位置
     * @return 返回指定位置的元素
     */
    T get(int index);

    /**
     * 获取链表指定元素的位置
     *
     * @param t 指定元素
     * @return 返回指定元素的索引
     */
    int get(T t);

    /**
     * 删除链表指定位置的元素
     *
     * @param index 指定位置
     * @return 返回指定位置的元素
     */
    T remove(int index);

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
