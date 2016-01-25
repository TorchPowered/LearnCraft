/*
 * Created by JFormDesigner on Mon Jan 25 17:20:37 ICT 2016
 */

package org.learncraft.gui;

import java.awt.event.*;
import org.learncraft.configuration.LearnCraftAssignments;
import org.learncraft.configuration.assignment.Assignment;
import org.learncraft.constants.LearnCraftFiles;
import org.learncraft.gui.dialog.AddAssignmentDialog;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Gary Lee
 */
public class AssignmentsMenuFrame extends JFrame {
    public static final DefaultListModel listModel = new DefaultListModel();

    public AssignmentsMenuFrame() {
        initComponents();
        list1.setModel(listModel);
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
                    button2.setEnabled(false);
                    return;
                }
                button2.setEnabled(true);
            }
        });
    }

    public void reloadAssignmentList() {
        listModel.clear();
        for (Assignment assignment : new LearnCraftAssignments(LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile()).getAssignmentList()) {
            listModel.addElement(assignment.getName());
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        AddAssignmentDialog addAssignmentDialog = new AddAssignmentDialog(this, this);
        addAssignmentDialog.setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        String selectedValue = (String) list1.getSelectedValue();
        new LearnCraftAssignments(LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile()).removeAssignment(selectedValue);
        list1.setSelectedIndex(-1);
        reloadAssignmentList();
    }

    private void button3ActionPerformed(ActionEvent e) {
        setVisible(false);
        MainMenuFrame mainMenuFrame = new MainMenuFrame();
        mainMenuFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gary Lee
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("LearnCraft - Assignments");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Assignments");
        label1.setFont(new Font("Minecraftia", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(0, 0, 520, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Manage assignments here.");
        label2.setFont(new Font("Minecraftia", Font.PLAIN, 14));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(0, 25, 520, 29);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Minecraftia", Font.PLAIN, 12));
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 55, 520, 450);

        //---- button1 ----
        button1.setText("Add Assignment");
        button1.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(0, 505, 260, 25);

        //---- button2 ----
        button2.setText("Remove Assignment");
        button2.setEnabled(false);
        button2.setFont(new Font("Minecraftia", Font.PLAIN, 12));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(260, 505, 260, 25);

        //---- button3 ----
        button3.setText("Home");
        button3.setFont(new Font("Minecraftia", Font.PLAIN, 20));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(135, 635, 245, 50);

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
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
