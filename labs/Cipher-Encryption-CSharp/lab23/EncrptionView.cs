using System;

public class EncryptionView
{
    public string GetMessage()
    {
        Console.Write("Enter your message: ");
        return Console.ReadLine();
    }

    public int GetKey()
    {
        Console.Write("Enter the key: ");

        if (int.TryParse(Console.ReadLine(), out int key))
        {
            return key;
        }
        else
        {
            PrintError();
            return 0;
        }
    }

    public void PrintResult(string result, string type)
    {
        Console.WriteLine($"The {type} message is: {result}");
    }

    public void PrintError()
    {
        Console.WriteLine("The key should be an integer.");
    }
}
