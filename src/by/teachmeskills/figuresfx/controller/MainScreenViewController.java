package by.teachmeskills.figuresfx.controller;

import by.teachmeskills.figuresfx.drawutils.Drawer;
import by.teachmeskills.figuresfx.exception.FigureException;
import by.teachmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private ArrayList<Figure> figures;
    private Random random;
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());

    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws FigureException {
        Figure figure = null;
        logger.info("Method createFigure started");
        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(3), Color.AQUA, random.nextInt(60), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(3), Color.BLACK,
                        new double[]{random.nextInt(100) + x, x - random.nextInt(100), x},
                        new double[]{random.nextInt(100) + y, y - random.nextInt(100), y - random.nextInt(70)});
                break;
            case Figure.FIGURE_TYPE_OVAL:
                figure = new Oval(x, y, random.nextInt(3), Color.CORAL, random.nextInt(100), random.nextInt(100));
                break;
            default:
                throw new FigureException("Unknown figure type!");
        }
        return figure;

    }

    private void repaint() {
        logger.info("Method repaint start");
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMousedClicked(MouseEvent mouseEvent)  {
        logger.info("Method onMousedClicked started");
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (FigureException e) {
            logger.error("Unknown type figure",e);
        }
        repaint();
    }


}
