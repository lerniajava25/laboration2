package org.example.shapes;

import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.math.Color;

/**
 * Represents a sphere in 3D space.
 * The sphere is defined by a center point and a radius.
 */
public class Sphere implements Shape{

    private final Vector3 center;
    private final double radius;
    private final Color color;

    /**
     * Constructs a new sphere with the specified center, radius, and color.
     *
     * @param center the center point of the sphere
     * @param radius the radius of the sphere
     * @param color the color of the sphere
     */
    public Sphere(Vector3 center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Determines if and where a ray intersects this sphere.
     * Uses the quadratic formula to solve for intersection points.
     * Returns the closest intersection point in front of the ray origin.
     *
     * @param ray the ray to test for intersection
     * @return a Hit record containing whether the ray hit the sphere and the distance
     */
    @Override
    public Hit hit(Ray ray) {
        Vector3 offset = ray.origin().subtract(center);

        double a = ray.dir().dotProduct(ray.dir());
        double b = 2.0 * offset.dotProduct(ray.dir());
        double c = offset.dotProduct(offset) - radius * radius;

        double discriminant = b * b - 4.0 * a * c;

        if (a == 0.0 || discriminant < 0.0) {
            return new Hit(false, Double.POSITIVE_INFINITY);
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);

        double t1 = (-b - sqrtDiscriminant) / (2.0 * a);
        double t2 = (-b + sqrtDiscriminant) / (2.0 * a);

        if (t1 > 0.0) {
            return new Hit(true, t1);
        }

        if (t2 > 0.0) {
            return new Hit(true, t2);
        }

        return new Hit(false, Double.POSITIVE_INFINITY);
    }

    /**
     * Gets the color of this sphere.
     *
     * @return the color of the sphere
     */
    @Override
    public Color getColor() {
        return color;
    }
}