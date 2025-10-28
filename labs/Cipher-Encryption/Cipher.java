public class Cipher {
    // field
    private int key;

    // constructor
    public Cipher(int key) {
        this.key = key;
    }

    // encrypt method
    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c += key;
                if (c > 'z') {
                    c -= 26;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c += key;
                if (c > 'Z') {
                    c -= 26;
                }
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    // decrypt method
    public String decrypt(String encryptedMessage) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char c = encryptedMessage.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c -= key;
                if (c < 'a') {
                    c += 26;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c -= key;
                if (c < 'A') {
                    c += 26;
                }
            }
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}