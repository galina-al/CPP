package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * ����� "������" ������ ���������� � ������ ��������
 * @author ����
 *
 */
public class Money {
	public SimpleStringProperty sum = new SimpleStringProperty();
	protected String owner_name;
	/**
	 * ����� "������" ������ ���������� � ������ ��������
	 * @param sum ����� �� �����
	 * @param owner_name ��� ���������
	 *
	 */
	public Money(int sum, String owner_name) {
		this.sum.set(String.valueOf(sum));
		this.owner_name = owner_name;
	}

}
