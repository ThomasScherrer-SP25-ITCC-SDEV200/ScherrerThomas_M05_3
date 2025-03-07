import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelector extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Colorful Text");
        text.setFont(new Font(30));

        Slider redSlider = createColorSlider();
        Slider greenSlider = createColorSlider();
        Slider blueSlider = createColorSlider();
        Slider opacitySlider = createColorSlider();

        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        Label opacityLabel = new Label("Opacity");

        ChangeListener<Number> colorChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            text.setFill(Color.color(
                    redSlider.getValue() / 255,
                    greenSlider.getValue() / 255,
                    blueSlider.getValue() / 255,
                    opacitySlider.getValue() / 255
            ));
        };

        redSlider.valueProperty().addListener(colorChangeListener);
        greenSlider.valueProperty().addListener(colorChangeListener);
        blueSlider.valueProperty().addListener(colorChangeListener);
        opacitySlider.valueProperty().addListener(colorChangeListener);

        VBox vbox = new VBox(10, text, redLabel, redSlider, greenLabel, greenSlider, blueLabel, blueSlider, opacityLabel, opacitySlider);
        vbox.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Slider createColorSlider() {
        Slider slider = new Slider(0, 255, 127);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
