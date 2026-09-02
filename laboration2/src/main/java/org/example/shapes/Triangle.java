package org.example.shapes;

import org.example.math.Color;
import org.example.math.Ray;
import org.example.math.Vector3;

public class Triangle implements Shape {

    private final Vector3 p1;
    private final Vector3 p2;
    private final Vector3 p3;
    private final Color color;

    public Triangle(Vector3 p1, Vector3 p2, Vector3 p3, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;
    }

    @Override
    public Hit hit(Ray ray) {

        Vector3 edge1 = p2.subtract(p1);
        Vector3 edge2 = p3.subtract(p1);

        Vector3 cross = ray.dir().crossProduct(edge2);
        double determinant = edge1.dotProduct(cross);

        if (determinant == 0) {
            return new Hit(false, Double.POSITIVE_INFINITY);
        }

        Vector3 fromVertex = ray.origin().subtract(p1);

        double u = fromVertex.dotProduct(cross) / determinant;

        Vector3 cross2 = fromVertex.crossProduct(edge1);
        double v = ray.dir().dotProduct(cross2) / determinant;

        if (u < 0 || v < 0 || u + v > 1) {
            return new Hit(false, Double.POSITIVE_INFINITY);
        }

        double t = edge2.dotProduct(cross2) / determinant;

        if (t <= 0) {
            return new Hit(false, Double.POSITIVE_INFINITY);
        }

        return new Hit(true, t);
    }

    @Override
    public Color getColor() {
        return color;
    }
}