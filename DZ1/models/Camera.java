package DZ1.models;

public class Camera {
    // Доработать в рамках ДР

    public Point3D Location;

    public Angle3D Angle;

    public void Rotate (Angle3D Angel) {
        System.out.println("Произошло вращение Camera");
    }

    public void Move (Point3D Location) {
        System.out.println("Произошло движение Camera");
    }
}
