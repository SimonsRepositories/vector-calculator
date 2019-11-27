package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Inputs
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
}
