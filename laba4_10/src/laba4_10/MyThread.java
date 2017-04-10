package laba4_10;

import java.util.ArrayList;

/**
 * Класс реализует работу с потоками
 * 
 * @author Галина
 *
 */
public class MyThread {
	/**
	 * Класс реализует работу с потоками
	 */
	private int summ = 0;
	private int numberDebaters, end;
	ArrayList<Debater> threadList = new ArrayList<Debater>();
	int random;
	String nameWinner;

	public MyThread() {
		// TODO Auto-generated constructor stub
	}

	public void SetMyThread(int number, int endArgue) {
		numberDebaters = number;
		end = endArgue;
	}

	/**
	 * Создает спорщиков
	 */
	public void CreateDebaters() {
		Debater thread;
		int i = 0, id;
		while (true) {
			if (i != numberDebaters) {
				id = i + 1;
				thread = new Debater("Debater № " + id, 1);
				threadList.add(thread);
				i++;
			} else {
				break;
			}
			if (i != numberDebaters) {
				id = i + 1;
				thread = new Debater("Debater № " + id, -1);
				threadList.add(thread);
				i++;
			} else {
				break;
			}
		}
		do {
			random = 0 + (int) (Math.random() * threadList.size());
			summ = threadList.get(random).Argue(summ);
			if (threadList.get(random).thread.getState() == Thread.State.TERMINATED) {
				System.out.println(threadList.get(random).thread.getName() + " terminated");
			}
		} while (Math.abs(summ) < end);
		System.out.println(summ + "|" + end);
		nameWinner = threadList.get(random).name;
	}

	/**
	 * Класс для создания потоков-спорщиков
	 * 
	 * @author Галина
	 *
	 */
	public class Debater implements Runnable {
		int way;
		String name;
		Thread thread;

		public Debater(String threadName, int wayArgue) {
			name = threadName;
			thread = new Thread(this, name);
			way = wayArgue;
			thread.start();
			// thread.run();
		}

		public int Argue(int sum) {
			if (this.way == 1) {
				sum++;
				// System.out.println("Sum" + sum);
			}
			if (this.way == (-1)) {
				sum--;
				// System.out.println("Sum" + sum);
			}
			return sum;
		}

		@Override
		public void run() {
			System.out.println(name + " is running\n");
		}
	}
}
