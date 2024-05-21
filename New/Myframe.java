package New;

import com.sun.deploy.net.MessageHeader;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Myframe extends JFrame { // 定义一个类继承JFrame类
        public Myframe(String title) {
            super(title); // 调用父类构造器，设置窗口标题
            Container container = getContentPane(); // 获取当前窗口的容器
            container.setBackground (Color.white); // 设置容器的背景颜色
            // 设置窗体大小
            setSize(1200, 800);
            // 计算 JFrame 的位置以使其居中
            // 获取屏幕尺寸
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            // 获取窗口的大小（确保在设置大小之后调用）
            Dimension frameSize = getSize();
            // 设置 JFrame 的位置
            int x = (screenSize.width - frameSize.width) / 2;
            int y = (screenSize.height - frameSize.height) / 2;
            setLocation(x, y);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭方式
            JPanel panel = new JPanel(); // 创建一个面板
            panel.setBackground(Color.gray); // 设置面板的背景颜色
            container.add(panel); // 将面板添加到容器中
            setVisible(true); // 设置窗体可见
            setContentPane(panel); // 设置内容面板
            // 设置面板的布局为null，这样我们可以手动设置组件的位置和大小
            panel.setLayout(null);
            JLabel label = new JLabel("图片结果展示区", SwingConstants.CENTER);
            label.setFont(new Font("微软雅黑", Font.BOLD, 20));
            // 设置 JLabel 为不透明，并设置背景色为白色
            label.setOpaque(true); // 设置 JLabel 为不透明
            label.setBackground(Color.WHITE); // 设置 JLabel 背景为白色
            label.setBorder(new BevelBorder(BevelBorder.LOWERED));
            //ImageIcon icon = new ImageIcon("D:\\Idea\\First\\pingtu_Game\\image\\sport\\sport8\\all.jpg"); // 替换为你的图片路径
            //label.setIcon(icon);
            label.setBounds(90, 120, 680, 450);
            this.getContentPane().add(label);

            // 创建一个按钮
            JButton button1 = new JButton("开始检测");
            JButton button2 = new JButton("文件回看");
            button1.addActionListener(e -> {
                // 在这里添加按钮点击事件的代码
                // 例如，创建一个新的窗口并显示它
                JFrame frame = new JFrame("开始检测");
                frame.setLocation( 150, 690);
                frame.setSize(300, 300);
                frame.setVisible(true);
            });
            button2.addActionListener(e -> {
                // 在这里添加按钮点击事件的代码
                // 例如，创建一个新的窗口并显示它
                JFrame frame = new JFrame("文件回看");
                frame.setLocation( 600, 400);
                frame.setSize(300, 300);
                frame.setVisible(true);
            });
            // 设置按钮的属性
            button1.setBounds(150, 690, 100, 45);// 设置按钮的背景色
            button1.setBackground(Color.GRAY);// 设置按钮上的文字颜色
            button1.setForeground(Color.black);// 设置按钮的字体
            button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
            button1.setBorder(BorderFactory.createMatteBorder(8, 8, 8,8,Color.lightGray)); // 设置矩形边框，宽度为6，颜色为黑色
            button1.setContentAreaFilled(false);// 设置按钮是否填充内容区域的内容（如背景色）

            button2.setBounds(450, 690, 100, 45);// 设置按钮的背景色
            button2.setBackground(Color.GRAY);// 设置按钮上的文字颜色
            button2.setForeground(Color.black);// 设置按钮的字体
            button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
            button2.setBorder(BorderFactory.createMatteBorder(8, 8, 8,8, Color.lightGray)); // 设置矩形边框，宽度为3，颜色为黑色
            button2.setContentAreaFilled(false);// 设置按钮是否填充内容区域的内容（如背景色）
            // 将按钮添加到面板中
            panel.add(button1);
            panel.add(button2);

            JLabel label15 = new JLabel("模型选择", SwingConstants.CENTER);
            label15.setFont(new Font("微软雅黑", Font.BOLD, 20));
            // 设置 JLabel 为不透明，并设置背景色为白色
            label15.setOpaque(true); // 设置 JLabel 为不透明
            label15.setBackground(Color.cyan); // 设置 JLabel 背景为白色
            label15.setBorder(new BevelBorder(BevelBorder.LOWERED));
            label15.setBounds(800, 150, 120, 45);
            getContentPane().add(label15);

            JLabel label16 = new JLabel("报警值设置", SwingConstants.CENTER);
            label16.setFont(new Font("微软雅黑", Font.BOLD, 20));
            // 设置 JLabel 为不透明，并设置背景色为白色
            label16.setOpaque(true); // 设置 JLabel 为不透明
            label16.setBackground(Color.cyan); // 设置 JLabel 背景为白色
            label16.setBorder(new BevelBorder(BevelBorder.LOWERED));
            label16.setBounds(800, 300, 120, 45);
            getContentPane().add(label16);

            JLabel label17 = new JLabel("模型一", SwingConstants.CENTER);
            label17.setFont(new Font("微软雅黑", Font.BOLD, 20));

            JButton button3 = new JButton("模型一");
            button3.addActionListener(e -> {
                // 在这里添加按钮点击事件的代码
                // 例如，创建一个新的窗口并显示它
                JFrame frame = new JFrame("模型一");
                frame.setLocation( 600, 400);
                frame.setSize(500, 400);
                frame.setVisible(true);
            });
            button3.setBounds(950, 120, 120, 45);
            button3.setBackground(Color.GRAY);// 设置按钮上的文字颜色
            button3.setForeground(Color.white);// 设置按钮的字体
            button3.setFont(new Font("微软雅黑", Font.BOLD, 18));
            button3.setBorder(BorderFactory.createMatteBorder(1, 1, 1,1,Color.black)); // 设置矩形边框，宽度为6，颜色为黑色
            button3.setContentAreaFilled(false);// 设置按钮是否填充内容区域的内容（如背景色）
            panel.add(button3);
            JButton button4 = new JButton("模型二");
            button4.addActionListener(e -> {
                // 在这里添加按钮点击事件的代码
                // 例如，创建一个新的窗口并显示它
                JFrame frame = new JFrame("模型二");
                frame.setLocation( 600, 400);
                frame.setSize(500, 400);
                frame.setVisible(true);
            });
            button4.setBounds(950, 170, 120, 45);
            button4.setBackground(Color.GRAY);// 设置按钮上的文字颜色
            button4.setForeground(Color.white);// 设置按钮的字体
            button4.setFont(new Font("微软雅黑", Font.BOLD, 18));
            button4.setBorder(BorderFactory.createMatteBorder(1, 1, 1,1,Color.black)); // 设置矩形边框，宽度为6，颜色为黑色
            button4.setContentAreaFilled(false);// 设置按钮是否填充内容区域的内容（如背景色）
            panel.add(button4);
            JButton button5 = new JButton("模型三");
            button5.addActionListener(e -> {
                // 在这里添加按钮点击事件的代码
                // 例如，创建一个新的窗口并显示它
                JFrame frame = new JFrame("模型三");
                frame.setLocation( 600, 400);
                frame.setSize(500, 400);
                frame.setVisible(true);
            });
            button5.setBounds(950, 220, 120, 45);// 设置按钮的背景色
            button5.setBackground(Color.GRAY);// 设置按钮上的文字颜色
            button5.setForeground(Color.white);// 设置按钮的字体
            button5.setFont(new Font("微软雅黑", Font.BOLD, 18));
            button5.setBorder(BorderFactory.createMatteBorder(1, 1, 1,1,Color.black)); // 设置矩形边框，宽度为6，颜色为黑色
            button5.setContentAreaFilled(false);// 设置按钮是否填充内容区域的内容（如背景色）
            panel.add(button5);

            JPanel panel1 = new JPanel();
            panel1.setName("报警值设置");
            panel1.setBounds(850, 350, 300, 300);
            panel1.setBackground(Color.white); // 设置对话框背景颜色
            panel1.setBorder(BorderFactory.createLineBorder(Color.black)); // 设置对话框边框
            panel1.setLayout(new GridLayout(7, 2)); // 设置布局为

            // 添加文本到对话框
            JLabel label1 = new JLabel("名称", SwingConstants.CENTER);
            JLabel label2 = new JLabel("大小", SwingConstants.CENTER);
            JLabel label3 = new JLabel("直径1", SwingConstants.CENTER);
            JLabel label4 = new JLabel("", SwingConstants.CENTER);
            JLabel label5 = new JLabel("直径2", SwingConstants.CENTER);
            JLabel label6 = new JLabel("", SwingConstants.CENTER);
            JLabel label7 = new JLabel("宽度1", SwingConstants.CENTER);
            JLabel label8 = new JLabel("", SwingConstants.CENTER);
            JLabel label9 = new JLabel("宽度2", SwingConstants.CENTER);
            JLabel label10 = new JLabel("", SwingConstants.CENTER);
            JLabel label11 = new JLabel("高度1", SwingConstants.CENTER);
            JLabel label12 = new JLabel("", SwingConstants.CENTER);
            JLabel label13 = new JLabel("高度2", SwingConstants.CENTER);
            JLabel label14 = new JLabel("", SwingConstants.CENTER);


            // 设置文本的属性
            label1.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label1.setBackground(new Color(66, 102, 220)); // 淡蓝色
            label2.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label2.setBackground(new Color(66, 102, 220)); // 淡蓝色
            label3.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label3.setBackground(new Color(173, 216, 230)); // 淡蓝色
            label4.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label4.setBackground(new Color(173, 216, 230)); // 淡蓝色
            label5.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label5.setBackground(new Color(255, 255, 255)); // 淡蓝色
            label6.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label6.setBackground(new Color(255, 255, 255)); // 淡蓝色
            label7.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label7.setBackground(new Color(173, 216, 230)); // 淡蓝色
            label8.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label8.setBackground(new Color(173, 216, 230)); // 淡蓝色
            label9.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label9.setBackground(new Color(255, 255, 255)); // 淡蓝色
            label10.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label10.setBackground(new Color(255, 255, 255)); // 淡蓝色
            label11.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label11.setBackground(new Color(173, 216, 230)); // 淡蓝色
            label12.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label12.setBackground(new Color(173, 216, 230)); // 淡蓝色
            label13.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label13.setBackground(new Color(255, 255, 255)); // 淡蓝色
            label14.setOpaque(true); // 必须设置为true，否则JLabel不会显示背景颜色
            label14.setBackground(new Color(255, 255, 255)); // 淡蓝色

            label1.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label1.setForeground(Color.WHITE);
            label2.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label2.setForeground(Color.WHITE);
            label3.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label4.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label5.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label6.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label7.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label8.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label9.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label10.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label11.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label12.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label13.setFont(new Font("微软雅黑", Font.BOLD, 18));
            label14.setFont(new Font("微软雅黑", Font.BOLD, 18));

            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(label4);
            panel1.add(label5);
            panel1.add(label6);
            panel1.add(label7);
            panel1.add(label8);
            panel1.add(label9);
            panel1.add(label10);
            panel1.add(label11);
            panel1.add(label12);
            panel1.add(label13);
            panel1.add(label14);
            panel1.setVisible(false);
            MessageHeader panel1panel;

panel1
            //显示网格线
            .setVisible(true);




        }
    public static void main(String[] args) {
        new Myframe("演示模板");
    }
}
