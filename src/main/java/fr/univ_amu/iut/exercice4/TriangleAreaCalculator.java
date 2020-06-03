package fr.univ_amu.iut.exercice4;

import fr.univ_amu.iut.exercice3.TriangleArea;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
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
        root.add(areaLabel, 0, 8);
        root.add(areaTextField, 1, 8);
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

        root.add(x3Slider, 1, 6);
        root.add(x3Label, 0,6);
        root.add(y3Slider, 1, 7);
        root.add(y3Label, 0,7);
    }

    private void addPointLabels() {
        root.add(p1Label, 1, 0);
        root.add(p2Label, 1, 3);
        root.add(p3Label, 1, 5);
     }

    private void createBinding() {
        NumberBinding x1y2 = Bindings.multiply(x1Slider.valueProperty(), y2Slider.valueProperty());
        NumberBinding x1y3 = Bindings.multiply(x1Slider.valueProperty(), y3Slider.valueProperty());
        NumberBinding x2y3 = Bindings.multiply(x2Slider.valueProperty(), y3Slider.valueProperty());
        NumberBinding x2y1 = Bindings.multiply(x2Slider.valueProperty(), y1Slider.valueProperty());
        NumberBinding x3y1 = Bindings.multiply(x3Slider.valueProperty(), y1Slider.valueProperty());
        NumberBinding x3y2 = Bindings.multiply(x3Slider.valueProperty(), y2Slider.valueProperty());

        NumberBinding sommePartieAbsolue = Bindings.subtract(x1y2, x1y3).add(x2y3).subtract(x2y1).add(x3y1).subtract(x3y2);
        NumberBinding partieAbsolue =
                Bindings.when(sommePartieAbsolue.lessThan(0)).then(sommePartieAbsolue.negate()).otherwise(sommePartieAbsolue);
        NumberBinding area = partieAbsolue.divide(2.0);
        areaTextField.setText(area.toString());
    }
}
