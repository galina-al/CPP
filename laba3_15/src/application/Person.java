package application;

import flower.Flower;
import flower.Gladiolus;
import flower.Rose;
import flower.Violet;

/**
 * ����� "�������" ��������� �������� ��������.
 * 
 * @author ����
 *
 */
public class Person {
	/**
	 * ����� "�������" ��������� �������� ��������.
	 * 
	 * @param name
	 *            ��� ��������
	 *
	 */
	protected String name = "����";
	/**
	 * ��������� �������� "������ ������"
	 * @param flower ������
	 * 
	 */
	protected void Water(Flower flower) {
		if (flower.height.get() != "0.0") {
			flower.IncHeight();
			Main.win(1, "������ ������", "�� ����� ������!\n" + "�������!\n" + "������ ����� �� 2 ��.");
			if (flower.b == 0) {
				flower.IssueBud();
			}
			flower.IssueLeaf();
		} else
			Main.win(0, "������ ������", "���� ������ ��� �� ������.\n" + "����� ������ �����.");
	}

	/**
	 * ��������� �������� "�������� ������"
	 * @param flow ������
	 * 
	 */
	protected void Smell(Flower flow) {
		if (flow.height.get() != "0.0") {
			if (flow.b == 1)
				Main.win(1, "To smell a flower", "����, ����� ������!!!\n" + flow.bud.smell);
			else {
				Main.win(0, "To smell a flower", "���, � ��� �� ������ ��������-��?\n" + "������ ���-�� ���.");
			}
		} else
			Main.win(0, "������ ������", "���� ������ ��� �� ������.\n" + "����� ������ �����.");
	}

	/**
	 * ��������� �������� "�������� ������"
	 * @param i ������, ��������������� ��� ������(1-����, 2-������, 3-���������)
	 * 
	 */
	protected void PlantFlower(int i) {
		if (i == 1) {
			Rose rose = new Rose();
			Main.win(1, "�������� ����", "�� �������� ����!\n" + "����������!");
			Main.listFlower.add(rose);
		}
		if (i == 2) {
			Violet violet = new Violet();
			Main.win(1, "�������� ������", "�� �������� ������!\n" + "����������!");
			Main.listFlower.add(violet);
		}
		if (i == 3) {
			Gladiolus gladiolus = new Gladiolus();
			Main.win(1, "�������� ���������", "�� �������� ���������!\n" + "����������!");
			Main.listFlower.add(gladiolus);
		}
		Main.table.setItems(Main.listFlower);
	}

	/**
	 * ��������� �������� "��������� �� �������"
	 * @param flower ������
	 * 
	 */
	protected void ReturnFromHoliday(Flower flower) {
		flower.DryUp();
	}
}
