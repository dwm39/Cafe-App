

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author drake
 */
public class StarController implements Initializable {

    private double blondeRoastCost = 3.50;
    private double caffeMistoPrice = 3.75;
    private double decafPikePrice = 3.00;
    private double hotChocolatePrice = 4.00;
    private double creamPrice = 1.00;
    private double sugarPrice = .50;
    private double spicesPrice = 1.50;
    private double honeyPrice = .75;
    private double veteranDiscount = 10.0;
    private String cupponWord = "javafx";
    private double couponDiscount = 20.0;
    private double totalCost;

    @FXML
    private RadioButton cafe;

    @FXML
    private RadioButton chocolate;

    @FXML
    private ToggleGroup coffee;

    @FXML
    private CheckBox cream;

    @FXML
    private RadioButton decaf;

    @FXML
    private CheckBox honey;

    @FXML
    private RadioButton nonVeteran;

    @FXML
    private RadioButton roast;

    @FXML
    private CheckBox spices;

    @FXML
    private ToggleGroup status;

    @FXML
    private CheckBox sugar;

    @FXML
    private RadioButton veteran;

    @FXML
    private TextArea orderSummury;

    @FXML
    private Button resetButton;

    @FXML
    private Button updateButton;

    @FXML
    private TextField promotionCode;

   
   
    
    @FXML
    void onStatusChange(ActionEvent event) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
       
        StringBuilder mainOrder = new StringBuilder("Main Order: \n");
        double price = 0.0;
        if (cafe.isSelected()) {
            price += caffeMistoPrice;
            mainOrder.append("Caffe Misto: $3.75 \n");
        }

        if (chocolate.isSelected()) {
            price += hotChocolatePrice;
            mainOrder.append("Hot Chocolate: $4.00 \n");
        }

        if (roast.isSelected()) {
            price += blondeRoastCost;
            mainOrder.append("Blode Roast: $3.50 \n");
        }

        if (decaf.isSelected()) {
            price += decafPikePrice;
            mainOrder.append("Decaf Pike: $3.00 \n");
        }
        
        StringBuilder extras = new StringBuilder("Extras: \n");

        if (sugar.isSelected()) {
            price += sugarPrice;
            extras.append("     Sugar: $.50 \n");
        }

        if (spices.isSelected()) {
            price += spicesPrice;
            extras.append("     Spices: $1.50 \n");
        }
        if (honey.isSelected()) {
            price += honeyPrice;
            extras.append("     Honey: $.75 \n");
        }

        if (cream.isSelected()) {
            price += creamPrice;
            extras.append("     Cream: $1.00 \n");
        }
        String veternDiscount = "Hi Jim";
        if (veteran.isSelected()) {
            double tempPrice = price * veteranDiscount / 100;
            price -= tempPrice;
            veternDiscount = "Vetern Discount Applied -" + nf.format(tempPrice);
        } else if (nonVeteran.isSelected()) {
            veternDiscount = "";
        }

        String currentMessage = promotionCode.getText();

        String couponMessage = "";
        if (currentMessage.equals(cupponWord)) {
            double tempPrice = price * couponDiscount / 100;
            price -= tempPrice;
            couponMessage = "Coupon Applied -" + nf.format(tempPrice);
        }

        totalCost = price;

        orderSummury.setText(mainOrder.toString() + "\n" + extras.toString() + "\n"
                + "Total Price: \n" + veternDiscount + "\n" + couponMessage + "\n" + nf.format(totalCost));

    }
    
      @FXML
    void onKeyPress(KeyEvent event) {
        if (!promotionCode.getText().isEmpty()) {
            updateButton.setDisable(false);
          }
        
        if (promotionCode.getText().isEmpty()) {
            updateButton.setDisable(true);
          }
    }

    @FXML
    void resetButtonAction(ActionEvent event) {
        orderSummury.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
      orderSummury.setEditable(false);
      
      if (promotionCode.getText().isEmpty()) {
          updateButton.setDisable(true);
          
          
          
      }
      

    }

}
