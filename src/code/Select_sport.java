/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tehyi
 */
public class Select_sport extends javax.swing.JFrame {

    /**
     * Creates new form Select_sport
     */
    ImageIcon background= new ImageIcon("swim-coach-regis.png");
    Students student = new Students();
    Sports spt = new Sports();
    
    public Select_sport() {
        initComponents();
    }
    
    public Select_sport(Students student){
        initComponents();
        this.student = student;
        String[] array = spt.readname_to_array(student.get_c_code());
        for(int i=0; i<array.length;i++){
           sport_select.insertItemAt(array[i],i);
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

        sport_select = new javax.swing.JComboBox<>();
        Next_pg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sport_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sport_selectActionPerformed(evt);
            }
        });
        getContentPane().add(sport_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 76, -1, -1));

        Next_pg.setText("Next");
        Next_pg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Next_pgActionPerformed(evt);
            }
        });
        getContentPane().add(Next_pg, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 189, -1, -1));

        jLabel1.setText("Please Select Your Sport");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 42, -1, -1));

        jLabel2.setText("jLabel2");
        jLabel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void sport_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sport_selectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sport_selectActionPerformed

    private void Next_pgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Next_pgActionPerformed
        // TODO add your handling code here:
        String[] array1 = spt.readid_to_array(student.get_c_code());
        int idx = sport_select.getSelectedIndex();
        student.set_s_code(array1[idx]);
        Select_coach sch = new Select_coach(student);
        sch.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Next_pgActionPerformed

    private void jLabel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel2AncestorAdded
        // TODO add your handling code here:
        jLabel2.setIcon(background);
    }//GEN-LAST:event_jLabel2AncestorAdded

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
            java.util.logging.Logger.getLogger(Select_sport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Select_sport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Select_sport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Select_sport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Select_sport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Next_pg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> sport_select;
    // End of variables declaration//GEN-END:variables
}
