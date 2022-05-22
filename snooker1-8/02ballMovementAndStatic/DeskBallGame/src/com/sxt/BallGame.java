package com.sxt;

import javax.swing.*;
import java.awt.*;

/**
 * @Author shuai
 * @create 2021/5/19 8:53
 */
public class BallGame extends JFrame {

    /** 定义变量表示球的水平位置*/
    double x = 200;
    /** 定义变量表示球的垂直位置*/
    double y = 200;
    /** 定义变量表示球的加速度*/
    double speed  =10;
   
    /** 获取桌面图片 */
    Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.jpg");
    /** 获取白球图片 */
    Image ballWhite = Toolkit.getDefaultToolkit().getImage("imgs/ball.png");

    /** 窗口创建启动方法 */
    public void launch(){
        //设置窗口是否可见
        setVisible(true);
        //设置窗口大小
        setSize(856,501);
        //设置窗口的位置
        setLocation(100,200);
        //设置窗口标题
        setTitle("桌面小游戏");

        while (true){
            repaint();
            try {
                //暂停40毫秒，相当于1秒钟执行(1000/40 = 25)次 repaint()方法
                Thread.sleep(40);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //绘制桌面图片
        g.drawImage(desk,0,20,null);
        //绘制白球图片
        g.drawImage(ballWhite,(int)x,(int)y,null);

        if (speed > 0){
            //每次调用paint方法speed递减0.15，实现白球逐渐停止的效果
            speed -= 0.15;
			//x的运动到逐渐停止
            x += speed;
        }

    }

    public static void main(String[] args) {
        BallGame bg = new BallGame();
        bg.launch();
    }
}
