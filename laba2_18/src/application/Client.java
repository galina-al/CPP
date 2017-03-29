package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * Класс "Клиент" реализует действия клиента.
 * @author Галя
 *
 */
public class Client {
	protected String name;
	public Money money;
	protected int password;
	/**
	 * Класс "Клиент" реализует действия клиента.
	 * @param name имя клиента
	 *
	 */
	public Client(String name) {
		this.name = name;
	}
	/**
	 * Реализует действие "Снять деньги"
	 * @param ind индекс элемента в таблице
	 * @param bank банкомат
	 */
	public void Withdrow(ATM bank, int ind) {
		bank.RequestPassword(Main.listClient.get(ind));
	}
	/**
	 * Реализует действие "Вернуть имя клиента"
	 * @return  Результат выполненной операции
	 */
	public String getName() {
		return name;
	}
	/**
	 * Реализует действие "Вернуть пароль клиента"
	 * @return  Результат выполненной операции
	 */
	public String getPassword() {
		return String.valueOf(password);
	}
	/**
	 * Реализует действие "Вернуть сумму на счете клиента"
	 * @return  Результат выполненной операции
	 */
	public String getMoney() {
		return money.sum.get();
	}

	/**
	 * Реализует действие "Вернуть сумму на счете клиента"
	 * @return  Результат выполненной операции
	 */
	public SimpleStringProperty moneyProperty() {
		return money.sum;
	}
}
