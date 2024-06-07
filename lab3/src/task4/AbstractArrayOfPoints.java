package task4;

public abstract class AbstractArrayOfPoints {
    public abstract void setPoint(int i, double x, double y);

    public abstract double getX(int i);

    public abstract double getY(int i);

    public abstract int countPoints();

    public abstract void addPointToEnd(double x, double y);

    public abstract void removeLastPoint();

    public void sortByX() {
        boolean unsorted = true;

        while (unsorted) {
            unsorted = false;

            for (int i = 0; i < countPoints() - 1; i++) {
                if (getX(i) > getX(i + 1)) {
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    unsorted = true;
                }
            }
        }
    }

    public void sortByY() {
        boolean unsorted = true;

        while (unsorted) {
            unsorted = false;

            for (int i = 0; i < countPoints() - 1; i++) {
                if (getY(i) > getY(i + 1)) {
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    unsorted = true;
                }
            }
        }
    }

    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < countPoints(); i++) {
            string += "\tpoint" + i
                    + "\t(x = " + getX(i)
                    + ";\ty = " + getY(i)
                    + ")\n";
        }

        return string;
    }

    public void testArrayOfPoints() {
        System.out.println("Array of added points:");
        addPointToEnd(22, 45);
        addPointToEnd(14, 11);
        addPointToEnd(30, 5.5);
        addPointToEnd(-2, 58);
        addPointToEnd(-13, -24);
        System.out.println(this);

        System.out.println("Array sorted ascending by X:");
        sortByX();
        System.out.println(this);

        System.out.println("Array sorted ascending by Y:");
        sortByY();
        System.out.println(this);

        System.out.println("Array where the last point is removed:");
        removeLastPoint();
        System.out.println(this);

        System.out.println("Array where coordinates of the point with index 0 changed:");
        setPoint(0, getX(0) / 2, getY(0) / 2);
        System.out.println(this);
    }
}
