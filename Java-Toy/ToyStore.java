import java.util.*;

public class ToyStore {
    public void play(Toy[] toys) {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        
        int randomNumber = (int) (Math.random() * totalWeight);
        int finalWeight = 0;
        for (Toy toy : toys) {
            finalWeight += toy.getWeight();
            if (randomNumber < finalWeight) {
                System.out.println("Поздравляем! Вы выиграли " + toy.getName());
                toy.lessQuantity();
                return;
            }
        }
        
        System.out.println("К сожалению, никто не выиграл. Все игрушки разыграны.");
    }

    public void showToys(List<Toy> toys) {
        System.out.println("Наличие игрушек:");
        for (Toy toy : toys) {
            System.out.println(toy.getName() + " - " + toy.getQuantity() + " штук");
        }
    }

    public void addToy(List<Toy> toys) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id новой игрушки:");
        int id = scanner.nextInt();

        System.out.println("Введите название новой игрушки:");
        String name = scanner.next();

        System.out.println("Введите количество новой игрушки:");
        int quantity = scanner.nextInt();

        System.out.println("Введите частоту выпадения игрушки в %:");
        int weight = scanner.nextInt();

        toys.add(new Toy(id, name, quantity, weight));

        System.out.println("Новая игрушка добавлена!");
    }

    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        List<Toy> toys = new ArrayList<>();
        
        toys.add(new Toy(1, "Шрек", 12, 19));
        toys.add(new Toy(2, "Маша и Медведь", 22, 32));
        toys.add(new Toy(3, "Мяч футбольный", 13, 11));
        toys.add(new Toy(4, "Кукла Барби", 3, 6));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Розыгрыш игрушки");
            System.out.println("2 - Просмотр наличия игрушек");
            System.out.println("3 - Добавить игрушку");
            System.out.println("4 - Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.play(toys.toArray(new Toy[0]));
                    break;
                case 2:
                    store.showToys(toys);
                    break;
                case 3:
                    store.addToy(toys);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}