package fr.univ_amu.iut.exercice5;

import fr.univ_amu.iut.exercice3.TriangleArea;
import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class TriangleAreaCalculatorAndDrawer extends Application {
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

    private Line p1p2 = new Line();
    private Line p2p3 = new Line();
    private Line p3p1 = new Line();

    private Pane drawPane = new Pane();

    private GridPane root = new GridPane();

    @Override
    public void start(Stage stage) throws Exception {
        configGridPane();
        configSliders();
        addSliders();
        addArea();
        addPointLabels();
        addDrawPane();
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

    private void addDrawPane() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void configSlider(Slider slider) {
        slider.setMin(0);
        slider.setMax(10);
        slider.setValue(0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(5);
        slider.setSnapToTicks(true);
    }

    private void configGridPane() {
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        ColumnConstraints firstColumnConstraints = new ColumnConstraints();
        ColumnConstraints secondColumnConstraints = new ColumnConstraints();
        firstColumnConstraints.setMinWidth(50);
        firstColumnConstraints.setPrefWidth(50);
        secondColumnConstraints.setFillWidth(true);
        root.getColumnConstraints().addAll(firstColumnConstraints, secondColumnConstraints);
    }

    private void addArea() {
        root.add(areaLabel, 0, 9);
        root.add(areaTextField, 1, 9);
    }

    private void addSliders() {
        root.add(x1Slider, 1, 1);
        root.add(x1Label, 0,1);
        root.add(y1Slider, 1, 2);
        root.add(y1Label, 0,2);

        root.add(x2Slider, 1, 4);
        root.add(x2Label, 0,4);
        root.add(y2Slider, 1, 5);
        root.add(y2Label, 0,5);

        root.add(x3Slider, 1, 7);
        root.add(x3Label, 0,7);
        root.add(y3Slider, 1, 8);
        root.add(y3Label, 0,8);    }

    private void addPointLabels() {
        root.add(p1Label, 1, 0);
        root.add(p2Label, 1, 3);
        root.add(p3Label, 1, 6);
    }

    private void createBinding() {
        StringBinding area = new StringBinding() {
            {
                super.bind(x1Slider.valueProperty(), y1Slider.valueProperty(), x2Slider.valueProperty(), y2Slider.valueProperty(), x3Slider.valueProperty(), y3Slider.valueProperty());
            }
            @Override
            protected String computeValue() {
                double x1v = x1Slider.getValue();
                double y1v = y1Slider.getValue();
                double x2v = x2Slider.getValue();
                double y2v = y2Slider.getValue();
                double x3v = x3Slider.getValue();
                double y3v = y3Slider.getValue();
                double total = x1v*y2v - x1v*y3v + x2v*y3v - x2v*y1v + x3v*y2v - x3v*y2v;
                return "" + ((total < 0)? -total : total) / 2.0;
            }
        };
        areaTextField.textProperty().bind(area);
    }
}
