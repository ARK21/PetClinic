package models;


import javax.persistence.Embeddable;

/**
 * Истерфейс объединяет всех питомцев
 */

public class Pet{

	private String name ;

	private String type ;

	public Pet(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Pet() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
}