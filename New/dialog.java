/*
 * Created by JFormDesigner on Sun Apr 28 15:18:20 CST 2024
 */

package New;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author LiuSiHao
 */
public class dialog extends JDialog {
    public dialog()
    {
        initComponents();
        panel1.setBorder(new TitledBorder("NEW模型"));
        initComponents1();
        // 将 panel1 添加到内容窗格中
        getContentPane().add(panel1, BorderLayout.CENTER);
        // 从文件夹加载数据到JTable
        loadDataFromFolder("D:\\模型数据");
    }
    private JTable table;
    private void initComponents1() {
        // 定义列名
        String[] columnNames = {"所在文件夹名","项目名称", "直径一", "直径二", "高度一", "高度二", "宽度一", "宽度二"};

        // 创建一个空的DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // 创建JTable并设置模型
        table = new JTable(model);

        // 添加JTable到JScrollPane中
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加滚动面板到对话框中
        add(scrollPane, BorderLayout.CENTER);
        // 添加滚动面板到 panel1 中
        panel1.add(scrollPane, BorderLayout.CENTER);
        // 设置滚动面板的边界
        scrollPane.setBounds(0, 0, 690, 305);
        //显示
        setVisible(true);
    }
    private void loadDataFromFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            JOptionPane.showMessageDialog(this, "文件夹不存在或不是目录！");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // 清空表格数据

        String folderName = "模型数据";
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line = reader.readLine(); // 假设每行包含所有信息
                    if (line != null) {
                        String[] values = line.split(","); // 使用逗号分隔值
                        if (values.length >= 7) { // 因为我们不再包括文件名作为一列，所以只需要6个值
                            // 假设文件名（不含扩展名）即为项目名称
                            //String projectName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                            Object[] rowData = new Object[]{ folderName, values[0], values[1], values[2], values[3], values[4], values[5],values[6]};
                            model.addRow(rowData);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "读取文件时出错：" + file.getName());
                }
            }
        }
    }
    
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        new InputDialogExample();
    }

        private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        run();
    }
    public void run() {
        try {
            FileDeleterGUI window = new FileDeleterGUI();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();// 打印异常信息
        }
    }
    private JList<File> fileList;
    private DefaultListModel<File> listModel;

//    public void Dialog () {
//        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        setSize(800, 350);
//        setLocationRelativeTo(null); // 居中显示
//        initComponents4();
//    }
//
//    private void initComponents4() {
//        // 创建文件列表模型
//        listModel = new DefaultListModel<>();
//        File folder = new File("D:\\模型数据");
//        if (folder.exists() && folder.isDirectory()) {
//            File[] files = folder.listFiles();
//            if (files != null) {
//                for (File file : files) {
//                    if (!file.isDirectory()) {
//                        listModel.addElement(file);
//                    }
//                }
//            }
//        }
//
//        // 创建文件列表
//        fileList = new JList<>(listModel);
//        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane scrollPane = new JScrollPane(fileList);
//
//        // 创建删除按钮
//        JButton deleteButton = new JButton("删除选定文件");
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int[] selectedIndices = fileList.getSelectedIndices();
//                for (int i = 0; i < selectedIndices.length; i++) {
//                    File fileToDelete = listModel.elementAt(selectedIndices[i]);
//                    if (fileToDelete.delete()) {
//                        listModel.removeElementAt(selectedIndices[i] - (i > 0 ? selectedIndices.length - i - 1 : 0));
//                    } else {
//                        JOptionPane.showMessageDialog(null, "无法删除文件: " + fileToDelete.getAbsolutePath(),
//                                "错误", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            }
//        });
//
//        // 布局组件
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(scrollPane, BorderLayout.CENTER);
//        panel.add(deleteButton, BorderLayout.PAGE_END);
//        getContentPane().add(panel, BorderLayout.CENTER);
//
//    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        setMinimumSize(new Dimension(19, 37));
        setBackground(new Color(0x0099ff));
        setForeground(SystemColor.inactiveCaption);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel2 ========
        {
            panel2.setLayout(new FormLayout(
                "219dlu, 3*($lcgap, 45dlu)",
                "default"));

            //---- button2 ----
            button2.setText("\u521b\u5efa");
            button2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            button2.setForeground(Color.black);
            button2.setBackground(Color.white);
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel2.add(button2, CC.xy(3, 1));

            //---- button3 ----
            button3.setText("\u5220\u9664");
            button3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
            button3.setForeground(Color.black);
            button3.setBackground(Color.white);
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel2.add(button3, CC.xy(7, 1));
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 355, panel2.getPreferredSize().width, 30);

        //======== panel1 ========
        {

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGap(0, 100, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGap(0, 100, Short.MAX_VALUE)
            );
        }
        contentPane.add(panel1);
        panel1.setBounds(20, 15, 690, 305);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JButton button2;
    private JButton button3;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
