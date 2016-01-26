/*
 * Created by JFormDesigner on Mon Jan 25 18:45:36 ICT 2016
 */

package org.learncraft.gui;

import java.awt.event.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.learncraft.gui.dialog.BroadcastMessageDialog;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Gary Lee
 */
public class StudentMainMenuFrame extends JFrame {
    public static final DefaultListModel listModel = new DefaultListModel();
    public static boolean isChatEnabled = true;

    public StudentMainMenuFrame() {
        initComponents();
        list1.setModel(listModel);
        for (Player player : Bukkit.getOnlinePlayers()) {
            listModel.addElement(player.getDisplayName());
        }
        list1.addMouseListener(new MouseAdapter() {

            int lastSelectedIndex;

            public void mouseClicked(MouseEvent e) {

                int index = list1.locationToIndex(e.getPoint());

                if (index != -1 && index == lastSelectedIndex) {
                    list1.clearSelection();
                }

                lastSelectedIndex = list1.getSelectedIndex();
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(list1.getSelectedIndex() == -1){
                    button1.setEnabled(false);
                    return;
                }
                button1.setEnabled(true);
            }
        });
    }

    private void button3ActionPerformed(ActionEvent e) {
        if(button3.getText().equals("Disable Student Chat")){
            button3.setText("Enable Student Chat");
            isChatEnabled = false;
        }
        if(button3.getText().equals("Enable Student Chat")){
            button3.setText("Disable Student Chat");
            isChatEnabled = true;
        }
    }

    public void reloadPlayerList() {
        listModel.clear();
        for (Player player : Bukkit.getOnlinePlayers()) {
            listModel.addElement(player.getDisplayName());
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        BroadcastMessageDialog dialog = new BroadcastMessageDialog(this);
        dialog.setVisible(true);
    }

    private void button5ActionPerformed(ActionEvent e) {
        setVisible(false);
        MainMenuFrame mainMenuFrame = new MainMenuFrame();
        mainMenuFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gary Lee
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setTitle("LearnCraft - Student Control");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Minecraftia", Font.PLAIN, 12));
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 65, 395, 315);

        //---- label1 ----
        label1.setText("Student Control");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Minecraftia", Font.PLAIN, 28));
        contentPane.add(label1);
        label1.setBounds(0, 0, 395, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Control your students.");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        contentPane.add(label2);
        label2.setBounds(-5, 25, 395, 40);

        //---- button1 ----
        button1.setText("View Student Profile");
        button1.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button1.setEnabled(false);
        contentPane.add(button1);
        button1.setBounds(0, 380, 395, 30);

        //---- button2 ----
        button2.setText("Broadcast Message");
        button2.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(0, 415, 395, 30);

        //---- button3 ----
        button3.setText("Disable Student Chat");
        button3.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(0, 450, 395, 30);

        //---- button4 ----
        button4.setText("Broadcast Title Message");
        button4.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        contentPane.add(button4);
        button4.setBounds(0, 485, 395, 30);

        //---- button5 ----
        button5.setText("Home");
        button5.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5ActionPerformed(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(90, 540, 215, 40);

        { // compute preferred size
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gary Lee
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
