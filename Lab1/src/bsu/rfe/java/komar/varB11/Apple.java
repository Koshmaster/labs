package bsu.rfe.java.komar.varB11;
/*fixed*/
public class Apple extends Food {


    private String size;             // из-за создания нового поля нужно переопределить методы equals и toString
    private Double calories = null;

    public Apple(String size)     // конструктор инициализации
    {
        super("Яблоко");               // вызывает конструктор базового класса
        this.size = size;
        par1 = size;
    }

    public void consume()           // реализация метода consume (что произошло с объектом)
    {
        System.out.println(this + " съедено");
    }

    public Double calculateCalories()       // реализация метода подсчета калорий
    {
        if(size.equals("маленькое"))
        {
            calories = 15.0;
        }
        else if(size.equals("среднее"))
        {
            calories = 20.0;
        }
        else if(size.equals("большое"))
        {
            calories = 25.0;
        }
        return calories;
    }

    public String getSize()   // возвращает размер яблока
    {
        return size;
    }

    public void setSize(String size)  // изменение размера яблока
    {
        this.size = size;
    }

    public boolean equals(Object arg0)  // переопределние метода сравнения
    {
        if (super.equals(arg0))
        {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    public String toString()       // переопределение метода преобразования в строку
    {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}
