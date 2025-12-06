public class Chips : IDiscountedItem
{
    public string Name => "Chips";

    public double FullPrice => 5.99;

    public double DiscountPrice => 3.99;

    public override string ToString() => $"{Name}, price: ${FullPrice:F2}";
}
