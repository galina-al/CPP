package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * ����� "������" ��������� �������� �������.
 * @author ����
 *
 */
public class Client {
	protected String name;
	public Money money;
	protected int password;
	/**
	 * ����� "������" ��������� �������� �������.
	 * @param name ��� �������
	 *
	 */
	public Client(String name) {
		this.name = name;
	}
	/**
	 * ��������� �������� "����� ������"
	 * @param ind ������ �������� � �������
	 * @param bank ��������
	 */
	public void Withdrow(ATM bank, int ind) {
		bank.RequestPassword(Main.listClient.get(ind));
	}
	/**
	 * ��������� �������� "������� ��� �������"
	 * @return  ��������� ����������� ��������
	 */
	public String getName() {
		return name;
	}
	/**
	 * ��������� �������� "������� ������ �������"
	 * @return  ��������� ����������� ��������
	 */
	public String getPassword() {
		return String.valueOf(password);
	}
	/**
	 * ��������� �������� "������� ����� �� ����� �������"
	 * @return  ��������� ����������� ��������
	 */
	public String getMoney() {
		return money.sum.get();
	}

	/**
	 * ��������� �������� "������� ����� �� ����� �������"
	 * @return  ��������� ����������� ��������
	 */
	public SimpleStringProperty moneyProperty() {
		return money.sum;
	}
}
