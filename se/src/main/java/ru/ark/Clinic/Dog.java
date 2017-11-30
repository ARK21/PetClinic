package ru.ark.Clinic;
/**
Класс описывающий собаку
*/
public class Dog implements Pet{
	/**
	 * Поле содержит имя собаки
	 */
	private  String name;

	/**
	 * Конструктор
	 * @param name имя собаки
	 */
	public Dog(final String name){
		this.name = name;
	}

	/**
	 * Возвращает имя собаки
	 * @return имя собаки
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * устанавлиевт имя собки
	 * @param name имя собаки
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Собаки лает
	 */
	public void makeSound() {
		System.out.println("Wav, wav");
	}
}
