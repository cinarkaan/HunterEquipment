package View;

import Accessory.Bag;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeBag {

	@FXML
	private TextField Bag_Capacity;
	@FXML
	private TextField Bag_Brand;
	@FXML
	private TextField Bag_Pocket_Capacity;
	@FXML
	private TextField Bag_Weight;
	@FXML
	private TextField Bag_UsingLife;
	@FXML
	private CheckBox Bag_Water_Proof1;
	@FXML
	private CheckBox Bag_Water_Proof2;

	private boolean okClicked = false;
	private Stage dialogStage;
	private Bag bag = new Bag();

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
	private void Bag_Yes_Check() {

		if (Bag_Water_Proof1.isSelected()) {
			Bag_Water_Proof2.setSelected(false);
			this.bag.setWaterProof(true);
		}

	}

	@FXML
	private void Bag_No_Check() {

		if (Bag_Water_Proof2.isSelected()) {
			Bag_Water_Proof1.setSelected(false);
			this.bag.setWaterProof(false);
		}

	}

	public void changeAccessory(Object object) {
		((Bag) object).setBrand(Bag_Brand.getText());
		((Bag) object).setCapacity(Integer.parseInt(Bag_Capacity.getText()));
		((Bag) object).setPocket_Total(Integer.parseInt(Bag_Pocket_Capacity.getText()));
		((Bag) object).setUsingLife(Integer.parseInt(Bag_UsingLife.getText()));
		((Bag) object).setWeight(Float.parseFloat(Bag_Weight.getText()));
	}

	private boolean isErrorBag() {
		String errorMessage = "";
		if (Bag_Brand.getText() == null || Bag_Brand.getText().length() == 0) {
			errorMessage += "Kulland���n�z �antan�n markas� olmak zorundad�r!!!!";
		}
		try {
			Integer.parseInt(Bag_UsingLife.getText());
			if (Integer.parseInt(Bag_UsingLife.getText()) < 2 || Integer.parseInt(Bag_UsingLife.getText()) > 6) {
				errorMessage += "Kulland���n�z �antan�n �mr� 2 ile 6 y�l aras�nda olmal�d�r!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullan�m �mr�n� l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(Bag_Capacity.getText());
			if (Integer.parseInt(Bag_Capacity.getText()) < 10 || Integer.parseInt(Bag_Capacity.getText()) > 20) {
				errorMessage += "�antan�z�n kapasitesi 10 ile 20 L aras�nda olmal�d�r.";
			}
		} catch (NumberFormatException e) {
			errorMessage += "�anta kapasitesini l�tfen Tamsay� giriniz!\n";
		}
		if (Bag_Brand.getText() == null || Bag_Brand.getText().length() == 0) {
			errorMessage += "L�tfen �antanizin markasini giriniz";
		}
		try {
			Integer.parseInt(Bag_Pocket_Capacity.getText());
			if (Integer.parseInt(Bag_Pocket_Capacity.getText()) < 6
					|| Integer.parseInt(Bag_Pocket_Capacity.getText()) > 9) {
				errorMessage += "�antan�z�n cep b�lmesi 6 ile 9 bolme aras�nda olmal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "�anta cep b�lmesini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Bag_Weight.getText());
			if (Float.parseFloat(Bag_Weight.getText()) < 2.2 || Float.parseFloat(Bag_Weight.getText()) > 4.0) {
				errorMessage += "�antan�z�n a��rl��� 2 ile 4 kg aras�nda olmal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "�anta a��rl���n� l�tfen ger�ek say� giriniz!\n";
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
	private void OkBag() {
		if (isErrorBag()) {
			changeAccessory(this.bag);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	public void setChange(Object object) {
		this.bag = (Bag) object;

	}

}
