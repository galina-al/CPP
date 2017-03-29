
package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * В данном классе создается форма
 * @author Галя
 *
 */
public class Main extends Application {
	private Stage stage;
	private Scene scene1;
	private GridPane pane;
	private Button buttonRich;
	private Button buttonPoor;
	private Button buttonStudent;
	private Button buttonGiveMoney;
	@SuppressWarnings("unused")
	private Window win;
	private ATM bank;
	public static ObservableList<Client> listClient = FXCollections.observableArrayList();
	public static TableView<Client> table = new TableView<>();
	public static TableColumn<Client, String> columnName = new TableColumn<Client, String>("Name");
	public static TableColumn<Client, String> columnPassword = new TableColumn<Client, String>("Password");
	public static TableColumn<Client, String> columnMoney = new TableColumn<Client, String>("Money");
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		this.stage.setTitle("Банкомат");
		this.bank = new ATM();

		columnName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		columnPassword.setCellValueFactory(new PropertyValueFactory<Client, String>("password"));
		columnMoney.setCellValueFactory(new PropertyValueFactory<Client, String>("money"));
		table.getColumns().setAll(columnName, columnMoney, columnPassword);
		GridPane.setConstraints(table, 0, 4);

		pane = new GridPane();
		pane.setPadding(new Insets(20));
		pane.setVgap(20);
		pane.setHgap(10);

		buttonRich = new Button("Богатый Клиент");
		GridPane.setConstraints(buttonRich, 0, 0);

		buttonPoor = new Button("Бедный Клиент");
		GridPane.setConstraints(buttonPoor, 0, 1);

		buttonStudent = new Button("Студент");
		GridPane.setConstraints(buttonStudent, 0, 2);

		buttonGiveMoney = new Button("Снять деньги");
		GridPane.setConstraints(buttonGiveMoney, 1, 3);

		pane.getChildren().addAll(buttonRich, buttonPoor, buttonStudent, table, buttonGiveMoney);

		/**
		 * Реализует события для кнопки "Богатый клиент"
		 *
		 */
		buttonRich.setOnAction(eventbuttonRich -> {
			this.win = new Window(1);
		});
		/**
		 * Реализует события для кнопки "Бедный клиент"
		 *
		 */
		buttonPoor.setOnAction(eventbuttonPoor -> {
			this.win = new Window(2);
		});
		/**
		 * Реализует события для кнопки "Студент"
		 *
		 */
		buttonStudent.setOnAction(eventbuttonStudent -> {
			this.win = new Window(3);
		});
		/**
		 * Реализует события для кнопки "Снять деньги"
		 *
		 */
		buttonGiveMoney.setOnAction(eventGiveMoney -> {
			int ind = (table.getSelectionModel().getSelectedIndex());
			table.getSelectionModel().getSelectedItem().Withdrow(bank, ind);
		});

		scene1 = new Scene(pane, 400, 500);
		stage.setScene(scene1);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * Реализует рандомную генерацию числа 
	 * @return Результат выполненной операции
	 * @param min нижняя граница
	 * @param max верхняя граница
	 *
	 */
	public static int rnd(int min, int max) {
		return (int) (Math.random() * max) + min;
	}

}
