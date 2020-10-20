/**
 * 
 * Hospital ER Command Generator
 * 
 * by @yamboi on Github
 * 
 * Made for use with FiveM servers utilizing the "/er" command
 * 
 * Licensed under MIT License
 * Copyright (c) 2020 @yamboi
 * 
 * Don't forget attribution! :)
 * 
 */

package me.yamboi.ergenerator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class MainWindow {

	private JFrame frmMainFrame;
	private JTextField txtIdHere;
	private JTextField textGenerateField;
	private JTextField txtTime;
	private JLabel lblSplashMessage;
	public ArrayList<Object> textBoxOrder;
	public String hospitalReason;
	public boolean descExampleText;
	public String origHospTime;
	public final String VERSION = "1.0";
	
	private final String DEFAULT_HOSP_TIME = "200";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// don't judge me
		
		hospitalReason = new String();
		origHospTime = new String();
		descExampleText = false;
		
		frmMainFrame = new JFrame();
		frmMainFrame.setResizable(false);
		frmMainFrame.setTitle("ER Paperwork");
		frmMainFrame.setBackground(Color.GRAY);
		frmMainFrame.getContentPane().setBackground(SystemColor.window);
		frmMainFrame.setBounds(100, 100, 551, 471);
		frmMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainFrame.getContentPane().setLayout(null);
		
		JLabel lblMainTitle = new JLabel("ER Paperwork");
		lblMainTitle.setForeground(Color.BLACK);
		lblMainTitle.setBounds(0, 2, 554, 45);
		lblMainTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frmMainFrame.getContentPane().add(lblMainTitle);
		
		JLabel lblWatermark = new JLabel("by @yamboi on Github");
		lblWatermark.setForeground(new Color(0, 0, 0));
		lblWatermark.setBounds(135, 401, 391, 22);
		lblWatermark.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWatermark.setHorizontalAlignment(SwingConstants.LEFT);
		frmMainFrame.getContentPane().add(lblWatermark);
		
		JLabel lblCityId = new JLabel("City ID");
		lblCityId.setForeground(new Color(0, 0, 0));
		lblCityId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCityId.setBounds(20, 63, 72, 25);
		frmMainFrame.getContentPane().add(lblCityId);
		
		txtIdHere = new JTextField();
		txtIdHere.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtIdHere.selectAll();
			}
		});
		txtIdHere.setForeground(new Color(0, 0, 0));
		txtIdHere.setBackground(SystemColor.menu);
		txtIdHere.setText("1");
		txtIdHere.setBounds(20, 86, 109, 20);
		frmMainFrame.getContentPane().add(txtIdHere);
		txtIdHere.setColumns(10);
		
		JLabel lblHospitalTitle = new JLabel("Hospital");
		lblHospitalTitle.setForeground(new Color(0, 0, 0));
		lblHospitalTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHospitalTitle.setBounds(20, 146, 86, 25);
		frmMainFrame.getContentPane().add(lblHospitalTitle);
		
		JRadioButton rdbtnSandyShores = new JRadioButton("Sandy Shores");
		rdbtnSandyShores.setBackground(SystemColor.menu);
		rdbtnSandyShores.setForeground(new Color(0, 0, 0));
		rdbtnSandyShores.setBounds(20, 194, 109, 23);
		frmMainFrame.getContentPane().add(rdbtnSandyShores);
		
		JRadioButton rdbtnPaletoMedical = new JRadioButton("Paleto Bay");
		rdbtnPaletoMedical.setForeground(new Color(0, 0, 0));
		rdbtnPaletoMedical.setBackground(SystemColor.menu);
		rdbtnPaletoMedical.setBounds(20, 169, 109, 23);
		frmMainFrame.getContentPane().add(rdbtnPaletoMedical);
		
		JRadioButton rdbtnPillbox = new JRadioButton("Pillbox Hill");
		rdbtnPillbox.setSelected(true);
		rdbtnPillbox.setForeground(new Color(0, 0, 0));
		rdbtnPillbox.setBackground(SystemColor.menu);
		rdbtnPillbox.setBounds(20, 246, 109, 23);
		frmMainFrame.getContentPane().add(rdbtnPillbox);
		
		JRadioButton rdbtnCrusade = new JRadioButton("Central LS");
		rdbtnCrusade.setBackground(SystemColor.menu);
		rdbtnCrusade.setForeground(new Color(0, 0, 0));
		rdbtnCrusade.setBounds(20, 272, 109, 23);
		frmMainFrame.getContentPane().add(rdbtnCrusade);
		
		JRadioButton rdbtnZonah = new JRadioButton("Zonah");
		rdbtnZonah.setBackground(SystemColor.menu);
		rdbtnZonah.setForeground(new Color(0, 0, 0));
		rdbtnZonah.setBounds(20, 220, 109, 23);
		frmMainFrame.getContentPane().add(rdbtnZonah);
		
		ButtonGroup hospLoc = new ButtonGroup();
		hospLoc.add(rdbtnSandyShores);
		hospLoc.add(rdbtnPillbox);
		hospLoc.add(rdbtnCrusade);
		hospLoc.add(rdbtnPaletoMedical);
		hospLoc.add(rdbtnZonah);
		
		textGenerateField = new JTextField();
		textGenerateField.setForeground(SystemColor.desktop);
		textGenerateField.setBackground(SystemColor.menu);
		textGenerateField.setBounds(135, 376, 391, 20);
		frmMainFrame.getContentPane().add(textGenerateField);
		textGenerateField.setColumns(10);
		
		JTextArea txtrReason = new JTextArea();
		txtrReason.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrReason.setLineWrap(true);
		txtrReason.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtrReason.getText().contains("Example:"))
				{
					txtrReason.selectAll();
				}
			}
		});
		txtrReason.setBackground(UIManager.getColor("CheckBox.background"));
		txtrReason.setText("Example:\r\nBMX accident\r\nScrapes on arms and legs\r\nLarge visible bump on head\r\nIV inserted into right arm\r\nPain level 8/10\r\nGiven ando/mosey\r\nRequires bed rest");
		txtrReason.setBounds(135, 84, 391, 285);
		frmMainFrame.getContentPane().add(txtrReason);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(new Color(0, 0, 0));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTime.setBounds(20, 105, 72, 25);
		frmMainFrame.getContentPane().add(lblTime);
		
		txtTime = new JTextField();
		txtTime.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTime.selectAll();
			}
		});
		txtTime.setForeground(new Color(0, 0, 0));
		txtTime.setBackground(SystemColor.menu);
		txtTime.setText(DEFAULT_HOSP_TIME);
		txtTime.setColumns(10);
		txtTime.setBounds(20, 127, 109, 20);
		frmMainFrame.getContentPane().add(txtTime);
		
		JCheckBox chckbxPoliceHold = new JCheckBox("Police Hold");
		chckbxPoliceHold.setBackground(SystemColor.menu);
		chckbxPoliceHold.setForeground(new Color(0, 0, 0));
		// Set timer to 1000 if Police Hold
		chckbxPoliceHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxPoliceHold.isSelected())
				{
					origHospTime = txtTime.getText();
					txtTime.setText("1800");
				}
				else
				{
					txtTime.setText(origHospTime);
				}
			}
		});
		chckbxPoliceHold.setBounds(20, 346, 109, 23);
		frmMainFrame.getContentPane().add(chckbxPoliceHold);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setForeground(new Color(0, 0, 0));
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReason.setBounds(135, 63, 72, 25);
		frmMainFrame.getContentPane().add(lblReason);
		
		JCheckBox chckbxIncludeTransport = new JCheckBox("Destination");
		chckbxIncludeTransport.setSelected(true);
		chckbxIncludeTransport.setForeground(Color.BLACK);
		chckbxIncludeTransport.setBackground(SystemColor.menu);
		chckbxIncludeTransport.setBounds(20, 320, 109, 23);
		frmMainFrame.getContentPane().add(chckbxIncludeTransport);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setForeground(new Color(0, 0, 0));
		btnGenerate.setBackground(SystemColor.menu);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// AKA when clicked
				
				String playerID = txtIdHere.getText();
				String hospLoc = new String();
				String hospTime = txtTime.getText();
				String hospDesc = new String();
				String hospDescRaw = txtrReason.getText();
				
				if (rdbtnPaletoMedical.isSelected())
					hospLoc = "1";
				else if (rdbtnSandyShores.isSelected())
					hospLoc = "2";
				else if (rdbtnZonah.isSelected())
					hospLoc = "3";
				else if (rdbtnPillbox.isSelected())
					hospLoc = "4";
				else if (rdbtnCrusade.isSelected())
					hospLoc = "5";
				
				Scanner scan = new Scanner(hospDescRaw);
				scan.useDelimiter("\\r?\\n|\\r");
				boolean firstScan = true;
				while (scan.hasNext())
				{
					if (firstScan)
					{
						String txtLine = scan.next();
						hospDesc = hospDesc + " " + txtLine;
						firstScan = false;
					}
					else
					{
						String txtLine = scan.next();
						hospDesc = hospDesc + " | " + txtLine;
					}
				}
				scan.close();
				
				if (chckbxIncludeTransport.isSelected())
				{
					if (rdbtnPaletoMedical.isSelected())
						hospDesc += " | Transported to Paleto Bay Medical Center";
					else if (rdbtnSandyShores.isSelected())
						hospDesc += " | Transported to Sandy Shores Medical Center";
					else if (rdbtnZonah.isSelected())
						hospDesc += " | Transported to Mount Zonah Medical Center";
					else if (rdbtnPillbox.isSelected())
						hospDesc += " | Transported to Pillbox Hill Medical Center";
					else if (rdbtnCrusade.isSelected())
						hospDesc += " | Transported to Central Los Santos Medical Center";
				}
				
				if (chckbxPoliceHold.isSelected())
				{
					hospDesc = hospDesc + " " + "[Police Hold " + playerID + "]";
				}
				
				
				hospitalReason = "/er " + playerID + " " + hospLoc + " " + hospTime + hospDesc;
				
				
				textGenerateField.setText(hospitalReason);
				textGenerateField.requestFocus();
				textGenerateField.selectAll();
				textGenerateField.copy();
			}
		});
		btnGenerate.setBounds(20, 375, 109, 23);
		frmMainFrame.getContentPane().add(btnGenerate);
		
		JLabel labelMessageOptions = new JLabel("Message");
		labelMessageOptions.setForeground(Color.BLACK);
		labelMessageOptions.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelMessageOptions.setBounds(20, 296, 86, 25);
		frmMainFrame.getContentPane().add(labelMessageOptions);
		
		JButton btnNewButton = new JButton("Clear Fields");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrReason.setText("");
				textGenerateField.setText("");
				rdbtnPaletoMedical.setSelected(false);
				rdbtnSandyShores.setSelected(false);
				rdbtnZonah.setSelected(false);
				rdbtnPillbox.setSelected(true);
				rdbtnCrusade.setSelected(false);
				txtTime.setText(DEFAULT_HOSP_TIME);
				chckbxPoliceHold.setSelected(false);
			}
		});
		btnNewButton.setBounds(20, 402, 109, 23);
		frmMainFrame.getContentPane().add(btnNewButton);
		
		JLabel lvlVersion = new JLabel(VERSION);
		lvlVersion.setHorizontalAlignment(SwingConstants.RIGHT);
		lvlVersion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lvlVersion.setBounds(495, 68, 29, 14);
		frmMainFrame.getContentPane().add(lvlVersion);
		
		lblSplashMessage = new JLabel();
		updateSplash();
		lblSplashMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSplashMessage.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSplashMessage.setBounds(141, 40, 261, 22);
		frmMainFrame.getContentPane().add(lblSplashMessage);
		
	}

	private void updateSplash() {
		// TODO Auto-generated method stub
		ArrayList<String> splashList = new ArrayList<String>();
		splashList.add("Wow, a splash screen!");
		splashList.add("Check out my GitHub for other projects!");
		splashList.add("American made!");
		splashList.add("Look, a wild snail!");
		splashList.add("The one and only!");
		splashList.add("The best version yet!");
		splashList.add("Don't forget to clock out!");
		splashList.add("Always looking for feature ideas!");
		splashList.add("Powered by hamsters!");
		splashList.add("Never gonna give you up!");
		splashList.add("Written in Java!");
		Random rand = new Random();
		int randNum = rand.nextInt(splashList.size());
		lblSplashMessage.setText(splashList.get(randNum));
	}
}
