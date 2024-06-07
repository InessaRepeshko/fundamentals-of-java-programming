package task4;

public class OneDimensionalArrayOfPoints extends AbstractArrayOfPoints {
    private double[] points = new double[0];

    @Override
    public void setPoint(int i, double x, double y) {
        if (i >= 0 && i * 2 + 1 < points.length) {
            points[i * 2] = x;
            points[i * 2 + 1] = y;
        }
    }

    @Override
    public double getX(int i) {
        if (i >= 0 && i * 2 + 1 < points.length) {
            return points[i * 2];
        }

        return 0;
    }

    @Override
    public double getY(int i) {
        if (i >= 0 && i * 2 + 1 < points.length) {
            return points[i * 2 + 1];
        }

        return 0;
    }

    @Override
    public int countPoints() {
        return points.length / 2;
    }

    @Override
    public void addPointToEnd(double x, double y) {
        double[] newArray = new double[points.length + 2];
        System.arraycopy(points, 0, newArray, 0, points.length);
        newArray[points.length] = x;
        newArray[points.length + 1] = y;
        points = newArray;
    }

    @Override
    public void removeLastPoint() {
        if (countPoints() > 0) {
            double[] newArray = new double[points.length - 2];
            System.arraycopy(points, 0, newArray, 0, points.length - 2);
            points = newArray;
        }
    }

    public static void main(String[] args) {
        OneDimensionalArrayOfPoints arrayOfPoints = new OneDimensionalArrayOfPoints();
        System.out.println("One-Dimensional Array Of Points:");
        arrayOfPoints.testArrayOfPoints();
    }
}
