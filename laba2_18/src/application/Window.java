package application;

import java.util.ArrayList;
import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * ����� "����", � ������ ������ ��������� ����� ��� ���������� �������
 * @author ����
 *
 */
public class Window {
	protected Stage stage;
	private Scene scene;
	private GridPane pane;
	private Label label;
	private Label labelName;
	private Label labelPassword;
	private Label labelYourPassword;
	private TextField text;
	private Button buttonGeneratePassword;
	private Button buttonOk;
	private Button buttonClose;
	/**
	 * � ������ ������ ��������� �����
	 * @param i ��������, ������ ���� ������ ������ ���� ������
	 *
	 */
	public Window(int i) {
		this.stage = new Stage();
		this.stage.setTitle("���������� �������");
		pane = new GridPane();
		pane.setPadding(new Insets(10));

		label = new Label("�������� " + "\n" + "������� " + "\n\n");
		GridPane.setConstraints(label, 0, 0);

		labelName = new Label("���: ");
		GridPane.setConstraints(labelName, 0, 2);

		text = new TextField();
		GridPane.setConstraints(text, 1, 2);
		text.setPromptText("������� ��� �������");
		text.setFocusTraversable(false);

		labelPassword = new Label("������: " + "\n\n");
		GridPane.setConstraints(labelPassword, 0, 3);

		labelYourPassword = new Label("");
		GridPane.setConstraints(labelYourPassword, 1, 3);

		buttonGeneratePassword = new Button("�������������" + "\n" + " ������");
		GridPane.setConstraints(buttonGeneratePassword, 0, 4);

		buttonClose = new Button("Close");
		GridPane.setConstraints(buttonClose, 2, 4);

		buttonOk = new Button("Ok");
		GridPane.setConstraints(buttonOk, 3, 4);

		pane.getChildren().addAll(label, labelName, labelPassword, labelYourPassword, text, buttonGeneratePassword,
				buttonClose, buttonOk);

		buttonGeneratePassword.setOnAction(eventbuttonGeneratePassword -> {
			labelYourPassword.setText(String.valueOf(ATM.GenerationPassword()));
		});

		/**
		 * ��������� ������� ��� ������ "��"
		 * ������� �������.
		 *
		 */
		buttonOk.setOnAction(eventbuttonOk -> {
			if (!text.getText().isEmpty() && !labelYourPassword.getText().isEmpty()) {
				if (i == 1) {
					RichClient rich = new RichClient(this.text.getText());
					rich.password = Integer.parseInt(this.labelYourPassword.getText());
					Main.listClient.add(rich);
				}
				if (i == 2) {
					PoorClient poor = new PoorClient(this.text.getText());
					poor.password = Integer.parseInt(this.labelYourPassword.getText());
					Main.listClient.add(poor);
				}
				if (i == 3) {
					Student student = new Student(this.text.getText());
					student.password = Integer.parseInt(this.labelYourPassword.getText());
					Main.listClient.add(student);
				}

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("������ �������� �������");
				alert.setHeaderText(null);
				alert.setContentText("������ ������!" + "\n\n" + "���: " + this.text.getText() + "\n" + "������: "
						+ this.labelYourPassword.getText());

				alert.showAndWait();
				this.text.clear();
				this.labelYourPassword.setText("");
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("������ �������� �������");
				alert.setHeaderText(null);
				alert.setContentText(
						"�� ������� ��� ������� ��� �� ������������ ������!" + "\n\n" + "��������� �����������.");

				alert.showAndWait();
				this.text.clear();
				this.labelYourPassword.setText("");
			}
			Main.table.setItems(Main.listClient);
		});
		/**
		 * ��������� ������� ��� ������ "Close"
		 *
		 */
		buttonClose.setOnAction(eventbuttonOk -> {
			this.stage.close();
		});
		scene = new Scene(pane, 350, 170);
		stage.setScene(scene);
		stage.show();

	}
}
