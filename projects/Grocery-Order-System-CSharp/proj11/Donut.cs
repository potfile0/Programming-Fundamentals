public class Donut : ICountableItem, IDiscountedItem
{
    private int _count = 1;
    private bool _frosted;

    public Donut(bool frosted) => _frosted = frosted;

    public string Name => _frosted ? "Frosted Donut" : "Plain Donut";

    public int Count
    {
        get => _count;
        set
        {
            if (value >= 1 && value <= 12)
                _count = value;
        }
    }

    public double UnitPrice => _frosted ? 1.50 : 1.25;

    public double FullPrice => _count * UnitPrice;

    public double DiscountPrice => 0.7 * FullPrice;

    public override string ToString() => $"{Name}, count: {Count}, price: ${FullPrice:F2}";
}

