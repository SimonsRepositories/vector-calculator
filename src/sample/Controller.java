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

        RadioButton checked = (RadioButton) toggleGroup.getSelectedToggle(); //Cast object to radio button
        System.out.println("Selected Radio Button - " + checked.getText());

        String option = checked.getText();
        switch (option) {
            case "Magnitude of v1":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {0, 0}");
                lb_vectorsFormula.setText("[display formula]");
                double result = myModel.calculateMagnitude(v1x, v1y);
                lb_vectorsResult.setText("m = " + result);
                break;
            case "Sum of v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("[display formula]");
                double[] sum = myModel.calculateSumOfTwoVectors(v1x, v1y, v2x, v2y);
                lb_vectorsResult.setText("sum = " + Arrays.toString(sum));
                break;
            case "Dot product of v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("[display formula]");
                double[] vec1 = {v1x, v1y};
                double[] vec2 = {v2x, v2y};
                double dotProduct = myModel.calculateDotProductBetweenTwoVectors(vec1, vec2);
                lb_vectorsResult.setText("v1 * v2 = " + dotProduct);
                break;
            case "Angle between v1 and v2":
                lb_v1.setText("v1 = {" + tf_v1x.getText() + ", " + tf_v1y.getText() + "}");
                lb_v2.setText("v2 = {" + tf_v2x.getText() + ", " + tf_v2y.getText() + "}");
                lb_vectorsFormula.setText("[display formula]");
                double cosA = myModel.calculateAngleBetweenTwoVectors(v1x, v1y, v2x, v2y);
                lb_vectorsResult.setText("sum = " + cosA);
                break;
            default:
                lb_v1.setText("Not an option, mate");
        }
    }

    public void calculateSimpleTrigonometry(ActionEvent event) {
        //http://www.carbidedepot.com/formulas-trigright.asp?__cf_chl_jschl_tk__=cb6406b984dde73ce4fc18905e6ad6130812c9b5-1574891811-0-AYet1OEVlF-aBGfdbuT63sCvn4GjpcvWNzDseRXYuIYS960Bdb_5KSNw3deSBBw_yMq0ILFDj_X3RHipkc1J5UqeD0QMJyRCb8j46YuukooQIz0EwPz38Flm_hLifF37GBj_MtGJOKxQcwbsrfHTdV1k3Q0aXyLWvJ8IHfsL7x2l5HbCbiHybU05xd5FaigCBR_aT5WEFpQ31XocJCHMLuUJR6BamSwvE60T1CttdfqEP1BnW8yl6fPxqdRMdQzWgTlLc5Aj8QKPK7I9mN4TpQeGQATRhtcUpL5a7GMH21x4

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

        List<Pair<String, String>> b = new ArrayList<Pair<String, String>>();
        //cosine (c * cos(A))
        b.add(new Pair<>("c", "A"));
        //sine (c * sin(B))
        b.add(new Pair<>("c", "B"));
        //tan (a * tan(B))
        b.add(new Pair<>("a", "B"));

        List<Pair<String, String>> c = new ArrayList<Pair<String, String>>();
        //pytagoras
        c.add(new Pair<>("b", "a"));
        //sine ( b / sin(angle))
        c.add(new Pair<>("b", "B"));
        //cosine (b
        c.add(new Pair<>("A", "b"));
        //
        c.add(new Pair<>("A", "a"));

        List<Pair<String, String>> angleA = new ArrayList<Pair<String, String>>();
        //cosine (b/c)
        angleA.add(new Pair<>("b", "c"));

        List<Pair<String, String>> angleB = new ArrayList<Pair<String, String>>();
        angleB.add(new Pair<>("a", "c"));

        for(Node node : vb_trigoInputs.getChildren()) {
            if(((TextField) node).getText().isEmpty()) {
                emptyTextFieldList.add((TextField) node);
            } else {
                filledTextFieldList.add((TextField) node);
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
                    } else {
                        System.out.println("You didn't provide enough data to calc side a");
                    }
                    break;
                case "tf_tc":

                    break;
                case "tf_tA":
                    break;
                case "tf_tB":
                    break;
                default:
                    System.out.println("Not an option, mate");
            }
        }
    }

    public void resetInputs(ActionEvent event) {
        for(Node node : vb_trigoInputs.getChildren()) {
            ((TextField) node).setText("");
        }
    }
}
