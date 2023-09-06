import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp extends Frame implements ActionListener {
    // Components
    private TextField inputField;
    private Label resultLabel;
    private Button celsiusToFahrenheitButton;
    private Button fahrenheitToCelsiusButton;

    public TemperatureConverterApp() {
        // Frame setup
        setTitle("Temperature Converter");
        setSize(300, 150);
        setLayout(new FlowLayout());

        // Input field for temperature
        inputField = new TextField(10);
        add(inputField);

        // Convert buttons
        celsiusToFahrenheitButton = new Button("C to F");
        fahrenheitToCelsiusButton = new Button("F to C");

        add(celsiusToFahrenheitButton);
        add(fahrenheitToCelsiusButton);

        // Result label
        resultLabel = new Label("");
        add(resultLabel);

        // Button listeners
        celsiusToFahrenheitButton.addActionListener(this);
        fahrenheitToCelsiusButton.addActionListener(this);

        // Window close listener
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == celsiusToFahrenheitButton) {
            // Convert Celsius to Fahrenheit
            try {
                double celsius = Double.parseDouble(inputField.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                resultLabel.setText("Result: " + fahrenheit + " °F");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        } else if (e.getSource() == fahrenheitToCelsiusButton) {
            // Convert Fahrenheit to Celsius
            try {
                double fahrenheit = Double.parseDouble(inputField.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                resultLabel.setText("Result: " + celsius + " °C");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        TemperatureConverterApp converter = new TemperatureConverterApp();
        converter.setVisible(true);
    }
}
