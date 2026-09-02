package org.example.math;

/**
 * Represents an RGB color with red, green, and blue components.
 * Each component should be in the range 0-255.
 *
 * @param red the red component (0-255)
 * @param green the green component (0-255)
 * @param blue the blue component (0-255)
 */
public record Color(int red, int green, int blue){
}