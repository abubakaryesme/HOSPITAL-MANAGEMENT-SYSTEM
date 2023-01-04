
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class AdminMode {
    
    JFrame optionFrame;
    JMenuBar optionSet;
    JMenu doctorOpt, receptionistOpt, viewPatient, nurseOpt,wardOpt,changeCredentials;
    JMenuItem docPersonalInfo, viewVRECDoc, addDoc,viewRec,addRec,addNurse,viewNurse,viewWard,addWard,
            addBedOpt,viewBedOpt,patientWardView, patientAptView,patientBill,patientInfo, 
            nameChange,passChange;
    JButton btnSignOut, dltAdmin;
    JPanel btnPanel, msgPanel;
    JLabel msgText;
    String admName,admPassword;
    
    public AdminMode(String admN, String admP)
    {
        admName=admN;
        admPassword=admP;
        
        initAdminMode();
    }
    
    public void initAdminMode()
    {
        optionFrame= new JFrame("Administrator Mode");
        optionFrame.setLayout(new BorderLayout());
        
        btnSignOut = new JButton("SIGN OUT");
        btnSignOut.setFocusable(false);
        //
        dltAdmin = new JButton("Deactiviate Me");
        dltAdmin.setFocusable(false);
        //
        
        Font ft2= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        btnSignOut.setFont(ft2);
        dltAdmin.setFont(ft2);
        btnPanel = new JPanel(new FlowLayout(1,50,10));
        btnPanel.add(dltAdmin);
        btnPanel.add(btnSignOut);
        
        msgText = new JLabel("Administrator Mode");
        Font ft1= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft1);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        
        
        Font ft3= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        Font ft4= btnSignOut.getFont().deriveFont(Font.PLAIN,20f);

        optionSet = new JMenuBar();
        optionSet.setLayout(new GridLayout(3,2));
        
        
        doctorOpt= new JMenu("Doctor");
        doctorOpt.setFont(ft3);
        
        docPersonalInfo = new JMenuItem("View Doctors Details");
        docPersonalInfo.setFont(ft4);
        //
        viewVRECDoc = new JMenuItem("View Visiting Record");
        viewVRECDoc.setFont(ft4);
        //
        addDoc = new JMenuItem("Add Doctor");
        addDoc.setFont(ft4);
        //
        doctorOpt.add(docPersonalInfo);
        doctorOpt.add(viewVRECDoc);
        doctorOpt.add(addDoc);
        
        
        nurseOpt = new JMenu("Nurse");
        nurseOpt.setFont(ft3);
        
        viewNurse = new JMenuItem("View Nurse");
        viewNurse.setFont(ft4);
        //
        addNurse = new JMenuItem("Add Nurse");
        addNurse.setFont(ft4);
        //
        nurseOpt.add(viewNurse);
        nurseOpt.add(addNurse);
        
        
        wardOpt= new JMenu("Ward");
        wardOpt.setFont(ft3);
        
        addWard = new JMenuItem("Add Ward");
        addWard.setFont(ft4);
        //
        addBedOpt=new JMenuItem("Add Bed");
        addBedOpt.setFont(ft4);
        //
        viewWard = new JMenuItem("View Ward");
        viewWard.setFont(ft4);
        //
        viewBedOpt = new JMenuItem("View Bed Info");
        viewBedOpt.setFont(ft4);
        //
        wardOpt.add(viewWard);
        wardOpt.add(viewBedOpt);
        wardOpt.add(addWard);
        wardOpt.add(addBedOpt);
        
        receptionistOpt= new JMenu("Receptionist");
        receptionistOpt.setFont(ft3);
        
        addRec=new JMenuItem("Add Receptionist");
        addRec.setFont(ft4);
        //
        viewRec = new JMenuItem("View Receptionist");
        viewRec.setFont(ft4);
        //
        receptionistOpt.add(viewRec);
        receptionistOpt.add(addRec);
        
        
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
        
        
        viewPatient = new JMenu("Patient");
        viewPatient.setFont(ft3);
        //
        
        patientAptView = new JMenuItem("View Appointment");
        patientAptView.setFont(ft4);
        //
        patientWardView= new JMenuItem("View Booking Records");
        patientWardView.setFont(ft4);
        //
        patientBill= new JMenuItem("View Bill Transaction");
        patientBill.setFont(ft4);
        //
        patientInfo= new JMenuItem("View Patient Info");
        patientInfo.setFont(ft4);
        //
        viewPatient.add(patientInfo);
        viewPatient.add(patientAptView);
        viewPatient.add(patientWardView);
        viewPatient.add(patientBill);
        
        //-------------------------------------
        
        optionSet.add(receptionistOpt);
        optionSet.add(doctorOpt);
        optionSet.add(nurseOpt);
        optionSet.add(wardOpt);
        optionSet.add(viewPatient);
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
