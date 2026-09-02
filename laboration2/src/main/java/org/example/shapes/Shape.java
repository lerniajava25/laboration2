package org.example.shapes;

import org.example.math.Ray;
import org.example.math.Color;

/**
 * Interface for geometric shapes that can be ray traced.
 * All shapes must be able to determine if they are hit by a ray
 * and provide their color.
 */
public interface Shape {
    /**
     * Determines if and where a ray intersects this shape.
     *
     * @param ray the ray to test for intersection
     * @return a Hit record containing whether the ray hit the shape and the distance
     */
    Hit hit(Ray ray);

    /**
     * Gets the color of this shape.
     *
     * @return the color of the shape
     */
    Color getColor();

    /**
     * Represents the result of a ray-shape intersection test.
     *
     * @param hit true if the ray hit the shape, false otherwise
     * @param t the distance along the ray to the intersection point
     */
    record Hit(boolean hit, double t){}
}
