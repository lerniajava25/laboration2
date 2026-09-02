package org.example.shapes;

import org.example.math.Ray;
import org.example.math.Color;

public interface Shape {
    Hit hit(Ray ray);
    Color getColor();

    record Hit(boolean hit, double t){}
}
