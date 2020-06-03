package fr.univ_amu.iut.exercice3_2;


import javafx.beans.binding.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TriangleArea {

    private IntegerProperty x1 = new SimpleIntegerProperty(0);
    private IntegerProperty y1 = new SimpleIntegerProperty(0);

    private IntegerProperty x2 = new SimpleIntegerProperty(0);
    private IntegerProperty y2 = new SimpleIntegerProperty(0);

    private IntegerProperty x3 = new SimpleIntegerProperty(0);
    private IntegerProperty y3 = new SimpleIntegerProperty(0);

//    private NumberBinding area;

    private StringExpression output;

    public TriangleArea() {
        createBinding();
    }

    public static void main(String[] args) {
        TriangleArea triangleArea = new TriangleArea();

        triangleArea.printResult();

        triangleArea.setP1(0, 1);
        triangleArea.setP2(5, 0);
        triangleArea.setP3(4, 3);

        triangleArea.printResult();

        triangleArea.setP1(1, 0);
        triangleArea.setP2(2, 2);
        triangleArea.setP3(0, 1);

        triangleArea.printResult();
    }

    public void setP1(int x1, int y1) {
        this.x1.set(x1);
        this.y1.set(y1);
    }

    public void setP2(int x2, int y2) {
        this.x2.set(x2);
        this.y2.set(y2);
    }

    public void setP3(int x3, int y3) {
        this.x3.set(x3);
        this.y3.set(y3);
    }

    public double getArea() {
        return area.getValue().doubleValue();
    }

    void printResult() {
        output = Bindings.format("For P1(" + x1.get() + "," + y1.get() + "), "
                + "P2(" + x2.get() + "," + y2.get() + "), "
                + "P3(" + x3.get() + "," + y3.get() + "), the area of triangle ABC is "
                + getArea());
        System.out.println(output.get());
    }

    private NumberBinding area = new DoubleBinding() {
        {
            super.bind(x1, x2, x3, y1, y2, y3);
        }
        @Override
        protected double computeValue() {
            int intx1 = x1.get();
            int intx2 = x2.get();
            int intx3 = x3.get();
            int inty1 = y1.get();
            int inty2 = y2.get();
            int inty3 = y3.get();
            return (Math.abs(intx1*inty2 - intx1*inty3 + intx2*inty3 - intx2*inty1 + intx3*inty1 - intx3*inty2)/2.0);
        }
    };

    private void createBinding() {

    }
}
