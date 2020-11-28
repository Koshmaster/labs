package bsu.rfe.java.komar.varB11;
/*fixed*/


import java.util.*;
import java.util.Comparator;

public class MainApplication {
    public static void main(String[] args) throws Exception
    {
        Food[] breakfast = new Food[20];
        int i = 0;
        boolean var1, var2;         // случаи для спец параметров, начинающихся с дефиса
        var1 = var2 = false;
        for (String arg : args)
        {
            String[] parts = arg.split(("/"));
            if (parts.length == 2)
            {
                breakfast[i] = new Cake(parts[1]);
                i++;
            }
            switch (parts[0])
            {
                case "-sort":            // если паратметр -sort, значит нужно будет отсортировать продукты завтрака
                    var1 = true;
                    break;
                case "-calories":       // если паратметр -calories, значит нужно будет посчитать калрийность завтрака
                    var2 = true;
                    break;
            }
        }

        System.out.println("Завтрак: ");
        for (Food item : breakfast)
        {
            if (item != null)
            {
                item.consume();
            }
            else
                break;
        }

        int cake1, cake2, cake3;
        cake1 = cake2 = cake3 = 0;
        for(Food item: breakfast)                            // считаем, сколько чего было съедено на завтрак
        {
            if (item == null)
                break;
            if (item.name.equals("Пирожное"))
            {
                if (item.par1.equals("шоколадная"))
                    cake1++;
                else if (item.par1.equals("сливочная"))
                    cake2++;
                else if (item.par1.equals("карамель"))
                    cake3++;
            }
        }

        if (var1)
        {
            Arrays.sort(breakfast, new Comparator()
            {
                public int compare(Object o2, Object o1)
                {
                    if (o2 == null || ((Food)o2).par1.length() > ((Food)o1).par1.length())
                    {
                        return 1;
                    }
                    if (o1 == null || ((Food)o2).par1.length() < ((Food)o1).par1.length())
                    {
                        return -1;
                    }
                    else return 0;
                }
            });

            System.out.println("Завтрак (отсортированный вариант):");
            for (Food item : breakfast)
            {
                if (item != null)
                {
                    if (item.calculateCalories()==0.0)
                        continue;
                    item.consume();
                    System.out.println(" " + item.calculateCalories());
                }
                else
                    break;
            }
        }

        if (var2)
        {
            double CaloriesCounter = 0.0;
            for (Food item : breakfast)
            {
                if (item != null)
                    CaloriesCounter += item.calculateCalories();
                else
                    break;
            }
            System.out.println("Общее количество калорий: " + CaloriesCounter);

        }

        System.out.println("На завтрак съедено:");
        System.out.println(" шоколадных пирожных - " + cake1 + ", сливочных пирожных - " + cake2 + ", пирожных с карамелью - " + cake3);

    }
}
