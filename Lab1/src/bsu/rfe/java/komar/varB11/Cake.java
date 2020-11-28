package bsu.rfe.java.komar.varB11;
/*fixed*/
public class Cake extends Food
{

    public Cake(String icing)
    {
        super("Пирожное");
        par1 = icing;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Cake)) return false;
            return par1.equals(((Cake)arg0).par1);
        } else
            return false;
    }

    public String getSize()
    {
        return par1;
    }

    public void setSize(String icing)
    {
        this.par1 = icing;
    }

    public void consume()           // реализация метода consume (что произошло с объектом)
    {
        System.out.println(this + " съедено");
    }

    public String toString()       // переопределение метода преобразования в строку
    {
        return super.toString() + " '" + par1.toUpperCase() + "'";
    }

    public Double calculateCalories()       // реализация метода подсчета калорий
    {
        if(par1.equals("шоколадная"))
        {
            calories = 15.5;
        }
        else if(par1.equals("сливочная"))
        {
            calories = 10.5;
        }
        else if(par1.equals("карамель"))
        {
            calories = 20.0;
        }
        else
            return 0.0;
        return calories;
    }

}