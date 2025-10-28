import java.util.*;

public class EncryptionView { 
    private Scanner s;

    public EncryptionView() {
        s = new Scanner(System.in);
    }

    public String getMessage() {
        System.out.print("Enter your message: ");
        return s.nextLine();
    }

    public int getKey() {
        System.out.print("Enter the key: ");
        int key = s.nextInt();
        s.nextLine();
        return key;
    }

    public void printResult(String result, String type) {
        System.out.println("The " + type + " message is: " + result);
    }

    public void printError() {
        System.out.println("The key should be an integer.");
    }
}
