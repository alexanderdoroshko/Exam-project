package by.teachmeskills.figuresfx.figures;

import by.teachmeskills.figuresfx.controller.MainScreenViewController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.logging.Logger;

public class Triangle extends Figure {
    private double [] xPoint;
    private  double [] yPoint;


    public double[] getxPoint() {
        return xPoint;
    }

    public void setxPoint(double[] xPoint) {
        this.xPoint = xPoint;
    }

    public double[] getyPoint() {
        return yPoint;
    }

    public void setyPoint(double[] yPoint) {
        this.yPoint = yPoint;
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double[] xPoint, double[] yPoint) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokePolygon(xPoint,yPoint,3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(xPoint, triangle.xPoint) && Arrays.equals(yPoint, triangle.yPoint);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(xPoint);
        result = 31 * result + Arrays.hashCode(yPoint);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                ", xPoint=" + Arrays.toString(xPoint) +
                ", yPoint=" + Arrays.toString(yPoint) +
                '}';
    }
}

