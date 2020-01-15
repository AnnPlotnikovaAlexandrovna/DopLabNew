package DopLab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DopLab extends JFrame {
    JButton generateButton = new JButton("Нарисовать");
    Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN}; //Цвета фигур
    int x = 10; //Начальные координаты квадрата и круга по оси X
    int y = 65; //Начальные координаты квадрата и круга по оси Y
    int[] xP = new int[] {10, 60, 110}; //Начальные координаты вершин треугольника по оси X
    int[] yP = new int[] {165, 65, 165}; //Начальные координаты вершин треугольника по оси Y
    int width = 100; //Ширина квадрата и круга
    int height = 100; //Высота квадрата и круга
    int countColumns = 4; //Количество фигур в строке
    int countRows = 2; //Количество строк
    int stepX = 10; //Расстояние между фигурами в строке
    int stepY = 10; //Расстояние между строками

    DopLab() {
        super("Фигуры");
        add(generateButton);
        setLayout(new FlowLayout());
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = DopLab.super.getGraphics();
                DopLab.super.paint(g);
                Random rnd = new Random();

                for (int i = 0; i < countRows; i++) {
                    for (int j = 0; j < countColumns; j++) {
                        int c = rnd.nextInt(colors.length);
                        int f = rnd.nextInt(3);

                        g.setColor(colors[c]);

                        switch (f) {
                            case 0:
                                g.fillRect(x, y, width, height);
                                break;
                            case 1:
                                g.fillPolygon(xP, yP, 3);
                                break;
                            case 2:
                                g.fillOval(x, y, width, height);
                        }
                        x += width + stepX;
                        xP[0] += width + stepX;
                        xP[1] += width + stepX;
                        xP[2] += width + stepX;
                    }
                    x -= (width + stepX) * countColumns;
                    xP[0] -= (width + stepX) * countColumns;
                    xP[1] -= (width + stepX) * countColumns;
                    xP[2] -= (width + stepX) * countColumns;
                    y += height + stepY;
                    yP[0] += height + stepY;
                    yP[1] += height + stepY;
                    yP[2] += height + stepY;
                }
                y -= (height + stepY) * countRows;
                yP[0] -= (height + stepY) * countRows;
                yP[1] -= (height + stepY) * countRows;
                yP[2] -= (height + stepY) * countRows;
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) { new DopLab(); };
}
