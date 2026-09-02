package org.example.Shapes;

public class Sphere implements Shape{

    private final Vector3 center;
    private final double radius;

    public Sphere(Vector3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Hit hit(Ray ray) {
        //Implement collision check
        return new Hit(false);
    }
}