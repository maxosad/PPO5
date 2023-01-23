package com.osadchiy;

public class testMain {
    public static void main(String[] args) {
        if (args[0].equals("0")) {
            JavaFxDrawingApiImpl javaFx1 = new JavaFxDrawingApiImpl();
            EdgeListGraph g1 = new EdgeListGraph(javaFx1, 5);
            g1.addEdge(1, 2);
            g1.addEdge(2, 3);
            g1.addEdge(1, 3);
            g1.drawGraph();
        }
        if(args[0].equals("1")) {
            JavaFxDrawingApiImpl javaFx2 = new JavaFxDrawingApiImpl();
            AdjacencyMatrixGraph g2 = new AdjacencyMatrixGraph(javaFx2, 6);
            g2.addEdge(1, 2);
            g2.addEdge(2, 3);
            g2.addEdge(1, 3);
            g2.drawGraph();
        }

        if(args[0].equals("2")) {
            JavaAwtDrawingApiImpl javaAwt2 = new JavaAwtDrawingApiImpl();
            EdgeListGraph g3 = new EdgeListGraph(javaAwt2, 5);
            g3.addEdge(1, 2);
            g3.addEdge(2, 3);
            g3.addEdge(1, 3);
            g3.drawGraph();
        }

        if(args[0].equals("3")) {
            JavaAwtDrawingApiImpl javaAwt3 = new JavaAwtDrawingApiImpl();
            EdgeListGraph g4 = new EdgeListGraph(javaAwt3, 5);
            g4.addEdge(1, 2);
            g4.addEdge(2, 3);
            g4.addEdge(1, 3);
            g4.drawGraph();
        }
    }
}
