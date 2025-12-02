// See https://aka.ms/new-console-template for more information
using System;

public class Lab23
{
    public static void Main(string[] args)
    {
        EncryptionView view = new EncryptionView();

        int key = 0;
        bool validKey = false;
        int attempts = 0;

        while (!validKey && attempts < 3)
        {
            try
            {
                key = view.GetKey();
                validKey = true;
            }
            catch (Exception)
            {
                view.PrintError();
                attempts++;

                view = new EncryptionView();
            }
        }

        if (!validKey)
        {
            Console.WriteLine("Too many invalid attempts. Exiting program.");
            return;
        }

        Cipher cipher = new Cipher();
        cipher.Key = key;

        string message = view.GetMessage();

        string encrypted = cipher.Encrypt(message);
        view.PrintResult(encrypted, "encrypted");
        Console.WriteLine();

        string decrypted = cipher.Decrypt(encrypted);
        view.PrintResult(decrypted, "decrypted");
        Console.WriteLine();
    }
}
