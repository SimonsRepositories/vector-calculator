package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Inputs (Vectors)
    @FXML
    private TextField tf_v1x;
    @FXML
    private TextField tf_v1y;
    @FXML
    private TextField tf_v2x;
    @FXML
    private TextField tf_v2y;

    //Radio buttons
    @FXML
    private RadioButton rb_vectors1;
    @FXML
    private RadioButton rb_vectors2;
    @FXML
    private RadioButton rb_vectors3;
    @FXML
    private RadioButton rb_vectors4;
    @FXML
    private RadioButton rb_vectors5;

    //Result Labels
    @FXML
    private Label lb_v1;
    @FXML
    private Label lb_v2;
    @FXML
    private Label lb_vectorsFormula;
    @FXML
    private Label lb_vectorsResult;

    //Calculate Button
    @FXML
    private Button btn_vectorsCalculate;

    //Inputs Simple trigonometry
    @FXML
    private TextField tf_ta;
    @FXML
    private TextField tf_tb;
    @FXML
    private TextField tf_tc;
    @FXML
    private TextField tf_tA;
    @FXML
    private TextField tf_tB;
    @FXML
    private TextField lb_trigoFormula;
    @FXML
    private Label lb_trigoResult;
    @FXML
    private VBox vb_trigoInputs;
    @FXML
    private Label lb_error;

    public Model myModel;

    public void setModel(Model myModel) {
        this.myModel = myModel;
    }

    public void initialize(URL location, ResourceBundle resources) {
        rb_vectors1.setSelected(true);
    }

    public void calculateVectors(ActionEvent event) {
        Model myModel = new Model();

        double v1x = Double.parseDouble(tf_v1x.getText());
        double v1y = Double.parseDouble(tf_v1y.getText());

        double v2x = 0;
        double v2y = 0;
        if(!tf_v2x.getText().isEmpty() && !tf_v2y.getText().isEmpty()) {
            v2x = Double.parseDouble(tf_v2x.getText());
            v2y = Double.parseDouble(tf_v2y.getText());
        }

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_vectors1.setToggleGroup(toggleGroup);
        rb_vectors2.setToggleGroup(toggleGroup);
        rb_vectors3.setToggleGroup(toggleGroup);
        rb_vectors4.setToggleGroup(toggleGroup);
        rb_vectors5.setToggleGroup(toggleGroup);

        RadioButton checked = (RadioButton) toggleGroup.getSelectedToggle(); //Cast object to radio button
        System.out.println("Selected Radio Button - " + checked.getText());

        String option = checked.getText();
        switch (option) {
            case "Magnitude of v1":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {0, 0}");
                lb_vectorsFormula.setText("");
                double result = myModel.calculateMagnitude(v1x, v1y);
                lb_vectorsResult.setText("m = " + result);
                break;
            case "Sum of v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("");
                double[] sum = myModel.calculateSumOfTwoVectors(v1x, v1y, v2x, v2y);
                lb_vectorsResult.setText("sum = " + Arrays.toString(sum));
                break;
            case "Dot product of v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("");
                double[] vec1 = {v1x, v1y};
                double[] vec2 = {v2x, v2y};
                double dotProduct = myModel.calculateDotProductBetweenTwoVectors(vec1, vec2);
                lb_vectorsResult.setText("v1 * v2 = " + dotProduct);
                break;
            case "Angle between v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("");
                double cosA = myModel.calculateAngleBetweenTwoVectors(v1x, v1y, v2x, v2y);
                lb_vectorsResult.setText("angle = " + cosA);
                break;
            case "Substract v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("");
                double[] subtrahierung = myModel.calculateSubtractOfTwoVectors(v1x, v1y, v2x, v2y);
                lb_vectorsResult.setText("subtraction = " + Arrays.toString(subtrahierung));
                break;
            default:
                lb_v1.setText("Not an option, mate");
        }
    }

    public void calculateSimpleTrigonometry(ActionEvent event) {
        //http://www.carbidedepot.com/formulas-trigright.asp

        Model myModel = new Model();
        // Create a List to track all the empty TextFields
        List<TextField> emptyTextFieldList = new ArrayList<>();
        List<TextField> filledTextFieldList = new ArrayList<>();

        //TextField relationships
        List<Pair<String, String>> a = new ArrayList<Pair<String, String>>();
        //sine (c * sin(angle))
        a.add(new Pair<>("A", "c"));
        //cosine (c * cos(angle))
        a.add(new Pair<>("c", "B"));
        //tangent (b/tan(angle))
        a.add(new Pair<>("b", "B"));
        //tangent ()
        a.add(new Pair<>("b", "A"));
        //pythagoras
        a.add(new Pair<>("c", "b"));

        List<Pair<String, String>> b = new ArrayList<Pair<String, String>>();
        //cosine (c * cos(A))
        b.add(new Pair<>("c", "A"));
        //sine (c * sin(B))
        b.add(new Pair<>("c", "B"));
        //tan (a * tan(B))
        b.add(new Pair<>("a", "B"));
        //
        b.add(new Pair<>("a", "A"));
        //pythagoras
        b.add(new Pair<>("c", "a"));

        List<Pair<String, String>> c = new ArrayList<Pair<String, String>>();
        //pytagoras
        c.add(new Pair<>("b", "a"));
        //sine ( b / sin(angle))
        c.add(new Pair<>("b", "B"));
        //cosine (b
        c.add(new Pair<>("A", "b"));
        //
        c.add(new Pair<>("A", "a"));
        //
        c.add(new Pair<>("a", "B"));

        List<Pair<String, String>> angleA = new ArrayList<Pair<String, String>>();
        //cosine (adjacent / hypothenuse)
        angleA.add(new Pair<>("b", "c"));
        //tan (opposite / adjacent
        angleA.add(new Pair<>("b", "a"));
        //sine (opposite / hypothenuse
        angleA.add(new Pair<>("a", "c"));


        List<Pair<String, String>> angleB = new ArrayList<Pair<String, String>>();
        //cosine -1 * (adjacent / hypothenuse
        angleB.add(new Pair<>("a", "c"));
        //tan -1 * (opposite / adjacent)
        angleB.add(new Pair<>("a", "b"));
        //sine -1 * (opposite / hypothenuse)
        angleB.add(new Pair<>("c", "b"));

        //list all empty textfields
        for(Node node : vb_trigoInputs.getChildren()) {
            if(((TextField) node).getText().isEmpty()) {
                emptyTextFieldList.add((TextField) node);
            } else {
                filledTextFieldList.add((TextField) node);
            }
        }

        if(!tf_tA.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
            int AB = 90;
            double sumAB = Double.parseDouble(tf_tA.getText()) + Double.parseDouble(tf_tB.getText());
            if(sumAB < AB) {
                lb_error.setText("You input two angles that do not add up to 90 degrees. Please input only one angle or two angles that add up to 90 degrees");
            }
        }
        System.out.println("empty textfields:");
        for(Node node : emptyTextFieldList) {

            System.out.println(node.getId());
            switch (node.getId()) {
                case "tf_ta":
                    if(!tf_tA.getText().isEmpty() && !tf_tc.getText().isEmpty()) {
                        double result1 = myModel.calculateOpposite(Double.parseDouble(tf_tc.getText()), Double.parseDouble(tf_tA.getText()));
                        tf_ta.setText("" + result1);
                    } else if(!tf_tc.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
                        double result2 = myModel.calculateAdjacent(Double.parseDouble(tf_tc.getText()), Double.parseDouble(tf_tB.getText()));
                        tf_ta.setText("" + result2);
                    } else if(!tf_tb.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
                        double result3 = myModel.calculateAdjacent2(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_tB.getText()));
                        tf_ta.setText("" + result3);
                    } else if(!tf_tb.getText().isEmpty() && !tf_tA.getText().isEmpty()) {
                        double result4 = myModel.calculateOpposite2(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_tA.getText()));
                        tf_ta.setText("" + result4);
                    } else if(!tf_tc.getText().isEmpty() && !tf_tb.getText().isEmpty()) {
                        double result5 = myModel.calculateAdjacent4(Double.parseDouble(tf_tc.getText()), Double.parseDouble(tf_tb.getText()));
                        tf_ta.setText("" + result5);
                    } else {
                        lb_error.setText("You didn't provide enough data to calc side a");
                    }
                    break;
                case "tf_tb":
                    if(!tf_tc.getText().isEmpty() && !tf_tA.getText().isEmpty()) {
                        double result1 = myModel.calculateAdjacent(Double.parseDouble(tf_tc.getText()), Double.parseDouble(tf_tA.getText()));
                        tf_tb.setText("" + result1);
                    } else if(!tf_tc.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
                        double result2 = myModel.calculateOpposite(Double.parseDouble(tf_tc.getText()), Double.parseDouble(tf_tB.getText()));
                        tf_tb.setText("" + result2);
                    } else if(!tf_ta.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
                        double result3 = myModel.calculateOpposite2(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tB.getText()));
                        tf_tb.setText("" + result3);
                    } else if(!tf_ta.getText().isEmpty() && !tf_tA.getText().isEmpty()) {
                        double result4 = myModel.calculateAdjacent2(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tA.getText()));
                        tf_tb.setText("" + result4);
                    } else if(!tf_tc.getText().isEmpty() && !tf_ta.getText().isEmpty()) {
                        double result5 = myModel.calculateAdjacent3(Double.parseDouble(tf_tc.getText()), Double.parseDouble(tf_ta.getText()));
                        tf_tb.setText("" + result5);
                    } else {
                        lb_error.setText("You didn't provide enough data to calc side b");
                    }
                    break;
                case "tf_tc":
                    if(!tf_tb.getText().isEmpty() && !tf_ta.getText().isEmpty()) {
                        double result1 = myModel.calculateAdjacent5(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_ta.getText()));
                        tf_tc.setText("" + result1);
                    } else if(!tf_tb.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
                        double result2 = myModel.calculateHypothenuse(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_tB.getText()));
                        tf_tc.setText("" + result2);
                    } else if(!tf_tb.getText().isEmpty() && !tf_tA.getText().isEmpty()) {
                        double result3 = myModel.calculateHypothenuse2(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_tA.getText()));
                        tf_tc.setText("" + result3);
                    } else if(!tf_ta.getText().isEmpty() && !tf_tA.getText().isEmpty()) {
                        double result4 = myModel.calculateHypothenuse(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tA.getText()));
                        tf_tc.setText("" + result4);
                    } else if(!tf_ta.getText().isEmpty() && !tf_tB.getText().isEmpty()) {
                        double result5 = myModel.calculateHypothenuse2(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tB.getText()));
                        tf_tc.setText("" + result5);
                    } else {
                        lb_error.setText("You didn't provide enough data to calc side c");
                    }
                    break;
                case "tf_tA":
                    if(!tf_tb.getText().isEmpty() && !tf_tc.getText().isEmpty()) {
                        double result1 = myModel.calculateCosAngle(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_tc.getText()));
                        tf_tA.setText("" + result1);
                    } else if (!tf_tb.getText().isEmpty() && !tf_ta.getText().isEmpty()) {
                        double result2 = myModel.calculateTanAngle(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tb.getText()));
                        tf_tA.setText("" + result2);
                    } else if (!tf_ta.getText().isEmpty() && !tf_tc.getText().isEmpty()) {
                        double result3 = myModel.calculateSineAngle(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tc.getText()));
                        tf_tA.setText("" + result3);
                    } else {
                        lb_error.setText("You didn't provide enough data to calc Angle A");
                    }
                    break;
                case "tf_tB":
                    if(!tf_ta.getText().isEmpty() && !tf_tc.getText().isEmpty()) {
                        double result1 = myModel.calculateCosAngle(Double.parseDouble(tf_ta.getText()), Double.parseDouble(tf_tc.getText()));
                        tf_tB.setText("" + result1);
                    } else if (!tf_tb.getText().isEmpty() && !tf_ta.getText().isEmpty()) {
                        double result2 = myModel.calculateTanAngle(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_ta.getText()));
                        tf_tB.setText("" + result2);
                    } else if (!tf_tb.getText().isEmpty() && !tf_tc.getText().isEmpty()) {
                        double result3 = myModel.calculateSineAngle(Double.parseDouble(tf_tb.getText()), Double.parseDouble(tf_tc.getText()));
                        tf_tB.setText("" + result3);
                    }
                    break;
                default:
                    lb_error.setText("Not an option, mate");
            }
        }
    }

    public void resetInputs(ActionEvent event) {
        for(Node node : vb_trigoInputs.getChildren()) {
            ((TextField) node).setText("");
        }
    }
}
