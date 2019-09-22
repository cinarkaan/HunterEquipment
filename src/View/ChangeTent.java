package View;

import Accessory.Tent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeTent {

	@FXML
	private CheckBox Tent_Water_Proof_chck1;
	@FXML
	private CheckBox Tent_Water_Proof_chck2;
	@FXML
	private TextField Tent_Brand;
	@FXML
	private TextField Tent_UsingLife;
	@FXML
	private TextField Tent_Lenght;
	@FXML
	private TextField Tent_Height;
	@FXML
	private TextField Tent_Prodect_Temp;
	@FXML
	private TextField Tent_Person_Amount;
	@FXML
	private TextField Tent_Season;

	private boolean okClicked = false;
	private Stage dialogStage;
	private Tent tent = new Tent();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void TentYesCheck() {

		if (Tent_Water_Proof_chck1.isSelected()) {
			Tent_Water_Proof_chck2.setSelected(false);
			this.tent.setWaterProof(true);
		}

	}

	@FXML
	private void TentNoCheck() {

		if (Tent_Water_Proof_chck2.isSelected()) {
			Tent_Water_Proof_chck1.setSelected(false);
			this.tent.setWaterProof(false);
		}

	}

	private boolean isErrorTent() {
		String errorMessage = "";
		try {
			Integer.parseInt(Tent_UsingLife.getText());
			if (Integer.parseInt(Tent_UsingLife.getText()) < 2 || Integer.parseInt(Tent_UsingLife.getText()) > 6) {
				errorMessage += "Kulland���n�z �ad�r�n �mr� 2 ile 6 y�l ars�nda olmal�d�r!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kulland���n�z �ad�r�n �mr�n� l�tfen Tamsay� giriniz!\n";
		}
		if (Tent_Brand.getText() == null || Tent_Brand.getText().length() == 0) {
			errorMessage += "Kulland���n�z �ad�r�n bir markas� olmak zorundad�r!!!!";
		}
		try {
			Float.parseFloat(Tent_Lenght.getText());
			if (Float.parseFloat(Tent_Lenght.getText()) < 12.0 || Float.parseFloat(Tent_Lenght.getText()) > 20.0) {
				errorMessage += "Kullanilan cadirin uzunlu�u 12 ile 20 m aras�nda olmal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullanilan cadirin uzunlu�unu l�tfen ger�ek sayi giriniz!\n";
		}
		try {
			Float.parseFloat(Tent_Height.getText());
			if (Float.parseFloat(Tent_Height.getText()) < 12.0 || Float.parseFloat(Tent_Height.getText()) > 20.0) {
				errorMessage += "Kullanilan cadirin y�ksekli�i 12 ile 20 m arasinda olmal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullanilan cadirin y�ksekli�ini l�tfen ger�ek sayi giriniz!\n";
		}
		if (Tent_Season.getText() == null || Tent_Season.getText().length() == 0) {
			errorMessage += "Kullan�lan cadirin sezonu girilmek zorunda!!!";
		}
		try {
			Integer.parseInt(Tent_Person_Amount.getText());
			if (Integer.parseInt(Tent_Person_Amount.getText()) < 4 || Integer.parseInt(Tent_Person_Amount.getText()) > 7) {
				errorMessage += "Kullanilan cadir 4 ile 7 kisilik olmak zorundad�r!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullanilan cadirin ki�i sayisini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(Tent_Prodect_Temp.getText());
			if (Integer.parseInt(Tent_Prodect_Temp.getText()) < -25 || Integer.parseInt(Tent_Prodect_Temp.getText()) > 30) {
				errorMessage += "Kullanilan cadirin s�n�r s�cakl�klar� -25 ile 30 aras�nda olmal�d�r!!!!";

			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullanilan cadirin s�n�r s�cakl�klar�n� l�tfen Tamsay� giriniz!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Gecersiz Alanlar");
			alert.setHeaderText("Lutfen gecersiz alanlar� duzeltin");
			alert.setContentText(errorMessage);

			alert.showAndWait();
			return false;
		}
	}

	@FXML
	private void OkTent() {
		if (isErrorTent()) {
			changeAccessory(this.tent);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	public void changeAccessory(Object object) {
		((Tent) object).setLenght(Float.parseFloat(Tent_Lenght.getText()));
		((Tent) object).setheight(Float.parseFloat(Tent_Height.getText()));
		((Tent) object).setPerson_Amount(Integer.parseInt(Tent_Person_Amount.getText()));
		((Tent) object).setProtection_Tempature(Integer.parseInt(Tent_Prodect_Temp.getText()));
		((Tent) object).setSeason(Tent_Season.getText());
		((Tent) object).setUsingLife(Integer.parseInt(Tent_UsingLife.getText()));
		((Tent) object).setBrand(Tent_Brand.getText());
	}

	public void setChange(Object object) {
		this.tent = (Tent) object;
	}
}
