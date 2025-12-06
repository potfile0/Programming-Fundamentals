public class Orange : ICountableItem
{
    private int _count = 1;
    private bool _organic;

    public Orange(bool organic) => _organic = organic;

    public string Name
    {
    get { return _organic ? "Organic Orange" : "Orange"; }
    }


    public int Count
    {
        get => _count;
        set
        {
            if (value >= 1 && value <= 3)
                _count = value;
        }
    }

    public double UnitPrice
    {
    get
    {
        if (_organic)
            return 1.25;
        else
            return 0.99;
    }
    }


    public double FullPrice => _count * UnitPrice;

    public override string ToString() => $"{Name}, count: {Count}, price: ${FullPrice:F2}";
}

