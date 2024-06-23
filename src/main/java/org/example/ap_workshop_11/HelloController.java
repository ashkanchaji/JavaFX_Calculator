package org.example.ap_workshop_11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class HelloController {

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
    void type_eight(KeyEvent event) {
        appendTextToEditor("8");
    }

    @FXML
    void type_five(KeyEvent event) {
        appendTextToEditor("5");
    }

    @FXML
    void type_nine(KeyEvent event) {
        appendTextToEditor("9");
    }

    @FXML
    void type_one(KeyEvent event) {
        appendTextToEditor("1");
    }

    @FXML
    void type_seven(KeyEvent event) {
        appendTextToEditor("7");
    }

    @FXML
    void type_six(KeyEvent event) {
        appendTextToEditor("6");
    }

    @FXML
    void type_three(KeyEvent event) {
        appendTextToEditor("3");
    }

    @FXML
    void type_two(KeyEvent event) {
        appendTextToEditor("2");
    }

    @FXML
    void type_zero(KeyEvent event) {
        appendTextToEditor("0");
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
        this.operator = operator;
        num1 = Double.parseDouble(editor.getText());
        editor.setText("");
    }

    private void calculate() {
        double num2 = Double.parseDouble(editor.getText());
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
                    editor.setText("Error");
                    return;
                }
                break;
        }
        editor.setText(String.valueOf(result));
        start = true;
    }
}
