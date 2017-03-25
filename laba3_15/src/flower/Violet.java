package flower;

import bud_leaf.Bud;
import bud_leaf.Leaf;
/**
 * Класс "Фиалка" реализует действия фиалки.
 * @author Галя
 *
 */
public class Violet extends Flower {
	/**
	 * Конструктор
	 *
	 */
	public Violet() {
		this.name.set("Фиалка");
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
		this.bud = new Bud("Нежный");
		this.b++;
		this.cb.set("Фиолетовый");
		this.bud.petals.collor = this.cb.get();
		this.WinBud();
	}

}
