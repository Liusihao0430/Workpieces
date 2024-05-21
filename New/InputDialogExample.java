package New;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class InputDialogExample {

    private JFrame frame;

    private JTextField[] textFields;

    public InputDialogExample() {
        createInputDialog();
    }


    private  void createInputDialog() {
        textFields = new JTextField[7];

        JDialog dialog = new JDialog(frame, "输入信息", true);
        dialog.setBounds(700, 350, 400, 300);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS)); // 使用BoxLayout纵向布局

        String[] prompts = {"模型名称", "直径1", "直径2", "宽度1", "宽度2", "高度1", "高度2"}; // 提示文本数组

        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField(10);

            JPanel panel = new JPanel(new BorderLayout(5, 0));
            JLabel label = new JLabel(prompts[i] + ":", JLabel.LEFT);
            panel.add(label, BorderLayout.WEST);
            panel.add(textFields[i], BorderLayout.CENTER);

            textFields[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        saveInput();
                        dialog.dispose();
                    }
                }
            });

            dialog.add(panel);
            dialog.add(Box.createVerticalStrut(10));
        }

        dialog.setVisible(true);
    }


private void saveInput() {
    // 定义CSV文件将要保存到的文件夹路径
    String folderPath = "D:\\模型数据";

    // 创建一个File对象，表示要操作的文件夹
    File folder = new File(folderPath);

    // 检查文件夹是否存在，如果不存在则调用mkdirs()方法创建它（包括所有必要的父文件夹）
    if (!folder.exists()) {
        folder.mkdirs();
    }

    // 使用SimpleDateFormat来格式化当前日期和时间，生成一个唯一的文件名
    // 格式为"yyyyMMddHHmmss"，例如"20230913143025"
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    // 使用生成的日期时间字符串来构建文件名，并添加.csv后缀
    String fileName = "input_" + sdf.format(new java.util.Date()) + ".csv";

    // 将文件夹路径和文件名合并，形成完整的文件路径
    String filePath = folderPath + File.separator + fileName;

    // 使用try-with-resources语句来自动关闭BufferedWriter，并尝试打开文件以写入数据
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        // 遍历textFields数组，将每个文本框的内容写入CSV文件
        for (int i = 0; i < textFields.length; i++) {
            // 如果不是第一个字段（即i > 0），则写入逗号作为字段分隔符
            if (i > 0) {
                writer.write(",");
            }
            // 写入当前文本框的内容
            writer.write(textFields[i].getText());
        }
        // 写入新行，以便在CSV文件中形成新的记录
        writer.newLine();

        // 显示一个消息框，告知用户信息已成功保存到CSV文件
        JOptionPane.showMessageDialog(frame, "信息已保存到CSV文件: " + filePath);
    } catch (IOException e) {
        // 如果在写入文件时发生异常，显示一个错误消息框
        JOptionPane.showMessageDialog(frame, "保存CSV文件时发生错误: " + e.getMessage());
        // 打印堆栈跟踪到控制台，以便调试
        e.printStackTrace();
    }}
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InputDialogExample());// 在Swing线程中创建窗口
    }}

