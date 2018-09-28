
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MiniExplorerGUI extends javax.swing.JFrame {

    private FileModell bl = new FileModell();
    private File dir = new File("/Users/mikeykahr/Desktop/Privat/SCHULE/POS/3.Klasse/Exercises/Exercise102/Exercise102");

    public MiniExplorerGUI() {
        initComponents();
        liOut.setModel(bl);
        liOut.setCellRenderer(new FileListRenderer());

        bl.add(new Datei(dir.getAbsolutePath() + "/.."));
        for (File f : dir.listFiles()) {
            bl.add(new Datei(f.getAbsolutePath()));
            //System.out.println(f.getAbsolutePath());
        }
    }

    public void addThings(File di) {
        dir = di;
        bl.clearList();
        bl.add(new Datei(di.getAbsolutePath() + "/.."));
        System.out.println(di);
        for (File f : di.listFiles()) {
            bl.add(new Datei(f.getAbsolutePath()));
            //System.out.println(f.getAbsolutePath());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        liOut = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        liOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liOutMouseClicked(evt);
            }
        });
        liOut.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                liOutValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(liOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void liOutValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_liOutValueChanged

    }//GEN-LAST:event_liOutValueChanged

    private void liOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liOutMouseClicked
        if (evt.getClickCount() == 2) {
            if (liOut.getSelectedValue().getName().equalsIgnoreCase("..")) {
                addThings(new File(dir.getParent()));
            } else if (liOut.getSelectedValue().isDirectory()) {
                File t = new File(dir + "/" + liOut.getSelectedValue().getName());
                addThings(t);
            } else{
                Desktop desktop = Desktop.getDesktop();
                System.out.println("is a file");
                File fi = new File(dir+"/"+liOut.getSelectedValue().getName());
                try {
                    desktop.open(fi);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "File could not be opened");
                }
            }

        }
    }//GEN-LAST:event_liOutMouseClicked
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniExplorerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Datei> liOut;
    // End of variables declaration//GEN-END:variables
}
