/*
 * Created by JFormDesigner on Mon Jan 25 17:28:08 ICT 2016
 */

package org.learncraft.gui.dialog;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.learncraft.configuration.LearnCraftAssignments;
import org.learncraft.configuration.assignment.Assignment;
import org.learncraft.constants.LearnCraftFiles;
import org.learncraft.gui.AssignmentsMenuFrame;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Gary Lee
 */
public class AddAssignmentDialog extends JDialog {
    private AssignmentsMenuFrame menu;

    public AddAssignmentDialog(AssignmentsMenuFrame menu, Frame owner) {
        super(owner);
        initComponents();
        this.menu = menu;
    }

    public AddAssignmentDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        menu.reloadAssignmentList();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        if(textField1.getText() == null || textField2.getText() == null || textArea1.getText() == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all of the form to add the assignment.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String name = textField1.getText();
        String description = textArea1.getText();
        String date = textField2.getText();
        Date date1;
        try {
            Date theDate = LearnCraftAssignments.getDateFormat().parse(date);
            date1 = theDate;
        } catch (ParseException e1) {
            JOptionPane.showMessageDialog(this, "The date filled in the date text field was not in the correct format.", "Error", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
            return;
        }
        new LearnCraftAssignments(LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile()).newAssignment(name, description, date1);
        setVisible(false);
        menu.reloadAssignmentList();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.GOLD + "Your teacher has assigned a new assignment called " + name + " with the due date of " + date + "! Do /assignments to check for more information!");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gary Lee
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label3 = new JLabel();
        textField2 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Add Assignment");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);
                contentPanel.add(textField1);
                textField1.setBounds(15, 20, 330, textField1.getPreferredSize().height);

                //---- label1 ----
                label1.setText("Name of assignment");
                contentPanel.add(label1);
                label1.setBounds(new Rectangle(new Point(15, 0), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("Description of assignment");
                contentPanel.add(label2);
                label2.setBounds(15, 45, 170, 16);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textArea1);
                }
                contentPanel.add(scrollPane1);
                scrollPane1.setBounds(15, 65, 330, 90);

                //---- label3 ----
                label3.setText("Due Date (please follow format: month/day/year)");
                contentPanel.add(label3);
                label3.setBounds(new Rectangle(new Point(15, 160), label3.getPreferredSize()));
                contentPanel.add(textField2);
                textField2.setBounds(15, 180, 330, textField2.getPreferredSize().height);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonActionPerformed(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gary Lee
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label3;
    private JTextField textField2;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
