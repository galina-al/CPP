package application;
/**
 * Класс "Богатый клиент" хранит информацию о клинте 
 * @author Галя
 *
 */
public class RichClient extends Client {
	public RichClient(String name) {
		super(name);
		int sum = Main.rnd(500, 1000);
		this.money = new Money(sum, this.name);
	}
}
