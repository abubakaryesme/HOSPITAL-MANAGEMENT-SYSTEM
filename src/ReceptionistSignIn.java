
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ReceptionistSignIn {
    JFrame rptSignInFrame;
    JLabel rptUsername,rptPassword,textMode;
    JTextField tfRpt;
    JPasswordField tfPswd;
    JButton btnOKAY, btnBACK;
    JPanel signInCmpPanel,signInPanel, btnPanel,northPanel;
    
    public ReceptionistSignIn()
    {
        initAdminSignGUI();
    }
    
    public void initAdminSignGUI()
    {
        rptSignInFrame = new JFrame("Receptionist SIGN IN");
        rptSignInFrame.setLayout(new BorderLayout());
        
        rptUsername = new JLabel("Username: ");
        rptPassword = new JLabel("Password: ");
        
        tfRpt = new JTextField(15);
        tfPswd = new JPasswordField(15);
        
        
        btnBACK= new JButton("BACK");
        btnBACK.setFocusable(false);
        
        btnOKAY= new JButton("OKAY");
        btnOKAY.setFocusable(false);
        
       
        
        Font ft1= btnBACK.getFont().deriveFont(Font.PLAIN,25f);
        btnBACK.setFont(ft1);
        btnOKAY.setFont(ft1);
        rptUsername.setFont(ft1);
        tfRpt.setFont(ft1);
        rptPassword.setFont(ft1);
        tfPswd.setFont(ft1);
        
        
        signInPanel = new JPanel(new GridLayout(2,2));
        signInPanel.add(rptUsername);
        signInPanel.add(tfRpt);
        signInPanel.add(rptPassword);
        signInPanel.add(tfPswd);
        
        btnPanel = new JPanel(new FlowLayout(1,50,50));
        btnPanel.add(btnOKAY);
        btnPanel.add(btnBACK);
        
        signInCmpPanel = new JPanel(new BorderLayout());
        signInCmpPanel.add(signInPanel, BorderLayout.CENTER);
        signInCmpPanel.add(btnPanel, BorderLayout.SOUTH);
        
        
        textMode= new JLabel("SIGN IN ");
        Font ft= btnBACK.getFont().deriveFont(Font.PLAIN,35f);
        textMode.setFont(ft);
        
        northPanel= new JPanel(new BorderLayout());
        northPanel.add(textMode, BorderLayout.CENTER);
        
        
        rptSignInFrame.add(northPanel, BorderLayout.NORTH);
        rptSignInFrame.add(signInCmpPanel, BorderLayout.CENTER);
        
        rptSignInFrame.setSize(550,350);
        rptSignInFrame.setLocationRelativeTo(null);
        rptSignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rptSignInFrame.setResizable(false);
    }
}
