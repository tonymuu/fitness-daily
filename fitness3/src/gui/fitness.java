package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import bp.Aerobic;
import bp.ExerciseDay;
import bp.Sports;
import bp.Weight;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class fitness {

	private JFrame mframe;
	private JTextField textFieldName;
	private JTextField textFieldRHR;
	private JTextField textFieldUserName;
	private JPanel Welcome;
	private JPanel NewUser;
	private JPanel LogIn;
	private JPanel Exercise;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewUser;
	private JButton btnLogIn;
	private JButton btnBackLogIn;
	private JButton btnBackExercise;
	private JButton btnBackNewUser;
	private DefaultListModel listModelSportsPlayed = new DefaultListModel();
	private DefaultListModel listModelAerobic = new DefaultListModel();
	private DefaultListModel listModelWeight = new DefaultListModel();
	private JTextField textFieldSportsHeartRate;
	private JTextField textFieldSportsNotes;
	private JComboBox comboBoxSportsPlayed;
	private JComboBox comboBoxAerobics;
	
	private String[] sports = new String[] {"Tennis", "Basketball", "Soccer", "Football", "Freesbee", "Ping-Pong", "Racket Ball"};
	
	private ExerciseDay myExercise = new ExerciseDay();
	
	private JTextField textFieldDate;
	private JTextField textFieldSportsTime;
	
	private List<Sports> sportsList = new ArrayList<Sports>();
	private List<Aerobic> aerobicList = new ArrayList<Aerobic>();
	private List<Weight> weightList = new ArrayList<Weight>();
	
	private Sports mySports = new Sports();
	private Weight myWeight = new Weight();
	private Aerobic myAerobic = new Aerobic();
	private JTextField textFieldLogInDate;
	private JTextField textFieldCaloriesIntake;
	private JTextField textFieldAutoDate;
	private JTextField textFieldNotesExerciseDay;
	private JList listSportsPlayed;
	private JTextField textFieldHeartRateAerobic;
	private JTextField textFieldTimeAerobic;
	private JTextField textFieldNotesAerobic;
	private JTextField textFieldHeartRateWeight;
	private JTextField textFieldNotesWeight;
	private JTextField textFieldReps;
	private JTextField textFieldDistance;
	private JTextField textFieldWeight;
	private JList listAerobic;
	private JComboBox comboBoxMovement;
	private JList listWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fitness window = new fitness();
					window.mframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fitness() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mframe = new JFrame();
		mframe.setTitle("Fitness V0.1 Beta");
		mframe.setSize(new Dimension(512, 300));
		mframe.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 508, 274);
		mframe.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		Welcome = new JPanel();
		Welcome.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		Welcome.setName("Welcome");
		panel.add(Welcome, "Welcome");
		Welcome.setLayout(new CardLayout(0, 0));
		
		JPanel WelcomePane = new JPanel();
		Welcome.add(WelcomePane, "name_36959949772777");
		WelcomePane.setLayout(null);
		
		
		
		JLabel lblWelcomeToFitness = new JLabel("<html>Welcome to Fitness V0.1</html>");
		lblWelcomeToFitness.setBounds(10, 10, 187, 67);
		WelcomePane.add(lblWelcomeToFitness);
		
		Exercise = new JPanel();
		Exercise.setName("Exercise");
		panel.add(Exercise, "Exercise");
		Exercise.setLayout(new CardLayout(0, 0));
		
		JPanel ExercisePane_1 = new JPanel();
		Exercise.add(ExercisePane_1, "name_37070289755818");
		ExercisePane_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 500, 198);
		ExercisePane_1.add(tabbedPane);
		
		JPanel aerobicPane = new JPanel();
		aerobicPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		tabbedPane.addTab("Aerobic", null, aerobicPane, null);
		aerobicPane.setLayout(null);
		
		JLabel lblAerobics = new JLabel("Aerobics");
		lblAerobics.setBounds(12, 24, 70, 15);
		aerobicPane.add(lblAerobics);
		
		JLabel lblTimeminutes = new JLabel("Time(minutes)");
		lblTimeminutes.setBounds(12, 63, 100, 15);
		aerobicPane.add(lblTimeminutes);
		
		JLabel lblNewLabel_2 = new JLabel("Heart Rate(BPM)");
		lblNewLabel_2.setBounds(12, 102, 123, 15);
		aerobicPane.add(lblNewLabel_2);
		
		JLabel lblNotes_2 = new JLabel("Notes(optional)");
		lblNotes_2.setBounds(12, 144, 90, 15);
		aerobicPane.add(lblNotes_2);
		
		JButton btnAddAerobic = new JButton("Add");
		btnAddAerobic.setToolTipText("add the exercise");
		btnAddAerobic.addActionListener(new BtnAddAerobicActionListener());
		btnAddAerobic.setBounds(260, 71, 81, 25);
		aerobicPane.add(btnAddAerobic);
		
		JButton btnDeleteAerobic = new JButton("Delete");
		btnDeleteAerobic.setToolTipText("remove the exercise");
		btnDeleteAerobic.addActionListener(new BtnDeleteAerobicActionListener());
		btnDeleteAerobic.setBounds(260, 123, 81, 25);
		aerobicPane.add(btnDeleteAerobic);
		
		listAerobic = new JList();
		listAerobic.addMouseListener(new ListAerobicMouseListener());
		listAerobic.setBounds(353, 63, 130, 96);
		aerobicPane.add(listAerobic);
		
		textFieldHeartRateAerobic = new JTextField();
		textFieldHeartRateAerobic.setToolTipText("the average heart rate");
		textFieldHeartRateAerobic.setBounds(139, 102, 114, 19);
		textFieldHeartRateAerobic.addKeyListener(new KeyGeneralListener());
		aerobicPane.add(textFieldHeartRateAerobic);
		textFieldHeartRateAerobic.setColumns(10);
		
		textFieldTimeAerobic = new JTextField();
		textFieldTimeAerobic.setToolTipText("work out time in minutes");
		textFieldTimeAerobic.setBounds(139, 63, 114, 19);
		textFieldTimeAerobic.addKeyListener(new KeyGeneralListener());
		aerobicPane.add(textFieldTimeAerobic);
		textFieldTimeAerobic.setColumns(10);
		
		textFieldNotesAerobic = new JTextField();
		textFieldNotesAerobic.setToolTipText("What else did you want to take note of?");
		textFieldNotesAerobic.setBounds(139, 144, 114, 19);
		aerobicPane.add(textFieldNotesAerobic);
		textFieldNotesAerobic.setColumns(10);
		
		comboBoxAerobics = new JComboBox();
		comboBoxAerobics.setToolTipText("what kind of aerobic did you do?");
		comboBoxAerobics.setModel(new DefaultComboBoxModel(new String[] {"Running", "Swimming", "Walking", "Cycling", "Spinning"}));
		comboBoxAerobics.setBounds(83, 19, 114, 24);
		aerobicPane.add(comboBoxAerobics);
		
		JLabel lblDistance = new JLabel("Distance(miles)");
		lblDistance.setBounds(209, 24, 109, 15);
		aerobicPane.add(lblDistance);
		
		textFieldDistance = new JTextField();
		textFieldDistance.setToolTipText("how far did you do this aerobic for?");
		textFieldDistance.addKeyListener(new KeyGeneralListener());
		textFieldDistance.setBounds(334, 24, 55, 19);
		aerobicPane.add(textFieldDistance);
		textFieldDistance.setColumns(10);
		aerobicPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxAerobics, textFieldDistance, textFieldTimeAerobic, textFieldHeartRateAerobic, textFieldNotesAerobic, btnAddAerobic, btnDeleteAerobic, listAerobic}));
		
		JPanel sportPane = new JPanel();
		sportPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		tabbedPane.addTab("Sports", null, sportPane, null);
		sportPane.setLayout(null);
		
		JLabel lblSports = new JLabel("Sports");
		lblSports.setBounds(12, 24, 70, 15);
		sportPane.add(lblSports);
		
		JLabel lblTime = new JLabel("Time(minutes)");
		lblTime.setBounds(12, 63, 100, 15);
		sportPane.add(lblTime);
		
		JLabel lblHeartRate = new JLabel("Heart Rate(BPM)");
		lblHeartRate.setBounds(12, 102, 135, 15);
		sportPane.add(lblHeartRate);
		
		JLabel lblNotes = new JLabel("Notes(optional)");
		lblNotes.setBounds(12, 144, 90, 15);
		sportPane.add(lblNotes);
		
		comboBoxSportsPlayed = new JComboBox();
		comboBoxSportsPlayed.setToolTipText("what kind of sports did you play?");
		comboBoxSportsPlayed.setModel(new DefaultComboBoxModel(sports));
		comboBoxSportsPlayed.setBounds(139, 19, 114, 24);
		sportPane.add(comboBoxSportsPlayed);
		
		textFieldSportsHeartRate = new JTextField();
		textFieldSportsHeartRate.setToolTipText("what was your average heart rate?");
		textFieldSportsHeartRate.setBounds(139, 102, 114, 19);
		textFieldSportsHeartRate.addKeyListener(new KeyGeneralListener());
		sportPane.add(textFieldSportsHeartRate);
		textFieldSportsHeartRate.setColumns(10);
		
		textFieldSportsNotes = new JTextField();
		textFieldSportsNotes.setToolTipText("anything else to note?");
		textFieldSportsNotes.setBounds(139, 144, 114, 19);
		sportPane.add(textFieldSportsNotes);
		textFieldSportsNotes.setColumns(10);
		
		textFieldSportsTime = new JTextField();
		textFieldSportsTime.setToolTipText("how long did you play?");
		textFieldSportsTime.setBounds(139, 63, 114, 19);
		textFieldSportsTime.addKeyListener(new KeyGeneralListener());
		sportPane.add(textFieldSportsTime);
		textFieldSportsTime.setColumns(10);
		
		JButton btnAddSports = new JButton("Add");
		btnAddSports.addActionListener(new BtnAddActionListener());
		btnAddSports.setBounds(260, 71, 81, 25);
		sportPane.add(btnAddSports);
		
		JButton btnDeleteSports = new JButton("Delete");
		btnDeleteSports.addActionListener(new BtnDeleteActionListener());
		btnDeleteSports.setBounds(260, 123, 81, 25);
		sportPane.add(btnDeleteSports);
		
		listSportsPlayed = new JList();
		listSportsPlayed.addMouseListener(new ListSportsPlayedMouseListener());
		listSportsPlayed.setSelectedIndex(0);
		listSportsPlayed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSportsPlayed.setBounds(353, 63, 130, 96);
		sportPane.add(listSportsPlayed);
		sportPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxSportsPlayed, textFieldSportsTime, textFieldSportsHeartRate, textFieldSportsNotes, btnAddSports, btnDeleteSports, listSportsPlayed}));
		
		JPanel weightPane = new JPanel();
		weightPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		tabbedPane.addTab("Weight", null, weightPane, null);
		weightPane.setLayout(null);
		
		JLabel lblWorkOut = new JLabel("Movement");
		lblWorkOut.setBounds(12, 24, 100, 15);
		weightPane.add(lblWorkOut);
		
		JLabel lblReps = new JLabel("Reps");
		lblReps.setBounds(12, 63, 50, 15);
		weightPane.add(lblReps);
		
		JLabel label_2 = new JLabel("Heart Rate(BPM)");
		label_2.setBounds(12, 102, 135, 15);
		weightPane.add(label_2);
		
		JLabel lblNotesoptional = new JLabel("Notes(optional)");
		lblNotesoptional.setBounds(12, 144, 100, 15);
		weightPane.add(lblNotesoptional);
		
		comboBoxMovement = new JComboBox();
		comboBoxMovement.setModel(new DefaultComboBoxModel(new String[] {"Biceps Curls", "Triceps Curls", "Bench Press", "Dumpbell Shoulder Press", "Deadlift", "Squat", "Sit-ups"}));
		comboBoxMovement.setBounds(139, 19, 135, 24);
		weightPane.add(comboBoxMovement);
		
		textFieldHeartRateWeight = new JTextField();
		textFieldHeartRateWeight.setToolTipText("average heart rate?");
		textFieldHeartRateWeight.setColumns(10);
		textFieldHeartRateWeight.setBounds(139, 102, 114, 19);
		textFieldHeartRateWeight.addKeyListener(new KeyGeneralListener());
		weightPane.add(textFieldHeartRateWeight);
		
		textFieldNotesWeight = new JTextField();
		textFieldNotesWeight.setColumns(10);
		textFieldNotesWeight.setBounds(139, 144, 114, 19);
		weightPane.add(textFieldNotesWeight);
		
		textFieldReps = new JTextField();
		textFieldReps.setToolTipText("how many repititions did you do?");
		textFieldReps.setColumns(10);
		textFieldReps.setBounds(59, 63, 40, 19);
		textFieldReps.addKeyListener(new KeyGeneralListener());
		weightPane.add(textFieldReps);
		
		JButton btnAddWeight = new JButton("Add");
		btnAddWeight.addActionListener(new BtnAddWeightActionListener());
		btnAddWeight.setBounds(260, 71, 81, 25);
		weightPane.add(btnAddWeight);
		
		JButton btnDeleteWeight = new JButton("Delete");
		btnDeleteWeight.addActionListener(new BtnDeleteWeightActionListener());
		btnDeleteWeight.setBounds(260, 123, 81, 25);
		weightPane.add(btnDeleteWeight);
		
		listWeight = new JList();
		listWeight.addMouseListener(new ListWeightMouseListener());
		listWeight.setBounds(353, 63, 130, 96);
		weightPane.add(listWeight);
		
		JLabel lblWeight = new JLabel("Weight(lb)");
		lblWeight.setBounds(115, 63, 81, 15);
		weightPane.add(lblWeight);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setToolTipText("how heavy was the weight?");
		textFieldWeight.setBounds(206, 63, 40, 19);
		textFieldWeight.addKeyListener(new KeyGeneralListener());
		weightPane.add(textFieldWeight);
		textFieldWeight.setColumns(10);
		weightPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxMovement, textFieldReps, textFieldWeight, textFieldHeartRateWeight, textFieldNotesWeight, btnAddWeight, btnDeleteWeight, listWeight}));
		
		JButton btnSaveExercise = new JButton("Save");
		btnSaveExercise.addActionListener(new BtnSaveExerciseActionListener());
		btnSaveExercise.setBounds(30, 237, 117, 25);
		ExercisePane_1.add(btnSaveExercise);
		
		btnBackExercise = new JButton("Back");
		btnBackExercise.addActionListener(new ButtonBackListener());
		btnBackExercise.setBounds(323, 237, 117, 25);
		ExercisePane_1.add(btnBackExercise);
		
		JButton btnClearExercise = new JButton("Clear");
		btnClearExercise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSports();
				clearAerobic();
				clearWeight();
			}
		});
		btnClearExercise.setBounds(175, 237, 117, 25);
		ExercisePane_1.add(btnClearExercise);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(30, 210, 70, 15);
		ExercisePane_1.add(lblDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setEditable(false);
		textFieldDate.setBounds(104, 206, 252, 19);
		textFieldDate.setText(new Date().toString());
		ExercisePane_1.add(textFieldDate);
		textFieldDate.setColumns(10);
		ExercisePane_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnSaveExercise, btnClearExercise, btnBackExercise}));
		
		LogIn = new JPanel();
		LogIn.setName("LogIn");
		panel.add(LogIn, "LogIn");
		LogIn.setLayout(null);
		

		
		JPanel LogInPane_1 = new JPanel();
		LogInPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		LogInPane_1.setSize(new Dimension(600, 300));
		LogInPane_1.setBounds(0, 0, 505, 273);
		LogIn.add(LogInPane_1);
		LogInPane_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(51, 12, 99, 29);
		LogInPane_1.add(lblName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setToolTipText("Please enter your name");
		textFieldUserName.setBounds(51, 42, 231, 19);
		LogInPane_1.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(-10004, -10023, 442, 273);
		LogIn.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		NewUser = new JPanel();
		NewUser.setName("NewUser");
		panel.add(NewUser, "NewUser");
		NewUser.setLayout(null);
		
		
		
		JPanel NewUserPanel = new JPanel();
		NewUserPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		NewUserPanel.setBounds(0, 0, 502, 273);
		NewUserPanel.setName("NewUser1");
		NewUser.add(NewUserPanel);
		NewUserPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(30, 12, 70, 15);
		NewUserPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rest Heart Rate");
		lblNewLabel_1.setBounds(30, 53, 129, 15);
		NewUserPanel.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(167, 10, 226, 19);
		NewUserPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldRHR = new JTextField();
		textFieldRHR.setBounds(167, 51, 226, 19);
		textFieldRHR.addKeyListener(new KeyGeneralListener());
		NewUserPanel.add(textFieldRHR);
		textFieldRHR.setColumns(10);
		
		JButton btnRecord = new JButton("Record");
		btnRecord.setMnemonic('r');
		btnRecord.addActionListener(new BtnRegisterActionListener());
		btnRecord.setBounds(30, 208, 117, 25);
		NewUserPanel.add(btnRecord);
		
		JButton btnClearNewUser = new JButton("Clear");
		btnClearNewUser.setMnemonic('c');
		btnClearNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearExerciseDay();
			}
		});
		btnClearNewUser.setBounds(172, 208, 117, 25);
		NewUserPanel.add(btnClearNewUser);
		
		btnBackNewUser = new JButton("Back");
		btnBackNewUser.setMnemonic('b');
		btnBackNewUser.addActionListener(new ButtonBackListener());
		btnBackNewUser.setBounds(304, 208, 117, 25);
		NewUserPanel.add(btnBackNewUser);
		
		JLabel lblCaloriesIntake = new JLabel("Calories Intake");
		lblCaloriesIntake.setBounds(30, 91, 117, 15);
		NewUserPanel.add(lblCaloriesIntake);
		
		textFieldCaloriesIntake = new JTextField();
		textFieldCaloriesIntake.setBounds(167, 89, 226, 19);
		textFieldHeartRateAerobic.addKeyListener(new KeyGeneralListener());
		NewUserPanel.add(textFieldCaloriesIntake);
		textFieldCaloriesIntake.setColumns(10);
		
		JLabel lblTodaysDate = new JLabel("Date");
		lblTodaysDate.setBounds(30, 133, 93, 15);
		NewUserPanel.add(lblTodaysDate);
		
		textFieldAutoDate = new JTextField();
		textFieldAutoDate.setEditable(false);
		textFieldAutoDate.setBounds(167, 131, 226, 19);
		textFieldAutoDate.setText(String.valueOf(new Date()));
		NewUserPanel.add(textFieldAutoDate);
		textFieldAutoDate.setColumns(10);
		
		JLabel lblNotes_1 = new JLabel("Notes(optional)");
		lblNotes_1.setBounds(30, 174, 93, 15);
		NewUserPanel.add(lblNotes_1);
		
		textFieldNotesExerciseDay = new JTextField();
		textFieldNotesExerciseDay.setBounds(167, 177, 226, 19);
		NewUserPanel.add(textFieldNotesExerciseDay);
		textFieldNotesExerciseDay.setColumns(10);
		NewUserPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldName, textFieldRHR, textFieldCaloriesIntake, textFieldNotesExerciseDay, btnRecord, btnClearNewUser, btnBackNewUser}));
		
		
		btnNewUser = new JButton("New User");
		btnNewUser.setMnemonic('n');
		btnNewUser.setBounds(32, 171, 117, 25);
		btnNewUser.addActionListener(new ButtonNewUserListener());
		WelcomePane.add(btnNewUser);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.setMnemonic('l');
		btnLogIn.setBounds(204, 171, 117, 25);
		btnLogIn.addActionListener(new ButtonLogInListener());
		WelcomePane.add(btnLogIn);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setMnemonic('x');
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null, "Exitting?");
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					
				}
				
			}
		});
		btnExit.setBounds(373, 171, 117, 25);
		WelcomePane.add(btnExit);
		
		JLabel lblNewLabel_3 = new JLabel("<html>This program will record, save, load, and modify your saved records of your daily workout routine, such as weight training, aerobic, and sports. It will record your time, your heart rate, your time spend on each workouts, etc. Enjoy!</html>");
		lblNewLabel_3.setBounds(10, 61, 445, 91);
		WelcomePane.add(lblNewLabel_3);
		WelcomePane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewUser, btnLogIn, btnExit}));
		Welcome.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewUser, btnLogIn, btnExit}));

		JButton btnLoad = new JButton("Load");
		btnLoad.setMnemonic('l');
		btnLoad.setToolTipText("Load");
		btnLoad.setBounds(51, 209, 117, 25);
		btnLoad.addActionListener(new ButtonLogInToExerciseListener());
		LogInPane_1.add(btnLoad);
		
		btnBackLogIn = new JButton("Back");
		btnBackLogIn.setMnemonic('b');
		btnBackLogIn.setToolTipText("Back to welcome");
		btnBackLogIn.addActionListener(new ButtonBackListener());
		btnBackLogIn.setBounds(376, 209, 117, 25);
		LogInPane_1.add(btnBackLogIn);
		
		JLabel lblDate_1 = new JLabel("Exercise Date");
		lblDate_1.setBounds(51, 89, 117, 15);
		LogInPane_1.add(lblDate_1);
		
		textFieldLogInDate = new JTextField();
		textFieldLogInDate.setToolTipText("Please enter the recorded in format YYYY/MM/DD");
		textFieldLogInDate.setBounds(51, 127, 114, 19);
		LogInPane_1.add(textFieldLogInDate);
		textFieldLogInDate.setColumns(10);
		
		JLabel lblYyyymmdd = new JLabel("YYYY/MM/DD");
		lblYyyymmdd.setBounds(175, 129, 99, 15);
		LogInPane_1.add(lblYyyymmdd);
		
		JButton btnLoadExercise = new JButton("Load Exercise");
		btnLoadExercise.addActionListener(new BtnLoadExerciseActionListener());
		btnLoadExercise.setBounds(30, 245, 131, 25);
		NewUserPanel.add(btnLoadExercise);
		
		
	}
	private class ButtonNewUserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent pArg0) {

			CardLayout cl = (CardLayout)panel.getLayout();
			cl.show(panel, NewUser.getName());
			
			textFieldName.requestFocus();
		}
		
	}

	private class ButtonLogInToExerciseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent pArg0) {
			try {
			myExercise.clear();
			clearExerciseDay();
			
			//myExercise = new ExerciseDay();
			Date d = new Date(textFieldLogInDate.getText());
			
			myExercise.load(textFieldUserName.getText(), d);
			
			JOptionPane.showMessageDialog(null, "Welcome Back, " + myExercise.getUserName());

			CardLayout cl = (CardLayout)panel.getLayout();
			cl.show(panel, NewUser.getName());
			
			updateExerciseDay();
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
			
			comboBoxAerobics.requestFocus();
		}
	}
	private class ButtonLogInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent pArg0) {
			
			CardLayout cl = (CardLayout)panel.getLayout();
			cl.show(panel, LogIn.getName());
			
			clearGUI();
			
			textFieldUserName.requestFocus();
		}
}
	private class ButtonBackListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cl = (CardLayout)panel.getLayout();
			cl.show(panel, Welcome.getName());
			
			clearGUI();
		}
	}
	private class BtnBackListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cl = (CardLayout)panel.getLayout();
			cl.show(panel, Welcome.getName());
			
			clearGUI();
		}
	}
	private class BtnRegisterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			sportsList.add(new Sports());
			aerobicList.add(new Aerobic());
			weightList.add(new Weight());
			
			
			myExercise.setRHR(Integer.parseInt(textFieldRHR.getText()));
			myExercise.setDate(new Date());
			myExercise.setUserName(textFieldName.getText());
			myExercise.setNotes(textFieldNotesExerciseDay.getText());
			myExercise.setCalories(Double.parseDouble(textFieldCaloriesIntake.getText()));
			
			myWeight.setNewUser(myExercise);
			myAerobic.setNewUser(myExercise);
			mySports.setNewUser(myExercise);
			
			myExercise.save();
			
			JOptionPane.showMessageDialog(Exercise, "Recorded!");
			CardLayout  cl = (CardLayout)panel.getLayout();
			cl.show(panel, Exercise.getName());
			
			clearGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
		}
	}
	private class BtnSaveExerciseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {

			
			if(weightList.size()>1) {
				for(int i = 1; i < (weightList.size()); i++) {
			
				((Weight) weightList.get(i)).save();
			}
				}
			
			if(sportsList.size() > 1){
			for(int i = 1; i < (sportsList.size()); i++) {
				((Sports) sportsList.get(i)).save();
			}
			}
			
			if(aerobicList.size() > 1){
			for(int i = 1; i < (aerobicList.size()); i++) {

				((Aerobic) aerobicList.get(i)).save();
			}
			} 
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
				}
			
			clearGUI();
		}
	}
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			Sports sportsWorkouts = new Sports();
			sportsWorkouts.setUserName(myExercise.getUserName());
			sportsWorkouts.setDate(new Date());
			sportsWorkouts.setSportsPlayed(comboBoxSportsPlayed.getSelectedItem().toString());
			
			sportsWorkouts.setTime(Double.parseDouble(textFieldSportsTime.getText()));
			sportsWorkouts.setHeartRate(Integer.parseInt(textFieldSportsHeartRate.getText()));
			sportsWorkouts.setNotes(textFieldSportsNotes.getText());
			
			sportsList.add(sportsWorkouts);
			
			listModelSportsPlayed.addElement(comboBoxSportsPlayed.getSelectedItem());
			
			listSportsPlayed.setModel(listModelSportsPlayed);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
				e.printStackTrace();
			}
			
			clearSports();

			
		}
	}
	private class BtnDeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			
			try {
	

			
			
			
			sportsList.remove(listSportsPlayed.getSelectedIndex() );
			listModelSportsPlayed.removeElement(listSportsPlayed.getSelectedValue());
			
			listSportsPlayed.setModel(listModelSportsPlayed);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
			
			
			
			
		}
	}
	private class ListSportsPlayedMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
			if(e.getClickCount() == 1) {
				
			updateSports();
				
				
			} else if(e.getClickCount()==2) {
				sportsList.remove(listSportsPlayed.getSelectedIndex() );
				listModelSportsPlayed.removeElement(listSportsPlayed.getSelectedValue());
				
				listSportsPlayed.setModel(listModelSportsPlayed);
			} 			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
				ex.printStackTrace();
			}
		
		} 
	}
	private class BtnAddAerobicActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			try {
			
			Aerobic aerobicWorkouts = new Aerobic();
			
			aerobicWorkouts.setUserName(myExercise.getUserName());
			aerobicWorkouts.setDate(new Date());
			aerobicWorkouts.setExercise(comboBoxAerobics.getSelectedItem().toString());
			aerobicWorkouts.setTime(Double.parseDouble(textFieldTimeAerobic.getText()));
			aerobicWorkouts.setDistance(Double.parseDouble(textFieldDistance.getText()));
			aerobicWorkouts.setHeartRate(Integer.parseInt(textFieldHeartRateAerobic.getText()));
			aerobicWorkouts.setNotes(textFieldNotesAerobic.getText());
			
			aerobicList.add(aerobicWorkouts);
			listModelAerobic.addElement(comboBoxAerobics.getSelectedItem());
			listAerobic.setModel(listModelAerobic);
			
			clearAerobic();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
		}
	}
	private class BtnDeleteAerobicActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			try {
			
			aerobicList.remove(listAerobic.getSelectedIndex() );
			
			listModelAerobic.removeElement(listAerobic.getSelectedValue());
			
			listAerobic.setModel(listModelAerobic);
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
		}
	}
	private class ListAerobicMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
			if(e.getClickCount() == 1) {
				
			updateAerobic();
				
				
			} else if(e.getClickCount()==2) {
				aerobicList.remove(listAerobic.getSelectedIndex() );
				listModelAerobic.removeElement(listAerobic.getSelectedValue());
				
				listAerobic.setModel(listModelAerobic);
			}			
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
		
		}
	}
	private class BtnAddWeightActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			Weight WeightWorkouts = new Weight();
			WeightWorkouts.setUserName(myExercise.getUserName());
			WeightWorkouts.setDate(new Date());
			WeightWorkouts.setExercise(comboBoxMovement.getSelectedItem().toString());
			WeightWorkouts.setHeartRate(Integer.parseInt(textFieldHeartRateWeight.getText()));
			WeightWorkouts.setNotes(textFieldNotesWeight.getText());
			WeightWorkouts.setReps(Integer.parseInt(textFieldReps.getText()));
			WeightWorkouts.setWeight(Double.parseDouble(textFieldWeight.getText()));
			
			weightList.add(WeightWorkouts);
			listModelWeight.addElement(comboBoxMovement.getSelectedItem());
			listWeight.setModel(listModelWeight);
			
			clearWeight();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			} 
		}
	}
	private class BtnDeleteWeightActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			weightList.remove(listWeight.getSelectedIndex() );
			
			listModelWeight.removeElement(listWeight.getSelectedValue());
			
			listWeight.setModel(listModelWeight);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
			
		}
	}
	private class ListWeightMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
			if(e.getClickCount() == 1) {
				
			updateWeight();
				
				
			} else if(e.getClickCount()==2) {
				weightList.remove(listWeight.getSelectedIndex() );
				listModelWeight.removeElement(listWeight.getSelectedValue());
				
				listWeight.setModel(listModelWeight);
			}			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ops, looks like something was wrong. It"
						+ " is either you entered was wrong, or it is our code's freaking out. "
						+ "Please make sure all the required fields were filled out, and we will "
						+ "try again for you! :)");
			}
		
		}
	}
	
	
	private class BtnLoadExerciseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			clearSports();
			
			Sports mySports = new Sports();
			Aerobic myAerobic = new Aerobic();
			Weight myWeight = new Weight();
			
			mySports.load(myExercise.getUserName(), myExercise.getDate());
			myAerobic.load(myExercise.getUserName(), myExercise.getDate());
			myWeight.load(myExercise.getUserName(), myExercise.getDate());


			sportsList.addAll(mySports.getSports());
			aerobicList.addAll(myAerobic.getSports());
			weightList.addAll(myWeight.getSports());

			

			
			

		
			for(int i = 0;i < sportsList.size(); i++) {
			listModelSportsPlayed.addElement(sportsList.get(i).getSportsPlayed());
						
			}
			listSportsPlayed.setModel(listModelSportsPlayed);
			for(int i = 0;i < weightList.size(); i++) {
			listModelWeight.addElement(weightList.get(i).getExercise());
						
			}
			listWeight.setModel(listModelWeight);
			for(int i = 0;i < aerobicList.size(); i++) {
			listModelAerobic.addElement(aerobicList.get(i).getExercise());
						
			}
			listAerobic.setModel(listModelAerobic);
			
			int a = listSportsPlayed.getSelectedIndex();
			int b = listAerobic.getSelectedIndex();
			int c = listWeight.getSelectedIndex();
			textFieldSportsTime.setText(String.valueOf(sportsList.get(0).getTime()));
			textFieldSportsHeartRate.setText(String.valueOf(sportsList.get(0).getHeartRate()));
			textFieldSportsNotes.setText(sportsList.get(0).getNotes());
			comboBoxSportsPlayed.setSelectedItem(sportsList.get(0).getSportsPlayed());
			
			textFieldTimeAerobic.setText(String.valueOf(aerobicList.get(0).getTime()));
			textFieldHeartRateAerobic.setText(String.valueOf(aerobicList.get(0).getHeartRate()));
			textFieldNotesAerobic.setText(aerobicList.get(0).getNotes());
			comboBoxAerobics.setSelectedItem(aerobicList.get(0).getExercise());
			
			textFieldWeight.setText(String.valueOf(weightList.get(0).getWeight()));
			textFieldHeartRateWeight.setText(String.valueOf(weightList.get(0).getHeartRate()));
			textFieldNotesWeight.setText(weightList.get(0).getNotes());
			comboBoxMovement.setSelectedItem(weightList.get(0).getExercise());
			textFieldReps.setText(String.valueOf(weightList.get(0).getReps()));
			
			CardLayout cl = (CardLayout)panel.getLayout();
			cl.show(panel, Exercise.getName());
			} 
		 
	}
	
	private class KeyGeneralListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent pArg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent pArg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyTyped(KeyEvent arg0) {
			// if user entered something other than
			// escape, enter, or .
			if (arg0.getKeyChar() != KeyEvent.VK_ESCAPE
					&& arg0.getKeyChar() != KeyEvent.VK_ENTER
					&& arg0.getKeyChar() != '.') {
				// if the user entered something other than a
				// number.
				if (arg0.getKeyChar() < KeyEvent.VK_0
						|| arg0.getKeyChar() > KeyEvent.VK_9) {
					arg0.consume();
				}

			
		} else if (arg0.getKeyChar() == KeyEvent.VK_ESCAPE) {
			clearGUI();
		}
		
	}
	
	}

	
	private void clearSports() {

		textFieldSportsTime.setText("");
		textFieldSportsHeartRate.setText("");
		textFieldSportsNotes.setText("");
		comboBoxSportsPlayed.setSelectedIndex(0);
	}
	
	private void updateSports() {
		int a =0;
		
		a = listSportsPlayed.getSelectedIndex() ;
		Sports sports = (Sports) sportsList.get(a);
		textFieldSportsTime.setText(String.valueOf(sports.getTime()));
		textFieldSportsHeartRate.setText(String.valueOf(sports.getHeartRate()));
		textFieldSportsNotes.setText(sports.getNotes());
		comboBoxSportsPlayed.setSelectedItem(sports.getSportsPlayed());
		textFieldDate.setText(sports.getDate().toString());
		
		
		
	}
	private void clearAerobic() {
		textFieldTimeAerobic.setText("");
		textFieldDistance.setText("");
		textFieldHeartRateAerobic.setText("");
		textFieldNotesAerobic.setText("");
		comboBoxAerobics.setSelectedIndex(0);
	}
	private void updateAerobic() {
		int a = listAerobic.getSelectedIndex();
		Aerobic aerobic = (Aerobic) aerobicList.get(a);
		textFieldTimeAerobic.setText(String.valueOf(aerobic.getTime()));
		textFieldHeartRateAerobic.setText(String.valueOf(aerobic.getHeartRate()));
		textFieldNotesAerobic.setText(aerobic.getNotes());
		textFieldDistance.setText(String.valueOf(aerobic.getDistance()));
		comboBoxAerobics.setSelectedItem(aerobic.getExercise());
		textFieldDate.setText(aerobic.getDate().toString());
	}
	private void clearWeight() {
		textFieldWeight.setText("");
		textFieldReps.setText("");
		textFieldHeartRateWeight.setText("");
		textFieldNotesWeight.setText("");
		comboBoxMovement.setSelectedIndex(0);
	}
	private void updateWeight() {
		int a = listWeight.getSelectedIndex();
		Weight weight = (Weight) weightList.get(a);
		textFieldReps.setText(String.valueOf(weight.getReps()));
		textFieldHeartRateWeight.setText(String.valueOf(weight.getHeartRate()));
		textFieldNotesWeight.setText(weight.getNotes());
		textFieldWeight.setText(String.valueOf(weight.getWeight()));
		comboBoxMovement.setSelectedItem(weight.getExercise());
		textFieldDate.setText(weight.getDate().toString());
	}
	private void clearExerciseDay() {
		textFieldCaloriesIntake.setText("");
		textFieldRHR.setText("");
		textFieldNotesExerciseDay.setText("");
		textFieldName.setText("");
		textFieldAutoDate.setText("");
	}
	private void updateExerciseDay() {
	textFieldCaloriesIntake.setText(String.valueOf(myExercise.getCalories()));
	textFieldRHR.setText(String.valueOf(myExercise.getRHR()));
	textFieldNotesExerciseDay.setText(String.valueOf(myExercise.getNotes()));
	textFieldName.setText(myExercise.getUserName());
	textFieldAutoDate.setText(String.valueOf(myExercise.getDate()));
	}
	public void clearGUI() {
		textFieldCaloriesIntake.setText("");
		textFieldRHR.setText("");
		textFieldNotesExerciseDay.setText("");
		textFieldName.setText("");
		
		textFieldWeight.setText("");
		textFieldReps.setText("");
		textFieldHeartRateWeight.setText("");
		textFieldNotesWeight.setText("");
		comboBoxMovement.setSelectedIndex(0);

		textFieldSportsTime.setText("");
		textFieldSportsHeartRate.setText("");
		textFieldSportsNotes.setText("");
		comboBoxSportsPlayed.setSelectedIndex(0);
		textFieldTimeAerobic.setText("");
		textFieldDistance.setText("");
		textFieldHeartRateAerobic.setText("");
		textFieldNotesAerobic.setText("");
		comboBoxAerobics.setSelectedIndex(0);
	}
}
