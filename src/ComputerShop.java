import java.util.ArrayList;

public class ComputerShop implements Store {
    private ArrayList<Computer> computers = new ArrayList<>();

    @Override
    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public void remove(int number) {
        if (number < 1 || number > computers.size()) {
            System.out.println("Нет компьютера с таким номером");
            return;
        }
        computers.remove(number - 1);
        System.out.println("Компьютер удалён");
    }

    @Override
    public void findByBrand(Brand brand) {
        boolean found = false;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getBrand() == brand) {
                System.out.println((i + 1) + ". " + computers.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Компьютеров марки " + brand + " нет");
        }
    }

    @Override
    public void printAll() {
        if (computers.size() == 0) {
            System.out.println("Компьютеров нет");
            return;
        }
        for (int i = 0; i < computers.size(); i++) {
            System.out.println((i + 1) + ". " + computers.get(i));
        }
    }

    public Computer get(int number) {
        return computers.get(number - 1);
    }
}
