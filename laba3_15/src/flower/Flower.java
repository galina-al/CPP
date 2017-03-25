package flower;

import application.Main;
import bud_leaf.Bud;
import bud_leaf.Leaf;
import javafx.beans.property.SimpleStringProperty;

/**
 * ����� "������" ��������� �������� ������.
 * @author ����
 *
 */
abstract public class Flower {
	/**
	 * ����� "������" ��������� �������� �������.
	 * @param name �������� ������
	 * @param height ������ ������
	 * @param leaf ������ 
	 * @param bud �����
	 * @param cl ���������� ������
	 * @param cb ���� ������
	 *
	 */
	protected SimpleStringProperty name = new SimpleStringProperty();
	public SimpleStringProperty height = new SimpleStringProperty();
	protected Leaf leaf;
	public Bud bud;
	protected SimpleStringProperty cl = new SimpleStringProperty();
	protected SimpleStringProperty cb = new SimpleStringProperty();
	public int b = 0;
	public int l = 0;
	
	/**
	 * ��������� �������� "��������� ������"
	 * 
	 */
	public void IncHeight() {
		double h = Double.parseDouble(this.height.get());
		h += 2.0;
		this.height.set(String.valueOf(h));
	}
	
	/**
	 * ��������� �������� "��������� ����"
	 * 
	 */
	public void IssueLeaf() {
	}

	/**
	 * ��������� �������� "��������� �����"
	 * 
	 */
	public void IssueBud() {
	}

	/**
	 * ��������� �������� "���������"
	 * 
	 */
	public void DryUp() {
		if (this.bud != null) {
			this.bud = null;
			this.leaf = null;
			b = 0;
			this.cb.set(String.valueOf(b));
			l = 0;
			this.cl.set(String.valueOf(l));
			this.height.set("0.0");
			Main.win(1, "The return from a holiday",
					"��� ������ ����� �� ����!\n" + "���, ������ ������ �������� � � ����� �����! ;(");
		} else
			Main.win(1, "The return from a holiday",
					"��� ������ ����� �� ����!\n" + "���, ������ ���� ������ �� ����� �������! ;(");

	}
	/**
	 * ����, ���������� � �������� �����
	 * 
	 */
	protected void WinLeaf() {
		Main.win(1, "To issue the leaf", "���� ������!!!");
	}

	/**
	 * ����, ���������� � �������� ������
	 * 
	 */
	protected void WinBud() {
		Main.win(1, "To issue the bud", "����� ������!!!");
	}

	public String getName() {
		return name.get();
	}

	public String getHeight() {
		return height.get();
	}

	public String getLeaf() {
		if (l != 0)
			return this.cl.get();
		else
			return "���";
	}

	public String getBud() {
		if (b != 0) {
			this.cb.set(this.bud.petals.collor);
			return this.cb.get();
		} else
			return "���";
	}

	public SimpleStringProperty heightProperty() {
		return height;
	}

	public SimpleStringProperty leafProperty() {
		if (l != 0)
			return this.cl;
		else {
			this.cl.set("���");
			return this.cl;
		}
	}

	public SimpleStringProperty budProperty() {
		if (b != 0) {
			this.cb.set(this.bud.petals.collor);
		} else {
			this.cb.set("���");
		}
		return this.cb;
	}

}
