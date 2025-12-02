using System;
using System.Text;

public class Cipher
{
    private int _key;

    public int Key
    {
        get{ 
            return _key; 
            }
        set{
            _key = value;

            while (_key < 0)
                _key += 26;

            while (_key > 25)
                _key -= 26;
        }
    }

    // Encrypt method
    public string Encrypt(string message)
    {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.Length; i++)
        {
            char c = message[i];

            if (c >= 'a' && c <= 'z')
            {
                c = (char)(c + _key);
                if (c > 'z')
                    c = (char)(c - 26);
            }
            else if (c >= 'A' && c <= 'Z')
            {
                c = (char)(c + _key);
                if (c > 'Z')
                    c = (char)(c - 26);
            }

            encrypted.Append(c);
        }

        return encrypted.ToString();
    }

    // Decrypt method
    public string Decrypt(string encryptedMessage)
    {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedMessage.Length; i++)
        {
            char c = encryptedMessage[i];

            if (c >= 'a' && c <= 'z')
            {
                c = (char)(c - _key);
                if (c < 'a')
                    c = (char)(c + 26);
            }
            else if (c >= 'A' && c <= 'Z')
            {
                c = (char)(c - _key);
                if (c < 'A')
                    c = (char)(c + 26);
            }

            decrypted.Append(c);
        }

        return decrypted.ToString();
    }
}
