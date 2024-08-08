package DZ1.models;

import java.util.List;

public class Flash {
    // Доработать в рамках ДР

    public List<Point3D> Location;

    public List<Angle3D> Angle;

    public List<Color> Color;

    public float Power;

    public void Rotate (Angle3D Angel) {
        System.out.println("Произошло вращение Flash");
    }

    public void Move (Point3D Location) {
        System.out.println("Произошло движение Flash");
    }
}
