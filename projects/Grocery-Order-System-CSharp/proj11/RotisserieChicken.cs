public class RotisserieChicken : IGroceryItem
{
    private bool _hot;

    public RotisserieChicken(bool hot) => _hot = hot;

    public string Name
    {
    get
    {
        if (_hot)
            return "Hot Rotisserie Chicken";
        else
            return "Rotisserie Chicken";
    }
    }


    public double FullPrice
    {
    get
    {
        if (_hot)
            return 7.99;
        else
            return 6.99;
    }
    }


    public override string ToString() => $"{Name}, price: ${FullPrice:F2}";
}

