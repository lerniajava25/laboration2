package org.example;

import org.example.math.Color;
import org.example.math.Ray;
import org.example.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Color getColor(Ray ray) {
        double closestT = Double.POSITIVE_INFINITY;
        Color color = new Color(0, 0, 0);

        for (Shape shape : shapes) {
            Shape.Hit result = shape.hit(ray);

            if (result.hit() && result.t() < closestT) {
                closestT = result.t();
                color = shape.getColor();
            }
        }

        return color;
    }
}