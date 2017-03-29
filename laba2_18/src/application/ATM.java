package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * ����� "����" ��������� �������� ���������
 * @author ����
 *
 */
public class ATM {
	private String bank_name;
	public Money money;
	/**
	 * ����� "����" ��������� �������� ���������
	 * 
	 * @param bank_name �������� ����� 
	 * @param money ������ ���� ������ "������", �������� �������� � �����, ����������� � ���������
	 */
	PasswordField password = new PasswordField();
	Alert Inf = new Alert(AlertType.INFORMATION);
	Alert Error = new Alert(AlertType.WARNING);

	public ATM() {
		this.bank_name = "Belarusbank";
		this.money = new Money(2000, this.bank_name);
	}

	/**
	 * ��������� �������� "������ ������"
	 * @param client ������
	 */
	protected void GiveMoney(Client client) {
		int sumCl = Integer.parseInt(client.money.sum.get());
		int sumB = Integer.parseInt(this.money.sum.get());
		if (sumCl == 0) {
			Error.setTitle("�� ����!;(");
			Error.setHeaderText(null);
			Error.setContentText("���-���-���!\n"  + "����� ���� ���, ���������!\n" + "���� ������� �� ����������.");
			Error.showAndWait();
			password.clear();
		} else {
			if (sumB >= sumCl) {
				sumB -= sumCl;
				sumCl = 0;
				Inf.setTitle("�������� ������");
				Inf.setHeaderText(null);
				Inf.setContentText("������ ������ ��������." + "\n\n" + "�����������, �� ����� ������ �� �����!");
				Inf.showAndWait();
				this.password.clear();
			} else {
				Error.setTitle("�������� - ����;(");
				Error.setHeaderText(null);
				Error.setContentText("� ������ ����� ���!" + "\n\n" + "��� ��� ����, �����(");
				Error.showAndWait();
				password.clear();
			}
		}
		client.money.sum.set(String.valueOf(sumCl));
		this.money.sum.set(String.valueOf(sumB));
	}

	/**
	 * ��������� �������� "�������� ������"
	 * @param client ������
	 */
	protected void RequestPassword(Client client) {
		Stage stage = new Stage();
		Scene scene;
		VBox pane = new VBox();
		pane.setPadding(new Insets(10));

		Label label = new Label("�������� ������");

		password.setMaxWidth(150);
		password.setPromptText("������� ������");

		Button Ok = new Button("Ok");
		Button Close = new Button("Close");
		HBox h = new HBox();
		h.getChildren().addAll(Ok, Close);

		pane.getChildren().addAll(label, password, h);

		Ok.setOnAction(eventOk -> {
			if (password.getText().equals(String.valueOf(client.password))) {
				this.GiveMoney(client);
				stage.close();

			} else {
				Error.setTitle("�������� ������");
				Error.setHeaderText(null);
				Error.setContentText("�� ���������!" + "\n\n" + "����� ���������� ������!");
				Error.showAndWait();
				password.clear();
			}
		});

		Close.setOnAction(eventClose -> {
			System.out.println(password.getText());
			password.clear();
			stage.close();
		});

		scene = new Scene(pane, 200, 100);
		stage.setScene(scene);
		stage.show();

	}

	/**
	 * ��������� �������� "��������� ������"
	 * @return  ��������� ����������� ��������
	 */
	public static int GenerationPassword() {
		return Main.rnd(1000, 9999);
	}

}
