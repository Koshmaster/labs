package bsu.rfe.java.komar.varB11;
/*fixed*/
public class Cheese extends Food {

        private Double calories = null;

        public Cheese()      // конструктор инициализации
        {
            super("Сыр");                      // вызывает конструктор базового класса
        }

        public Double calculateCalories()       // реализация метода подсчета калорий
        {
            calories = 30.0;
            return calories;
        }

        public void consume()           // реализация метода consume (что произошло с объектом)
        {
            System.out.println(this + " съеден");
        }

    }

