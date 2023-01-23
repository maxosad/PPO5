package com.osadchiy;

public abstract class GraphClass {
    /**
     * Bridge to drawing api
     */
    protected DrawingApi drawingApi;
    protected Integer nodeCount;
    public GraphClass(DrawingApi drawingApi, Integer nodeCount) {
        this.drawingApi = drawingApi;
        this.nodeCount = nodeCount;
    }

    public GraphClass(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
    }
    public abstract void drawGraph();

    public abstract void addEdge(int x, int y);
}