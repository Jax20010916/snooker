package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author shuai
 * @create 2021/5/19 8:53
 */
public class BallGame extends JFrame {

    /** 定义双缓存图片 */
    Image offScreenImage = null;
    /** 获取桌面图片 */
    Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.jpg");
    /** 获取白球图片 */
    Image ballWhite = Toolkit.getDefaultToolkit().getImage("imgs/ball.png");

    /** 定义白球的水平坐标 */
    double x = 200;
    /** 定义白球的垂直坐标 */
    double y = 200;
    /** 定义白球的移动速度 */
    double speed = 20;
    /** 定义白球的移动角度 */
    double degree = Math.PI / 3;

    /** 窗口创建启动方法 */
    public void launch(){
        //设置窗口是否可见
        setVisible(true);
        //设置窗口大小
        setSize(856,501);
        //设置窗口的位置
        setLocation(200,200);
        //设置窗口标题
        setTitle("桌面小游戏");

        //鼠标点击
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1){
                    System.out.println("=======================鼠标左键点击");
                }
                if (e.getButton() == 3){
                    System.out.println("=======================鼠标右键点击");
                }
            }
        });
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
        /** 创建和容器一样大小的Image图片 */
        if(offScreenImage ==null){
            offScreenImage=this.createImage(856, 501);
        }
        /** 获得该图片的画布*/
        Graphics gImage= offScreenImage.getGraphics();
        /** 填充整个画布*/
        gImage.fillRect(0, 0, 856, 501);
        //绘制桌面图片
        gImage.drawImage(desk,0,20,null);
        //绘制白球图片
        gImage.drawImage(ballWhite,(int)x,(int)y,null);
        /** 将缓冲区绘制好哦的图形整个绘制到容器的画布中 */
        g.drawImage(offScreenImage, 0, 0, null);

        //每次调用paint方法speed递减0.15，实现白球逐渐停止的效果
        speed -= 0.15;
        //移动速度大于0时才进行位移
        if (speed > 0){
            //x按照指定角度移动后的x坐标
            x += speed * Math.cos(degree);
            //x按照指定角度移动后的y坐标
            y += speed * Math.sin(degree);
        }

        //碰到左右时角度变为互补角
        if (x < 30 || x > 800){
            degree = Math.PI - degree;
        }
        //碰到上下边时角度变为原角度的负数
        if (y < 60 || y > 440){
            degree = -degree;
        }

        System.out.println("执行了一次");
    }



    public static void main(String[] args) {
        BallGame bg = new BallGame();
        bg.launch();
    }
}
