package sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Myframe extends JFrame {// 继承界面类
    public static Object obj = new Object();
    public final static JTextField[][] filed = new JTextField[9][9];// 创建九宫格界面

    public Myframe() {// 初始化界面，让所有的格子都等于空
        for (int a = 0; a < 9; a++) {
         for (int b = 0; b < 9; b++) {
            filed[a][b] = new JTextField();
            filed[a][b].setText("");
         }
        }
        JPanel jpan = new JPanel();// 编写布局，把textfield添加到布局中
        jpan.setLayout(new GridLayout(9, 9));
        for (int a = 8; a > -1; a--) {
         for (int b = 0; b < 9; b++) {
            jpan.add(filed[b][a]);
         }
        }
        add(jpan, BorderLayout.CENTER);// 界面布局为居中
        JPanel jpb = new JPanel();
        JButton button1 = new JButton("calc");// 设置两个按钮，计算和退出
        JButton button2 = new JButton("close");
        jpb.add(button1);// 将按钮添加到界面上
        jpb.add(button2);
        button1.addActionListener(new ActionListener() {// 给按钮添加监听器，就是添加事件响应函数
        public void actionPerformed(ActionEvent event) {
        synchronized (obj) {
         for (int a = 0; a < 9; a++) {
            for (int b3 = 0; b3 < 9; b3++) {
             int pp = 0;
             if (!(filed[a][b3].getText().trim().equals(""))) {// 获取九宫格中的已填入数据的值，这些就是谜面
                pp = Integer.parseInt(filed[a][b3].getText()
                        .trim());
                Calculate.b[a][b3] = pp;
             }
            }
        }
        }
        synchronized (obj) {
            new Thread(new Calculate()).start();// 开启线程计算九宫格的答案
        }
        }
        });
        button2.addActionListener(new ActionListener() {// button2很简单，调用api关闭程序
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        add(jpb, BorderLayout.SOUTH);// 设置界面的布局
    }
    }
