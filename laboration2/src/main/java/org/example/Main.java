package org.example;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import org.example.math.Color;
import org.example.math.Vector3;
import org.example.shapes.Sphere;
import org.example.shapes.Triangle;
import org.example.math.Ray;

public class Main {
    static void main() {
        Scene scene = new Scene();

        scene.addShape(new Sphere(
                new Vector3(-0.8, 0, 3),
                0.6,
                new Color(255, 0, 0)
        ));

        scene.addShape(new Triangle(
                new Vector3(0.2, -0.6, 3),
                new Vector3(1.4, -0.6, 3),
                new Vector3(0.8, 0.6, 3),
                new Color(0, 255, 0)
        ));

        int width = 800;
        int height = 800;

        BufferedImage image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB
        );

        Vector3 cameraPosition = new Vector3(0, 0, 0);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double directionX = (x + 0.5) / width * 2 - 1;
                double directionY = 1 - (y + 0.5) / height * 2;

                Ray ray = new Ray(
                        cameraPosition,
                        new Vector3(directionX, directionY, 1)
                );

                Color color = scene.getColor(ray);

                int rgb = new java.awt.Color(
                        color.red(), color.green(), color.blue()
                ).getRGB();

                image.setRGB(x, y, rgb);
            }
        }

        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Raytracer");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(new JLabel(new ImageIcon(image)));
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}
