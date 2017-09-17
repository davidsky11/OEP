package com.kvlt.utils.graph;

/**
 * Vertex
 * 图中的顶点
 * @author KVLT
 * @date 2017-07-27.
 */
public class Vertex<T> {

    public T data;  // 数据
    public Node<T> firstLinkNode;  // 第一个邻接节点
    public boolean visited;  // 访问标志，遍历时使用
    public int inDegree;  // 该节点入度

    public Vertex(T t) {
        this.data = t;
    }
}
