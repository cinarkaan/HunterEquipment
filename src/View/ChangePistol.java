package View;

import Accessory.Pistol;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangePistol extends ChangeWeapons {


	private Pistol pistol = new Pistol();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean isErrorPistol() {
		String errorMessage = "";
		if (Brand.getText() == null || Brand.getText().length() == 0) {
			errorMessage += "Girdiginiz Tabancan�n bir markas� olmak zorundad�r!!!";
		}
		try {
			Integer.parseInt(Range.getText());
			if (Integer.parseInt(Range.getText()) < 50 || Integer.parseInt(Range.getText()) > 200) {
				errorMessage += "Tabancan�n menzili 50 ile 200 m arasinda olmalidir!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n menzilini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Weight.getText());
			if (Float.parseFloat(Weight.getText()) < 1.5 || Float.parseFloat(Weight.getText()) > 2.5) {
				errorMessage += "Tabancan�n a��rl��� 1.5 ile 2.5 kg arasinda olmalidir!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n a��rl���n� l�tfen ger�ek say� giriniz!\n";
		}
		try {
			Integer.parseInt(Ammo.getText());
			if (Integer.parseInt(Ammo.getText()) < 6 || Integer.parseInt(Ammo.getText()) > 14) {
				errorMessage += "Tabancan�n �arjor kapasitesi 6 ile 14 mermi arasinda de�ismelidir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n �arjor kapasitesini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(FPS.getText());
			if (Integer.parseInt(FPS.getText()) < 400 || Integer.parseInt(FPS.getText()) > 650) {
				errorMessage += "Tabancan�n namlu ��k�� h�z� 400 m/sn ile 650 m/sn arasinda de�erler almal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n namlu ��k�� h�z�n� l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Calibrer.getText());
			if (Float.parseFloat(Calibrer.getText()) < 9 || Float.parseFloat(Calibrer.getText()) > 50) {
				errorMessage += "Tabancan�z�n mermi kalibresi 9 ile 50 cal aras�nda olmak zorundadir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�z�n mermi kalibresini l�tfen ger�ek say� giriniz!\n";
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
	private void OkPistol() {
		if (isErrorPistol()) {
			this.pistol.setBullet_Type(Pistol_Bullet_Type.getSelectionModel().getSelectedItem().toString());
			changeWeapons(this.pistol);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	@Override
	public void setChange(Object object) {
		Pistol_Bullet_Type.setPromptText("Kulland���n�z m�himmat t�r�n� se�iniz");
		Pistol_Bullet_Type.getItems().addAll(pistol.getBullet_Type().get(1), pistol.getBullet_Type().get(2),
				pistol.getBullet_Type().get(3), pistol.getBullet_Type().get(4));
		this.pistol = (Pistol) object;
	}

}
