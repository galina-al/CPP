package flower;

import bud_leaf.Bud;
import bud_leaf.Leaf;
/**
 * ����� "����" ��������� �������� ����.
 * @author ����
 *
 */
public class Rose extends Flower {
	/**
	 * �����������
	 *
	 */
	public Rose() {
		this.name.set("����");
		this.height.set("2.0");
	}
	/**
	 * ��������� �������� "��������� ����"
	 * 
	 */
	public void IssueLeaf() {
		this.leaf = new Leaf(1.0);
		this.l++;
		this.cl.set(String.valueOf(l));
		this.WinLeaf();
	}
	/**
	 * ��������� �������� "��������� �����"
	 * 
	 */
	public void IssueBud() {
		this.bud = new Bud("C������");
		this.b++;
		this.cb.set("����");
		this.bud.petals.collor = this.cb.get();
		this.WinBud();
	}

}
