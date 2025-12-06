using System;

public class Proj11
{
    public static void Main(string[] args)
    {
        if (args.Length != 1 || !(args[0] == "--standard" || args[0] == "--random"))
        {
            Console.WriteLine("Error, Please use: dotnet run --standard OR --random");
            return;
        }

        bool standard = args[0] == "--standard";
        GroceryOrder order = new GroceryOrder(standard);

        Console.WriteLine("GROCERY ORDER");
        foreach (IGroceryItem g in order.AllItems)
            Console.WriteLine(g);

        Console.WriteLine($"\nTotal before discounts: ${order.TotalFullPrice:F2}");
        Console.WriteLine($"Total after discounts: ${order.TotalDiscountPrice:F2}");
        Console.WriteLine($"Total savings: ${order.Savings:F2}\n");

        Console.WriteLine("COUNTABLE ITEMS");
        foreach (ICountableItem c in order.CountableItems)
            Console.WriteLine(c);

        Console.WriteLine("\nDISCOUNTED ITEMS");
        foreach (IDiscountedItem d in order.DiscountedItems)
            Console.WriteLine(d);
    }
}


