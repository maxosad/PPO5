package com.osadchiy;



public class Main {

    public static void main(String[] args) {
        DrawingApi api;
        if (args[0].equals("fx"))
            api = new JavaFxDrawingApiImpl();
        else
            api = new JavaAwtDrawingApiImpl();

        String str = args[2];
        Integer nodes;

        nodes = Integer.parseInt(str);


        GraphClass g;
        if (args[1].equals("el"))
            g = new EdgeListGraph(api, nodes);
        else
            g = new AdjacencyMatrixGraph(api, nodes);

	    g.drawGraph();

    }
}
