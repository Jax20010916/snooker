package com.sxt;

import javax.swing.*;
import java.awt.*;

/**
 * @Author shuai
 * @create 2021/5/19 8:53
 */
public class BallGame extends JFrame{


    /** 获取桌面图片 */
    Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.jpg");
    /** 获取白球图片 */
    Image ballWhite = Toolkit.getDefaultToolkit().getImage("imgs/ball.png");
    //定义白球的运动水平方向默认坐标
    double x = 200;
    //定义白球的垂直运动方向的坐标
    double y = 200;
    //定义成员变量 白球的移动速度
    double speed = 10;
    //设置白球的移动角度
    double degree = Math.PI / 3;
    /** 窗口创建启动方法 */
    public void launch(){
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(856,501);
        //设置窗口的位置
        this.setLocation(100,200);
        //设置窗口标题
        this.setTitle("桌球小游戏");


        while (true){
            repaint();
            try {
                Thread.sleep(40);   //每隔40毫秒执行一次，1秒25次
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    //绘制画布
    @Override
    public void paint(Graphics g){
        //绘制桌面图片
        g.drawImage(desk,0,20,null);
        //绘制白球图片
        g.drawImage(ballWhite,(int)x,(int)y,null);

        if (speed > 0){
            //speed递减
            speed -= 0.15; //0 .15为摩擦系数
            // 为下一次绘制更新 x和y坐标
            x += speed * Math.cos(degree);
            y += speed * Math.sin(degree);
        }

    }

    public static void main(String[] args) {
        BallGame bg = new BallGame();
        bg.launch();
    }


}
