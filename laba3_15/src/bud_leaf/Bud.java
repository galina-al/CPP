package bud_leaf;

import application.Main;
/**
 * ����� "�����" ��������� �������� ������.
 * @author ����
 *
 */
public class Bud {
	public String smell;
	public Petals petals;
	public int k = 0;
	/**
	 * �����������
	 * @param smell ����� ������
	 *
	 */
	public Bud(String smell) {
		this.smell = smell;
		this.petals = new Petals();
		k++;
	}
	/**
	 * ��������� �������� "�������� ��������"
	 * 
	 */
	protected void DumpPetals() {
		Main.win(1, "��������� ������", "����� ������� ��������!");
		this.smell = " ";
		this.petals.collor = " ";
		k--;
	}
}
