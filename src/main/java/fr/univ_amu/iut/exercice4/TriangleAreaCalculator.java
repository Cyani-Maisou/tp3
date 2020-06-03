package fr.univ_amu.iut.exercice4;

import fr.univ_amu.iut.exercice3.TriangleArea;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TriangleAreaCalculator extends Application {
    private TriangleArea triangleArea = new TriangleArea();

    private Slider x1Slider = new Slider(0, 10, 0);
    private Slider x2Slider = new Slider(0, 10, 0);
    private Slider x3Slider = new Slider(0, 10, 0);

    private Slider y1Slider = new Slider();
    private Slider y2Slider = new Slider();
    private Slider y3Slider = new Slider();

    private Label p1Label = new Label("P1");
    private Label p2Label = new Label("P2");
    private Label p3Label = new Label("P3");

    private Label x1Label = new Label("X1 :");
    private Label x2Label = new Label("X2 :");
    private Label x3Label = new Label("X3 :");

    private Label y1Label = new Label("Y1 :");
    private Label y2Label = new Label("Y2 :");
    private Label y3Label = new Label("Y3 :");

    private Label areaLabel = new Label("Area :");
    private TextField areaTextField = new TextField();

    private GridPane root = new GridPane();

    private static void configSlider(Slider slider) {
        slider.setMin(0);
        slider.setMax(10);
        slider.setValue(0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(1.0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        configGridPane();
        configSliders();

        addSliders();
        addArea();

        addPointLabels();
        createBinding();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Triangle Area Calculator");
        stage.show();
    }

    private void configSliders() {
        configSlider(x1Slider);
        configSlider(x2Slider);
        configSlider(x3Slider);
        configSlider(y1Slider);
        configSlider(y2Slider);
        configSlider(y3Slider);
    }

    private void configGridPane() {
        root.setPadding(new Insets(10));
        root.setHgap(10.0);
        root.setVgap(10.0);
    }

    private void addArea() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void addSliders() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void addPointLabels() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void createBinding() {
        throw new RuntimeException("Not yet implemented !");
    }
}
