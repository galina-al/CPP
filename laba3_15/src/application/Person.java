package application;

import flower.Flower;
import flower.Gladiolus;
import flower.Rose;
import flower.Violet;

/**
 * Класс "Человек" реализует действия человека.
 * 
 * @author Галя
 *
 */
public class Person {
	/**
	 * Класс "Человек" реализует действия человека.
	 * 
	 * @param name
	 *            имя человека
	 *
	 */
	protected String name = "Галя";
	/**
	 * Реализует действие "Полить цветок"
	 * @param flower цветок
	 * 
	 */
	protected void Water(Flower flower) {
		if (flower.height.get() != "0.0") {
			flower.IncHeight();
			Main.win(1, "Полить цветок", "Ты полил цветок!\n" + "Красава!\n" + "Цветок вырос на 2 см.");
			if (flower.b == 0) {
				flower.IssueBud();
			}
			flower.IssueLeaf();
		} else
			Main.win(0, "Полить цветок", "Этот цветок уже не спасти.\n" + "Лучше посади новый.");
	}

	/**
	 * Реализует действие "Понюхать цветок"
	 * @param flow цветок
	 * 
	 */
	protected void Smell(Flower flow) {
		if (flow.height.get() != "0.0") {
			if (flow.b == 1)
				Main.win(1, "To smell a flower", "Мммм, какой аромат!!!\n" + flow.bud.smell);
			else {
				Main.win(0, "To smell a flower", "Эмм, а что ты нюхать собрался-то?\n" + "Бутона так-то нет.");
			}
		} else
			Main.win(0, "Полить цветок", "Этот цветок уже не спасти.\n" + "Лучше посади новый.");
	}

	/**
	 * Реализует действие "Посадить цветок"
	 * @param i индекс, характеризующий вид цветка(1-роза, 2-фиалка, 3-гладиолус)
	 * 
	 */
	protected void PlantFlower(int i) {
		if (i == 1) {
			Rose rose = new Rose();
			Main.win(1, "Посадить розу", "Вы посадили розу!\n" + "Поздравляю!");
			Main.listFlower.add(rose);
		}
		if (i == 2) {
			Violet violet = new Violet();
			Main.win(1, "Посадить фиалку", "Вы посадили фиалку!\n" + "Поздравляю!");
			Main.listFlower.add(violet);
		}
		if (i == 3) {
			Gladiolus gladiolus = new Gladiolus();
			Main.win(1, "Посадить гладиолус", "Вы посадили гладиолус!\n" + "Поздравляю!");
			Main.listFlower.add(gladiolus);
		}
		Main.table.setItems(Main.listFlower);
	}

	/**
	 * Реализует действие "Вернуться из отпуска"
	 * @param flower цветок
	 * 
	 */
	protected void ReturnFromHoliday(Flower flower) {
		flower.DryUp();
	}
}
