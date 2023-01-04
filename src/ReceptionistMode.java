
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ReceptionistMode {
    
    JFrame optionFrame;
    JMenuBar optionSet;
    JMenu patientOpt, doctorView, wardOpt,billView,changeCredentials;
    JMenuItem docPersonalInfo,viewVRECDoc,addDocVisit, nameChange,passChange
            ,patientAdd,patientAptView,patientWardView, viewWard,viewBedInfo, viewBillPat, viewBillTransaction
            ,patientRq;
    JButton btnSignOut, dltRpt;
    JPanel btnPanel, msgPanel;
    JLabel msgText;
    String rptName,rptPassword;
    
    public ReceptionistMode(String rptN, String rptP)
    {
        rptName=rptN;
        rptPassword=rptP;
        
        initReceptionistMode();
    }
    
    public void initReceptionistMode()
    {
        optionFrame= new JFrame("Receptionist Mode");
        optionFrame.setLayout(new BorderLayout());
        
        btnSignOut = new JButton("SIGN OUT");
        btnSignOut.setFocusable(false);
        //
        dltRpt = new JButton("Deactiviate Me");
        dltRpt.setFocusable(false);
        //
        
        Font ft2= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        btnSignOut.setFont(ft2);
        dltRpt.setFont(ft2);
        btnPanel = new JPanel(new FlowLayout(1,50,10));
        btnPanel.add(dltRpt);
        btnPanel.add(btnSignOut);
        
        msgText = new JLabel("Receptionist Mode");
        Font ft1= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft1);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        
        
        Font ft3= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        Font ft4= btnSignOut.getFont().deriveFont(Font.PLAIN,20f);

        optionSet = new JMenuBar();
        optionSet.setLayout(new GridLayout(5,1));
        
        patientOpt = new JMenu("Patient");
        patientOpt.setFont(ft3);
        //,patientAdd,patientAptView,patientWardView;
        
        patientAdd= new JMenuItem("Add Patient");
        patientAdd.setFont(ft4);
        //
        patientRq = new JMenuItem("Patient Requirement");
        patientRq.setFont(ft4);
        //
        patientAptView = new JMenuItem("View Appointment");
        patientAptView.setFont(ft4);
        //
        patientWardView= new JMenuItem("View Booking Records");
        patientWardView.setFont(ft4);
        //
        patientOpt.add(patientAdd);
        patientOpt.add(patientRq);
        patientOpt.add(patientAptView);
        patientOpt.add(patientWardView);
        
        
        doctorView= new JMenu("Doctor");
        doctorView.setFont(ft3);
        
        docPersonalInfo = new JMenuItem("View Doctors Details");
        docPersonalInfo.setFont(ft4);
        //
        viewVRECDoc = new JMenuItem("View Visiting Record");
        viewVRECDoc.setFont(ft4);
        //
        addDocVisit = new JMenuItem("Add Visiting Record");
        addDocVisit.setFont(ft4);
        //
        doctorView.add(docPersonalInfo);
        doctorView.add(viewVRECDoc);
        doctorView.add(addDocVisit);
        
        wardOpt= new JMenu("Ward");
        wardOpt.setFont(ft3);
        
        viewWard = new JMenuItem("View Ward");
        viewWard.setFont(ft4);
        //
        viewBedInfo = new JMenuItem("View Bed Info");
        viewBedInfo.setFont(ft4);
        //
        wardOpt.add(viewWard);
        wardOpt.add(viewBedInfo);
        
        billView = new JMenu("BILL");
        billView.setFont(ft3);
        
        viewBillPat = new JMenuItem("View Bill");
        viewBillPat.setFont(ft4);
        //
        viewBillTransaction= new JMenuItem("View Bill Transaction");
        viewBillTransaction.setFont(ft4);
        //
        billView.add(viewBillPat);
        billView.add(viewBillTransaction);
        
        
        changeCredentials= new JMenu("Change Credentials");
        changeCredentials.setFont(ft3);
        
        nameChange = new JMenuItem("Change Username");
        nameChange.setFont(ft4);
        //
        passChange= new JMenuItem("Change Password");
        passChange.setFont(ft4);
        //
        changeCredentials.add(nameChange);
        changeCredentials.add(passChange);
        
        
        //-------------------------------------
        
        optionSet.add(patientOpt);
        optionSet.add(doctorView);
        optionSet.add(wardOpt);
        optionSet.add(billView);
        optionSet.add(changeCredentials);
        
        //---------------------------------------
        
        optionFrame.add(msgPanel, BorderLayout.NORTH);
        optionFrame.add(optionSet, BorderLayout.CENTER);
        optionFrame.add(btnPanel, BorderLayout.SOUTH);
        
        //----------------------------------------------
        
        optionFrame.setSize(550,550);
        optionFrame.setLocationRelativeTo(null);
        optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionFrame.setResizable(false);
    }
    
}
