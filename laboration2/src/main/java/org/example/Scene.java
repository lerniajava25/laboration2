package org.example;

import org.example.math.Color;
import org.example.math.Ray;
import org.example.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a 3D scene containing shapes that can be ray traced.
 * The scene manages a collection of shapes and determines which shape
 * is hit by a given ray.
 */
public class Scene {
    private final List<Shape> shapes = new ArrayList<>();

    /**
     * Adds a shape to the scene.
     *
     * @param shape the shape to add to the scene
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Determines the color at the intersection point of a ray with the scene.
     * Finds the closest shape that the ray intersects and returns its color.
     * If no shapes are hit, returns black.
     *
     * @param ray the ray to trace through the scene
     * @return the color of the closest intersected shape, or black if no hit
     */
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