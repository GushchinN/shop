public interface Store {
    void add(Computer computer);
    void remove(int number);
    void findByBrand(Brand brand);
    void printAll();
}
