package models;

/**
Класс описывающий собаку
*/
public class Dog extends Pet {


	/**
	 * Конструктор
	 *
	 * @param name имя собаки
	 */
	public Dog(final String name) {
		super(name,"Dog");
	}

	/**
	 * Возвращает имя собаки
	 *
	 * @return имя собаки
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * устанавлиевт имя собки
	 *
	 * @param name имя собаки
	 */
	public void setName(String name) {
		super.setName(name);
	}
}