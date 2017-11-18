package ru.ark.Clinic;
import java.util.Scanner;

/**
 * Класс для запуска приложения
 */
public class ClinicRunner{

    /**
     * Поле для пользовательского ввода
     */
    private static Scanner scanner = new Scanner(System.in);
    /**
     * Поле для создания клиники и получения доступа к её методам
     */
    private static Clinic clinic;

    /**
     * Метод запуска программмы
     * @param args  параметры при запуске программы
     */
	public static void main(String [] args){
	    clinic = new Clinic(5);
		clinic.addClient(0, new Client("Dave", new Cat("Murka")));
		clinic.addClient(1, new Client("Sasha", new Dog("Cipher")));
		clinic.addClient(2, new Client("Tanya", new Cat("Din")));
		clinic.addClient(3, new Client("Dasha", new Cat("Barsick")));
		clinic.addClient(4, new Client("Kristina", new Parrot("Kesha")));
		Menu();
	}

    /**
     * Метод главного меню программы
     */
	private static void Menu(){
        boolean on = true;
		while (on){
            welcomeMenu();
            switch (Integer.valueOf(scanner.next())) {
                case 1:
                    System.out.println(clinic.showAllClients());
                break;
                case 2:
                    addClientMenu();
                    break;
                case 3:
                    removeClientMenu();
                    break;
                case 4:
                    findClientMenu();
                    break;
                case 5:
                    setPetMenu();
                    break;
                case 6:
                    exitMenu();
                    on = false;
                    break;
            }
        }
}

    /**
     * Метод добавляющий клиентов
     */
    private static void addClientMenu(){
        System.out.println("Enter client name");
        String clientName = scanner.next();
        System.out.println("Enter Pet's type: dog, cat or parrot");
        String pet = scanner.next();
        System.out.println("Pet's name is");
        String petName = scanner.next();
        if (pet.equalsIgnoreCase("cat")){
            clinic.addClient(clinic.getClients().length, new Client(clientName, new Cat(petName)));
        } else if (pet.equalsIgnoreCase("dog")) {
            clinic.addClient(clinic.getClients().length, new Client(clientName, new Dog(petName)));
        } else if (pet.equalsIgnoreCase("parrot")) {
            clinic.addClient(clinic.getClients().length, new Client(clientName, new Parrot(petName)));
        } else System.out.println("Клиент не был добавлен");
    }

    /**
     * метод удаляющий клиентов
     */
    private static  void removeClientMenu(){
        System.out.println("Enter client position to delete");
        try {
            clinic.removeClient(Integer.valueOf(scanner.next()));
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Поиск клиента
     */
    private static void findClientMenu() {
        System.out.println("Searching by:");
        System.out.println("1. Client name");
        System.out.println("2. Pet name:");
        System.out.println("Enter the number");
        int number = Integer.valueOf(scanner.next()) ;
        try {
            switch (number) {
                case 1:
                    System.out.println("Client name is...");
                    System.out.println(clinic.findClientByName(scanner.next()));
                    break;
                case 2:
                    System.out.println("Pet name is...");
                    System.out.println(clinic.findClientByPetName(scanner.next()));
                    break;
                default:
                    System.out.println("Wrong enter.");
                    break;
            }
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Приветсвенное меню и список возможных операцый
     */
    private static void welcomeMenu() {
        System.out.println("WELCOME IN MY CLINIC - PAWS AND TALES");
        System.out.println("*************************************");
        System.out.println("What do you want?");
        System.out.println("1. Show all clients");
        System.out.println("2. Add client");
        System.out.println("3. Remove client");
        System.out.println("4. Find client by name");
        System.out.println("5. Set pet");
        System.out.println("6. Exit");
        System.out.println("*************************************");
    }


    /**
     * Устанавлиет питомца для клиента
     */
    private static void setPetMenu() {
        System.out.println("Client position to set pet");
        int position = Integer.valueOf(scanner.next());
        System.out.println(" Type of pet.   (dog/cat/parrot)");
        String petType = scanner.next();
        System.out.println("Pet name");
        String petName = scanner.next();
        try {
            if (petType.equalsIgnoreCase("dog")) {
                clinic.setPet(position, new Dog(petName));
            } else if (petType.equalsIgnoreCase("cat")) {
                clinic.setPet(position, new Cat(petName));
            } else if (petType.equalsIgnoreCase("parrot")) {
                clinic.setPet(position, new Parrot(petName));
            } else {
                System.out.println("Такой тип питомца нельзя использовать.");
            }
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Меню для выхода из программы
     */
    private static void exitMenu() {
        scanner.close();
        System.out.println("Goodbye. We will glad to see you again.");
    }
}

