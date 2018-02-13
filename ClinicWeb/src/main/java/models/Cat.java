package models;

import models.*;

/**
 * Класс описывающий кота
 */
public class Cat extends Pet{



    /**
     * конструктор для создания экземпляра класса
     * @param name входной параметр при создании имя кота
     */
	public Cat(final String name){
		super(name,"Cat");
	}

    /**
     * Позволяет получить доступ к приватному полу name
     * @return имя кота
     */
	public String getName(){
		return super.getName();
	}

    /**
     * Позволяет установить имя кота в приватное поле
     * @param name собственно имя кота
     */
	public void setName(String name){
		super.setName(name);
	}

}
