package flower;

import bud_leaf.Bud;
import bud_leaf.Leaf;
/**
 * Класс "Роза" реализует действия розы.
 * @author Галя
 *
 */
public class Rose extends Flower {
	/**
	 * Конструктор
	 *
	 */
	public Rose() {
		this.name.set("Роза");
		this.height.set("2.0");
	}
	/**
	 * Реализует действие "Выпустить лист"
	 * 
	 */
	public void IssueLeaf() {
		this.leaf = new Leaf(1.0);
		this.l++;
		this.cl.set(String.valueOf(l));
		this.WinLeaf();
	}
	/**
	 * Реализует действие "Выпустить бутон"
	 * 
	 */
	public void IssueBud() {
		this.bud = new Bud("Cладкий");
		this.b++;
		this.cb.set("Алый");
		this.bud.petals.collor = this.cb.get();
		this.WinBud();
	}

}
