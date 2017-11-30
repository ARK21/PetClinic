package ru.ark.Clinic;

import java.util.ArrayList;

/**
 * Класс описывающий клинику
 */
public class Clinic {

    /**
     * Поле в котором хранятся все клиенты клиники
     */
    private ArrayList<Client> clients;

    /**
     * Конструктор создающий клинику
     */
    public Clinic() {
        this.clients = new ArrayList<Client>();
    }

    /**
     * Добавляет нового клиента
     *
     * @param client сам клиент
     */
    public void addNewClient(Client client) {
        clients.add(client);
        System.out.println("Клиент " + client.getName() + " добавлен");
    }

    /**
     * Ищет клиента по имени питомца
     *
     * @param name имя питомца
     * @return возвращает найденного клиента
     * @throws UserException выбрасывает исключение если клиент не найдет
     */
    public Client findClientByPetName(String name) throws UserException {
        Client findingClient = null;
        for (Client client : clients) {
            if (client.getPet().getName().equals(name)) {
                findingClient = client;
            }
        }
        if (findingClient == null) {
            throw new UserException("Такого клиента нет в нашей клининке");
        }
        return findingClient;
    }

    /**
     * Ищет клиента по его имени
     *
     * @param name имя клиента
     * @return возвращает найденноо клиента
     * @throws UserException выбрасывает исключение если клиент не найдет
     */
    public Client findClientByName(String name) throws UserException {
        Client findingClient = null;
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                findingClient = client;
            }
        }
        if (findingClient == null) {
            throw new UserException("Такого клиента нет в нашей клинике");
        }
        return findingClient;
    }

    /**
     * устанавливает имя клиента
     *
     * @param position   позиция в массиве, указывающая какому клиента нужно установить имя
     * @param clientName собственно само имя
     * @throws UserException Выбрасывает исключение, если указана несуществующая позиция массива.
     */
    public void setClientName(int position, String clientName) throws UserException {
        if (!(position > clients.size() - 1 || position < 0)) {
            this.clients.get(position).setName(clientName);
        } else {
            throw new UserException("Такой позиции нет в нашей клинике");
        }
    }

    /**
     * Устанавлиет имя питомца
     *
     * @param position позиция клиента в массиве для которого нужно установить имя питомца
     * @param petName  имя питомца
     * @throws UserException Выбрасывает исключение, если указана несуществующая позиция массива.
     */
    public void setPetName(int position, String petName) throws UserException {
        if (!(position > clients.size() - 1 || position < 0)) {
            this.clients.get(position).getPet().setName(petName);
        } else throw new UserException("Такого клиента нет в нашей клинике");
    }

    /**
     * Устанавливает питомца для клиента
     *
     * @param position позиция клиента в массиве для которого нужно установить питомца
     * @param pet      сам питомец
     * @throws UserException Выбрасывает исключение, если указана несуществующая позиция массива.
     */
    public void setPet(int position, Pet pet) throws UserException {
        if (!(position > clients.size() - 1 || position < 0)) {
            this.clients.get(position).setPet(pet);
            System.out.println("Питомец успешно добавлен");
        } else {
            throw new UserException("Такого клиента нет в нашей клинике.");
        }
    }

    /**
     * Удаляет клиента из списков клинники
     *
     * @param index индекс клиента которого нужно удалить
     * @throws UserException выбрасывается если некоректный индекс
     */
    public void removeClient(int index) throws UserException {
        if (index < 0 || clients.size() < index) {
            throw new UserException("Неподходящий индекс");
        } else {
            Client client = clients.get(index);
            clients.remove(index);
            System.out.println("Клиент " + client.getName() + " был удален");
            client = null;
        }
    }

    /**
     * показывает всех влиентов клиники
     */
    public String showAllClients() {
        String result = "";
        for (int a = 0; a < clients.size(); a++) {
            result += (a) + ". " + clients.get(a).toString() + "\n";
        }
        return result;
    }

    /**
     * Предоставляет доступ к массиву клиентов
     *
     * @return возвращает лист
     */
    public ArrayList<Client> getClients() {
        return clients;
    }
}


