package by.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Oval extends Figure {
    private double width;
    private double height;

    public Oval(double cx, double cy, double lineWidth, Color color, double width, double height) {
        super(FIGURE_TYPE_OVAL, cx, cy, lineWidth, color);
        this.width = width < 30 ? 30 : width;
        this.height = height < 40 ? 40 : height;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokeOval(cx - width / 2, cy - height / 2, width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return Double.compare(oval.width, width) == 0 && Double.compare(oval.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Oval{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
