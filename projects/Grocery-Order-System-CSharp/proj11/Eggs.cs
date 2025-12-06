public class Eggs : IDiscountedItem
{
    public string Name => "Eggs";

    public double FullPrice => 3.50;

    public double DiscountPrice => 2.50;

    public override string ToString() => $"{Name}, price: ${FullPrice:F2}";
}

