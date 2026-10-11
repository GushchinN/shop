import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
                new Product("Наушники", 5000, Category.ELECTRONICS),
                new Product("Мышь", 1500, Category.ELECTRONICS),
                new Product("Клавиатура", 3200, Category.ELECTRONICS),
                new Product("Монитор", 18000, Category.ELECTRONICS),
                new Product("Футболка", 1200, Category.CLOTHES),
                new Product("Джинсы", 3500, Category.CLOTHES),
                new Product("Война и мир", 800, Category.BOOKS),
                new Product("Мастер и Маргарита", 650, Category.BOOKS)
        };
        ArrayList<Product> cart = new ArrayList<>();

        ComputerShop computerShop = new ComputerShop();
        computerShop.add(new Computer(Brand.LENOVO, 65000, new Processor("Intel Core i5", 6), new Memory(16), new Monitor(15.6)));
        computerShop.add(new Computer(Brand.APPLE, 120000, new Processor("Apple M2", 8), new Memory(8), new Monitor(13.3)));

        // Вход в магазин
        String login = "user";
        String password = "1234";
        boolean ok = false;
        while (!ok) {
            System.out.print("Логин: ");
            String l = sc.nextLine();
            System.out.print("Пароль: ");
            String p = sc.nextLine();
            if (l.equals(login) && p.equals(password)) {
                ok = true;
                System.out.println("Вы вошли в магазин");
            } else {
                System.out.println("Неверный логин или пароль");
            }
        }

        boolean work = true;
        while (work) {
            System.out.println("\n1. Список каталогов");
            System.out.println("2. Товары каталога");
            System.out.println("3. Корзина и покупка");
            System.out.println("4. Компьютеры");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Category[] categories = Category.values();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + ". " + categories[i].getTitle());
                    }
                    break;
                case 2:
                    System.out.print("Номер каталога: ");
                    int num = sc.nextInt();
                    Category category = Category.values()[num - 1];

                    ArrayList<Product> list = new ArrayList<>();
                    for (int i = 0; i < products.length; i++) {
                        if (products[i].getCategory() == category) {
                            list.add(products[i]);
                        }
                    }
                    System.out.println("Каталог: " + category.getTitle());
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }

                    System.out.print("Номер товара в корзину (0 - назад): ");
                    int p = sc.nextInt();
                    if (p > 0) {
                        System.out.print("Количество: ");
                        int count = sc.nextInt();
                        for (int i = 0; i < count; i++) {
                            cart.add(list.get(p - 1));
                        }
                        System.out.println("Добавлено в корзину: " + list.get(p - 1).getName() + " x" + count);
                    }
                    break;
                case 3:
                    if (cart.size() == 0) {
                        System.out.println("Корзина пуста");
                        break;
                    }
                    double total = 0;
                    System.out.println("Корзина:");
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println((i + 1) + ". " + cart.get(i));
                        total += cart.get(i).getPrice();
                    }
                    System.out.println(String.format("Сумма: %.2f руб.", total));

                    System.out.print("Выберите валюту (1 - RUB, 2 - USD, 3 - EUR, 0 - отмена): ");
                    int cur = sc.nextInt();
                    if (cur == 0) {
                        break;
                    }
                    String currency = "RUB";
                    if (cur == 2) {
                        total = total / 80;
                        currency = "USD";
                    }
                    if (cur == 3) {
                        total = total / 95;
                        currency = "EUR";
                    }
                    System.out.println(String.format("Итого к оплате: %.2f %s", total, currency));
                    System.out.println("Покупка оформлена, спасибо!");
                    cart.clear();
                    break;
                case 4:
                    System.out.println("1. Все компьютеры");
                    System.out.println("2. Добавить компьютер");
                    System.out.println("3. Удалить компьютер");
                    System.out.println("4. Найти по марке");
                    System.out.println("5. Положить в корзину");
                    System.out.print("Выбор: ");
                    int c = sc.nextInt();

                    if (c == 1) {
                        computerShop.printAll();
                    } else if (c == 2) {
                        Brand brand = chooseBrand(sc);
                        System.out.print("Цена: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Процессор: ");
                        String model = sc.nextLine();
                        System.out.print("Количество ядер: ");
                        int cores = sc.nextInt();
                        System.out.print("Память (ГБ): ");
                        int size = sc.nextInt();
                        System.out.print("Диагональ монитора (например 15,6): ");
                        double diagonal = sc.nextDouble();
                        computerShop.add(new Computer(brand, price, new Processor(model, cores), new Memory(size), new Monitor(diagonal)));
                        System.out.println("Компьютер добавлен");
                    } else if (c == 3) {
                        computerShop.printAll();
                        System.out.print("Номер компьютера для удаления: ");
                        computerShop.remove(sc.nextInt());
                    } else if (c == 4) {
                        computerShop.findByBrand(chooseBrand(sc));
                    } else if (c == 5) {
                        computerShop.printAll();
                        System.out.print("Номер компьютера: ");
                        Computer computer = computerShop.get(sc.nextInt());
                        cart.add(computer);
                        System.out.println("Добавлено в корзину: " + computer.getName());
                    }
                    break;
                case 0:
                    work = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    static Brand chooseBrand(Scanner sc) {
        Brand[] brands = Brand.values();
        for (int i = 0; i < brands.length; i++) {
            System.out.println((i + 1) + ". " + brands[i]);
        }
        System.out.print("Марка: ");
        return brands[sc.nextInt() - 1];
    }
}
