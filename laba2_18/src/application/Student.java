package application;
/**
 * Класс "Студент" хранит информацию о клиенте
 * @author Галя
 *
 */
public class Student extends Client {
	public Student(String name) {
		super(name);
		int sum = Main.rnd(10, 100);
		this.money = new Money(sum, this.name);
	}
}
