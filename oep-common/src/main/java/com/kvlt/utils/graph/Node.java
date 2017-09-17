package com.kvlt.utils.graph;

/**
 * Node
 * 链表中的邻接点
 * @author KVLT
 * @date 2017-07-27.
 */
public class Node<T> {

    public Vertex<T> adjvex;  // 顶点
    public Node<T> next;  // 下一个ling邻接点

    public Node(Vertex<T> t) {
        this.adjvex = t;
    }
}