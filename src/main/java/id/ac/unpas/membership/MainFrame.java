/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.unpas.membership;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ghifarullah19
 */
public class MainFrame
        extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPrint = new javax.swing.JButton();
        buttonPreview = new javax.swing.JButton();
        buttonExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonPrint.setText("Print");
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });

        buttonPreview.setText("Preview");
        buttonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewActionPerformed(evt);
            }
        });

        buttonExport.setText("Export to PDF");
        buttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPreview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExport)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrint)
                    .addComponent(buttonPreview)
                    .addComponent(buttonExport))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan path direktori laporan
            String reportPath = System.getProperty("user.dir") + File.separator + "report";

            // Mendapatkan path lengkap untuk file laporan (MemberReport.jrxml)
            String path = reportPath + File.separator  + "MemberReport.jrxml";

            // Mengompilasi file laporan menjadi objek JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            // Membuat objek parameter untuk laporan
            Map<String, Object> parameters = new HashMap<>();

            // Mengisi laporan menggunakan data dari koneksi database
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                            parameters, MySqlConnection.getInstance().getConnection());

            // Mencetak laporan ke printer
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (Exception e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void buttonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan path direktori laporan
            String reportPath = System.getProperty("user.dir") + File.separator + "report";

            // Mendapatkan path lengkap untuk file laporan (MemberReport.jrxml)
            String path = reportPath + File.separator  + "MemberReport.jrxml";

            // Mengompilasi file laporan menjadi objek JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            // Membuat objek parameter untuk laporan
            Map<String, Object> parameters = new HashMap<>();

            // Mengisi laporan menggunakan data dari koneksi database
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                            parameters, MySqlConnection.getInstance().getConnection());

            // Menampilkan laporan dalam jendela pratinjau
            JasperViewer.viewReport(jasperPrint);

        } catch (Exception e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonPreviewActionPerformed

    private void buttonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan path direktori laporan
            String reportPath = System.getProperty("user.dir") + File.separator + "report";

            // Mendapatkan path lengkap untuk file laporan (MemberReport.jrxml)
            String path = reportPath + File.separator  + "MemberReport.jrxml";

            // Mengompilasi file laporan menjadi objek JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            // Membuat objek parameter untuk laporan
            Map<String, Object> parameters = new HashMap<>();

            // Mengisi laporan menggunakan data dari koneksi database
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                            parameters, MySqlConnection.getInstance().getConnection());

            // Membuat direktori jika belum ada
            File outDir = new File(reportPath);
            outDir.mkdirs();

            // Mengekspor laporan ke file PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + File.separator + "MemberReport.pdf");

            // Menampilkan pesan dialog bahwa proses ekspor selesai
            JOptionPane.showMessageDialog(this, "Export selesai");
        } catch (Exception e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonExportActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExport;
    private javax.swing.JButton buttonPreview;
    private javax.swing.JButton buttonPrint;
    // End of variables declaration//GEN-END:variables
}
