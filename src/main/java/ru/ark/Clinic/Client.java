package ru.ark.Clinic;

/**
 * Класс описывает клиента клинники
 */
public class Client {

    /**
     * Приватное поле для хранения имени клиента
     */
    private String name;

    /**
     * Поле для хранения питомца который имеется у клиента
     */
    private Pet pet;

    /**
     * Конструктор класса
     *
     * @param name имя клиента
     * @param pet  питомец клиента
     */
    public Client(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    /**
     * Устанавлиевает питомца для клиента
     *
     * @param pet питомец
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Позволяет получить питомца клиента
     *
     * @return возвращает ссылку на питомца
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Позволяет установить имя клиента
     *
     * @param name имя клиента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает имя клиента
     *
     * @return имя клиента
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Клиент - " + name + ", Питомец - " + pet.getClass().getSimpleName() + " " + pet.getName();
    }
}
