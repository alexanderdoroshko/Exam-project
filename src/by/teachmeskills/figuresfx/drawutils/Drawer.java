package by.teachmeskills.figuresfx.drawutils;

import by.teachmeskills.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable> {
    ArrayList<T> figures;

    public Drawer(ArrayList<T> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) {
        for (Figure figure : figures) {
            figure.draw(gc);
        }
    }
}
