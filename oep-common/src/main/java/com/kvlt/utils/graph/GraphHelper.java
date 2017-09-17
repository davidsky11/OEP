package com.kvlt.utils.graph;

import java.util.List;

/**
 * GraphHelper
 * 图操作辅助类
 * @author KVLT
 * @date 2017-07-27.
 */
public class GraphHelper {

    /**
     * 检测有向图是否有闭环回路
     *  初始数据：逗号分割的from跟to字符串集合
     * @param originalData
     * @return
     * @throws Exception
     */
    public static boolean checkDigraphLoop(List<String> originalData) throws Exception {
        AdjacencyList<String> adjacencyList = new AdjacencyList<String>();
        String fromData = "";
        String toData = "";

        // 构造有向图的邻接表表示
        for (String originalDatum : originalData) {
            fromData = originalDatum.split(",")[0];  // 得到from顶点数据
            toData = originalDatum.split(",")[1];  // 得到to定点数据
            adjacencyList.addVertex(fromData);
            adjacencyList.addVertex(toData);

            Vertex fromVertex = adjacencyList.find(fromData); // 找到起始顶点
            Vertex toVertex = adjacencyList.find(toData); // 找到目标顶点
            toVertex.inDegree++; //目标顶点的入度+1
            adjacencyList.addDirectedEdge(fromVertex, toVertex); //添加有向边
        }

        return adjacencyList.toPologicalSort();
    }

}
