package com.suikajy.demo.swing;

import com.suikajy.demo.swing.util.CodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    JFrame mMainFrame;

    JPanel mPanel;

    JTextField mTfOriData = new JTextField(100);

    JButton mBtnEncrypt = new JButton("加密");

    JTextArea mTaResult = new JTextArea("");

    @Override
    public void show() {
        mMainFrame = new JFrame("加密工具");
        // Setting the width and height of frame
        mMainFrame.setSize(300, 250);
        mMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mMainFrame.setResizable(false);//固定窗体大小

        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width / 2; // 获取屏幕的宽
        int screenHeight = screenSize.height / 2; // 获取屏幕的高
        int height = mMainFrame.getHeight(); //获取窗口高度
        int width = mMainFrame.getWidth(); //获取窗口宽度
        mMainFrame.setLocation(screenWidth - width / 2, screenHeight - height / 2);//将窗口设置到屏幕的中部
        //窗体居中，c是Component类的父窗口
        //mainframe.setLocationRelativeTo(c);
        Image myimage = kit.getImage("res/test.jpg"); //由tool获取图像
        mMainFrame.setIconImage(myimage);
        initPanel();//初始化面板
        mMainFrame.add(mPanel);
        mMainFrame.setVisible(true);
    }

    /**
     * 创建面板，这个类似于 HTML 的 div 标签
     * 我们可以创建多个面板并在 JFrame 中指定位置
     * 面板中我们可以添加文本字段，按钮及其他组件。
     */
    private void initPanel() {
        mPanel = new JPanel();
        mPanel.setLayout(null);
        //this.panel = new JPanel(new GridLayout(3,2)); //创建3行3列的容器
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        mTfOriData.setBounds(0, 0, 300, 50);
        mBtnEncrypt.setBounds(0, 50, 300, 50);
        mTaResult.setBounds(0, 100, 300, 150);
        mPanel.add(mTfOriData);
        mPanel.add(mBtnEncrypt);
        mPanel.add(mTaResult);

        //增加动作监听
        mBtnEncrypt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
        if (e.getSource() == mBtnEncrypt) {
            mTaResult.setText(CodeUtil.Encode(mTfOriData.getText()));
        }
    }


}
