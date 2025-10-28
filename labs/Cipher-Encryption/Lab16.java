public class Lab16 {
    public static void main(String[] args) {
        EncryptionView view = new EncryptionView();

        int key = 0;
        boolean validKey = false;
        int attempts = 0;

        while (!validKey && attempts < 3) {
            try {
                key = view.getKey();
                validKey = true;
            } catch (Exception e) {
                view.printError();
                attempts++;

                view = new EncryptionView();
            }
        }

        if (!validKey) {
            System.out.println("Too many invalid attempts. Exiting program.");
            return;
        }

        Cipher cipher = new Cipher(key);

        String message = view.getMessage();

        String encrypted = cipher.encrypt(message);
        view.printResult(encrypted, "encrypted");

        String decrypted = cipher.decrypt(encrypted);
        view.printResult(decrypted, "decrypted");
    }
}
