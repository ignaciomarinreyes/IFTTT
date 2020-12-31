public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.start();
        new PulsometerFrame(person);
        new MainFrame();
    }
}
