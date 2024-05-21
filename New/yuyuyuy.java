/*
 * Created by JFormDesigner on Mon Apr 22 21:31:31 CST 2024
 */

package New;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * @author LiuSiHao
 */
public class yuyuyuy extends JFrame {
    public yuyuyuy() {
        initComponents();
        Container contentPane = getContentPane();
        // 设置内容面板的背景色或图片
        contentPane.setBackground(new Color(7,16,33));;
        // 确保内容面板是不透明的，以便背景可见
        contentPane.isOpaque();
        panel1.setBorder(new TitledBorder("图片展示"));
        panel2.setBorder(new TitledBorder("参数设置"));
        panel3.setBorder(new TitledBorder("模型选择"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭方式
        loadFirstImageFromFolder();// 加载第一张图片
        new CompareValuesExample();//数据对比
    }


    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        readFirstFileAndUpdateFields1();
    }
    private void readFirstFileAndUpdateFields1() {
        File folder = new File("D:\\模型数据");
        File[] files = folder.listFiles(); // 获取文件夹中的文件列表

        if (files != null && files.length > 0) {
            File firstFile = files[0]; // 获取第一个文件
            try (BufferedReader reader = new BufferedReader(new FileReader(firstFile))) {
                String line;
                // 读取文件第一行
                if ((line = reader.readLine()) != null) {
                    // 假设数值是用逗号分隔的
                    String[] values = line.split(",");
                    if (values.length >= 6) { // 确保有足够的数值来填充文本字段
                        textField7.setText(values[1]);
                        textField8.setText(values[2]);
                        textField9.setText(values[3]);
                        textField10.setText(values[4]);
                        textField11.setText(values[5]);
                        textField12.setText(values[6]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace(); // 处理异常或显示错误消息
            }
        } else {
            // 文件夹为空或无法访问时的处理
             JOptionPane.showMessageDialog(null, "文件夹为空或无法访问", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        dialog  NEW = new dialog();
        NEW.setVisible(true);
        //设置关闭方式
        NEW.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void loadFirstImageFromFolder() {
        // 创建一个File对象，表示指定的文件夹
        String folderPath = "C:\\Users\\LiuSiHao\\Pictures\\Screenshots";
        File folder = new File(folderPath);

        // 检查该文件夹是否存在以及是否是一个目录
        if (!folder.exists() || !folder.isDirectory()) {
            // 如果文件夹不存在或不是目录，则打印错误信息并返回
            System.out.println("文件夹不存在或不是目录: " + folderPath);
            return;
        }

        // 只保留具有指定扩展名的图片文件
        File[] files = folder.listFiles((dir, name) -> {
            // 定义一个图片文件扩展名的数组
            String[] extensions = {"jpg", "jpeg", "png", "gif"}; // 可以根据需要添加更多扩展名

            // 遍历扩展名数组，检查文件名是否以某个扩展名结尾
            for (String extension : extensions) {
                if (name.toLowerCase().endsWith("." + extension)) {
                    // 如果文件名以某个扩展名结尾，则返回true，表示该文件应该被包含在结果中
                    return true;
                }
            }
            // 如果文件名不以任何指定的扩展名结尾，则返回false
            return false;
        });

        // 检查files数组是否为null或是否为空
        if (files != null && files.length > 0) {
            // 假设第一个文件就是我们要加载的图片
            File imageFile = files[0];

            try {
                // 使用ImageIO.read方法读取图片文件，并返回BufferedImage对象
                BufferedImage image = ImageIO.read(imageFile);

                // 缩放图片以适应JLabel的大小
                Image scaledImage = image.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);

                // 创建一个ImageIcon对象，使用缩放后的图片
                ImageIcon icon = new ImageIcon(scaledImage);

                // 将ImageIcon设置为JLabel的图标
                label1.setIcon(icon);

            } catch (IOException e) {
                // 如果读取或缩放图片时发生IO异常，则打印堆栈跟踪
                e.printStackTrace();
                // 在这里可以添加额外的错误处理逻辑
            }
        } else {
            // 如果文件夹中没有找到图片文件，则打印一条消息
            JOptionPane.showMessageDialog(this, "文件夹中没有找到图片文件", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

        // CSV文件的路径
        String csvFilePath = "C:\\Users\\LiuSiHao\\Desktop\\example.csv";
        // 创建一个CSVReader对象，用于读取CSV文件
        CSVReader csvReader = null;
        try {
            // 尝试打开CSV文件
            csvReader = new CSVReader(csvFilePath);

            // 循环读取CSV文件的每一行，直到没有更多行可读
            String[] data;
            while ((data = csvReader.readNextLine()) != null) {
                // 假设你每次只处理前6个数据项
                if (data.length >= 6) {
                    // 打印到控制台作为示例（这里应该是设置JLabel的文本）
                    label22.setText(data[1]); // 将data数组的第一个元素（索引为1）设置为jLabel22的文本。
                    label23.setText(data[2]);
                    label24.setText(data[3]);
                    label25.setText(data[4]);
                    label26.setText(data[5]);
                    label27.setText(data[6]);
//                    label32.setText(data[7]);圆心1
//                    label33.setText(data[8]);圆心2
                    // ... 为其他JLabel设置数据 ...
                }
            }
        } catch (IOException ex) {
            // 如果在读取CSV文件时发生IO异常，则捕获并处理
            ex.printStackTrace();
            // 显示错误消息对话框
            JOptionPane.showMessageDialog(null, "数据获取异常", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        readFirstFileAndUpdateFields2();
    }
    private void readFirstFileAndUpdateFields2() {
        File folder = new File("D:\\模型数据");
        File[] files = folder.listFiles(); // 获取文件夹中的文件列表

        if (files != null && files.length > 0) {
            File firstFile = files[1]; // 获取第二个文件
            try (BufferedReader reader = new BufferedReader(new FileReader(firstFile))) {
                String line;
                // 读取文件第一行
                if ((line = reader.readLine()) != null) {
                    // 假设数值是用逗号分隔的
                    String[] values = line.split(",");
                    if (values.length >= 6) { // 确保有足够的数值来填充文本字段
                        textField7.setText(values[1]);
                        textField8.setText(values[2]);
                        textField9.setText(values[3]);
                        textField10.setText(values[4]);
                        textField11.setText(values[5]);
                        textField12.setText(values[6]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace(); // 处理异常或显示错误消息
            }
        } else {
            // 文件夹为空或无法访问时的处理
            JOptionPane.showMessageDialog(null, "文件夹为空或无法访问", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        readFirstFileAndUpdateFields3();
    }
    private void readFirstFileAndUpdateFields3() {
        File folder = new File("D:\\模型数据");
        File[] files = folder.listFiles(); // 获取文件夹中的文件列表

        if (files != null && files.length > 0) {
            File firstFile = files[2]; // 获取第三个文件
            try (BufferedReader reader = new BufferedReader(new FileReader(firstFile))) {
                String line;
                // 读取文件第一行
                if ((line = reader.readLine()) != null) {
                    // 假设数值是用逗号分隔的
                    String[] values = line.split(",");
                    if (values.length >= 6) { // 确保有足够的数值来填充文本字段
                        textField7.setText(values[1]);
                        textField8.setText(values[2]);
                        textField9.setText(values[3]);
                        textField10.setText(values[4]);
                        textField11.setText(values[5]);
                        textField12.setText(values[6]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace(); // 处理异常或显示错误消息
            }
        } else {
            // 文件夹为空或无法访问时的处理
            JOptionPane.showMessageDialog(null, "文件夹为空或无法访问", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


public class CSVReader {
    // 定义一个BufferedReader对象，用于读取文件内容
    private BufferedReader br;

    // 构造函数，用于初始化CSVReader对象，并打开文件
    public CSVReader(String filePath) throws IOException {
        // 使用文件路径创建一个FileInputStream
        // 使用UTF-8字符集创建一个InputStreamReader
        // 使用InputStreamReader创建一个BufferedReader
        br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
    }

    // 读取CSV文件的下一行，并返回一个字符串数组，其中每个元素是CSV字段
    // 如果没有更多行可读，则返回null
    public String[] readNextLine() throws IOException {
        // 读取下一行
        String line = br.readLine();
        if (line == null) {
            // 如果没有更多行可读，则关闭文件
            br.close();
            return null;
        }

        // 将当前行按逗号分割成一个字符串数组
        return line.split(",");
    }

}

    public class CompareValuesExample extends JFrame {

        private JLabel[] labels = {label22, label23, label24, label25, label26, label27}; // 假设这些label已经定义
        private JTextField[] textFields = {textField7, textField8, textField9, textField10, textField11, textField12}; // 假设这些textField已经定义

        public CompareValuesExample() {
            // 为每个textField添加ActionListener以处理回车事件
            for (JTextField textField : textFields) {
                textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 触发数值比较
                        compareValues();
                    }
                });
            }
        }

        private void compareValues() {
            for (int i = 0; i < labels.length; i++) {
                try {
                    // 尝试从label和textField中获取数值
                    double labelValue = Double.parseDouble(labels[i].getText());
                    double textFieldValue = Double.parseDouble(textFields[i].getText().trim()); // 去除首尾空格

                    // 比较两个数值是否相差0.05以内
                    if (Math.abs(labelValue - textFieldValue) <= 0.05) {
                        // 数值接近，不处理
                    } else {
                        // 数值不接近，将label背景设置为红色
                        labels[i].setBackground(Color.RED);

                        // 显示弹窗提示
                        //JOptionPane.showMessageDialog(null, "输入的数值与标准值不符，请检查！");
                    }
                } catch (NumberFormatException ex) {
                    // 处理无效输入（空字符或非法字符）
                    labels[i].setBackground(Color.WHITE); // 重置背景颜色
                   // JOptionPane.showMessageDialog(null, "输入了无效的字符或空字符，请重新输入！");
                    // 清空textField的内容
                    textFields[i].setText("");
                }
            }
        }
    }
        private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label7 = new JLabel();
        label4 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        textField10 = new JTextField();
        textField11 = new JTextField();
        textField12 = new JTextField();
        label28 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        label31 = new JLabel();
        label32 = new JLabel();
        label33 = new JLabel();
        panel3 = new JPanel();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button2 = new JButton();
        button1 = new JButton();
        panel4 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1200, 800));
        setMaximumSize(null);
        setPreferredSize(new Dimension(1300, 900));
        setBackground(new Color(0x0099ff));
        setForeground(new Color(0x0066ff));
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x022c54));
            panel1.setMaximumSize(new Dimension(666666, 666666));

            //---- label1 ----
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(93, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setPreferredSize(new Dimension(200, 200));
            panel2.setBackground(new Color(0x022c54));

            //---- label7 ----
            label7.setText("\u76f4\u5f841");
            label7.setHorizontalAlignment(SwingConstants.CENTER);
            label7.setOpaque(true);
            label7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label4 ----
            label4.setText("\u76f4\u5f842");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setOpaque(true);
            label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label12 ----
            label12.setText("\u5bbd\u5ea61");
            label12.setHorizontalAlignment(SwingConstants.CENTER);
            label12.setOpaque(true);
            label12.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label13 ----
            label13.setText("\u5bbd\u5ea62");
            label13.setHorizontalAlignment(SwingConstants.CENTER);
            label13.setOpaque(true);
            label13.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label14 ----
            label14.setText("\u9ad8\u5ea61");
            label14.setHorizontalAlignment(SwingConstants.CENTER);
            label14.setOpaque(true);
            label14.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label15 ----
            label15.setText("\u9ad8\u5ea62");
            label15.setHorizontalAlignment(SwingConstants.CENTER);
            label15.setOpaque(true);
            label15.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label16 ----
            label16.setText("\u76f4\u5f841");
            label16.setHorizontalAlignment(SwingConstants.CENTER);
            label16.setOpaque(true);
            label16.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label17 ----
            label17.setText("\u76f4\u5f842");
            label17.setHorizontalAlignment(SwingConstants.CENTER);
            label17.setOpaque(true);
            label17.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label18 ----
            label18.setText("\u5bbd\u5ea61");
            label18.setHorizontalAlignment(SwingConstants.CENTER);
            label18.setOpaque(true);
            label18.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label19 ----
            label19.setText("\u5bbd\u5ea62");
            label19.setHorizontalAlignment(SwingConstants.CENTER);
            label19.setOpaque(true);
            label19.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label20 ----
            label20.setText("\u9ad8\u5ea61");
            label20.setHorizontalAlignment(SwingConstants.CENTER);
            label20.setOpaque(true);
            label20.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label21 ----
            label21.setText("\u9ad8\u5ea62");
            label21.setHorizontalAlignment(SwingConstants.CENTER);
            label21.setOpaque(true);
            label21.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label22 ----
            label22.setHorizontalAlignment(SwingConstants.CENTER);
            label22.setOpaque(true);
            label22.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label23 ----
            label23.setHorizontalAlignment(SwingConstants.CENTER);
            label23.setOpaque(true);
            label23.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label24 ----
            label24.setHorizontalAlignment(SwingConstants.CENTER);
            label24.setOpaque(true);
            label24.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label25 ----
            label25.setHorizontalAlignment(SwingConstants.CENTER);
            label25.setOpaque(true);
            label25.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label26 ----
            label26.setHorizontalAlignment(SwingConstants.CENTER);
            label26.setOpaque(true);
            label26.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label27 ----
            label27.setHorizontalAlignment(SwingConstants.CENTER);
            label27.setOpaque(true);
            label27.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- textField7 ----
            textField7.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- textField8 ----
            textField8.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- textField9 ----
            textField9.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- textField10 ----
            textField10.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- textField11 ----
            textField11.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- textField12 ----
            textField12.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label28 ----
            label28.setText("\u68c0\u6d4b\u503c");
            label28.setHorizontalAlignment(SwingConstants.CENTER);
            label28.setOpaque(true);
            label28.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label28.setForeground(Color.white);
            label28.setBackground(new Color(0x022c54));

            //---- label29 ----
            label29.setText("\u6807\u51c6\u503c");
            label29.setHorizontalAlignment(SwingConstants.CENTER);
            label29.setOpaque(true);
            label29.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label29.setBackground(new Color(0x022c54));
            label29.setForeground(Color.white);

            //---- label30 ----
            label30.setText("\u5706\u5fc31");
            label30.setHorizontalAlignment(SwingConstants.CENTER);
            label30.setOpaque(true);
            label30.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label31 ----
            label31.setText("\u5706\u5fc32");
            label31.setHorizontalAlignment(SwingConstants.CENTER);
            label31.setOpaque(true);
            label31.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

            //---- label32 ----
            label32.setHorizontalAlignment(SwingConstants.CENTER);
            label32.setOpaque(true);
            label32.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            //---- label33 ----
            label33.setHorizontalAlignment(SwingConstants.CENTER);
            label33.setOpaque(true);
            label33.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 16));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(label31, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label33, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label21, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(textField12))
                            .addComponent(label28, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(label23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(label22, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label20, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(textField11))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label19, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(textField10))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label18, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(textField9))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label17, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label16, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField7, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(textField8)))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(label30, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label32, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label12, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label14, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label15, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(label26, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                            .addComponent(label25, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label24, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label27, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(label29, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label28, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label22, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label23, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label24, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label25, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label26, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label15, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label27, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label30, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label32, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label33, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label31, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(label29, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label17, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label19, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label20, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label21, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
            );
        }

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0x022c54));

            //---- button3 ----
            button3.setText("\u6a21\u578b\u4e00");
            button3.setForeground(Color.black);
            button3.setBackground(Color.white);
            button3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });

            //---- button4 ----
            button4.setText("\u6a21\u578b\u4e8c");
            button4.setBackground(Color.white);
            button4.setForeground(Color.black);
            button4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });

            //---- button5 ----
            button5.setText("\u6a21\u578b\u4e09");
            button5.setForeground(Color.black);
            button5.setBackground(Color.white);
            button5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                }
            });

            //---- button6 ----
            button6.setText("+");
            button6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 20));
            button6.setForeground(Color.white);
            button6.setBackground(new Color(0x022c54));
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(87, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))
            );
        }

        //---- button2 ----
        button2.setText("\u6587\u4ef6\u56de\u770b");
        button2.setForeground(Color.black);
        button2.setBackground(Color.white);
        button2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));

        //---- button1 ----
        button1.setText("\u5f00\u59cb\u68c0\u6d4b");
        button1.setForeground(Color.black);
        button1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
        button1.setBackground(Color.white);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //======== panel4 ========
        {
            panel4.setBackground(new Color(0x022c54));
            panel4.setMaximumSize(new Dimension(13426, 33277));
            panel4.setLayout(new FormLayout(
                "4dlu, $lcgap, default, $lcgap, 12dlu, $lcgap, default, $lcgap, 12dlu, $lcgap, default, $lcgap, 12dlu, $lcgap, default, $lcgap, 12dlu, $lcgap, default, $lcgap, 12dlu, $lcgap, default, $lcgap, 100dlu",
                "fill:default"));

            //---- label2 ----
            label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setOpaque(true);
            label2.setIcon(new ImageIcon("C:\\Users\\LiuSiHao\\Desktop\\1.png"));
            panel4.add(label2, CC.xy(3, 1));

            //---- label3 ----
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label3.setDoubleBuffered(true);
            label3.setFocusable(false);
            label3.setOpaque(true);
            label3.setIcon(new ImageIcon("C:\\Users\\LiuSiHao\\Desktop\\2.png"));
            panel4.add(label3, CC.xy(7, 1));

            //---- label5 ----
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            label5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label5.setOpaque(true);
            label5.setIcon(new ImageIcon("C:\\Users\\LiuSiHao\\Desktop\\3.png"));
            panel4.add(label5, CC.xy(11, 1));

            //---- label6 ----
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label6.setOpaque(true);
            label6.setIcon(new ImageIcon("C:\\Users\\LiuSiHao\\Desktop\\4.png"));
            panel4.add(label6, CC.xy(15, 1));

            //---- label8 ----
            label8.setHorizontalAlignment(SwingConstants.CENTER);
            label8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label8.setOpaque(true);
            label8.setIcon(new ImageIcon("C:\\Users\\LiuSiHao\\Desktop\\5.png"));
            panel4.add(label8, CC.xy(19, 1));

            //---- label9 ----
            label9.setHorizontalAlignment(SwingConstants.CENTER);
            label9.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            label9.setOpaque(true);
            label9.setIcon(new ImageIcon("C:\\Users\\LiuSiHao\\Desktop\\6.png"));
            panel4.add(label9, CC.xy(23, 1));
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(105, 105, 105)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 113, Short.MAX_VALUE))
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label7;
    private JLabel label4;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JLabel label28;
    private JLabel label29;
    private JLabel label30;
    private JLabel label31;
    private JLabel label32;
    private JLabel label33;
    private JPanel panel3;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button2;
    private JButton button1;
    private JPanel panel4;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label6;
    private JLabel label8;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
