/*
 * JFrGamesOptions.java
 */
package info.vannier.gotha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  Administrateur
 */
public class JFrGamesOptions extends javax.swing.JFrame {

    private static final long REFRESH_DELAY = 2000;
    private long lastComponentsUpdateTime = 0;
    private TournamentInterface tournament;

    private volatile boolean running = true;
    javax.swing.Timer timer = null;
    private void setupRefreshTimer() {
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!running){
                    timer.stop();
                }
                try {
                    if (tournament.getLastTournamentModificationTime() > lastComponentsUpdateTime) {
                        updateAllViews();
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(JFrGamesResults.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        timer = new javax.swing.Timer((int) REFRESH_DELAY, taskPerformer);
        timer.start();
    }

    public JFrGamesOptions(TournamentInterface tournament) throws RemoteException {
        this.tournament = tournament;

        initComponents();
        customInitComponents();
        setupRefreshTimer();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpComplTimeSystem = new javax.swing.ButtonGroup();
        pnlGam = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfSize = new javax.swing.JTextField();
        txfKomi = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        pnlTime = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfBasicTime = new javax.swing.JTextField();
        rdbSuddenDeath = new javax.swing.JRadioButton();
        rdbStdByoYomi = new javax.swing.JRadioButton();
        rdbCanByoYomi = new javax.swing.JRadioButton();
        rdbFischer = new javax.swing.JRadioButton();
        lblFischerTime = new javax.swing.JLabel();
        txfFischerTime = new javax.swing.JTextField();
        lblStdTime = new javax.swing.JLabel();
        txfStdTime = new javax.swing.JTextField();
        lblCanTime = new javax.swing.JLabel();
        txfCanTime = new javax.swing.JTextField();
        txfCanNbMoves = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblEGFClass = new javax.swing.JLabel();
        lblAT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Games settings");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlGam.setLayout(null);

        jLabel2.setText("Goban size");
        pnlGam.add(jLabel2);
        jLabel2.setBounds(100, 30, 80, 14);

        jLabel3.setText("Komi");
        pnlGam.add(jLabel3);
        jLabel3.setBounds(100, 80, 80, 14);

        txfSize.setText("19");
        txfSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfSizeFocusLost(evt);
            }
        });
        pnlGam.add(txfSize);
        txfSize.setBounds(220, 30, 50, 20);

        txfKomi.setText("7.5");
        txfKomi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfKomiFocusLost(evt);
            }
        });
        pnlGam.add(txfKomi);
        txfKomi.setBounds(220, 80, 50, 20);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlGam.add(btnClose);
        btnClose.setBounds(140, 460, 210, 30);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/vannier/gotha/gothalogo16.jpg"))); // NOI18N
        btnHelp.setText("help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        pnlGam.add(btnHelp);
        btnHelp.setBounds(10, 460, 110, 30);

        pnlTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Thinking time"));
        pnlTime.setLayout(null);

        jLabel1.setText("Basic time (min)");
        pnlTime.add(jLabel1);
        jLabel1.setBounds(10, 30, 120, 14);

        txfBasicTime.setText("0");
        txfBasicTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfBasicTimeFocusLost(evt);
            }
        });
        pnlTime.add(txfBasicTime);
        txfBasicTime.setBounds(280, 30, 40, 20);

        grpComplTimeSystem.add(rdbSuddenDeath);
        rdbSuddenDeath.setSelected(true);
        rdbSuddenDeath.setText("Sudden death system");
        rdbSuddenDeath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbComplTimeSystemActionPerformed(evt);
            }
        });
        pnlTime.add(rdbSuddenDeath);
        rdbSuddenDeath.setBounds(10, 60, 200, 20);

        grpComplTimeSystem.add(rdbStdByoYomi);
        rdbStdByoYomi.setText("Standard Byo-yomi system");
        rdbStdByoYomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbComplTimeSystemActionPerformed(evt);
            }
        });
        pnlTime.add(rdbStdByoYomi);
        rdbStdByoYomi.setBounds(10, 100, 280, 20);

        grpComplTimeSystem.add(rdbCanByoYomi);
        rdbCanByoYomi.setText("Canadian Byo-yomi system");
        rdbCanByoYomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbComplTimeSystemActionPerformed(evt);
            }
        });
        pnlTime.add(rdbCanByoYomi);
        rdbCanByoYomi.setBounds(10, 150, 210, 20);

        grpComplTimeSystem.add(rdbFischer);
        rdbFischer.setText("Fischer system");
        rdbFischer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbComplTimeSystemActionPerformed(evt);
            }
        });
        pnlTime.add(rdbFischer);
        rdbFischer.setBounds(10, 200, 200, 20);

        lblFischerTime.setText("Bonus time(seconds)");
        pnlTime.add(lblFischerTime);
        lblFischerTime.setBounds(110, 220, 160, 20);

        txfFischerTime.setText("5");
        txfFischerTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfFischerTimeFocusLost(evt);
            }
        });
        pnlTime.add(txfFischerTime);
        txfFischerTime.setBounds(280, 220, 40, 20);

        lblStdTime.setText("Time(seconds)");
        pnlTime.add(lblStdTime);
        lblStdTime.setBounds(140, 120, 130, 20);

        txfStdTime.setText("30");
        txfStdTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfStdTimeFocusLost(evt);
            }
        });
        pnlTime.add(txfStdTime);
        txfStdTime.setBounds(280, 120, 40, 20);

        lblCanTime.setText("Time(seconds)");
        pnlTime.add(lblCanTime);
        lblCanTime.setBounds(140, 170, 130, 20);

        txfCanTime.setText("300");
        txfCanTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfCanTimeFocusLost(evt);
            }
        });
        pnlTime.add(txfCanTime);
        txfCanTime.setBounds(280, 170, 40, 20);

        txfCanNbMoves.setText("15");
        txfCanNbMoves.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfCanNbMovesFocusLost(evt);
            }
        });
        pnlTime.add(txfCanNbMoves);
        txfCanNbMoves.setBounds(30, 170, 40, 20);

        jLabel7.setText("moves");
        pnlTime.add(jLabel7);
        jLabel7.setBounds(80, 170, 50, 20);

        lblEGFClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEGFClass.setForeground(new java.awt.Color(255, 0, 0));
        lblEGFClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEGFClass.setText("EGF class X");
        pnlTime.add(lblEGFClass);
        lblEGFClass.setBounds(10, 280, 290, 30);

        lblAT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAT.setForeground(new java.awt.Color(255, 0, 0));
        lblAT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAT.setText("Adjusted time = 0");
        pnlTime.add(lblAT);
        lblAT.setBounds(10, 260, 290, 20);

        pnlGam.add(pnlTime);
        pnlTime.setBounds(10, 110, 340, 330);

        getContentPane().add(pnlGam);
        pnlGam.setBounds(20, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfKomiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfKomiFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();
            String oldKomi = gps.getStrKomi();
            String newKomi = txfKomi.getText();
            if (newKomi.compareTo(oldKomi) == 0) return;
            
            gps.setStrKomi(newKomi);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfKomiFocusLost

    private void txfSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfSizeFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();

            String oldStrSize = gps.getStrSize();
            String newStrSize = txfSize.getText();
            if (newStrSize.compareTo(oldStrSize) == 0) return;
            
            gps.setStrSize(newStrSize);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfSizeFocusLost

    private void txfBasicTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfBasicTimeFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();
            int oldVal = gps.getBasicTime();
            int newVal = oldVal;
            try {
                newVal = Integer.parseInt(this.txfBasicTime.getText());
            } catch (NumberFormatException e) {
                this.txfBasicTime.setText("" + oldVal);
                return;
            }
            if (newVal == oldVal) {
                return;
            }
            gps.setBasicTime(newVal);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txfBasicTimeFocusLost

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        cleanClose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cleanClose(){
        running = false;
        dispose();
    }
    
    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        Gotha.displayGothaHelp("Games Options");
}//GEN-LAST:event_btnHelpActionPerformed

    private void rdbComplTimeSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbComplTimeSystemActionPerformed
        TournamentParameterSet tps = null;
        GeneralParameterSet gps = null;
        try {
            tps = tournament.getTournamentParameterSet();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        gps = tps.getGeneralParameterSet();

        int oldComplementaryTimeSystem = gps.getComplementaryTimeSystem();
        int newComplementaryTimeSystem = GeneralParameterSet.GEN_GP_CTS_SUDDENDEATH;
        if (this.rdbSuddenDeath.isSelected()) {
            newComplementaryTimeSystem = GeneralParameterSet.GEN_GP_CTS_SUDDENDEATH;
        }
        if (this.rdbStdByoYomi.isSelected()) {
            newComplementaryTimeSystem = GeneralParameterSet.GEN_GP_CTS_STDBYOYOMI;
        }
        if (this.rdbCanByoYomi.isSelected()) {
            newComplementaryTimeSystem = GeneralParameterSet.GEN_GP_CTS_CANBYOYOMI;
        }
        if (this.rdbFischer.isSelected()) {
            newComplementaryTimeSystem = GeneralParameterSet.GEN_GP_CTS_FISCHER;
        }

        if (newComplementaryTimeSystem == oldComplementaryTimeSystem) {
            return;
        }

        gps.setComplementaryTimeSystem(newComplementaryTimeSystem);

        try {
            tournament.setTournamentParameterSet(tps);
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.tournamentChanged();

    }//GEN-LAST:event_rdbComplTimeSystemActionPerformed

    private void txfStdTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfStdTimeFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();
            int oldVal = gps.getStdByoYomiTime();
            int newVal = oldVal;
            try {
                newVal = Integer.parseInt(this.txfStdTime.getText());
            } catch (NumberFormatException e) {
                this.txfStdTime.setText("" + oldVal);
                return;
            }
            if (newVal == oldVal) {
                return;
            }
            gps.setStdByoYomiTime(newVal);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfStdTimeFocusLost

    private void txfCanTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCanTimeFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();
            int oldVal = gps.getCanByoYomiTime();
            int newVal = oldVal;
            try {
                newVal = Integer.parseInt(this.txfCanTime.getText());
            } catch (NumberFormatException e) {
                this.txfCanTime.setText("" + oldVal);
                return;
            }
            if (newVal == oldVal) {
                return;
            }
            gps.setCanByoYomiTime(newVal);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfCanTimeFocusLost

    private void txfFischerTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfFischerTimeFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();
            int oldVal = gps.getFischerTime();
            int newVal = oldVal;
            try {
                newVal = Integer.parseInt(this.txfFischerTime.getText());
            } catch (NumberFormatException e) {
                this.txfFischerTime.setText("" + oldVal);
                return;
            }
            if (newVal == oldVal) {
                return;
            }
            gps.setFischerTime(newVal);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfFischerTimeFocusLost

    private void txfCanNbMovesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCanNbMovesFocusLost
        try {
            TournamentParameterSet tps = tournament.getTournamentParameterSet();
            GeneralParameterSet gps = tps.getGeneralParameterSet();
            int oldVal = gps.getNbMovesCanTime();
            int newVal = oldVal;
            try {
                newVal = Integer.parseInt(this.txfCanNbMoves.getText());
            } catch (NumberFormatException e) {
                this.txfCanNbMoves.setText("" + oldVal);
                return;
            }
            if (newVal == oldVal) {
                return;
            }
            gps.setNbMovesCanTime(newVal);
            tournament.setTournamentParameterSet(tps);
            this.tournamentChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfCanNbMovesFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cleanClose();
    }//GEN-LAST:event_formWindowClosing

    private void customInitComponents() throws RemoteException {
        updateAllViews();
        // this.updatePnlGam();
    }

    private void tournamentChanged() {
        try {
            tournament.setLastTournamentModificationTime(tournament.getCurrentTournamentTime());
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }

        updateAllViews();
    }

    private void updateAllViews() {
       this.pnlGam.setVisible(true);
        try {
            if (!tournament.isOpen()) cleanClose();
            this.lastComponentsUpdateTime = tournament.getCurrentTournamentTime();
            setTitle("Games Settings. " + tournament.getFullName());
            updatePnlGam();
        } catch (RemoteException ex) {
            Logger.getLogger(JFrGamesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updatePnlGam() throws RemoteException {
        GeneralParameterSet gps = null;
        gps = tournament.getTournamentParameterSet().getGeneralParameterSet();
        this.txfSize.setText(gps.getStrSize());
        this.txfKomi.setText(gps.getStrKomi());

        this.txfBasicTime.setText("" + gps.getBasicTime());

        int complTimeSystem = gps.getComplementaryTimeSystem();
        this.txfStdTime.setEnabled(false);
        this.txfCanNbMoves.setEnabled(false);
        this.txfCanTime.setEnabled(false);
        this.txfFischerTime.setEnabled(false);

        switch (complTimeSystem) {
            case GeneralParameterSet.GEN_GP_CTS_SUDDENDEATH:
                this.rdbSuddenDeath.setSelected(true);
                break;
            case GeneralParameterSet.GEN_GP_CTS_STDBYOYOMI:
                this.rdbStdByoYomi.setSelected(true);
                this.txfStdTime.setEnabled(true);
                break;
            case GeneralParameterSet.GEN_GP_CTS_CANBYOYOMI:
                this.rdbCanByoYomi.setSelected(true);
                this.txfCanNbMoves.setEnabled(true);
                this.txfCanTime.setEnabled(true);
                break;
            case GeneralParameterSet.GEN_GP_CTS_FISCHER:
                this.rdbFischer.setSelected(true);
                this.txfFischerTime.setEnabled(true);
                break;
        }

        this.txfStdTime.setText("" + gps.getStdByoYomiTime());
        this.txfCanNbMoves.setText("" + gps.getNbMovesCanTime());
        this.txfCanTime.setText("" + gps.getCanByoYomiTime());
        this.txfFischerTime.setText("" + gps.getFischerTime());

        // What EGF Adjusted time ?
        int at = tournament.egfAdjustedTime();
        String strAT = "Adjusted time = " + (at / 60) + " min";
        
        this.lblAT.setText(strAT);
        
        // What EGF class ?
        String strClass = tournament.egfClass();
        String strMes = "";
        if (strClass.equals("C")) strMes = "EGF class C";
        if (strClass.equals("B")) strMes = "EGF class B";
        if (strClass.equals("A")) strMes = "EGF class A";
        
        this.lblEGFClass.setText(strMes);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHelp;
    private javax.swing.ButtonGroup grpComplTimeSystem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAT;
    private javax.swing.JLabel lblCanTime;
    private javax.swing.JLabel lblEGFClass;
    private javax.swing.JLabel lblFischerTime;
    private javax.swing.JLabel lblStdTime;
    private javax.swing.JPanel pnlGam;
    private javax.swing.JPanel pnlTime;
    private javax.swing.JRadioButton rdbCanByoYomi;
    private javax.swing.JRadioButton rdbFischer;
    private javax.swing.JRadioButton rdbStdByoYomi;
    private javax.swing.JRadioButton rdbSuddenDeath;
    private javax.swing.JTextField txfBasicTime;
    private javax.swing.JTextField txfCanNbMoves;
    private javax.swing.JTextField txfCanTime;
    private javax.swing.JTextField txfFischerTime;
    private javax.swing.JTextField txfKomi;
    private javax.swing.JTextField txfSize;
    private javax.swing.JTextField txfStdTime;
    // End of variables declaration//GEN-END:variables
}
