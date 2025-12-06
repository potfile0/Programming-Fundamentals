using System;
using System.Collections.Generic;

public class GroceryOrder
{
    private List<IGroceryItem> _items = new List<IGroceryItem>();

    public GroceryOrder(bool standard)
    {
        if (standard)
            CreateStandardOrder();
        else
            CreateRandomOrder();
    }

    private void CreateStandardOrder()
    {
        _items.Add(new Apple() { Count = 5 });
        _items.Add(new Chips());
        _items.Add(new Donut(true) { Count = 4 });
        _items.Add(new Donut(false) { Count = 3 });
        _items.Add(new Eggs());
        _items.Add(new Eggs());
        _items.Add(new Orange(true) { Count = 3 });
        _items.Add(new RotisserieChicken(true));
        _items.Add(new RotisserieChicken(false));
    }

    private void CreateRandomOrder()
    {
        Random rand = new Random();
        int numItems = rand.Next(4, 21);

        for (int i = 0; i < numItems; i++)
        {
            int choice = rand.Next(0, 6);
            if (choice == 0)
                _items.Add(new Apple() { Count = rand.Next(1, 6) });
            else if (choice == 1)
                _items.Add(new Chips());
            else if (choice == 2)
                _items.Add(new Donut(rand.Next(0, 2) == 1) { Count = rand.Next(1, 13) });
            else if (choice == 3)
                _items.Add(new Eggs());
            else if (choice == 4)
                _items.Add(new Orange(rand.Next(0, 2) == 1) { Count = rand.Next(1, 4) });
            else
                _items.Add(new RotisserieChicken(rand.Next(0, 2) == 1));
        }
    }

    public double TotalFullPrice
    {
        get
        {
            double total = 0;
            foreach (IGroceryItem g in _items)
                total += g.FullPrice;
            return total;
        }
    }

    public double TotalDiscountPrice
    {
        get
        {
            double total = 0;
            foreach (IGroceryItem g in _items)
            {
                IDiscountedItem d = g as IDiscountedItem;
                total += d != null ? d.DiscountPrice : g.FullPrice;
            }
            return total;
        }
    }

    public double Savings => TotalFullPrice - TotalDiscountPrice;

    public List<IGroceryItem> AllItems => _items;

    public List<ICountableItem> CountableItems
    {
        get
        {
            List<ICountableItem> list = new List<ICountableItem>();
            foreach (IGroceryItem g in _items)
            {
                ICountableItem c = g as ICountableItem;
                if (c != null) list.Add(c);
            }
            return list;
        }
    }

    public List<IDiscountedItem> DiscountedItems
    {
        get
        {
            List<IDiscountedItem> list = new List<IDiscountedItem>();
            foreach (IGroceryItem g in _items)
            {
                IDiscountedItem d = g as IDiscountedItem;
                if (d != null) list.Add(d);
            }
            return list;
        }
    }
}

