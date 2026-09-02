package org.example.shapes;

import org.example.math.Color;
import org.example.math.Ray;
import org.example.math.Vector3;

/**
 * Represents a triangle in 3D space.
 * The triangle is defined by three vertices.
 */
public class Triangle implements Shape {

    private final Vector3 p1;
    private final Vector3 p2;
    private final Vector3 p3;
    private final Color color;

    /**
     * Constructs a new triangle with the specified vertices and color.
     *
     * @param p1 the first vertex of the triangle
     * @param p2 the second vertex of the triangle
     * @param p3 the third vertex of the triangle
     * @param color the color of the triangle
     */
    public Triangle(Vector3 p1, Vector3 p2, Vector3 p3, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;
    }

    /**
     * Determines if and where a ray intersects this triangle.
     * Uses the Möller-Trumbore intersection algorithm.
     *
     * @param ray the ray to test for intersection
     * @return a Hit record containing whether the ray hit the triangle and the distance
     */
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

    /**
     * Gets the color of this triangle.
     *
     * @return the color of the triangle
     */
    @Override
    public Color getColor() {
        return color;
    }
}