package com.osadchiy;

import javafx.util.Pair;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class JavaAwtDrawingApiImpl extends Frame implements DrawingApi{

    private Integer w = 500;
    private Integer h = 500;
    private static ArrayList<Ellipse2D.Double> circles = new ArrayList<>();
    private static ArrayList<Line2D.Double> lines = new ArrayList<>();

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

    @Override
    public void drawCircle(double x, double y, double radius) {
        circles.add(new Ellipse2D.Double(x0+x,y0-y, 5,5));
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {

        lines.add(new Line2D.Double(
                x0+x1,
                y0-y1,
                x0+x2,
                y0-y2
        ));

    }



    @Override
    public void drawFigure() {
        Frame frame = new JavaAwtDrawingApiImpl();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.setSize(w, h);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("circles.size() ="+ circles.size());
        Graphics2D ga = (Graphics2D)g;
        for (int i = 0; i < circles.size(); i++) {
            ga.fill(circles.get(i));
        }
        for (int i = 0; i < lines.size(); i++) {
            ga.draw(lines.get(i));
        }
//        ga.fill(new Ellipse2D.Float(100,100, 5,5));
//
//        g.drawLine(50,50,100,100);
    }
}
