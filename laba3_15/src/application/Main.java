
package application;

import flower.Flower;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * В данном классе создается форма
 * 
 * @author Галя
 *
 */
public class Main extends Application {
	private Stage stage;
	private Scene scene1;

	public static Alert alert;
	public static GridPane pane;
	private Button buttonRose;
	private Button buttonViolet;
	private Button buttonGladiolus;
	private Button buttonSmell;
	private Button buttonWater;
	private Button buttonHoliday;
	public Person person = new Person();
	public static ObservableList<Flower> listFlower = FXCollections.observableArrayList();
	public static TableView<Flower> table = new TableView<>();
	public static TableColumn<Flower, String> columnType = new TableColumn<Flower, String>("Вид\n" + "цветка");
	public static TableColumn<Flower, String> columnHeight = new TableColumn<Flower, String>("Высота\n" + "цветка");
	public static TableColumn<Flower, String> columnBud = new TableColumn<Flower, String>("Цвет\n" + "бутона(ов)");
	public static TableColumn<Flower, String> columnLeaf = new TableColumn<Flower, String>("Кол-во\n" + "листов");

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		int w = 90, h = 20;
		this.stage = stage;
		this.stage.setTitle("Цветочный сад");

		columnType.setCellValueFactory(new PropertyValueFactory<Flower, String>("name"));
		columnHeight.setCellValueFactory(new PropertyValueFactory<Flower, String>("height"));
		columnLeaf.setCellValueFactory(new PropertyValueFactory<Flower, String>("leaf"));
		columnBud.setCellValueFactory(new PropertyValueFactory<Flower, String>("bud"));
		table.getColumns().setAll(columnType, columnHeight, columnLeaf, columnBud);
		table.setPrefSize(320, 250);
		GridPane.setConstraints(table, 0, 2);

		pane = new GridPane();
		pane.setPadding(new Insets(20));
		pane.setVgap(20);

		buttonRose = new Button("Роза");
		buttonRose.setPrefSize(w, h);
		buttonViolet = new Button("Фиалка");
		buttonViolet.setPrefSize(w, h);
		buttonGladiolus = new Button("Гладиолус");
		buttonGladiolus.setPrefSize(w, h);

		HBox hbox1 = new HBox(30);
		hbox1.getChildren().addAll(buttonRose, buttonViolet, buttonGladiolus);
		GridPane.setConstraints(hbox1, 0, 0);

		buttonSmell = new Button("Понюхать");
		buttonSmell.setPrefSize(w, h);
		buttonWater = new Button("Полить");
		buttonWater.setPrefSize(w, h);
		buttonHoliday = new Button(" Вернуться\n" + " из отпуска");
		buttonHoliday.setPrefSize(w, 40);

		HBox hbox2 = new HBox(30);
		hbox2.getChildren().addAll(buttonSmell, buttonWater, buttonHoliday);
		GridPane.setConstraints(hbox2, 0, 1);

		pane.getChildren().addAll(hbox1, hbox2, table);

		/**
		 * Реализует события для кнопки "Роза"
		 *
		 */
		buttonRose.setOnAction(eventbuttonRich -> {
			this.person.PlantFlower(1);
		});
		/**
		 * Реализует события для кнопки "Фиалка"
		 *
		 */
		buttonViolet.setOnAction(eventbuttonPoor -> {
			this.person.PlantFlower(2);
		});
		/**
		 * Реализует события для кнопки "Гладиолус"
		 *
		 */
		buttonGladiolus.setOnAction(eventbuttonStudent -> {
			this.person.PlantFlower(3);
		});
		/**
		 * Реализует события для кнопки "Понюхать"
		 *
		 */
		buttonSmell.setOnAction(eventGiveMoney -> {
			if (!table.getSelectionModel().isEmpty())
				this.person.Smell(table.getSelectionModel().getSelectedItem());
			else
				win(0, "Ошибка", "Не выбран цветок из таблицы!!!");
		});
		/**
		 * Реализует события для кнопки "Полить"
		 *
		 */
		buttonWater.setOnAction(eventbuttonStudent -> {
			if (!table.getSelectionModel().isEmpty()) {
				this.person.Water(table.getSelectionModel().getSelectedItem());
			} else
				win(0, "Ошибка", "Не выбран цветок из таблицы!!!");
		});
		/**
		 * Реализует события для кнопки "Вернуться из отпуска"
		 *
		 */
		buttonHoliday.setOnAction(eventbuttonStudent -> {
			if (!table.getSelectionModel().isEmpty()) {
				this.person.ReturnFromHoliday(table.getSelectionModel().getSelectedItem());
			} else
				win(0, "Ошибка", "Не выбран цветок из таблицы!!!");
		});

		scene1 = new Scene(pane, 370, 400);
		stage.setScene(scene1);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Реализует вывод всплывающего окна
	 * 
	 * @param title
	 *            заголовок окна
	 * @param contentText
	 *            текстовое сообщение
	 *
	 */
	public static void win(int i, String title, String contentText) {
		if (i == 0)
			alert = new Alert(AlertType.WARNING);
		else
			alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
