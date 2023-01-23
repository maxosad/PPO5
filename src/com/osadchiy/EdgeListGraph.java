package com.osadchiy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class EdgeListGraph extends GraphClass{
    private ArrayList<Pair<Integer, Integer>> edges;

    private HashMap<Pair<Integer, Integer>, Boolean> edgesExists;

    public EdgeListGraph(DrawingApi drawingApi, Integer nodeCount) {
        super(drawingApi, nodeCount);
        edgesExists = new HashMap<>();
        edges = new ArrayList<>();
    }


    @Override
    public void drawGraph() {
        double alpha = 360 / nodeCount;
        double radius = 100;
        double nodeRadius = 5;
        for (int i = 0; i < nodeCount; i++) {
            drawingApi.drawCircle(radius*Math.cos(Math.toRadians(alpha*i)), radius*Math.sin(Math.toRadians(alpha*i)), nodeRadius);
        }
        for (int i = 0; i < edges.size(); i++) {
            drawingApi.drawLine(radius*Math.cos(Math.toRadians(alpha*(edges.get(i).getKey()))),
                    radius*Math.sin(Math.toRadians(alpha*edges.get(i).getKey())),
                    radius*Math.cos(Math.toRadians(alpha*(edges.get(i).getValue()))),
                    radius*Math.sin(Math.toRadians(alpha*edges.get(i).getValue()))
            );
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
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(x,y);
        if (y < nodeCount && null == edgesExists.get(p)) {
            edges.add(p);
            edgesExists.put(p,true);
        }
    }
}
