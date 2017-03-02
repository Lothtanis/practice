package sudoku;

import javax.swing.JFrame;

public class Sudoku {
    public static void main(String[] args) {
        Myframe myf = new Myframe();
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myf.setTitle("sudoku");// 设置主界面的名称
        myf.setSize(500, 500);// 设置界面的大小
        myf.setVisible(true);// 设置主程序可见
    }
}
