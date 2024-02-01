package task4;

public class TwoDimensionalArrayOfPoints extends AbstractArrayOfPoints {
    private double[][] points = new double[0][2];

    @Override
    public int countPoints() {
        return points.length;
    }

    @Override
    public void setPoint(int i, double x, double y) {
        if (i >= 0 && i < countPoints()) {
            points[i][0] = x;
            points[i][1] = y;
        }
    }

    @Override
    public double getX(int i) {
        if (i >= 0 && i < countPoints()) {
            return points[i][0];
        }

        return 0;
    }

    @Override
    public double getY(int i) {
        if (i >= 0 && i < countPoints()) {
            return points[i][1];
        }

        return 0;
    }

    @Override
    public void addPointToEnd(double x, double y) {
        double[][] newArray = new double[countPoints() + 1][2];
        System.arraycopy(points, 0, newArray, 0, countPoints());
        newArray[countPoints()][0] = x;
        newArray[countPoints()][1] = y;
        points = newArray;
    }

    @Override
    public void removeLastPoint() {
        if (countPoints() > 0) {
            double[][] newArray = new double[countPoints() - 1][2];
            System.arraycopy(points, 0, newArray, 0, countPoints() - 1);
            points = newArray;
        }
    }

    public static void main(String[] args) {
        TwoDimensionalArrayOfPoints arrayOfPoints1 = new TwoDimensionalArrayOfPoints();
        System.out.println("Two-Dimensional Array Of Points:");
        arrayOfPoints1.testArrayOfPoints();
    }
}
