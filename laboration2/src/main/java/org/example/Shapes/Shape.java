package org.example.Shapes;

import org.example.math.Ray;

public interface Shape {
    Hit hit(Ray ray);

    record Hit(boolean hit){}
}
