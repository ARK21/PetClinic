package ru.ark.Clinic;

/**
 * Класс описывающий клинику
 */
public class Clinic {

    /**
     * Поле в котором хранятся все клиенты клиники
     */
    private Client[] clients;

    /**
     * Конструктор создающий клинику
     *
     * @param size входной параметр использующиймя для создания массива клиентов размером size
     */
    public Clinic(int size) {
        this.clients = new Client[size];
    }

    /**
     * Добавляет клиентов в массив
     *
     * @param position Позиция в массиве для добавления
     * @param client   ссылка на добавлемого клиента
     */
    public void addClient(int position, Client client) {
        if (position == clients.length) {
            Client[] newArrayClient = new Client[position + 1];
            System.arraycopy(clients, 0, newArrayClient, 0, clients.length);
            clients = newArrayClient;
        }
        clients[position] = client;
        System.out.println("Клиент " + client.getName() + " добавлен.");
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
        if (!(position > clients.length - 1 || position < 0)) {
            this.clients[position].setName(clientName);
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
        if (!(position > clients.length - 1 || position < 0)) {
            this.clients[position].getPet().setName(petName);
        } else throw new UserException("Такого клиента нет в нашей клинике");
    }

    /**
     * Устанавливает питомца для клиента
     *
     * @param position позиция клиента в массиве для которого нужно установить питомца
     * @param pet сам питомец
     * @throws UserException Выбрасывает исключение, если указана несуществующая позиция массива.
     */
    public void setPet(int position, Pet pet) throws UserException {
        if (!(position > clients.length - 1 || position < 0)) {
            this.clients[position].setPet(pet);
            System.out.println("Питомец успешно добавлен");
        } else {
            throw new UserException("Такого клиента нет в нашей клинике.");
        }
    }

    /**
     * удаляет клиента вместе с питомцем
     *
     * @param position позиция клиента в массиве
     * @throws UserException Выбрасывает исключение, если указана несуществующая позиция массива.
     */
    public void removeClient(int position) throws UserException {
        if (!(position > clients.length - 1 || position < 0)) {
            Client[] newArrayClients = new Client[clients.length - 1];
            if (position == 0) {
                System.arraycopy(clients, 1, newArrayClients, 0, clients.length - 1);
            } else if (position == clients.length - 1) {
                System.arraycopy(clients, 0, newArrayClients, 0, clients.length - 1);
            } else {
                System.arraycopy(clients, 0, newArrayClients, 0, position);
                System.arraycopy(clients, position + 1, newArrayClients, position, clients.length - position - 1);
            }
            System.out.println("Клиент  - " + clients[position].getName() + " was delete");
            clients = newArrayClients;
        } else {
            throw new UserException("Такого клиента нет в нашей клинике.");
        }


    }

    /**
     * показывает всех влиентов клиники
     */
    public String showAllClients() {
        String result = "";
        for (int a = 0; a < clients.length; a++) {
            result += (a) + ". " + clients[a].toString() + "\n";
        }
        return result;
    }

    /**
     * Предоставляет доступ к массиву клиентов
     *
     * @return возвращает сам массив
     */
    public Client[] getClients() {
        return clients;
    }
}


