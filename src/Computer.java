public class Computer extends Product {
    private Brand brand;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(Brand brand, double price, Processor processor, Memory memory, Monitor monitor) {
        super("Компьютер " + brand, price, Category.ELECTRONICS);
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    public Brand getBrand() {return brand;}
    public Processor getProcessor() {return processor;}
    public Memory getMemory() {return memory;}
    public Monitor getMonitor() {return monitor;}

    @Override
    public String toString() {
        return super.toString() + "\n     процессор: " + processor + ", память: " + memory + ", монитор: " + monitor;
    }
}
