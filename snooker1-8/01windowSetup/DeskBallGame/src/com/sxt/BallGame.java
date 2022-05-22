package com.sxt;

import javax.swing.*;
import java.awt.*;

/**
 * @Author shuai
 * @create 2021/5/19 8:53
 */
public class BallGame extends  JFrame {

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
        setTitle("桌球");
    }

    @Override
    public void paint(Graphics g){
		//绘制台球桌面
        g.drawImage(desk,0,20,null);
		//绘制白球
        g.drawImage(ballWhite,200,200,null);
    }

    public static void main(String[] args) {
        BallGame bg = new BallGame();
        bg.launch();
    }

}
