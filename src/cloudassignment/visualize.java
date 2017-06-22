package cloudassignment;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class visualize extends javax.swing.JFrame{
	private HashMap hm = new HashMap();
	private JComboCheckBox jccb;
	private JCheckBox b;
	private String accepted[] = new String[100];
        private JPanel jPanel1 = new JPanel();  
        private JLabel jLabel1;
        private JButton generateBtn;
        private Vector v = new Vector();
        private JCheckBox cb[];

	public visualize(HashMap myhash){
                super("Visualize words");
            
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation(dim.width/3-this.getSize().width/3, dim.height/3-this.getSize().height/3);
            
                hm = myhash;
                jLabel1 = new JLabel("List of words\n");
                generateBtn = new JButton("Generate");
                
                generateBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        generateBtnActionPerformed(evt);
                    }
                });
                
                fillCombo();
                
                jPanel1.add(jLabel1);
                jPanel1.add(jccb);
                jPanel1.add(generateBtn);
                add(jPanel1);
	}
        
        public void fillCombo(){
            
            cb = new JCheckBox[hm.size()];
            
            Set set = hm.entrySet();
            Iterator it = set.iterator();
            
            for(int i=0; it.hasNext(); i++){
                Map.Entry me = (Map.Entry)it.next();
                cb[i] = new JCheckBox(me.getKey().toString());
                v.add(cb[i]);
            }
            jccb = new JComboCheckBox(v);
            
        }
        
        private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed

            int ct=0;
            for(int i=0; i<v.size(); i++){
                if(cb[i].isSelected()){
                    accepted[ct] = cb[i].getText();
                    System.out.println(accepted[ct] + ":" + v.size());
                    ct++;
                }
            }
            System.out.println("here" + ct);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(int i=0; i<ct; i++){
                System.out.println(accepted[i]);
            }
            //JOptionPane.showMessageDialog(null, "printintg" + accepted[0], "Error", JOptionPane.PLAIN_MESSAGE);
            //dataset.setValue((int)(hm.get(accepted[0])) , accepted[0], "count");
            for(int i=0; i<ct; i++){
                //JOptionPane.showMessageDialog(null, "printintg" + accepted[i] + ":" + i, "Error", JOptionPane.PLAIN_MESSAGE);
                //dataset.setValue((int) (hm.get(accepted[i])), accepted[i], "occurences");
                dataset.setValue((int) (hm.get(accepted[i])), "occurences", accepted[i]);
            }

            JFreeChart chart = ChartFactory.createBarChart("Word Count", 
                    "Words", 
                    "Counts", 
                    dataset, PlotOrientation.VERTICAL, 
                    false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame = new ChartFrame("Bar chart for word counts", chart);
            frame.setVisible(true);
            frame.setSize(550, 450);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/3-this.getSize().width/3, dim.height/3-this.getSize().height/3);
        }//GEN-LAST:event_generateBtnActionPerformed
}