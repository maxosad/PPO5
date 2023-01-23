package com.osadchiy;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JavaFxDrawingApiImpl extends Application implements DrawingApi{
    private static Group group = new Group();
    private Integer w = 500;
    private Integer h = 500;


    @Override
    public long getDrawingAreaWidth() {
        return w;
    }

    @Override
    public long getDrawingAreaHeight() {
        return h;
    }
    private double x0 = getDrawingAreaWidth() / 2;
    private double y0 = getDrawingAreaHeight() / 2;

//    int n = 20;
//    double alpha = 360 / n;
//    int radius = 100;
//        for (int i = 0; i < n; i++) {
//        Circle circleTmp = new Circle(x0+(radius*Math.cos(Math.toRadians(alpha*i))), y0-(radius*Math.sin(Math.toRadians(alpha*i))),5);
//        group.getChildren().add(circleTmp);
//    }
    @Override
    public void drawCircle(double x, double y, double radius) {
        Circle circleTmp = new Circle(x0+x, y0-y, radius);
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(x0);
//        System.out.println(y0);
//        System.out.println(x0+x);
//        System.out.println(y0-y);
//        System.out.println("-------");
        group.getChildren().add(circleTmp);

    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        Line lineTmp = new Line(
                x0+x1,
                y0-y1,
                x0+x2,
                y0-y2
        );
        group.getChildren().add(lineTmp);
    }

    @Override
    public void drawFigure() {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(group);


        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(w);
        stage.setHeight(h);
        stage.show();
    }
}
