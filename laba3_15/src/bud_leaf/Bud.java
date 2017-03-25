package bud_leaf;

import application.Main;
/**
 * Класс "Бутон" реализует действия бутона.
 * @author Галя
 *
 */
public class Bud {
	public String smell;
	public Petals petals;
	public int k = 0;
	/**
	 * Конструктор
	 * @param smell запах бутона
	 *
	 */
	public Bud(String smell) {
		this.smell = smell;
		this.petals = new Petals();
		k++;
	}
	/**
	 * Реализует действие "Сбросить лепестки"
	 * 
	 */
	protected void DumpPetals() {
		Main.win(1, "Состаяние бутона", "Бутон сбросил лепестки!");
		this.smell = " ";
		this.petals.collor = " ";
		k--;
	}
}
