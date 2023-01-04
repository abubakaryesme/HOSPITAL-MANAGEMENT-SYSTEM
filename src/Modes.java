
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Modes {
    
    JFrame modeFrame;
    JButton admMode,rptMode, exitBtn;
    JLabel welcomeLabel,modeLabel;
    JPanel welcomePanel,mainPanel, btnPanel, exitPanel;
    
    public Modes()
    {
        initModeGUI();
    }
    
    public void initModeGUI()
    {
        modeFrame = new JFrame("HOSPITAL");
        modeFrame.setLayout(new BorderLayout());
   
        welcomeLabel = new JLabel("Welcome to Hospital");
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        
        modeLabel = new JLabel("Select a mode:");
        mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(modeLabel, BorderLayout.NORTH);
        
        admMode = new JButton("Administrator Mode");
        admMode.setFocusable(false);
        rptMode = new JButton("Receptionist Mode");
        rptMode.setFocusable(false);
        exitBtn= new JButton("EXIT");
        exitBtn.setFocusable(false);
        
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(1,10,150));
        btnPanel.add(admMode);
        btnPanel.add(rptMode);
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        
        exitPanel = new JPanel(new BorderLayout());
        exitPanel.add(exitBtn);
        
        //Font Adjustment:
        Font ft1= welcomeLabel.getFont().deriveFont(Font.PLAIN,50f);
        welcomeLabel.setFont(ft1);
        
        Font ft2= modeLabel.getFont().deriveFont(Font.PLAIN,30f);
        modeLabel.setFont(ft2);
        
        Font ft3= admMode.getFont().deriveFont(Font.PLAIN,25f);
        admMode.setFont(ft3);
        rptMode.setFont(ft3);
        
        //Add component into Frame:
        modeFrame.add(welcomePanel, BorderLayout.NORTH);
        modeFrame.add(mainPanel, BorderLayout.CENTER);
        modeFrame.add(exitPanel, BorderLayout.SOUTH);
        
        modeFrame.setSize(550,550);
        modeFrame.setLocationRelativeTo(null);
       // modeFrame.setVisible(true);
        //fMain.setResizable(false);
        modeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
