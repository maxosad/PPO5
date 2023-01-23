package com.osadchiy;



public class AdjacencyMatrixGraph extends GraphClass{

    boolean[][] graph;

    public AdjacencyMatrixGraph(DrawingApi drawingApi, Integer nodeCount) {
        super(drawingApi,nodeCount);
        graph = new boolean[nodeCount][nodeCount];
    }

    @Override
    public void drawGraph() {
        double alpha = 360 / nodeCount;
        double radius = 100;
        double nodeRadius = 5;

        for (int i = 0; i < nodeCount; i++) {
            drawingApi.drawCircle(radius*Math.cos(Math.toRadians(alpha*i)), radius*Math.sin(Math.toRadians(alpha*i)), nodeRadius);
        }


        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {

                if (graph[i][j]) {
                    drawingApi.drawLine(radius*Math.cos(Math.toRadians(alpha*i)),
                            radius*Math.sin(Math.toRadians(alpha*i)),
                            radius*Math.cos(Math.toRadians(alpha*j)),
                            radius*Math.sin(Math.toRadians(alpha*j))
                    );
                }
            }
        }

        for (int i = 0; i < nodeCount; i++) {
            drawingApi.drawCircle(radius*Math.cos(Math.toRadians(alpha*i)), radius*Math.sin(Math.toRadians(alpha*i)), nodeRadius);
        }

        drawingApi.drawFigure();
    }

    @Override
    public void addEdge(int x, int y) {
        if (x > y) {
            x ^= y;
            y ^= x;
            x ^= y;
        }
       if (y < nodeCount) {
           graph[x][y] = true;
       }
    }
}
