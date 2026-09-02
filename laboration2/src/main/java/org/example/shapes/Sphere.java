package org.example.shapes;

import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.math.Color;

public class Sphere implements Shape{

    private final Vector3 center;
    private final double radius;
    private final Color color;

    public Sphere(Vector3 center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

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

    @Override
    public Color getColor() {
        return color;
    }
}