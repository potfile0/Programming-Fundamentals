public class Apple : ICountableItem
{
    private int _count = 1;

    public string Name => "Apple";

    public int Count
    {
        get => _count;
        set
        {
            if (value >= 1 && value <= 5)
                _count = value;
        }
    }

    public double UnitPrice => 0.75;

    public double FullPrice => _count * UnitPrice;

    public override string ToString() => $"{Name}, count: {Count}, price: ${FullPrice:F2}";
}
