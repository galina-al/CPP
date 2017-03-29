package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * Класс "Деньги" хранит информацию о счетах клиентов
 * @author Галя
 *
 */
public class Money {
	public SimpleStringProperty sum = new SimpleStringProperty();
	protected String owner_name;
	/**
	 * Класс "Деньги" хранит информацию о счетах клиентов
	 * @param sum сумма на счете
	 * @param owner_name имя владельца
	 *
	 */
	public Money(int sum, String owner_name) {
		this.sum.set(String.valueOf(sum));
		this.owner_name = owner_name;
	}

}
