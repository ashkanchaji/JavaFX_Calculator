package org.example.ap_workshop_11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CalculatorController {

    @FXML
    private Button addition;

    @FXML
    private Button decimal;

    @FXML
    private Button divide;

    @FXML
    private TextField editor;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button multiply;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button subtract;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    private String operator = "";
    private double num1 = 0;
    private boolean start = true;

    @FXML
    void initialize() {
        // Attach a key event handler to the editor for key typing events
        editor.setOnKeyTyped(this::handleKeyTyped);
    }

    @FXML
    void on_addition_clicked(ActionEvent event) {
        setOperator("+");
    }

    @FXML
    void on_decimal_clicked(ActionEvent event) {
        appendTextToEditor(".");
    }

    @FXML
    void on_divide_clicked(ActionEvent event) {
        setOperator("/");
    }

    @FXML
    void on_eight_clicked(ActionEvent event) {
        appendTextToEditor("8");
    }

    @FXML
    void on_equal_clicked(ActionEvent event) {
        calculate();
    }

    @FXML
    void on_five_clicked(ActionEvent event) {
        appendTextToEditor("5");
    }

    @FXML
    void on_four_clicked(ActionEvent event) {
        appendTextToEditor("4");
    }

    @FXML
    void on_multiply_clicked(ActionEvent event) {
        setOperator("*");
    }

    @FXML
    void on_nine_clicked(ActionEvent event) {
        appendTextToEditor("9");
    }

    @FXML
    void on_one_clicked(ActionEvent event) {
        appendTextToEditor("1");
    }

    @FXML
    void on_seven_clicked(ActionEvent event) {
        appendTextToEditor("7");
    }

    @FXML
    void on_six_clicked(ActionEvent event) {
        appendTextToEditor("6");
    }

    @FXML
    void on_subtract_clicked(ActionEvent event) {
        setOperator("-");
    }

    @FXML
    void on_three_clicked(ActionEvent event) {
        appendTextToEditor("3");
    }

    @FXML
    void on_two_clicked(ActionEvent event) {
        appendTextToEditor("2");
    }

    @FXML
    void on_zero_clicked(ActionEvent event) {
        appendTextToEditor("0");
    }

    @FXML
    void handleKeyTyped(KeyEvent event) {
        String key = event.getCharacter();

        switch (key) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                appendTextToEditor(key);
                break;
            case "+":
                setOperator("+");
                break;
            case "-":
                setOperator("-");
                break;
            case "*":
                setOperator("*");
                break;
            case "/":
                setOperator("/");
                break;
            case ".":
                appendTextToEditor(".");
                break;
            case "=":
                calculate();
                break;
            case "\r":  // Enter key
                calculate();
                break;
            default:
                // Ignore other keys
                break;
        }
    }

    private void appendTextToEditor(String text) {
        if (start) {
            editor.setText(text);
            start = false;
        } else {
            editor.setText(editor.getText() + text);
        }
    }

    private void setOperator(String operator) {
        if (!start && !this.operator.isEmpty()) {
            calculate();  // calculate the previous operation first if there's already an operator
        }
        this.operator = operator;
        num1 = Double.parseDouble(editor.getText());
        appendTextToEditor(" " + operator + " ");
    }

    private void calculate() {
        try {
            String[] parts = editor.getText().split(" ");
            if (parts.length < 3) {
                throw new IllegalArgumentException("Incomplete expression");
            }
            num1 = Double.parseDouble(parts[0]);
            operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result = 0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown operator");
            }
            editor.setText(String.valueOf(result));
            resetCalculator();
        } catch (NumberFormatException e) {
            editor.setText("Error: Invalid number");
            resetCalculator();
        } catch (IllegalArgumentException | ArithmeticException | UnsupportedOperationException e) {
            editor.setText("Error: " + e.getMessage());
            resetCalculator();
        }
    }

    private void resetCalculator() {
        operator = "";
        num1 = 0;
        start = true;
    }
}
