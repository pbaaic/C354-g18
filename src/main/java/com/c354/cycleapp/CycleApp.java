package com.c354.cycleapp;

import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.ConsoleEvent;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JList;

public class CycleApp extends JFrame {

    public CycleApp() {
        initComponents();
        open_site();
    }

    /**
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapview_button_group = new javax.swing.ButtonGroup();
        main_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        map_panel = new javax.swing.JPanel();
        ride_pane = new javax.swing.JScrollPane();
        ride_list = new javax.swing.JList<>();
        ride_label = new javax.swing.JLabel();
        splitinterval_label = new javax.swing.JLabel();
        split_interval = new javax.swing.JComboBox<>();
        cyclosm_button = new javax.swing.JToggleButton();
        streetview_button = new javax.swing.JToggleButton();
        satellite_button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(225, 239, 253));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title_label.setForeground(new java.awt.Color(0, 153, 255));
        title_label.setText("Cycle App");
        main_panel.add(title_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        map_panel.setLayout(new java.awt.BorderLayout());
        main_panel.add(map_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 360, 380));

        ride_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Workout 2021-06-06", "Workout 2021-06-18", "Workout 2021-07-10", "Workout 2021-07-17", "G16 Integration Test" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ride_pane.setViewportView(ride_list);

        main_panel.add(ride_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 130));

        ride_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ride_label.setText("Ride List");
        main_panel.add(ride_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        splitinterval_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        splitinterval_label.setText("Split Interval:");
        main_panel.add(splitinterval_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        split_interval.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 km", "5 km", "10 km", "15 km" }));
        split_interval.setFocusable(false);
        split_interval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                split_intervalActionPerformed(evt);
            }
        });
        main_panel.add(split_interval, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 90, -1));

        mapview_button_group.add(cyclosm_button);
        cyclosm_button.setText("CyclOSM View");
        cyclosm_button.setFocusPainted(false);
        cyclosm_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cyclosm_buttonActionPerformed(evt);
            }
        });
        main_panel.add(cyclosm_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        mapview_button_group.add(streetview_button);
        streetview_button.setText("Street View");
        streetview_button.setFocusPainted(false);
        streetview_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetview_buttonActionPerformed(evt);
            }
        });
        main_panel.add(streetview_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        mapview_button_group.add(satellite_button);
        satellite_button.setText("Satellite View");
        satellite_button.setFocusPainted(false);
        satellite_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satellite_buttonActionPerformed(evt);
            }
        });
        main_panel.add(satellite_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 640));

        setBounds(0, 0, 372, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void split_intervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_split_intervalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_split_intervalActionPerformed
    CharSequence street = "&amp;distance";
    CharSequence satellite = "&amp;source=satellite";
    CharSequence cosm = "&amp;source=cosm";
    String replace = "";
    private void cyclosm_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cyclosm_buttonActionPerformed
        int current = ride_list.getSelectedIndex();
        if (browser.getHTML().contains(satellite)) {
            replace = browser.getHTML().replace(satellite, cosm);
        } else if (browser.getHTML().contains(street)) {
            replace = browser.getHTML().replace(street, cosm);
        }
        browser.loadHTML(replace);
        mapview_button_group.clearSelection();
    }//GEN-LAST:event_cyclosm_buttonActionPerformed

    private void streetview_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetview_buttonActionPerformed
        int current = ride_list.getSelectedIndex();
        if (browser.getHTML().contains(satellite)) {
            replace = browser.getHTML().replace(satellite, street);
        } else if (browser.getHTML().contains(cosm)) {
            replace = browser.getHTML().replace(cosm, street);
        }
        browser.loadHTML(replace);
        mapview_button_group.clearSelection();
    }//GEN-LAST:event_streetview_buttonActionPerformed

    private void satellite_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satellite_buttonActionPerformed
        //System.out.print(browser.getHTML());
        int current = ride_list.getSelectedIndex();
        //System.out.print(current);
        if (browser.getHTML().contains(street)) {
            replace = browser.getHTML().replace(street, satellite);
        } else if (browser.getHTML().contains(cosm)) {
            replace = browser.getHTML().replace(cosm, satellite);
        }
        browser.loadHTML(replace);
        mapview_button_group.clearSelection();
        //System.out.print(current);
        //System.out.println("");
        //System.out.print(browser.getHTML());
    }//GEN-LAST:event_satellite_buttonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CycleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CycleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CycleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CycleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CycleApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cyclosm_button;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel map_panel;
    private javax.swing.ButtonGroup mapview_button_group;
    private javax.swing.JLabel ride_label;
    private javax.swing.JList<String> ride_list;
    private javax.swing.JScrollPane ride_pane;
    private javax.swing.JToggleButton satellite_button;
    private javax.swing.JComboBox<String> split_interval;
    private javax.swing.JLabel splitinterval_label;
    private javax.swing.JToggleButton streetview_button;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables

    Browser browser;
    BrowserView view;

    private void open_site() {
        BrowserUtil.setVersion(Version.V6_22);

        browser = new Browser();
        view = new BrowserView(browser);

        map_panel.add(view, BorderLayout.CENTER);

        browser.addTitleListener((TitleEvent evt) -> {
            setTitle(evt.getTitle());
        });
        browser.addConsoleListener((ConsoleEvent evt) -> {
            System.out.println("LOG: " + evt.getMessage());
        });

        browser.addLoadListener(new LoadAdapter() {
            @Override
            public void onFinishLoadingFrame(FinishLoadingEvent evt) {
                evt.getBrowser().setZoomLevel(-2);
            }
        ;
        });
        browser.loadURL("C:\\HTMLGmaps\\simple_map.html");

        ride_list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = ride_list.locationToIndex(evt.getPoint());
                    switch (index) {
                        case 0:
                            browser.loadHTML("<iframe src=\"https://gpx.studio/?state=%7B%22ids%22:%5B%221ETBK7UyreipM5Gr7TtFb0cg4nap2O_Fu%22%5D%7D&embed&token=pk.eyJ1IjoiYzM1NGdwIiwiYSI6ImNsMTkzdzFvMDR5OTUzYnBrOG1lOG84ODkifQ.5z_eVrxohLKmHzXqaZAxdw&running&distance&direction\" width=\"100%\" height=\"500\" frameborder=\"0\" allowfullscreen><p><a href=\"https://gpx.studio/?state=%7B%22ids%22:%5B%221ETBK7UyreipM5Gr7TtFb0cg4nap2O_Fu%22%5D%7D></a></p></iframe>");
                            break;
                        case 1:
                            browser.loadHTML("<iframe src=\"https://gpx.studio/?state=%7B%22ids%22:%5B%221HpeedYjC51JP4j84kHMNz7LfOmadvAwT%22%5D%7D&embed&token=pk.eyJ1IjoiYzM1NGdwIiwiYSI6ImNsMTkzdzFvMDR5OTUzYnBrOG1lOG84ODkifQ.5z_eVrxohLKmHzXqaZAxdw&running&distance&direction\" width=\"100%\" height=\"500\" frameborder=\"0\" allowfullscreen><p><a href=\"https://gpx.studio/?state=%7B%22ids%22:%5B%221HpeedYjC51JP4j84kHMNz7LfOmadvAwT%22%5D%7D></a></p></iframe>");
                            break;
                        case 2:
                            browser.loadHTML("<iframe src=\"https://gpx.studio/?state=%7B%22ids%22:%5B%2218ehq0zBMpCWv3N8eubdHLT9Q0__CQeOR%22%5D%7D&embed&token=pk.eyJ1IjoiYzM1NGdwIiwiYSI6ImNsMTkzdzFvMDR5OTUzYnBrOG1lOG84ODkifQ.5z_eVrxohLKmHzXqaZAxdw&running&distance&direction\" width=\"100%\" height=\"500\" frameborder=\"0\" allowfullscreen><p><a href=\"https://gpx.studio/?state=%7B%22ids%22:%5B%2218ehq0zBMpCWv3N8eubdHLT9Q0__CQeOR%22%5D%7D></a></p></iframe>");
                            break;
                        case 3:
                            browser.loadHTML("<iframe src=\"https://gpx.studio/?state=%7B%22ids%22:%5B%221LbMiqc5WxSGvDOiMMA-s2Ar5JzYCBH_V%22%5D%7D&embed&token=pk.eyJ1IjoiYzM1NGdwIiwiYSI6ImNsMTkzdzFvMDR5OTUzYnBrOG1lOG84ODkifQ.5z_eVrxohLKmHzXqaZAxdw&running&distance&direction\" width=\"100%\" height=\"500\" frameborder=\"0\" allowfullscreen><p><a href=\"https://gpx.studio/?state=%7B%22ids%22:%5B%221LbMiqc5WxSGvDOiMMA-s2Ar5JzYCBH_V%22%5D%7D></a></p></iframe>");
                            break;
                        case 4:
                            browser.loadHTML("<iframe src=\"https://gpx.studio/?state=%7B%22ids%22:%5B%2210IbXh7W7QDO7ZKmapJYdcgN3vhdN2Q-e%22%5D%7D&embed&token=pk.eyJ1IjoiYzM1NGdwIiwiYSI6ImNsMTkzdzFvMDR5OTUzYnBrOG1lOG84ODkifQ.5z_eVrxohLKmHzXqaZAxdw&distance\" width=\"100%\" height=\"500\" frameborder=\"0\" allowfullscreen><p><a href=\"https://gpx.studio/?state=%7B%22ids%22:%5B%2210IbXh7W7QDO7ZKmapJYdcgN3vhdN2Q-e%22%5D%7D></a></p></iframe>");
                        default:
                            break;
                    }
                }
            }
        });
    }
}
