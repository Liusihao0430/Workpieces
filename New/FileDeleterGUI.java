package New;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileDeleterGUI {

    JFrame frame;
    private JList<String> fileList;
    private DefaultListModel<String> listModel;

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    FileDeleterGUI window = new FileDeleterGUI();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public FileDeleterGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(650, 350, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 加载文件夹中的文件
        String folderPath = "D:\\模型数据";
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> !name.startsWith(".") && !new File(dir, name).isDirectory());

        if (files != null) {
            listModel = new DefaultListModel<>();
            for (File file : files) {
                listModel.addElement(file.getName());
            }
        }

        fileList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(fileList);

        JButton deleteButton = new JButton("删除选定文件");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndices = fileList.getSelectedIndices();
                for (int index : selectedIndices) {
                    String fileName = listModel.get(index);
                    Path filePath = Paths.get(folderPath, fileName);
                    try {
                        Files.deleteIfExists(filePath);
                        listModel.removeElementAt(index);
                        // 注意：如果删除后需要更新UI，可以在这里调用方法
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "删除文件时发生错误: " + fileName, "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());// 设置面板的布局为边界布局
        panel.add(scrollPane, BorderLayout.CENTER);// 添加滚动面板到面板的中央
        panel.add(deleteButton, BorderLayout.PAGE_END);// 添加删除按钮到面板的底部

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}