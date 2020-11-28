package bsu.rfe.group9.komar.B11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
// Главный класс приложения, он же класс фрейма
public class MainFrame extends JFrame
{
    // Главный метод класса
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    private final JTextField textFieldX;
    private final JTextField textFieldY;
    private final JTextField textFieldZ;
    private final JTextField textFieldAdd;
    private final JTextField textFieldResult;

    private final ButtonGroup radioButtons = new ButtonGroup();
    private final ButtonGroup radioMemoryButtons = new ButtonGroup();

    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxMemoryType = Box.createHorizontalBox();

    private Double mem1 = 0.0;
    private Double mem2 = 0.0;
    private Double mem3 = 0.0;
    private int formulaId = 1;
    private int memoryId = 1;

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z)
    {
        return (1/Math.sqrt(x)+Math.cos(Math.exp(y))+Math.cos(z*z)) /
                (Math.pow(Math.log((1+z)*(1+z))+Math.sqrt(Math.exp(Math.cos(y))+Math.pow(Math.sin(Math.PI*x) , 2)), (1/3)));
    }

    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z)
    {
        return Math.atan(Math.pow(z, (1/x)))/(y*y + z * Math.sin(Math.log(x)));
    }

    private void addRadioButton(String buttonName, final int formulaId)
    {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    private void addMemoryRadioButton(String buttonName, final int memoryId)
    {
        JRadioButton button = new JRadioButton(buttonName);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event) {
                MainFrame.this.memoryId = memoryId;
            }
        });
        radioMemoryButtons.add(button);
        hboxMemoryType.add(button);
    }
    // Конструктор класса
    public MainFrame()
    {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - WIDTH) / 2,(kit.getScreenSize().height - HEIGHT) / 2);

        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

// Область с полями ввода для X Y Z
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 25);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 25);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 25);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

// Область для вывода результата
        hboxMemoryType.add(Box.createHorizontalGlue());
        addMemoryRadioButton("Переменная X", 1);
        addMemoryRadioButton("Переменная Y", 2);
        addMemoryRadioButton("Переменная Z", 3);
        radioMemoryButtons.setSelected(radioMemoryButtons.getElements().nextElement().getModel(), true);
        hboxMemoryType.add(Box.createHorizontalGlue());

// Область для кнопок MC, M+ и текстoвого поля
        Box memory_result = Box.createHorizontalBox();
        memory_result.add(Box.createHorizontalGlue());
        JButton MC=new JButton("MC");
        MC.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                if (memoryId == 1)	{mem1 = 0.0; textFieldX.setText("0");}
                if (memoryId == 2)	{mem2 = 0.0; textFieldY.setText("0");}
                if (memoryId == 3)	{mem3 = 0.0; textFieldZ.setText("0");}
            }
        });

        JButton M_Plus=new JButton("M+");
        M_Plus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                try
                {
                    Double result = Double.parseDouble(textFieldAdd.getText());

                    mem1 = Double.parseDouble(textFieldX.getText());
                    mem2 = Double.parseDouble(textFieldY.getText());
                    mem3 = Double.parseDouble(textFieldZ.getText());

                    if (memoryId == 1) 	{mem1 += result;textFieldX.setText(mem1.toString());}
                    if (memoryId == 2)	{mem2 += result;textFieldY.setText(mem2.toString());}
                    if (memoryId == 3)	{mem3 += result;textFieldZ.setText(mem3.toString());}

                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "" +
                                    "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        textFieldAdd = new JTextField("0", 10);
        textFieldAdd.setMaximumSize(textFieldAdd.getPreferredSize());
        memory_result.add(M_Plus);
        memory_result.add(Box.createHorizontalStrut(10));
        memory_result.add(textFieldAdd);
        memory_result.add(Box.createHorizontalStrut(10));
        memory_result.add(MC);
        memory_result.add(Box.createHorizontalGlue());

// Область для вывода результата вычислений
        JLabel labelForResult = new JLabel("Результат:");
        labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

// Область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                try
                {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldAdd.setText("0");
                textFieldResult.setText("0");
            }
        });

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));

// Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxMemoryType);
        contentBox.add(memory_result);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
}