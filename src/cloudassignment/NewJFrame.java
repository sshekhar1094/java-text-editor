/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudassignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Shashank Shekhar
 */
public class NewJFrame extends javax.swing.JFrame {
    
    private int current;
    private HashMap hm = new HashMap();
    private Highlighter.HighlightPainter highlightobj = new MyHighlightPainter(Color.yellow);
    private Highlighter.HighlightPainter highlightobjred = new MyHighlightPainter(Color.red);
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame(HashMap myhash) {
        super("Java text editor");
        hm = myhash;
        initComponents();
        browseFileText.setEditable(false);
    }
    
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter{
        public MyHighlightPainter(Color color){
            super(color);
        }
    }
    
    public Highlighter getHilite(JTextComponent textComp){
        Highlighter hilite = textComp.getHighlighter();
        return hilite;
    }
    
    public void changeHighlight(String text) {
        Highlighter highlighter = mainTextArea.getHighlighter();
        highlighter.removeAllHighlights();
        Document doc = mainTextArea.getDocument();
        try {
            int flags = Pattern.CASE_INSENSITIVE ;
            Pattern pattern = Pattern.compile(text, flags);
            if (pattern != null) {
                Matcher matcher = pattern.matcher(doc.getText(0, doc.getLength()));
                int pos = 0;
                while (matcher.find(pos)) {
                    int start = matcher.start();
                    int end   = matcher.end();
                    highlighter.addHighlight(start, end, highlightobj);
                    pos = end;
                }
            }
            Highlighter.Highlight[] hilites = highlighter.getHighlights();
            int hits = hilites.length;
            if (hits == 0) {
                current = -1;
            } else {
                current = (current + hits) % hits;
                highlighter.removeHighlight(hilites[current]);
                highlighter.addHighlight(hilites[current].getStartOffset(), hilites[current].getEndOffset(), highlightobjred);
                
                Rectangle viewRect = mainTextArea.modelToView(hilites[current].getStartOffset());
                mainTextArea.scrollRectToVisible(viewRect);
            }
            resultLabel.setText(String.format("Showing %02d of %d", current + 1, hits));

            hm.put(text, hits);
            
//            Set set = hm.entrySet();
//            Iterator i = set.iterator();
//            while(i.hasNext()){
//                Map.Entry me = (Map.Entry)i.next();
//                System.out.println(me.getKey() + ": " + me.getValue());
//            }
            
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        searchText = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        previousBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTextArea = new javax.swing.JTextArea();
        browseFileText = new javax.swing.JTextField();
        visualizeBtn = new javax.swing.JButton();
        browseBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        previousBtn.setText("<");
        previousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtnActionPerformed(evt);
            }
        });

        nextBtn.setText(">");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        mainTextArea.setColumns(20);
        mainTextArea.setRows(5);
        jScrollPane1.setViewportView(mainTextArea);

        browseFileText.setText("Click Browse to select your file");

        visualizeBtn.setText("Visualize");
        visualizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizeBtnActionPerformed(evt);
            }
        });

        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter search Text:");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(browseFileText, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visualizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchText)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBtn)
                        .addComponent(previousBtn)
                        .addComponent(nextBtn)
                        .addComponent(jLabel1))
                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseFileText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(visualizeBtn)
                        .addComponent(browseBtn)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String pattern = searchText.getText();
        if(pattern==null || pattern.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter text first", "Title", JOptionPane.WARNING_MESSAGE);
        }
        else {
            current = 0;
            changeHighlight(pattern);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        String pattern = searchText.getText();
        if(pattern==null || pattern.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter text first", "Title", JOptionPane.WARNING_MESSAGE);
        }
        else {
            current = 0;
            changeHighlight(pattern);
        }
    }//GEN-LAST:event_searchTextActionPerformed

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        hm.clear();
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getAbsolutePath();
        browseFileText.setText(fileName);
        this.setTitle(fileName);
        mainTextArea.setFont(new Font("Monospaced",Font.PLAIN,14));
        
        try {
            BufferedReader bfrd = new BufferedReader(new FileReader(file));
            String line = bfrd.readLine();
            mainTextArea.setText(null);
            while (line != null) {
                mainTextArea.append(' ' + line + '\n');
                line = bfrd.readLine();
            }
        } catch (Exception e) {
            //System.out.println("Error in opening file");
            JOptionPane.showMessageDialog(null, "Error in opening file", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_browseBtnActionPerformed

    private void previousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtnActionPerformed
        String pattern = searchText.getText();
        if(pattern==null || pattern.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter text first", "Title", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(current == 0) current = 0;
        else current--;
        changeHighlight(searchText.getText());
    }//GEN-LAST:event_previousBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        String pattern = searchText.getText();
        if(pattern==null || pattern.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter text first", "Title", JOptionPane.WARNING_MESSAGE);
            return;
        }
        current++;
        changeHighlight(searchText.getText());
    }//GEN-LAST:event_nextBtnActionPerformed
    
    private void visualizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizeBtnActionPerformed
        visualize vis = new visualize(hm);
        vis.setVisible(true);
        vis.setSize(300, 150);
//        visualizeFrame visl = new visualizeFrame(hm);
//        visl.setVisible(true);
    }//GEN-LAST:event_visualizeBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseBtn;
    private javax.swing.JTextField browseFileText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea mainTextArea;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton previousBtn;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchText;
    private javax.swing.JButton visualizeBtn;
    // End of variables declaration//GEN-END:variables
}
