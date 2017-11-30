package ru.ark.Clinic;

/**
 * Класс описывающий кота
 */
public class Cat implements Pet{

    /**
     * поле содержащее имя кота
     */
	private String name;


    /**
     * конструктор для создания экземпляра класса
     * @param name входной параметр при создании имя кота
     */
	public Cat(final String name){
		this.name = name;
	}

    /**
     * Позволяет получить доступ к приватному полу name
     * @return имя кота
     */
	public String getName(){
		return this.name;
	}

    /**
     * Позволяет установить имя кота в приватное поле
     * @param name собственно имя кота
     */
	public void setName(String name){
		this.name = name;
	}

    /**
     * Кот мяукает
     */
	public void makeSound() {
		System.out.println("Meoooew");
	}
}
