/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudassignment;

/**
 *
 * @author hp
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class JComboCheckBox extends JComboBox {
  public JComboCheckBox() { addStuff(); }
  public JComboCheckBox(JCheckBox[] items) { super(items); addStuff(); }
  public JComboCheckBox(Vector items) { super(items); addStuff(); }
  public JComboCheckBox(ComboBoxModel aModel) { super(aModel); addStuff(); }
  private void addStuff() {
    setRenderer(new ComboBoxRenderer());
    addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) { itemSelected(); }
    });
  }
  private void itemSelected() {
    if (getSelectedItem() instanceof JCheckBox) {
      JCheckBox jcb = (JCheckBox)getSelectedItem();
      jcb.setSelected(!jcb.isSelected());
    }
  }
  class ComboBoxRenderer implements ListCellRenderer {
    private JLabel defaultLabel;
    public ComboBoxRenderer() { setOpaque(true); }
    public Component getListCellRendererComponent(JList list, Object value, int index,
    		    boolean isSelected, boolean cellHasFocus) {
      if (value instanceof Component) {
        Component c = (Component)value;
        if (isSelected) {
          c.setBackground(list.getSelectionBackground());
          c.setForeground(list.getSelectionForeground());
        } else {
          c.setBackground(list.getBackground());
          c.setForeground(list.getForeground());
        }
        return c;
      } else {
        if (defaultLabel==null) defaultLabel = new JLabel(value.toString());
        else defaultLabel.setText(value.toString());
        return defaultLabel;
      }
    }
  }
}
