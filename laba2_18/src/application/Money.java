package application;
/**
 * ����� "������" ������ ���������� � ������ ��������
 * @author ����
 *
 */
public class Money {
	public int sum;
	protected String owner_name;
	/**
	 * ����� "������" ������ ���������� � ������ ��������
	 * @param sum ����� �� �����
	 * @param owner_name ��� ���������
	 *
	 */
	public Money(int sum, String owner_name) {
		this.sum = sum;
		this.owner_name = owner_name;
	}

}
