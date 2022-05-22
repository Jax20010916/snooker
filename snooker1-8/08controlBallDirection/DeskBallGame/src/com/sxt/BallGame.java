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
    Image offScreenImage = null;
    /** 获取桌面图片 */
    Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.jpg");
    /** 获取白球图片 */
    Image ballWhite = Toolkit.getDefaultToolkit().getImage("imgs/ball.png");

    /** 定义白球的水平坐标 */
    double x = 200;
    double y = 200;
    /** 定义白球的移动速度 */
    double speed = 20;
    /** 定义白球的移动角度 */
    double degree = Math.PI / 3;
    /** 定义鼠标点击区域的x坐标 */
    double endx = 200;
    /** 定定义鼠标点击区域的y坐标*/
    double endy = 200;
    //红线是否可见,默认不可见，鼠标左键点击时可见
    boolean isShow = false;
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
                //左键点击
                if (e.getButton() == 1){
                    //获取白球球心x坐标
                    double startx = x + 15;
                    //获取白球的球心y坐标
                    double starty = y + 12;
                    //获取鼠标左键点击区域的坐标
                    endx = e.getX();
                    //获取鼠标左键点击区域的坐标
                    endy = e.getY();
                    //获取以白球球心到点击区域向量的角度
                    //设置红线可见
                    isShow = true;
                    //描绘红线
                    degree = getAngle(startx,starty,endx,endy);
                    System.out.println(getAngle(startx,starty,endx,endy));
                }
                //右键点击
                if (e.getButton() == 3){
                    speed = 20;
                    isShow = false;
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
        //画笔改为红色
        gImage.setColor(Color.red);
        //绘制红线
        if (isShow){
            gImage.drawLine((int)(x + 15),(int)(y + 12),(int)endx,(int)endy);
        }
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

    /** 获取任意两个点所成的向量角度 0——2 * Math.PI */
    public double getAngle(double startx,double starty,double endx,double endy){
        double tempx = endx - startx;
        double tempy = endy - starty;
        //对角线长度
        double z = Math.sqrt(tempx * tempx + tempy * tempy);
        //角度   0到1.57    相当于 0到pi/2
        double angle = (float)(Math.asin(Math.abs(tempy)/z));

        if (tempx > 0 && tempy < 0){
            //第一象限，得到270-360的角度
            angle = Math.PI * 2 - angle;
        } else if (tempx < 0 && tempy < 0){
            //第二象限
            angle = Math.PI + angle;
        } else if (tempx < 0 && tempy > 0){
            //第三象限
            angle = Math.PI - angle;
        } else if (tempx > 0 && tempy > 0){
            //第四象限，角度不用改变
        }
        return angle;
    }

    public static void main(String[] args) {
        BallGame bg = new BallGame();
        bg.launch();
    }
}
