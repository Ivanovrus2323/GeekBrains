import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static int labelValue = 0;

    MainFrame() {

        setLayout(new GridLayout(1, 5));

        // Текст со значением
        JLabel jLabel = new JLabel("Значение: " + String.valueOf(labelValue));

        // Кнопки вычитания
        JButton jButton1 = new JButton("-1");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelValue += -1;
                jLabel.setText("Значение: " + String.valueOf(labelValue));
            }
        });
        JButton jButton2 = new JButton("-5");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelValue += -5;
                jLabel.setText("Значение: " + String.valueOf(labelValue));
            }
        });

        // Кнопка сложения
        JButton jButton3 = new JButton("+1");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelValue += 1;
                jLabel.setText("Значение: " + String.valueOf(labelValue));
            }
        });
        JButton jButton4 = new JButton("+5");
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelValue += 5;
                jLabel.setText("Значение: " + String.valueOf(labelValue));
            }
        });

        add(jButton1);
        add(jButton2);
        add(jLabel  );
        add(jButton3);
        add(jButton4);

        // Настройки окна
        setTitle("Test app");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
