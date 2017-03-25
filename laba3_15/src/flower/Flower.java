package flower;

import application.Main;
import bud_leaf.Bud;
import bud_leaf.Leaf;
import javafx.beans.property.SimpleStringProperty;

/**
 * Класс "Цветок" реализует действия цветка.
 * @author Галя
 *
 */
abstract public class Flower {
	/**
	 * Класс "Клиент" реализует действия клиента.
	 * @param name название цветка
	 * @param height высота цветка
	 * @param leaf листок 
	 * @param bud бутон
	 * @param cl количество листов
	 * @param cb цвет бутона
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
	 * Реализует действие "Увеличить высоту"
	 * 
	 */
	public void IncHeight() {
		double h = Double.parseDouble(this.height.get());
		h += 2.0;
		this.height.set(String.valueOf(h));
	}
	
	/**
	 * Реализует действие "Выпустить лист"
	 * 
	 */
	public void IssueLeaf() {
	}

	/**
	 * Реализует действие "Выпустить бутон"
	 * 
	 */
	public void IssueBud() {
	}

	/**
	 * Реализует действие "Засохнуть"
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
					"Вас сишком долго не было!\n" + "Увы, цветок скинул лепестки и в итоге засох! ;(");
		} else
			Main.win(1, "The return from a holiday",
					"Вас сишком долго не было!\n" + "Увы, цветок даже толком не успел вырасти! ;(");

	}
	/**
	 * Окно, сообщающее о создании листа
	 * 
	 */
	protected void WinLeaf() {
		Main.win(1, "To issue the leaf", "Лист создан!!!");
	}

	/**
	 * Окно, сообщающее о создании бутона
	 * 
	 */
	protected void WinBud() {
		Main.win(1, "To issue the bud", "Бутон создан!!!");
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
			return "нет";
	}

	public String getBud() {
		if (b != 0) {
			this.cb.set(this.bud.petals.collor);
			return this.cb.get();
		} else
			return "нет";
	}

	public SimpleStringProperty heightProperty() {
		return height;
	}

	public SimpleStringProperty leafProperty() {
		if (l != 0)
			return this.cl;
		else {
			this.cl.set("нет");
			return this.cl;
		}
	}

	public SimpleStringProperty budProperty() {
		if (b != 0) {
			this.cb.set(this.bud.petals.collor);
		} else {
			this.cb.set("нет");
		}
		return this.cb;
	}

}
