package org.example.math;

/**
 * Represents a ray in 3D space with an origin point and a direction vector.
 * Used for ray tracing operations to determine intersections with shapes.
 *
 * @param origin the starting point of the ray
 * @param dir the direction vector of the ray
 */
public record Ray(Vector3 origin, Vector3 dir) {
}