package ru.ark.Clinic;

/**
 * Истерфейс объединяет всех питомцев
 */
public interface Pet{

	/**
	Издать звук
	*/
	void makeSound();

	/**
	 * Возвращает имя питомца
	 * @return имя питомца
	 */
	String getName();

	void setName(String name);
}