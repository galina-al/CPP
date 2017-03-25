package flower;

import bud_leaf.Bud;
import bud_leaf.Leaf;
/**
 * Класс "Гладиолус" реализует действия гладиолуса.
 * @author Галя
 *
 */
public class Gladiolus extends Flower {
	/**
	 * Конструктор
	 *
	 */
	public Gladiolus() {
		this.name.set("Гладиолус");
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
		this.bud = new Bud("Очень слабый нежный аромат");
		this.b++;
		this.cb.set("Желтый");
		this.bud.petals.collor = this.cb.get();
		this.WinBud();
	}

}
