package application;
/**
 * ����� "������ ������" ������ ���������� � �������
 * @author ����
 *
 */
public class PoorClient extends Client {
	public PoorClient(String name) {
		super(name);
		int sum = Main.rnd(100, 300);
		this.money = new Money(sum, this.name);
	}

}
