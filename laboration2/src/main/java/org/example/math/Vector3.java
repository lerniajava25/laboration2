package org.example.math;

/**
 * Represents a 3D vector with x, y, and z components.
 * Provides common vector operations such as subtraction, dot product, and cross product.
 *
 * @param x the x component of the vector
 * @param y the y component of the vector
 * @param z the z component of the vector
 */
public record Vector3(double x, double y, double z) {

    //SIMD - Single Instruction Multiple Data
    //Register1 -> a.x  a.y  a.z  1
    //Register2 -> b.x  b.y  b.z  1


    /**
     * Subtracts another vector from this vector.
     *
     * @param other the vector to subtract
     * @return a new vector representing the difference
     */
    public Vector3 subtract(Vector3 other) {
        return new Vector3(x - other.x(), y - other.y(), z - other.z());
    }

    /**
     * Computes the dot product of this vector with another vector.
     *
     * @param b the other vector
     * @return the dot product of the two vectors
     */
    public double dotProduct(Vector3 b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    /**
     * Computes the dot product of two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the dot product of the two vectors
     */
    public static double dotProduct(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    /**
     * Computes the cross product of this vector with another vector.
     *
     * @param b the other vector
     * @return a new vector representing the cross product
     */
    public Vector3 crossProduct(Vector3 b) {
        return new Vector3(this.y * b.z - this.z * b.y, this.z * b.x - this.x * b.z, this.x * b.y - this.y * b.x);
    }

    /**
     * Computes the cross product of two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new vector representing the cross product
     */
    public static Vector3 crossProduct(Vector3 a, Vector3 b) {
        return new Vector3(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }
}