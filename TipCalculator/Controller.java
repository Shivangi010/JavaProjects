package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller implements Initializable 
{
	@FXML
	TextField Amt;
	@FXML
	TextField Tip;
	@FXML
	TextField Total;
	@FXML
	Slider TPer;
	@FXML
	Label LPer;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		LPer.setText("15%");
		TPer.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number>ov,Number oldValue,Number newValue) {
				//System.out.println(newValue);
				LPer.setText(String.format("%.1f", newValue)+"%");
			}
			
		});
	}
	@FXML
	private void calculateAmount(ActionEvent e)
	{
		double amt = Double.parseDouble(Amt.getText());
		double tip = (amt*TPer.getValue())/100;
		double total = tip + amt;
		Tip.setText(String.format("%.2f", tip));
		Total.setText(String.format("%.2f", total));
	}

}
