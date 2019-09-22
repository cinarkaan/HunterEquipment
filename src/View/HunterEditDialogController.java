package View;

import Hunter.Hunter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class HunterEditDialogController {

	@FXML
	private TextField hunterName;
	@FXML
	private Label hunterId;
	@FXML
	private TextField hunterNumber;
	@FXML
	private TextField hunter_Adress;
	@FXML
	private CheckBox hunter_Criminal_Yes;
	@FXML
	private CheckBox hunter_Criminal_No;
	@FXML
	private TextField Rifle_FPS;
	@FXML
	private TextField Rifle_Ammo;
	@FXML
	private TextField Rifle_Weight;
	@FXML
	private TextField Rifle_Range;
	@FXML
	private TextField Rifle_Brand;
	@FXML
	private TextField Rifle_Calibrer;
	@FXML
	private ComboBox<String> Rifle_Bullet_Type = new ComboBox<>();
	@FXML
	private TextField Pistol_Brand;
	@FXML
	private TextField Pistol_Weight;
	@FXML
	private TextField Pistol_Range;
	@FXML
	private TextField Pistol_Calibrer;
	@FXML
	private TextField Pistol_FPS;
	@FXML
	private TextField Pistol_Bullet_Capacity;
	@FXML
	private ComboBox<String> Pistol_Bullet_Type = new ComboBox<>();
	@FXML
	private TextField Bag_Capacity;
	@FXML
	private TextField Bag_Brand;
	@FXML
	private TextField Bag_Pocket_Capacity;
	@FXML
	private TextField Bag_Weight;
	@FXML
	private CheckBox Bag_Water_Proof1;
	@FXML
	private CheckBox Bag_Water_Proof2;
	@FXML
	private TextField Bag_UsingLife;
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
	@FXML
	private CheckBox Tent_Water_Proof_chck1;
	@FXML
	private CheckBox Tent_Water_Proof_chck2;
	@FXML
	private TextField Knife_Lenght;
	@FXML
	private TextField Knife_Brand;
	@FXML
	private ComboBox<String> Knife_Type = new ComboBox<>();
	@FXML
	private ComboBox<String> Eat_Type = new ComboBox<>();
	@FXML
	private TextField Total_Eat;
	@FXML
	private CheckBox LiveEat_Yes_Check;
	@FXML
	private CheckBox EatLive_NoCheck;
	@FXML
	private TextField Rotation_Rate;
	@FXML
	private TextField Number_Of_Ball;
	@FXML
	private ComboBox<String> F_Rod_Type;
	@FXML
	private TextField Rod_Brand;

	private Stage dialogStage;
	protected Hunter hunter = new Hunter();
	private boolean okClicked = false;

	@FXML
	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void TentYesCheck() {

		if (Tent_Water_Proof_chck1.isSelected()) {
			Tent_Water_Proof_chck2.setSelected(false);
			hunter.getAccessory().getTent().setWaterProof(true);
		}

	}

	@FXML
	private void TentNoCheck() {

		if (Tent_Water_Proof_chck2.isSelected()) {
			Tent_Water_Proof_chck1.setSelected(false);
			hunter.getAccessory().getTent().setWaterProof(false);
		}

	}

	@FXML
	private void Bag_Yes_Check() {

		if (Bag_Water_Proof1.isSelected()) {
			Bag_Water_Proof2.setSelected(false);
			hunter.getAccessory().getBag().setWaterProof(true);
		}

	}

	@FXML
	private void Bag_No_Check() {

		if (Bag_Water_Proof2.isSelected()) {
			Bag_Water_Proof1.setSelected(false);
			hunter.getAccessory().getBag().setWaterProof(false);
		}

	}

	@FXML
	private void isLiveEat_YesCheck() {

		if (LiveEat_Yes_Check.isSelected()) {
			EatLive_NoCheck.setSelected(false);
			hunter.getAccessory().getFishing_Eat().setIsLive(true);
		}

	}

	@FXML
	private void isLiveEat_NoCheck() {

		if (EatLive_NoCheck.isSelected()) {
			LiveEat_Yes_Check.setSelected(false);
			hunter.getAccessory().getFishing_Eat().setIsLive(false);
		}

	}

	@FXML
	private void isCriminalYes() {

		if (hunter_Criminal_Yes.isSelected()) {
			hunter_Criminal_No.setSelected(false);
			hunter.setCrime(true);
		}

	}

	@FXML
	private void isCriminalNo() {

		if (hunter_Criminal_No.isSelected()) {
			hunter_Criminal_Yes.setSelected(false);
			hunter.setCrime(false);
		}

	}

	public void setHunter(Hunter hunter) {
		this.hunter = hunter;
		hunterName.setText(hunter.gethunter_Name());
		hunterNumber.setText(hunter.getHunter_Number());
		hunterId.setText(Integer.toString(Hunter.hunter_id + 1));
		hunter_Adress.setText(hunter.getAdress());
		Rifle_FPS.setText(Integer.toString(hunter.getAccessory().getRifle().getFPS()));
		Rifle_Ammo.setText(Integer.toString(hunter.getAccessory().getRifle().getBulletCapacity()));
		Rifle_Weight.setText(Float.toString(hunter.getAccessory().getRifle().getWeight()));
		Rifle_Range.setText(Integer.toString(hunter.getAccessory().getRifle().getRange()));
		Rifle_Brand.setText(hunter.getAccessory().getRifle().getBrand());
		Rifle_Calibrer.setText(Float.toString(hunter.getAccessory().getRifle().getCalibrer()));
		Rifle_Bullet_Type.setPromptText("Kulland���n�z m�himmat t�r�n� se�iniz");
		Rifle_Bullet_Type.getItems().addAll(hunter.getAccessory().getRifle().getbullet_Type().get(1),
				hunter.getAccessory().getRifle().getbullet_Type().get(2),
				hunter.getAccessory().getRifle().getbullet_Type().get(3),
				hunter.getAccessory().getRifle().getbullet_Type().get(4));
		Pistol_Brand.setText(hunter.getAccessory().getPistol().getBrand());
		Pistol_Bullet_Capacity.setText(Integer.toString(hunter.getAccessory().getPistol().getBulletCapacity()));
		Pistol_Calibrer.setText(Float.toString(hunter.getAccessory().getPistol().getCalibrer()));
		Pistol_FPS.setText(Integer.toString(hunter.getAccessory().getPistol().getFPS()));
		Pistol_Range.setText(Integer.toString(hunter.getAccessory().getPistol().getRange()));
		Pistol_Weight.setText(Float.toString(hunter.getAccessory().getPistol().getWeight()));
		Pistol_Bullet_Type.setPromptText("Kulland���n�z m�himmat t�r�n� se�iniz");
		Pistol_Bullet_Type.getItems().addAll(hunter.getAccessory().getPistol().getBullet_Type().get(1),
				hunter.getAccessory().getPistol().getBullet_Type().get(2),
				hunter.getAccessory().getPistol().getBullet_Type().get(3),
				hunter.getAccessory().getPistol().getBullet_Type().get(4));
		Bag_Brand.setText(hunter.getAccessory().getBag().getBrand());
		Bag_UsingLife.setText(Integer.toString(hunter.getAccessory().getBag().getUsingLife()));
		Bag_Capacity.setText(Integer.toString(hunter.getAccessory().getBag().getCapacity()));
		Bag_Brand.setText(hunter.getAccessory().getBag().getBrand());
		Bag_Pocket_Capacity.setText(Integer.toString(hunter.getAccessory().getBag().getPocket_Total()));
		Bag_Weight.setText(Float.toString(hunter.getAccessory().getBag().getWeight()));
		Tent_Brand.setText(hunter.getAccessory().getTent().getBrand());
		Tent_UsingLife.setText(Integer.toString(hunter.getAccessory().getTent().getUsingLife()));
		Tent_Lenght.setText(Float.toString(hunter.getAccessory().getTent().getLenght()));
		Tent_Height.setText(Float.toString(hunter.getAccessory().getTent().getheight()));
		Tent_Person_Amount.setText(Integer.toString(hunter.getAccessory().getTent().getPerson_Amount()));
		Tent_Prodect_Temp.setText(Integer.toString(hunter.getAccessory().getTent().getProtection_Tempature()));
		Tent_Season.setText(hunter.getAccessory().getTent().getSeason());
		Knife_Lenght.setText(Float.toString(hunter.getAccessory().getKnife().getLengt()));
		Knife_Brand.setText(hunter.getAccessory().getKnife().getOrigin());
		Knife_Type.setPromptText("Kulland���n�z B��ak t�r�n� se�iniz");
		Knife_Type.getItems().addAll(hunter.getAccessory().getKnife().getType().get(1),
				hunter.getAccessory().getKnife().getType().get(2), hunter.getAccessory().getKnife().getType().get(3),
				hunter.getAccessory().getKnife().getType().get(4), hunter.getAccessory().getKnife().getType().get(5));
		Eat_Type.setPromptText("Yem t�r� seciniz!!");
		Eat_Type.getItems().addAll(hunter.getAccessory().getFishing_Eat().getEat_Type().get(1),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(2),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(3),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(4),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(5));
		Total_Eat.setText(Integer.toString(hunter.getAccessory().getFishing_Eat().getTotal_Eat()));
		Rod_Brand.setText(hunter.getAccessory().getFishing_Rod().getBrand());
		Rotation_Rate.setText(Float.toString(hunter.getAccessory().getFishing_Rod().getRotation_Rate()));
		Number_Of_Ball.setText(Integer.toString(hunter.getAccessory().getFishing_Rod().getNumber_Of_Ball()));
		F_Rod_Type.setPromptText("Olta t�r� se�iniz");
		F_Rod_Type.getItems().addAll(hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(1),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(2),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(3),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(4),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(5));
	}

	public void editSetHunter(Hunter hunter) {
		this.hunter = hunter;
		hunterName.setText(hunter.gethunter_Name());
		hunterNumber.setText(hunter.getHunter_Number());
		hunter_Adress.setText(hunter.getAdress());
		hunterId.setText(Integer.toString(hunter.getHunter_id()));
		Rifle_FPS.setText(Integer.toString(hunter.getAccessory().getRifle().getFPS()));
		Rifle_Ammo.setText(Integer.toString(hunter.getAccessory().getRifle().getBulletCapacity()));
		Rifle_Weight.setText(Float.toString(hunter.getAccessory().getRifle().getWeight()));
		Rifle_Range.setText(Integer.toString(hunter.getAccessory().getRifle().getRange()));
		Rifle_Brand.setText(hunter.getAccessory().getRifle().getBrand());
		Rifle_Calibrer.setText(Float.toString(hunter.getAccessory().getRifle().getCalibrer()));
		Rifle_Bullet_Type.getItems().addAll(hunter.getAccessory().getRifle().getbullet_Type().get(1),
				hunter.getAccessory().getRifle().getbullet_Type().get(2),
				hunter.getAccessory().getRifle().getbullet_Type().get(3),
				hunter.getAccessory().getRifle().getbullet_Type().get(4));
		Pistol_Brand.setText(hunter.getAccessory().getPistol().getBrand());
		Pistol_Bullet_Capacity.setText(Integer.toString(hunter.getAccessory().getPistol().getBulletCapacity()));
		Pistol_Calibrer.setText(Float.toString(hunter.getAccessory().getPistol().getCalibrer()));
		Pistol_FPS.setText(Integer.toString(hunter.getAccessory().getPistol().getFPS()));
		Pistol_Range.setText(Integer.toString(hunter.getAccessory().getPistol().getRange()));
		Pistol_Weight.setText(Float.toString(hunter.getAccessory().getPistol().getWeight()));
		Pistol_Bullet_Type.getItems().addAll(hunter.getAccessory().getPistol().getBullet_Type().get(1),
				hunter.getAccessory().getPistol().getBullet_Type().get(2),
				hunter.getAccessory().getPistol().getBullet_Type().get(3),
				hunter.getAccessory().getPistol().getBullet_Type().get(4));
		Bag_Brand.setText(hunter.getAccessory().getBag().getBrand());
		Bag_UsingLife.setText(Integer.toString(hunter.getAccessory().getBag().getUsingLife()));
		Bag_Capacity.setText(Integer.toString(hunter.getAccessory().getBag().getCapacity()));
		Bag_Brand.setText(hunter.getAccessory().getBag().getBrand());
		Bag_Pocket_Capacity.setText(Integer.toString(hunter.getAccessory().getBag().getPocket_Total()));
		Bag_Weight.setText(Float.toString(hunter.getAccessory().getBag().getWeight()));
		Tent_Brand.setText(hunter.getAccessory().getTent().getBrand());
		Tent_UsingLife.setText(Integer.toString(hunter.getAccessory().getTent().getUsingLife()));
		Tent_Lenght.setText(Float.toString(hunter.getAccessory().getTent().getLenght()));
		Tent_Height.setText(Float.toString(hunter.getAccessory().getTent().getheight()));
		Tent_Person_Amount.setText(Integer.toString(hunter.getAccessory().getTent().getPerson_Amount()));
		Tent_Prodect_Temp.setText(Integer.toString(hunter.getAccessory().getTent().getProtection_Tempature()));
		Tent_Season.setText(hunter.getAccessory().getTent().getSeason());
		Knife_Lenght.setText(Float.toString(hunter.getAccessory().getKnife().getLengt()));
		Knife_Brand.setText(hunter.getAccessory().getKnife().getOrigin());
		Knife_Type.setPromptText("Kulland���n�z B��ak t�r�n� se�iniz");
		Knife_Type.getItems().addAll(hunter.getAccessory().getKnife().getType().get(1),
				hunter.getAccessory().getKnife().getType().get(2), hunter.getAccessory().getKnife().getType().get(3),
				hunter.getAccessory().getKnife().getType().get(4), hunter.getAccessory().getKnife().getType().get(5));
		Eat_Type.setPromptText("Yem t�r� seciniz!!");
		Eat_Type.getItems().addAll(hunter.getAccessory().getFishing_Eat().getEat_Type().get(1),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(2),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(3),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(4),
				hunter.getAccessory().getFishing_Eat().getEat_Type().get(5));
		Total_Eat.setText(Integer.toString(hunter.getAccessory().getFishing_Eat().getTotal_Eat()));
		Rod_Brand.setText(hunter.getAccessory().getFishing_Rod().getBrand());
		Rotation_Rate.setText(Float.toString(hunter.getAccessory().getFishing_Rod().getRotation_Rate()));
		Number_Of_Ball.setText(Integer.toString(hunter.getAccessory().getFishing_Rod().getNumber_Of_Ball()));
		F_Rod_Type.setPromptText("Olta t�r� se�iniz");
		F_Rod_Type.getItems().addAll(hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(1),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(2),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(3),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(4),
				hunter.getAccessory().getFishing_Rod().getF_Rod_Type().get(5));
	}

	public boolean isokClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isHunterInputValid()) {
			hunter.sethunter_Name(hunterName.getText());
			hunter.setHunter_Number(hunterNumber.getText());
			hunter.setHunter_id(Integer.parseInt(hunterId.getText()));
			hunter.setAdress(hunter_Adress.getText());
			hunter.getAccessory().getRifle().setFPS(Integer.parseInt(Rifle_FPS.getText()));
			hunter.getAccessory().getRifle().setBulletCapacity(Integer.parseInt(Rifle_Ammo.getText()));
			hunter.getAccessory().getRifle().setWeight(Float.parseFloat(Rifle_Weight.getText()));
			hunter.getAccessory().getRifle().setRange(Integer.parseInt(Rifle_Range.getText()));
			hunter.getAccessory().getRifle().setBrand(Rifle_Brand.getText());
			hunter.getAccessory().getRifle().setCalibrer(Float.parseFloat(Rifle_Calibrer.getText()));
			hunter.getAccessory().getRifle()
					.setBullet_Type(Rifle_Bullet_Type.getSelectionModel().getSelectedItem().toString());
			hunter.getAccessory().getPistol().setBrand(Pistol_Brand.getText());
			hunter.getAccessory().getPistol().setBulletCapacity(Integer.parseInt(Pistol_Bullet_Capacity.getText()));
			hunter.getAccessory().getPistol().setCalibrer(Float.parseFloat(Pistol_Calibrer.getText()));
			hunter.getAccessory().getPistol().setFPS(Integer.parseInt(Pistol_FPS.getText()));
			hunter.getAccessory().getPistol().setRange(Integer.parseInt(Pistol_Range.getText()));
			hunter.getAccessory().getPistol().setWeight(Float.parseFloat(Pistol_Weight.getText()));
			hunter.getAccessory().getPistol()
					.setBullet_Type(Pistol_Bullet_Type.getSelectionModel().getSelectedItem().toString());
			hunter.getAccessory().getBag().setBrand(Bag_Brand.getText());
			hunter.getAccessory().getBag().setCapacity(Integer.parseInt(Bag_Capacity.getText()));
			hunter.getAccessory().getBag().setPocket_Total(Integer.parseInt(Bag_Pocket_Capacity.getText()));
			hunter.getAccessory().getBag().setUsingLife(Integer.parseInt(Bag_UsingLife.getText()));
			hunter.getAccessory().getBag().setWeight(Float.parseFloat(Bag_Weight.getText()));
			hunter.getAccessory().getTent().setLenght(Float.parseFloat(Tent_Lenght.getText()));
			hunter.getAccessory().getTent().setheight(Float.parseFloat(Tent_Height.getText()));
			hunter.getAccessory().getTent().setPerson_Amount(Integer.parseInt(Tent_Person_Amount.getText()));
			hunter.getAccessory().getTent().setProtection_Tempature(Integer.parseInt(Tent_Prodect_Temp.getText()));
			hunter.getAccessory().getTent().setSeason(Tent_Season.getText());
			hunter.getAccessory().getTent().setUsingLife(Integer.parseInt(Tent_UsingLife.getText()));
			hunter.getAccessory().getTent().setBrand(Tent_Brand.getText());
			hunter.getAccessory().getKnife().setLengt(Float.parseFloat(Knife_Lenght.getText()));
			hunter.getAccessory().getKnife().setOrigin(Knife_Brand.getText());
			hunter.getAccessory().getKnife().setKnife_Type(Knife_Type.getSelectionModel().getSelectedItem().toString());
			hunter.getAccessory().getFishing_Eat()
					.setEat_Type(Eat_Type.getSelectionModel().getSelectedItem().toString());
			hunter.getAccessory().getFishing_Eat().setTotal_Eat(Integer.parseInt(Total_Eat.getText()));
			hunter.getAccessory().getFishing_Rod().setBrand(Rod_Brand.getText());
			hunter.getAccessory().getFishing_Rod()
					.setRod_Type(F_Rod_Type.getSelectionModel().getSelectedItem().toString());
			hunter.getAccessory().getFishing_Rod().setNumber_Of_Ball(Integer.parseInt(Number_Of_Ball.getText()));
			hunter.getAccessory().getFishing_Rod().setRotation_Rate(Float.parseFloat(Rotation_Rate.getText()));
			++Hunter.hunter_id;
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isHunterInputValid() {

		String errorMessage = "";

		if (Knife_Brand.getText() == null || Knife_Brand.getText().length() == 0) {
			errorMessage += "Kullanilan bircagin bir markasi olmak zorundadir";
		}
		try {
			Float.parseFloat(Knife_Lenght.getText());
			if (Float.parseFloat(Knife_Lenght.getText()) < 4 || Float.parseFloat(Knife_Lenght.getText()) > 10) {
				errorMessage += "Kullandiginiz bica�in uzunlu�u 4 ile 10 cm arasinda olmak zorundadir";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullandiginiz bica�in uzunlu�unu l�tfen ger�ek say� giriniz!\n";
		}
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
			errorMessage += "Kullanilan cadirin uzunlu�unu l�tfen ger�ek say� giriniz!\n";
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
			if (Integer.parseInt(Tent_Person_Amount.getText()) < 4
					|| Integer.parseInt(Tent_Person_Amount.getText()) > 7) {
				errorMessage += "Kullanilan cadir 4 ile 7 kisilik olmak zorundad�r!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullanilan cadirin ki�i sayisini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(Tent_Prodect_Temp.getText());
			if (Integer.parseInt(Tent_Prodect_Temp.getText()) < -25
					|| Integer.parseInt(Tent_Prodect_Temp.getText()) > 30) {
				errorMessage += "Kullanilan cadirin s�n�r s�cakl�klar� -25 ile 30 aras�nda olmal�d�r!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullanilan cadirin s�n�r s�cakl�klar�n� l�tfen Tamsay� giriniz!\n";
		}
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
		if (Rifle_Brand.getText() == null || Rifle_Brand.getText().length() == 0) {
			errorMessage += "Girdiginiz T�fe�inizin bir markas� olmak zorundad�r!!!";
		}
		try {
			Integer.parseInt(Rifle_Range.getText());
			if (Integer.parseInt(Rifle_Range.getText()) < 100 || Integer.parseInt(Rifle_Range.getText()) > 450) {
				errorMessage += "T�fe�inizin menzili 200 ile 450 m arasinda olmalidir!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin menzilini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Rifle_Weight.getText());
			if (Float.parseFloat(Rifle_Weight.getText()) < 1.5 || Float.parseFloat(Rifle_Weight.getText()) > 4.5) {
				errorMessage += "T�fe�inizin a��rl��� 1.5 ile 4.5 kg arasinda olmalidir!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin a��rl���n� l�tfen ger�ek sayi giriniz!\n";
		}
		try {
			Integer.parseInt(Rifle_Ammo.getText());
			if (Integer.parseInt(Rifle_Ammo.getText()) < 3 || Integer.parseInt(Rifle_Ammo.getText()) > 10) {
				errorMessage += "T�fe�inizin �arjor kapasitesi 3 ile 10 mermi arasinda de�ismelidir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin �arjor kapasitesini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(Rifle_FPS.getText());
			if (Integer.parseInt(Rifle_FPS.getText()) < 600 || Integer.parseInt(Rifle_FPS.getText()) > 1000) {
				errorMessage += "T�fe�inizin namlu ��k�� h�z� 600 m/sn ile 1000 m/sn arasinda de�erler almal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin namlu ��k�� h�z�n� l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Rifle_Calibrer.getText());
			if (Float.parseFloat(Rifle_Calibrer.getText()) < 12.0
					|| Float.parseFloat(Rifle_Calibrer.getText()) > 50.0) {
				errorMessage += "T�fe�inizin mermi calibresi 12 ile 50 cal aras�nda olmak zorundad�r!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "T�fe�inizin mermi calibresini l�tfen ger�ek sayi giriniz!\n";
		}
		if (Pistol_Brand.getText() == null || Pistol_Brand.getText().length() == 0) {
			errorMessage += "Girdiginiz Tabancan�n bir markas� olmak zorundad�r!!!";
		}
		try {
			Integer.parseInt(Pistol_Range.getText());
			if (Integer.parseInt(Pistol_Range.getText()) < 50 || Integer.parseInt(Pistol_Range.getText()) > 200) {
				errorMessage += "Tabancan�n menzili 50 ile 200 m arasinda olmalidir!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n menzilini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Pistol_Weight.getText());
			if (Float.parseFloat(Pistol_Weight.getText()) < 1.5 || Float.parseFloat(Pistol_Weight.getText()) > 2.5) {
				errorMessage += "Tabancan�n a��rl��� 1.5 ile 2.5 kg arasinda olmalidir!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n a��rl���n� l�tfen ger�ek say� giriniz!\n";
		}
		try {
			Integer.parseInt(Pistol_Bullet_Capacity.getText());
			if (Integer.parseInt(Pistol_Bullet_Capacity.getText()) < 6
					|| Integer.parseInt(Pistol_Bullet_Capacity.getText()) > 14) {
				errorMessage += "Tabancan�n �arjor kapasitesi 6 ile 14 mermi arasinda de�ismelidir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n �arjor kapasitesini l�tfen Tamsay� giriniz!\n";
		}
		try {
			Integer.parseInt(Pistol_FPS.getText());
			if (Integer.parseInt(Pistol_FPS.getText()) < 400 || Integer.parseInt(Pistol_FPS.getText()) > 650) {
				errorMessage += "Tabancan�n namlu ��k�� h�z� 400 m/sn ile 650 m/sn arasinda de�erler almal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�n namlu ��k�� h�z�n� l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Pistol_Calibrer.getText());
			if (Float.parseFloat(Pistol_Calibrer.getText()) < 9 || Float.parseFloat(Pistol_Calibrer.getText()) > 50) {
				errorMessage += "Tabancan�z�n mermi kalibresi 9 ile 50 cal aras�nda olmak zorundadir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancan�z�n mermi kalibresini l�tfen ger�ek say� giriniz!\n";
		}
		if (hunterName.getText() == null || hunterName.getText().length() == 0) {
			errorMessage += "Gecerli bir acvi yok!!\n";
		}
		if (hunterNumber.getText().length() != 11) {
			errorMessage += "Gecerli bir avci numarasi yok(11Haneli)!!\n";
		}
		try {
			Integer.parseInt(Total_Eat.getText());
			if (Integer.parseInt(Total_Eat.getText()) < 0 || Integer.parseInt(Total_Eat.getText()) > 150) {
				errorMessage += "Yem miktar�n�z en az 0 en fazla 150 aras�nda olmal�d�r";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Yem miktar�n� l�tfen Tamsay� giriniz!\n";
		}
		if (Rod_Brand.getText() == null || Rod_Brand.getText().length() == 0) {
			errorMessage += "Kulland���n�z oltan�n markas� olmak zorundad�r!!!!";
		}
		try {
			Integer.parseInt(Number_Of_Ball.getText());
			if (Integer.parseInt(Number_Of_Ball.getText()) < 6 || Integer.parseInt(Number_Of_Ball.getText()) > 11) {
				errorMessage += "Kulland���n�z oltan�n bilye sayisi 6 ile 11 arasinda olmal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kulland���n�z oltan�n bilye sayis�n� l�tfen Tamsay� giriniz!\n";
		}
		try {
			Float.parseFloat(Rotation_Rate.getText());
			if (Float.parseFloat(Rotation_Rate.getText()) < 5.5 || Float.parseFloat(Rotation_Rate.getText()) > 9.4) {
				errorMessage += "Kulland���n�z oltan�n devir oran� 5.5 ile 9.4 w arasinda olmal�d�r!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kulland���n�z oltan�n d�nme oran�n� l�tfen ger�ek sayi giriniz!\n";
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

}
