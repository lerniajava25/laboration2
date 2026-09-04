package org.example.math;

public record Vector3(double x, double y, double z) {

    public Vector3 subtract(Vector3 other) {
        return new Vector3(x - other.x(), y - other.y(), z - other.z());
    }

    public double dotProduct(Vector3 b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    public Vector3 crossProduct(Vector3 b) {
        return new Vector3(this.y * b.z - this.z * b.y, this.z * b.x - this.x * b.z, this.x * b.y - this.y * b.x);
    }
}
