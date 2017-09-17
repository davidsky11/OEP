package com.kvlt.utils.graph;

import com.kvlt.exception.ArgumentException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * AdjacencyList
 * 图的邻接表表示类
 * @author KVLT
 * @date 2017-07-27.
 */
public class AdjacencyList<T> {

    List<Vertex<T>> items;  // 图的顶点集合

    public AdjacencyList() {
        items = new ArrayList<Vertex<T>>();
    }

    /**
     * 添加一个顶点
     * @param item
     */
    public void addVertex(T item) {
        // 顶点不存在
        if (!contains(item)) {
            items.add(new Vertex<T>(item));
        }
    }

    /**
     * 添加无向边
     * @param from
     * @param to
     */
    public void addEdge(T from, T to) throws Exception {
        Vertex<T> fromVer = find(from);  // 找到起始顶点
        if (null == fromVer) {
            throw new ArgumentException("头顶点并不存在！");
        }

        Vertex<T> toVer = find(to); //找到结束顶点
        if (toVer == null)
            throw new ArgumentException("尾顶点并不存在！");

        //无向图的两个顶点都需记录边信息，有向图只需记录单边信息
        //即无相图的边其实就是两个双向的有向图边
        addDirectedEdge(fromVer, toVer);
        addDirectedEdge(toVer, fromVer);
    }

    /**
     * 查找图中是否包含某项
     * @param data
     * @return
     */
    public boolean contains(T data) {
        for (Vertex<T> item : items) {
            if (item.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据顶点数据查找顶点
     * @param data
     * @return
     */
    public Vertex<T> find(T data) {
        for (Vertex<T> item : items) {
            if (item.data.equals(data)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 添加有向边
     * @param fromVer  头顶点
     * @param toVer 尾顶点
     */
    public void addDirectedEdge(Vertex<T> fromVer, Vertex<T> toVer) throws Exception {
        if (fromVer.firstLinkNode == null) {  // 无邻接点时，当前添加的尾顶点就是firstLinkNode
            fromVer.firstLinkNode = new Node<T>(toVer);
        } else {  // 该头顶点已经存在邻接点，则找到该头顶点链表最后一个Node，将toVer添加到链表末尾
            Node<T> tmp, node = fromVer.firstLinkNode;
            do {
                // 检查是否添加了重复有向边
                if (node.adjvex.data.equals(toVer.data)) {
                    throw new ArgumentException("添加了重复的边！");
                }
                tmp = node;
                node = node.next;
            } while (node != null);
            tmp.next = new Node<T>(toVer);  // 添加到链表尾部
        }
    }

    /**
     * 拓扑排序是否能成功执行
     * 对有向图来说，如果能够用拓扑排序完成对图中所有节点的排序的话，就说明这个图中没有环，而如果不能完成，则说明有环。
     * @return
     */
    public boolean toPologicalSort() {
        Stack<Vertex<T>> stack = new Stack<Vertex<T>>();  // 定义栈
        for (Vertex<T> item : items) {  // 循环顶点集合，将入度为0的顶点入栈
            if (item.inDegree == 0) {
                stack.push(item);
            }
        }

        int count = 0;  // 定义查找到的顶点总数
        Iterator iter = stack.iterator();
        while (iter.hasNext()) {
            Vertex<T> t = stack.pop();  // 出栈
            count ++;
            if (t.firstLinkNode != null) {
                Node<T> tmp = t.firstLinkNode;
                while (tmp != null) {
                    tmp.adjvex.inDegree --;  // 邻接点入度-1
                    if (tmp.adjvex.inDegree == 0) {  // 如果邻接点入度为0，则入栈
                        stack.push(tmp.adjvex);
                    }
                    tmp = tmp.next;  // 递归所有邻接点
                }
            }
        }

        return count >= items.size();
    }
}
