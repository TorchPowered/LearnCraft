/*
 * Created by JFormDesigner on Mon Jan 25 16:58:15 ICT 2016
 */

package org.learncraft.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Gary Lee
 */
public class MainMenuFrame extends JFrame {
    public MainMenuFrame() {
        initComponents();
    }

    private void button8ActionPerformed(ActionEvent e) {
        setVisible(false);
        AssignmentsMenuFrame assignmentsMenuFrame = new AssignmentsMenuFrame();
        assignmentsMenuFrame.setVisible(true);
    }

    private void button7ActionPerformed(ActionEvent e) {
        setVisible(false);
        Bukkit.shutdown();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kickPlayer(ChatColor.RED + "Your teacher has ended this LearnCraft session.");
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        setVisible(false);
        StudentMainMenuFrame studentMainMenuFrame = new StudentMainMenuFrame();
        studentMainMenuFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gary Lee
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        setTitle("LearnCraft");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Control Panel");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Minecraftia", Font.PLAIN, 24));
        contentPane.add(label1);
        label1.setBounds(0, 5, 580, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Everything under your control.");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        contentPane.add(label2);
        label2.setBounds(0, 35, 580, 34);

        //---- button1 ----
        button1.setText("Manage your students");
        button1.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(0, 95, 580, 35);

        //---- button4 ----
        button4.setText("Manage LearnCraft additions");
        button4.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button4.setEnabled(false);
        contentPane.add(button4);
        button4.setBounds(0, 385, 580, 35);

        //---- button5 ----
        button5.setText("Minecraft Forums");
        button5.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button5.setEnabled(false);
        contentPane.add(button5);
        button5.setBounds(0, 435, 580, 35);

        //---- button6 ----
        button6.setText("GitHub");
        button6.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button6.setEnabled(false);
        contentPane.add(button6);
        button6.setBounds(0, 485, 580, 35);

        //---- button7 ----
        button7.setText("End LearnCraft session");
        button7.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button7ActionPerformed(e);
            }
        });
        contentPane.add(button7);
        button7.setBounds(0, 585, 580, 35);

        //---- button8 ----
        button8.setText("Manage assignments");
        button8.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button8ActionPerformed(e);
            }
        });
        contentPane.add(button8);
        button8.setBounds(0, 140, 580, 35);

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
        setSize(595, 675);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gary Lee
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
