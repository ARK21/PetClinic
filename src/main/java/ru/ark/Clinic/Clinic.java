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
    }

    /**
     * Ищет клиента по имени питомца
     *
     * @param name имя питомца
     * @return возвращает найденного клиента или Null
     */
    public Client findClientByPetName(String name) {
        Client findingClient = null;
        for (Client client : clients) {
            if (client.getPet().getName().equals(name)) {
                findingClient = client;
            }
        }
        return findingClient;
    }

    /**
     * Ищет клиента по его имени
     *
     * @param name имя клиента
     * @return возвращает найденноо клиента или Null
     */

    public Client findClientByName(String name) {
        Client findingClient = null;
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                findingClient = client;
            }
        }
        return findingClient;
    }

    /**
     * устанавливает имя клиента
     *
     * @param position   позиция в массиве, указывающая какому клиента нужно установить имя
     * @param clientName собственно само имя
     */
    public void setClientName(int position, String clientName) {
        this.clients[position].setName(clientName);
    }

    /**
     * Устанавлиет имя питомца
     *
     * @param position позиция клиента в массиве для которого нужно установить имя питомца
     * @param petName  имя питомца
     */
    public void setPetName(int position, String petName) {
        this.clients[position].getPet().setName(petName);
    }

    /**
     * Устанавливает питомца для клиента
     *
     * @param position позиция клиента в массиве для которого нужно установить питомца
     * @param pet      сам питомец
     */
    public void setPet(int position, Pet pet) {
        this.clients[position].setPet(pet);
    }

    /**
     * удаляет питомца. Пока работает некорректно. ВЫВОДИТ СТРОКУ ОТСТУТСВИЯ ПИТОМЦА
     * @param position позиция клиента в массиве
     */

    /**
     * удаляет клиента вместе с питомцем
     *
     * @param position позиция клиента в массиве
     */
    public void removeClient(int position) {
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
    }

    /**
     * показывает всех влиентов клиники
     */
    public String showAllClients() {
        String result = new String();
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


