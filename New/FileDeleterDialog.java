package New;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

public class FileDeleterDialog {

    // JDialog实例
    private JDialog dialog;
    private JList<File> fileList;
    private DefaultListModel<File> listModel;

    // 构造函数，用于初始化GUI
    public FileDeleterDialog(JFrame owner, File directory) {
        initialize(owner, directory);
    }


    // 初始化GUI组件的方法
    private void initialize(JFrame owner, File directory) {
        dialog = new JDialog(owner, "文件删除器", true);
        dialog.setBounds(100, 100, 450, 300);

        // 加载文件夹中的文件
        listModel = new DefaultListModel<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    listModel.addElement(file);
                }
            }
        }

        // 创建JList组件并设置其数据模型
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 创建一个滚动窗格来包含JList
        JScrollPane scrollPane = new JScrollPane(fileList);

        // 创建一个按钮并添加动作监听器
        JButton deleteButton = new JButton("删除选定文件");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 删除选中文件
                int[] selectedIndices = fileList.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    File fileToDelete = listModel.elementAt(selectedIndices[i]);
                    try {
                        Files.delete(fileToDelete.toPath());
                        listModel.removeElementAt(selectedIndices[i]);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(dialog, "无法删除文件: " + fileToDelete.getAbsolutePath(),
                                "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // 创建一个面板来容纳滚动窗格和按钮
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.PAGE_END);

        // 将面板添加到dialog的内容窗格
        dialog.getContentPane().add(panel, BorderLayout.CENTER);
    }

    // 显示dialog的方法
    public void showDialog() {
        dialog.setVisible(true);
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        // 假设我们有一个存在的目录
        File directory = new File("D:\\模型数据"); // 替换为你的目录路径

        // 创建并显示主窗口（这只是一个示例，你可以根据需要修改）
        JFrame frame = new JFrame("主窗口");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 创建FileDeleterDialog实例并显示它
        FileDeleterDialog dialog = new FileDeleterDialog(frame, directory);
        dialog.showDialog();

        // 显示主窗口（可选）
        frame.setVisible(true);
    }
}