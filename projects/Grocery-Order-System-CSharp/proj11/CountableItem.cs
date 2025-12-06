public interface ICountableItem : IGroceryItem
{
    int Count { get; set; }
    double UnitPrice { get; }
}
