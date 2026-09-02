package org.example.Shapes;

public interface Shape {
    Hit hit(Ray ray);

    record Hit(boolean hit){}
}
