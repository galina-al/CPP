package bud_leaf;
/**
 * Класс "Лист" реализует действия листа.
 * @author Галя
 *
 */
public class Leaf {
	protected double length;
	public int k = 0;
	/**
	 * Конструктор
	 * @param l длина листа
	 *
	 */
	public Leaf(double l) {
		this.length = l;
		k++;
	}
}
