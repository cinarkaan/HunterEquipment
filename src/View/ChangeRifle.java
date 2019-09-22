package View;

import Accessory.Rifle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeRifle extends ChangeWeapons {
	
	private Rifle rifle = new Rifle();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	private boolean isErrorRifle() {
		String errorMessage = "";
		if (Brand.getText() == null || Brand.getText().length() == 0) {
			errorMessage += "Girdiginiz T�fe�inizin bir markas� olmak zorundad�r!!!";
		}
		try {
			Integer.parseInt(Range.getText());
			if (Integer.parseInt(Range.getText()) < 100 || Integer.parseInt(Range.getText()) > 450) {
				errorMessage += "T�fe�inizin menzili 200 ile 450 m arasinda olmalidir!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin menzilini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Weight.getText());
			if (Float.parseFloat(Weight.getText()) < 1.5 || Float.parseFloat(Weight.getText()) > 4.5) {
				errorMessage += "T�fe�inizin a��rl��� 1.5 ile 4.5 kg arasinda olmalidir!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin a��rl���n� l�tfen ger�ek sayi giriniz!\n";
		}
		try {
			Integer.parseInt(Ammo.getText());
			if (Integer.parseInt(Ammo.getText()) < 3 || Integer.parseInt(Ammo.getText()) > 10) {
				errorMessage += "T�fe�inizin �arjor kapasitesi 3 ile 10 mermi arasinda de�ismelidir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin �arjor kapasitesini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(FPS.getText());
			if (Integer.parseInt(FPS.getText()) < 600 || Integer.parseInt(FPS.getText()) > 1000) {
				errorMessage += "T�fe�inizin namlu ��k�� h�z� 600 m/sn ile 1000 m/sn arasinda de�erler almal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin namlu ��k�� h�z�n� l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Calibrer.getText());
			if (Float.parseFloat(Calibrer.getText()) < 12.0|| Float.parseFloat(Calibrer.getText()) > 50.0) {
				errorMessage += "T�fe�inizin mermi calibresi 12 ile 50 cal aras�nda olmak zorundad�r!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin mermi calibresini l�tfen ger�ek sayi giriniz!\n";
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
	private void OkRifle() {
		if (isErrorRifle()) {
			this.rifle.setBullet_Type(Rifle_Bullet_Type.getSelectionModel().getSelectedItem().toString());
			changeWeapons(this.rifle);
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void Cancel() {
		dialogStage.close();
	}
	
	@Override
	protected void setChange(Object object) {
		Rifle_Bullet_Type.setPromptText("Kulland���n�z m�himmat t�r�n� se�iniz");
		Rifle_Bullet_Type.getItems().addAll(rifle.getbullet_Type().get(1),rifle.getbullet_Type().get(2)
				,rifle.getbullet_Type().get(3),rifle.getbullet_Type().get(4));
		this.rifle = (Rifle) object;
	}
	
}
