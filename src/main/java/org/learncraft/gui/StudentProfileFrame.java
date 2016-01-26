/*
 * Created by JFormDesigner on Mon Jan 25 19:15:10 ICT 2016
 */

package org.learncraft.gui;

import java.awt.event.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.learncraft.gui.dialog.SendMessageDialog;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Gary Lee
 */
public class StudentProfileFrame extends JFrame {
    public static ArrayList<Player> mutedPlayers = new ArrayList<Player>();

    private String studentName;
    private Player player;

    public StudentProfileFrame(String studentName)  {
        this.studentName = studentName;
        this.player = Bukkit.getPlayer(studentName);
        initComponents();
        setTitle("Student Profile - " + studentName);
        label1.setText(this.studentName);
        for (Player mutedPlayer : mutedPlayers) {
            if(this.player == mutedPlayer) {
                button3.setText("Unmute Student Chat");
            }
        }
    }

    private void button5ActionPerformed(ActionEvent e) {
        player.getWorld().strikeLightning(player.getLocation());
    }

    private void button4ActionPerformed(ActionEvent e) {
        player.setHealth(0.0);
    }

    private void button3ActionPerformed(ActionEvent e) {
        if(button3.getText().equals("Mute student chat")){
            button3.setText("Unmute student chat");
            mutedPlayers.add(player);
            return;
        }
        button3.setText("Mute student chat");
        mutedPlayers.remove(player);
        return;
    }

    private void button1ActionPerformed(ActionEvent e) {
        player.kickPlayer(ChatColor.RED + "Your teacher has kicked you out of this session.");
    }

    private void button2ActionPerformed(ActionEvent e) {
        SendMessageDialog messageDialog = new SendMessageDialog(player, this);
        messageDialog.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gary Lee
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setTitle("Student Profile");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Steve");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Minecraftia", Font.BOLD, 26));
        contentPane.add(label1);
        label1.setBounds(0, 50, 385, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Student Profile Page");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        contentPane.add(label2);
        label2.setBounds(0, 75, 385, 38);

        //---- button1 ----
        button1.setText("Kick from Session");
        button1.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        button1.setEnabled(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(0, 365, 385, 50);

        //---- button2 ----
        button2.setText("Send Message");
        button2.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(0, 315, 385, 50);

        //---- button3 ----
        button3.setText("Mute student chat");
        button3.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(0, 265, 385, 50);

        //---- button4 ----
        button4.setText("Kill player");
        button4.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4ActionPerformed(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(0, 215, 385, 50);

        //---- button5 ----
        button5.setText("Strike with Lightning");
        button5.setFont(new Font("Minecraftia", Font.PLAIN, 16));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5ActionPerformed(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(0, 165, 385, 50);

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
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
