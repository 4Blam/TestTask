package test.solve;

public class MainApp {
    public static void main(String[] args) {
        MailCreator mailCreator = new MailCreator("Анна Ивановна");
        System.out.println(mailCreator.createMessage());
    }
}
