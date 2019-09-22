package View;

import java.io.IOException;

import Accessory.Bag;
import Accessory.FishingEat;
import Accessory.FishingRod;
import Accessory.Knife;
import Accessory.Pistol;
import Accessory.Rifle;
import Accessory.Tent;
import File.ReadFile;
import File.WriteFile;
import Hunter.Hunter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private String dialogStageName;
	private String fxmlName;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane Login;

	private ObservableList<Hunter> HunterData = FXCollections.observableArrayList();

	public boolean isEmpty() {
		return this.getHunterData().isEmpty();
	}

	public MainApp() {
		
		//BU KISIM KAYIT MEVCUTSA VAR OLAN KAYITLARI ALMAK VE EN YUKSEK ID �LE TOPLAM KAYITLARI BULMAK ���N ZORUNLUDUR!!!!!!!!
		ReadFile readFile = new ReadFile();
		readFile.totalFile();
		System.out.println("En yuksek id"+""+Hunter.hunter_id+"");
		//BU KISIMA �STED���N�Z KADAR ******DENEME AMA�LI******* AVCI KAYDI G�REB�L�RS�N�Z VEYA PROGRAMDA MANUEL KAYIT YAPAB�L�RS�N�Z!!!!!!!!!!!
		//PROGRAMDA MANUEL KAYIT UZUN OLDU�U ���N BURADAN �STED���N�Z KADAR DENEME AMA�LI AVCI KAYDI YAPAB�L�RS�N�Z!!!!!
		//BU KISIMDAN YAPILAN DENEM AMACLI KAYIT VARSA PROGRAM VAR OLAN KAYITLARI ��E ALMIYACAKTIR!!!!!!
		/*
		 * 
		 *
		  this.HunterData.add(new Hunter("Turan","05067351367", "Ankara")); 
		  this.HunterData.add(new Hunter("Alp", "05067351367", "izmir")); 
		  this.HunterData.add(new Hunter("Mehmet", "05067351367", "istanbul"));
		  this.HunterData.add(new Hunter("R�za", "05067351367","Trabzon"));
		  this.HunterData.add(new Hunter("Veli","05067351367", "Bolu"));
		  */
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Avc� Te�hizat Y�netimi");

		LoginControl();
	}

	public boolean showHunterRecordDialog(Hunter hunter) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("HunterEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Yeni Kay�t");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			HunterEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setHunter(hunter);

			dialogStage.showAndWait();

			return controller.isokClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showEditHunterDialog(Hunter hunter) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("HunterEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Avc� D�zenle");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			HunterEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.editSetHunter(hunter);

			dialogStage.showAndWait();

			return controller.isokClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void findFxmlName(Object getObject) {
		if (getObject instanceof Bag) {
			this.fxmlName = "ChangeBag.fxml";
			this.dialogStageName = "�antay�De�i�tir";
		} else if (getObject instanceof FishingEat) {
			this.fxmlName = "ChangeFishingEat.fxml";
			this.dialogStageName = "OltaYemiDe�i�tir";
		} else if (getObject instanceof FishingRod) {
			this.fxmlName = "ChangeFishingRod.fxml";
			this.dialogStageName = "Oltay�De�i�tir";
		} else if (getObject instanceof Knife) {
			this.fxmlName = "ChangeKnife.fxml";
			this.dialogStageName = "B��a��De�i�tir";
		} else if (getObject instanceof Pistol) {
			this.fxmlName = "ChangePistol.fxml";
			this.dialogStageName = "Tabancay�De�i�tir";
		} else if (getObject instanceof Rifle) {
			this.fxmlName = "ChangeRifle.fxml";
			this.dialogStageName = "T�fe�iDe�i�tir";
		} else if (getObject instanceof Tent) {
			this.fxmlName = "ChangeTent.fxml";
			this.dialogStageName = "�ad�r�De�i�tir";
		}
	}

	public void findClass(FXMLLoader loader, Object getObject, Stage dialogStage) {
		if (getObject instanceof Bag) {
			ChangeBag changeBag = loader.getController();
			changeBag.setDialogStage(dialogStage);
			changeBag.setChange(getObject);
		} else if (getObject instanceof FishingEat) {
			ChangeFishingEat changeFishingEat = loader.getController();
			changeFishingEat.setDialogStage(dialogStage);
			changeFishingEat.setChange(getObject);
		} else if (getObject instanceof FishingRod) {
			ChangeFishingRod changeFishingRod = loader.getController();
			changeFishingRod.setDialogStage(dialogStage);
			changeFishingRod.setChange(getObject);
		} else if (getObject instanceof Knife) {
			ChangeKnife changeKnife = loader.getController();
			changeKnife.setDialogStage(dialogStage);
			changeKnife.setChange(getObject);
		} else if (getObject instanceof Pistol) {
			ChangePistol changePistol = loader.getController();
			changePistol.setDialogStage(dialogStage);
			changePistol.setChange(getObject);
		} else if (getObject instanceof Rifle) {
			ChangeRifle changeRifle = loader.getController();
			changeRifle.setDialogStage(dialogStage);
			changeRifle.setChange(getObject);
		} else if (getObject instanceof Tent) {
			ChangeTent changeTent = loader.getController();
			changeTent.setDialogStage(dialogStage);
			changeTent.setChange(getObject);
		}
	}

	public boolean showEditAccessory(Object object) {
		findFxmlName(object);
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(this.fxmlName));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle(this.dialogStageName);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			findClass(loader, object, dialogStage);
			dialogStage.showAndWait();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			return false;
		}

	}

	public boolean SaveFile(Hunter hunter) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/File/SaveFile.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Dosya Kaydet");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			WriteFile writeFile = loader.getController();
			writeFile.setDialogStage(dialogStage);
			writeFile.setHunter(hunter);
			dialogStage.showAndWait();

			return writeFile.isokClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Hunter openFile() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/File/OpenFile.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Dosya A�");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ReadFile readFile = loader.getController();
			readFile.setDialogStage(dialogStage);
			dialogStage.showAndWait();

			return readFile.isFileHunter();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteFile() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("DeleteFile.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Avc� Sil");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DeleteHunter deleteHunter = loader.getController();
			deleteHunter.setDialogStage(dialogStage);
			dialogStage.showAndWait();

			return deleteHunter.isDelete();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public void aboutUs() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Hakk�m�zda.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Hakk�m�zda");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public ObservableList<Hunter> getHunterData() {
		return HunterData;
	}

	/**
	 * Avc� y�netimekran�n� baslat�r
	 */
	public void hunterDetail() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("HunterDetail.fxml"));
			rootLayout = (BorderPane) loader.load();

			HunterController control = loader.getController();
			control.setMainApp(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LoginControl() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Login.fxml"));
			Login = loader.load();

			LoginController control = loader.getController();
			control.setMainApp(this);

			Scene scene = new Scene(Login);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main stage i g�nderir.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}