package pierre.lab5cc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    // Instance variables for interacting with GUI components
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // Instance variables for managing color values
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;


    public void initialize() {
        // bind TextField values to corresponding Slider values
        redTextField.textProperty().bind(
                redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(
                greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(
                blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(
                alphaSlider.valueProperty().asString("%.2f"));


        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            red = newValue.intValue();
            updateColor();
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            green = newValue.intValue();
            updateColor();
        });

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            blue = newValue.intValue();
            updateColor();
        });

        alphaSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            alpha = newValue.doubleValue();
            updateColor();
        });

        // Listeners for TextField changes to update the Sliders
        redTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                redSlider.setValue(value);
            } catch (NumberFormatException e) {
                redTextField.setText(String.valueOf(red)); // Reset to last valid value
            }
        });

        greenTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                greenSlider.setValue(value);
            } catch (NumberFormatException e) {
                greenTextField.setText(String.valueOf(green)); // Reset to last valid value
            }
        });

        blueTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                blueSlider.setValue(value);
            } catch (NumberFormatException e) {
                blueTextField.setText(String.valueOf(blue)); // Reset to last valid value
            }
        });

        alphaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double value = Double.parseDouble(newValue);
                alphaSlider.setValue(value);
            } catch (NumberFormatException e) {
                alphaTextField.setText(String.format("%.2f", alpha)); // Reset to last valid value
            }
        });
    }

    private void updateColor() {
        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
    }
}