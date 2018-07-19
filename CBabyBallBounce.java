package javaAssignment;

/**
 * Program name : Baby ball bounce game
 * File name : CBabyBallBounce.java
 * @author Kailash Bhattarai
 * UN id: 17425099
 * Course : B.Sc.(HONS) computing
 * Module: CSY1020 problem solving and programming
 * Tutor: Loksesh gupta
 * version:1.3
 * Date: 2017/7/20
 */

//All the necessary imports for the assignments
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** 
 * this is the main class (CBabyBallBounce) which extends JFrame this game can
 * be played by two players on each side of the barrier. There are three stages
 * of game basic, intermediate and advanced. a team can win if the ball strikes
 * in the opposite wall as score keeps on increasing.
 * 
 * This class extends JFrame of swing api and implements action listener, change
 * listener and key listener
 * 
 * @author KAILASH
 * 
 */
public class CBabyBallBounce extends JFrame implements ActionListener,
		ChangeListener, KeyListener {

	int timeInSecond = 0;// counts time in seconds.
	int x = 6; // x coordinate of the ball initially
	int y = 6; // y coordinate of the ball initially
	private JMenuBar menubar; // Menubar of the JFrame
	private JMenu menu1, menu2, menu3, menu4; // Menu of the frame.
	private JPanel gamePanel, controlPanel, bottomPanel; // declaration of three panels gamePanel
											// controlPanel and bottomPanel
	//Counts the score of baby1 and baby2.
	private int baby1Score = 0, baby2Score = 0;
	private JButton panelButton[][], actButton, runButton, resetButton; // panelButton
																		// is
																		// the
																		// array
																		// of
																		// all
																		// the
																		// 13 /
																		// 16
																		// buttons
																		// arranged
																		// in
																		// the
																		// grid.
																		// also
																		// button
																		// to
																		// make
																		// ball
																		// move
																		// once,
																		// run
																		// and
																		// reset
																		// our
																		// game
																		// is
																		// used.
	private JLabel optionLabel, squareLabel, directionLabel, digitalTimerLabel,
			scoreLabel, semi1Label, semi2Label; // declaration
																		// of
																		// the
																		// label
																		// used
																		// in
																		// this
																		// application.
	private JSlider slider;// Declaration of the slider used to set the speed of
							// the ball.
	private JButton forwardButton, backwardButton, upButton, downButton,
			blank1, blank2, blank3, blank4, ballImageButton; // Collection of
																// all the
																// buttons which
																// are set to
																// move the ball
																// in any
																// specified
																// direction.
																// And also five
																// unused
																// buttons.
	private JTextField optionTextField, squareTextField, directionTextField;// Textfield
																			// that
																			// shows
																			// no.
																			// of
																			// players,
																			// the
																			// pall
																			// position
																			// and
																			// the
																			// direction
																			// of
																			// the
																			// ball.
	private JButton twoPlayerButton, fourPlayerButton, multiPlayerButton,
			exitButton;// Button used to determine option for two player, four
						// players and multiplayers also a exit button.
	private JTextField hourTextField, minuteTextField, secondTextField;// Textfield
																		// to
																		// determine
																		// the
																		// hour,
																		// minute
																		// and
																		// second
																		// the
																		// game
																		// has
																		// been
																		// running.
	private JButton compassButton;// Button that shows the direction of the
									// ball.
	private JTextField baby1ScoreTextField, baby2ScoreTextField;// Textfield
																// showing the
																// score of
																// baby1 and
																// baby2.
	private Timer time, ballMotion;// Two object of Timer class used, time to
									// determine time of game being run and
									// ballMotion to move the ball in a
									// particular direction.
	int xPassed = 1, yPassed;// global variable to determine the direction of
								// ball.
	boolean startButtonPressed = false;
	int xBaby1 = 4, yBaby1 = 6, xBaby2 = 12, yBaby2 = 6, yBaby3 = 3,
			yBaby4 = 3, yBaby5 = 9, yBaby6 = 9; // Initialization of the babies
												// in their respective x and y
												// coordinate position.
	Container contentPane;// Container that contains all the JFrame
	boolean resetButtonClicked = false;// Boolean value to determine weather
										// reset button must work or not.
	boolean twoPlayerButtonPressed = true, fourPlayerButtonPressed = false,
			multiPlayerButtonPressed = false; // Boolean value to determine
												// weather two player,four
												// player or multi player button
												// must work or not.

	ImageIcon baby1 = new ImageIcon(
			"C:/Users/KAILASH/Desktop/images/baby1.png"); // baby1
																			// object
																			// of
																			// ImageIcon
																			// class
																			// to
																			// display
																			// image
																			// of
																			// baby1
	ImageIcon baby2 = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/baby2.png");// baby2
																		// object
																		// of
																		// ImageIcon
																		// class
																		// to
																		// display
																		// and
																		// use
																		// image
																		// of
																		// baby2.
	ImageIcon act = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/step.png");// represent
																		// the
																		// image
																		// of
																		// act
																		// button.
	ImageIcon run = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/run.png");// run
																		// object
																		// of
																		// ImageIcon
																		// class
																		// for
																		// run
																		// images
	ImageIcon reset = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/reset.png");// This
																		// contain
																		// the
																		// reset
																		// Icon
																		// object
	ImageIcon ballIcon = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/ball.png");// ImageIcon
																		// for
																		// ball.
	ImageIcon compassWestIcon = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/west.jpg");// ImageIcon
																		// for
																		// compass
																		// west
																		// direction.
	ImageIcon compassEastIcon = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/east.jpg");// ImageIcon
																		// for
																		// compass
																		// east
																		// direction.
	ImageIcon compassNorthIcon = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/north.jpg");// ImageIcon
																		// for
																		// compass
																		// north
																		// direction.
	ImageIcon compassSouthIcon = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/south.jpg");// ImageIcon
																		// for
																		// compass
																		// south
																		// direction.

	ImageIcon wall = new ImageIcon(
			"C:/Users/KAILASH/Desktop/psp assignment/images/bricks2.jpg");// ImageIcon
																			// for
																			// the
																			// wall.

	/**
	 * Constructor for CBabyBallBounce class. It initializes all the previously
	 * declared objects and variables
	 */
	public CBabyBallBounce() {

		menubar = new JMenuBar();
		menu1 = new JMenu("Scenario");
		menu2 = new JMenu("Edit");
		menu3 = new JMenu("Controls");
		menu4 = new JMenu("Help");

		// All the menus are added inside menubar.
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);

		setJMenuBar(menubar);

		panelButton = new JButton[13][16];

	}

	/**
	 * This is the main methods for the the assignment. It calls the gameGui()
	 * method which calls other methods.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CBabyBallBounce game = new CBabyBallBounce();
		game.setVisible(true);
		game.gameGui();
		game.setSize(825, 585);
		game.setResizable(false);
		game.setTitle("CBabyBallBounce- Baby Ball Bounce Application");
	}

	public void gameGui() {
		// To close the program execution as soon as cross button is pressed.
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// get the content pane and set its layout to null.
		contentPane = getContentPane();
		contentPane.setLayout(null);

		// Creates the objects gamePanel, controlPanel, bottomPanel of the JPanel class
		gamePanel = new JPanel();
		controlPanel = new JPanel();
		bottomPanel = new JPanel();

		// Sets the position of first JPanel gamePanel
		gamePanel.setBounds(15, 10, 600, 450);
		gamePanel.setBackground(Color.white);// Sets its background to white
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.black, 1, false)); // Sets
																					// border
																					// of
																					// color
																					// black
		gamePanel.setLayout(new GridLayout(13, 16));// sets the grid layout of 13 *
													// 16.
		contentPane.add(gamePanel);// add gamePanel to contentPane

		// Sets boundary of controlPanel and add border of color gray then adds panel
		// to Container.
		controlPanel.setBounds(15, 470, 800, 60);
		controlPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1, false));
		contentPane.add(controlPanel);

		// Sets boundary of bottomPanel and add border of color gray then adds panel
		// to Container.
		bottomPanel.setBounds(640, 10, 170, 450);
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1, false));
		contentPane.add(bottomPanel);

		// for getting the array of buttons in panel in 2 dimensional array.
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 16; j++) {
				panelButton[i][j] = new JButton();
				panelButton[i][j].setBackground(Color.white);	
				panelButton[i][j].setBorder(BorderFactory.createEmptyBorder());
				panelButton[i][j].addKeyListener(this);// sets the keyListener as run button is
				// clicked.
				gamePanel.add(panelButton[i][j]);
				
			}

		}
		// The following loop set the wall in the panel.
		for (int l = 0; l < 13; l++) {
			for (int k = 8; k < 10; k++) {
				panelButton[l][k].setIcon(wall);
			}
		}

		// initially sets the icon of the ball.
		panelButton[x][y].setIcon(ballIcon);

		// Sets the layout of controlPanel as null layout.
		controlPanel.setLayout(null);
		actButton = new JButton("act", act);// Sets the icon of the act button.
		actButton.setBounds(100, 20, 80, 20);// Sets the boundary of the
												// actButton.
		actButton.addActionListener(this);// Sets the actionListener for the act
											// button.
		controlPanel.add(actButton);// add act button to controlPanel.

		runButton = new JButton("run", run);// sets the icon and text for the
											// run button.
		runButton.setBounds(200, 20, 80, 20);// sets the boundary of the run
												// button.
		runButton.addActionListener(this);// Sets the action listener for run
											// button.

		runButton.addKeyListener(this);// sets the keyListener as run button is
										// clicked.
		controlPanel.add(runButton);// add run button to the controlPanel.

		resetButton = new JButton("reset", reset);// resets the game.
		resetButton.setBounds(300, 20, 100, 20);// sets the boundary/position
												// for the reset button.
		resetButton.addActionListener(this);// action Listener to listen to the
											// button clicked.
		controlPanel.add(resetButton);

		slider = new JSlider(JSlider.HORIZONTAL, 100, 1000, 500);// Sets the
																	// slider in
																	// horizontal
																	// direction
																	// with
																	// default
																	// value 300
		slider.setBounds(500, 5, 250, 40);
		slider.setMinorTickSpacing(20);// For the minor scales positions.
		slider.setMajorTickSpacing(200);// For the major scale positions.
		slider.setPaintLabels(true);// Show the label for slider scaling
		slider.setPaintTicks(true);// Shows the lines for slider scaling.
		slider.addChangeListener(this);// detects the change listener.
		controlPanel.add(slider);

		// The following statements sets the layout of bottomPanel to null and adds
		// the label to bottomPanel
		bottomPanel.setLayout(null);
		digitalTimerLabel = new JLabel("DIGITAL TIMER");
		digitalTimerLabel.setBounds(40, 5, 100, 20);
		bottomPanel.add(digitalTimerLabel);

		// Sets the hour text field to the controlPanel. Adds this to bottomPanel
		hourTextField = new JTextField(2);
		hourTextField.setBounds(10, 30, 30, 20);
		hourTextField.setForeground(Color.white);// sets the foreground color to
													// white and background to
													// balck
		hourTextField.setBackground(Color.black);
		bottomPanel.add(hourTextField);

		// adds the jlabel lying in between hour and minuteTextField to panel.
		semi1Label = new JLabel(" :");
		semi1Label.setBounds(50, 30, 10, 20);
		bottomPanel.add(semi1Label);

		// For the minute text field. It adds to bottomPanel.
		minuteTextField = new JTextField(2);
		minuteTextField.setBounds(70, 30, 30, 20);
		minuteTextField.setBackground(Color.black);
		minuteTextField.setForeground(Color.white);
		bottomPanel.add(minuteTextField);

		// For the label in between minute and second textfield.
		semi2Label = new JLabel(" :");
		semi2Label.setBounds(110, 30, 10, 20);
		bottomPanel.add(semi2Label);

		// This text field lies inside bottomPanel and displays the time from when
		// the game has been started.
		secondTextField = new JTextField(2);
		secondTextField.setBounds(130, 30, 30, 20);
		secondTextField.setBackground(Color.black);
		secondTextField.setForeground(Color.white);
		secondTextField.setText("");
		bottomPanel.add(secondTextField);

		// It is the label of the score.
		scoreLabel = new JLabel("SCORE");
		scoreLabel.setBounds(60, 50, 100, 20);
		bottomPanel.add(scoreLabel);

		// sets initially the icon of baby1 and baby2
		panelButton[yBaby1][xBaby1].setIcon(baby1);
		panelButton[yBaby2][xBaby2].setIcon(baby2);

		// the textfield that shows the score of baby2.
		baby2ScoreTextField = new JTextField(2);
		baby2ScoreTextField.setBounds(130, 70, 30, 20);
		baby2ScoreTextField.setBackground(Color.black);
		bottomPanel.add(baby2ScoreTextField);

		// the textfield that shows the score of baby1.
		baby1ScoreTextField = new JTextField(2);
		baby1ScoreTextField.setBounds(10, 70, 30, 20);
		baby1ScoreTextField.setBackground(Color.black);
		bottomPanel.add(baby1ScoreTextField);

		// the label in between baby1 and baby 2.
		semi2Label = new JLabel("<Left:Right>");
		semi2Label.setBounds(50, 70, 70, 20);
		bottomPanel.add(semi2Label);

		// Label of option button which is a label of optionTextField
		optionLabel = new JLabel("Option");
		optionLabel.setBounds(2, 110, 70, 20);
		bottomPanel.add(optionLabel);

		// textfield that shows the total numbers of players in the game.
		optionTextField = new JTextField(8);
		optionTextField.setBounds(80, 110, 85, 20);
		bottomPanel.add(optionTextField);

		// The label that shows the square portion in grid layout which contain
		// the baby.
		squareLabel = new JLabel("Square");
		squareLabel.setBounds(2, 150, 70, 20);
		bottomPanel.add(squareLabel);

		// the textfield that shows the number of girdbuttons that actually
		// contains ball as an imageicon.
		squareTextField = new JTextField(8);
		squareTextField.setBounds(80, 150, 85, 20);
		bottomPanel.add(squareTextField);

		// label of direction textfield.
		directionLabel = new JLabel("Direction");
		directionLabel.setBounds(2, 190, 70, 20);
		bottomPanel.add(directionLabel);

		// text field that shows the direction of the motion of the ball.
		directionTextField = new JTextField(8);
		directionTextField.setBounds(80, 190, 85, 20);
		bottomPanel.add(directionTextField);

		// blank1, blank2, blank3, blank4, ballImageButton has no particular
		// tasks at all.
		blank1 = new JButton();
		blank1.setBounds(2, 220, 58, 30);
		bottomPanel.add(blank1);

		// breaks the direction of the ball motion and make the ball move in
		// upward direction.
		upButton = new JButton("^");
		upButton.setBounds(62, 225, 45, 20);
		upButton.setBackground(Color.white);
		upButton.addActionListener(this);// Action listener for upButton.
		bottomPanel.add(upButton);

		blank2 = new JButton();
		blank2.setBounds(110, 220, 58, 30);
		bottomPanel.add(blank2);

		// Make the ball move in left direction by breaking the normal motion of
		// ball.
		backwardButton = new JButton("<");
		backwardButton.setBounds(7, 255, 45, 20);
		backwardButton.addActionListener(this);// Action listener for
												// backwardButton.
		backwardButton.setBackground(Color.white);
		bottomPanel.add(backwardButton);

		// This button has the image of the ball and has no particular function.
		ballImageButton = new JButton(ballIcon);
		ballImageButton.setBounds(63, 255, 45, 20);
		ballImageButton.setBackground(Color.white);
		bottomPanel.add(ballImageButton);

		// Make the ball move in right direction by breaking the normal motion
		// of ball.
		forwardButton = new JButton(">");
		forwardButton.setBounds(112, 255, 45, 20);
		forwardButton.addActionListener(this);// Add the actionListener for the
												// forward button.
		forwardButton.setBackground(Color.white);
		bottomPanel.add(forwardButton);

		blank3 = new JButton();
		blank3.setBounds(2, 280, 58, 30);
		bottomPanel.add(blank3);

		// Make the ball move in downward direction by breaking the normal
		// motion of ball.
		downButton = new JButton("v");
		downButton.setBounds(62, 285, 45, 20);
		downButton.setBackground(Color.white);
		downButton.addActionListener(this);// Add the action listener for the
											// downButton.
		bottomPanel.add(downButton);

		blank4 = new JButton();
		blank4.setBounds(110, 280, 58, 30);
		bottomPanel.add(blank4);

		// this button shows the direction of ball in the form of image
		compassButton = new JButton(compassWestIcon);
		compassButton.setBounds(50, 320, 70, 70);
		bottomPanel.add(compassButton);

		// Sets the player of the game to 2 player which is a basic level.
		twoPlayerButton = new JButton("2 Player");
		twoPlayerButton.setBounds(5, 400, 80, 20);
		twoPlayerButton.setBackground(Color.white);
		twoPlayerButton.addActionListener(this);// Adds the action listener for
												// the two player button.
		bottomPanel.add(twoPlayerButton);

		// Sets the player of the game to 4 player which is a intermediary
		// level.
		fourPlayerButton = new JButton("4 Player");
		fourPlayerButton.setBounds(87, 400, 82, 20);
		fourPlayerButton.addActionListener(this);
		fourPlayerButton.setBackground(Color.white);// Adds the action listener
													// for the two player
													// button.
		bottomPanel.add(fourPlayerButton);

		// Adds the multiplayer to the button.
		multiPlayerButton = new JButton("Multi");
		multiPlayerButton.setBounds(5, 425, 80, 20);
		multiPlayerButton.addActionListener(this);// Adds the action listener to
													// multiplayerButton.
		multiPlayerButton.setBackground(Color.white);
		bottomPanel.add(multiPlayerButton);

		// Add the exit button. The game closes if the exit button is pressed.
		exitButton = new JButton("Exit");
		exitButton.setBounds(87, 425, 82, 20);
		exitButton.addActionListener(this);
		exitButton.setBackground(Color.white);
		bottomPanel.add(exitButton);

		// Starts the timer. This timer keeps track of hour, minutes and
		// seconds.
		time = new Timer(1000, this);
		time.start();

		// Ball has its motion as specified by this timer.
		ballMotion = new Timer(300, this);
		ballMotion.start();

	}

	/**
	 * This method kickBall is called with the help of timer ballMotion. Every
	 * time the kickBall is called it receives two parameter and change its
	 * panelButton according to specified instruction. The direction of motion
	 * of ball changes if any collision is detected.
	 * 
	 * @param yChange
	 * @param xChange
	 */
	public void kickBall(int yChange, int xChange) {
		panelButton[y - yChange][x - xChange].setIcon(ballIcon);
		panelButton[y][x].setIcon(null);
		x = x - xChange;
		y = y - yChange;
		int squareBox = y * 16 + x + 1;
		squareTextField.setText("" + squareBox);// sets the square in which ball
												// is set as icon in
												// panelButton.
		setDirection();// Sets the direction of ball in imageIcon and as the
						// textField.
	}

	// This method checks the passed x and y motion value and sets the direction
	// of ball in text field and in image icon.
	public void setDirection() {
		if (yPassed == 1 && xPassed == 0) {
			directionTextField.setText("North");
			compassButton.setIcon(compassNorthIcon);
		}
		if (yPassed == 1 && xPassed == 1) {
			directionTextField.setText("North West");
			compassButton.setIcon(compassNorthIcon);

		}
		if (yPassed == 0 && xPassed == 1) {
			directionTextField.setText("West");
			compassButton.setIcon(compassWestIcon);

		}
		if (yPassed == -1 && xPassed == 1) {
			directionTextField.setText("South West");
			compassButton.setIcon(compassSouthIcon);

		}
		if (yPassed == -1 && xPassed == 0) {
			directionTextField.setText("South");
			compassButton.setIcon(compassSouthIcon);

		}
		if (yPassed == -1 && xPassed == -1) {
			directionTextField.setText("South East");
			compassButton.setIcon(compassSouthIcon);

		}
		if (yPassed == 0 && xPassed == -1) {
			directionTextField.setText("East");
			compassButton.setIcon(compassEastIcon);

		}
		if (yPassed == 1 && xPassed == -1) {
			directionTextField.setText("North East");
			compassButton.setIcon(compassNorthIcon);

		}

	}

	/**
	 * sets the location of the ball to the panel as specified by the parameter
	 * passed.
	 * 
	 * @param setXPosition
	 * @param setYPosition
	 */
	public void setBall(int setXPosition, int setYPosition) {
		panelButton[setYPosition][setXPosition].setIcon(ballIcon);
		x = setXPosition;
		y = setYPosition;
	}

	/**
	 * This method is used to remove any item from any panelButton.
	 * 
	 * @param removeXPosition
	 * @param removeYPosition
	 */

	public void removeObject(int removeXPosition, int removeYPosition) {
		panelButton[removeXPosition][removeYPosition].setIcon(null);
	}

	/**
	 * This method makes the ball bounce in random direction. Two parameters
	 * randomXValue and randomYValue are the value passed as x_passed and
	 * yPassed. they make ball move in random direction.
	 * 
	 * @param randomXValue
	 * @param randomYValue
	 */
	public void randomBounceBall(int randomXValue, int randomYValue) {
		panelButton[y + randomYValue][x + randomXValue].setIcon(ballIcon);
		x = x + randomXValue;
		y = y + randomYValue;
	}

	/**
	 * This method checks the collision of the ball to either baby or wall.
	 * 
	 * @param currYValue
	 * @param currXValue
	 */
	public void checkCollision(int currYValue, int currXValue) {

		// This checks the collision for the ball with the baby if the condition
		// is met.
		if (currYValue > 0 && currXValue > 0 && currXValue < 15
				&& currYValue < 12) {
			ImageIcon checkIcon = new ImageIcon(
					""
							+ panelButton[currYValue - yPassed][currXValue
									- xPassed].getIcon());// This gets the
															// reference to the
															// imageIcon.

			// This condition executes only if two player is enabled.
			if (twoPlayerButtonPressed == true) {
				if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/images/baby1.png")// Checks
																							// if
																							// there
																							// is
																							// image
																							// baby1
						&& xPassed == 1) {
					removeObject(currYValue, 0);// remove image in the following
												// coordinates.
					yPassed = 0;
					xPassed = -1;

					// This condition executes if baby2 is in the way of ball.
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/psp assignment/images/baby2.png")
						&& xPassed == -1) {
					removeObject(currYValue, 0);// Removes the ball at the
												// following coordinates.
					yPassed = 0;
					xPassed = 1;
				}
				optionTextField.setText("2 Players");// Sets the textfield to 2
														// players.
			}

			// This condition gets executed if there are more than two players.
			if (twoPlayerButtonPressed == false) {

				// If baby1 is in the way and xPassd is 1 the following
				// conditions gets executed.
				if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/images/baby1.png")
						&& xPassed == 1) {
					removeObject(currYValue, 0);
					yPassed = getRandom();// The ball gets turned in random y
											// direction.
					xPassed = -1;// The x coordinate is changed to negative.

					// This condition gets executed if xPassed is -1.
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/images/baby1.png")
						&& xPassed == -1) {
					removeObject(currYValue, 0);
					yPassed = getRandom();// Sets the y coordinate in random
											// direction.
					xPassed = 1;
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/images/baby1.png")
						&& yPassed == 1) {
					removeObject(0, currXValue);
					xPassed = getRandom();
					yPassed = -1;
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/images/baby1.png")
						&& yPassed == -1) {
					removeObject(0, currXValue);
					xPassed = getRandom();
					yPassed = 1;
				}

				if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/psp assignment/images/baby2.png")
						&& xPassed == 1) {
					removeObject(currYValue, 0);
					yPassed = getRandom();
					xPassed = -1;
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/psp assignment/images/baby2.png")
						&& xPassed == -1) {
					removeObject(currYValue, 0);
					yPassed = getRandom();
					xPassed = 1;
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/psp assignment/images/baby2.png")
						&& yPassed == 1) {
					removeObject(0, currXValue);
					xPassed = getRandom();
					yPassed = -1;
				} else if (checkIcon
						.toString()
						.equals("C:/Users/KAILASH/Desktop/psp assignment/images/baby2.png")
						&& yPassed == -1) {
					removeObject(0, currXValue);
					xPassed = getRandom();
					yPassed = 1;
				}
			}
		}

		// The following code checks the condition of ball reflection from wall
		// if twoPlayerButtonPressed is set to false.
		if (twoPlayerButtonPressed == false) {
			if (currYValue == 12) {
				removeObject(0, currYValue);
				xPassed = getRandom();
				yPassed = 1;
			}
			if (currYValue == 0) {
				removeObject(0, currXValue);
				xPassed = getRandom();
				yPassed = -1;

			}
			if (currXValue == 15) {
				removeObject(currYValue, 15);
				yPassed = getRandom();
				xPassed = 1;
				baby1Score++;
				baby1ScoreTextField.setForeground(Color.white);
				baby1ScoreTextField.setText(""+baby1Score);
				if(baby1Score == 10){
					JOptionPane.showMessageDialog(null, "Baby 1 wins");
					baby1Score = 0;
					baby2Score = 0;
					baby1ScoreTextField.setText(""+baby1Score);
					baby2ScoreTextField.setText(""+baby2Score);
				}
			}
			if (currXValue == 0) {
				removeObject(currYValue, 0);
				yPassed = getRandom();
				xPassed = -1;
				baby2Score++;
				baby2ScoreTextField.setForeground(Color.white);
				baby2ScoreTextField.setText(""+baby2Score);
				if(baby1Score == 10){
					JOptionPane.showMessageDialog(null, "Baby 2 wins");
					baby1Score = 0;
					baby2Score = 0;
					baby1ScoreTextField.setText(""+baby1Score);
					baby2ScoreTextField.setText(""+baby2Score);
				}
			}
		}
		// These conditions are executed if twoPlayerButtonPressed is set to
		// true.
		if (twoPlayerButtonPressed == true) {
			if (currYValue == 12) {
				removeObject(0, currYValue);
				xPassed = 0;
				yPassed = 1;
			}
			if (currYValue == 0) {
				removeObject(0, currXValue);
				xPassed = 0;
				yPassed = -1;

			}
			if (currXValue == 15) {
				removeObject(currYValue, 15);
				yPassed = 0;
				xPassed = 1;

			}
			if (currXValue == 0) {
				removeObject(currYValue, 0);
				yPassed = 0;
				xPassed = -1;

			}
		}
	}

	// This method gets the random value between -1 and 1 and returns it to the
	// method.
	public int getRandom() {
		Random random = new Random();
		int randomValue = random.nextInt(3) - 1;
		return randomValue;
	}

	/**
	 * This method gets three parameters to get the baby current x and y
	 * coordinates and to get the value by which the baby is to be moved. this
	 * moves the baby1.
	 * 
	 * @param babyCurrYValue
	 * @param babyCurrXValue
	 * @param moveValue
	 */
	public void moveBaby1(int babyCurrYValue, int babyCurrXValue, int moveValue) {
		// If there are only one baby in each side this condition is executed.
		if (twoPlayerButtonPressed == true) {
			// Removes the baby at current position.
			removeObject(babyCurrYValue, babyCurrXValue);
			panelButton[babyCurrYValue - moveValue][babyCurrXValue]
					.setIcon(baby1);// Sets the position of the baby at the new
									// position with respect to move value
									// passed by the programmer.
			yBaby1 -= moveValue;// Reset the y coordinate of baby.
		}
		// If fourPlayerButton is pressed following code will be executed in
		// order to move the baby.
		if (fourPlayerButtonPressed == true) {
			removeObject(babyCurrYValue, babyCurrXValue);// Removes the first
															// baby at current
															// position.
			removeObject(babyCurrYValue + 6, babyCurrXValue);// Remove the
																// second baby
																// at current
																// position.
			panelButton[babyCurrYValue - moveValue][babyCurrXValue]
					.setIcon(baby1);// Sets the image of baby1 for the new baby.
			panelButton[babyCurrYValue + 6 - moveValue][babyCurrXValue]
					.setIcon(baby1);// Sets the image of baby2 for new baby.
			yBaby3 -= moveValue;// sets the new y coordinate for first baby.
			yBaby5 -= moveValue;// Sets the new x coordinate for second baby.
		}
		// If multi player button is pressed following condition gets executed.
		if (multiPlayerButtonPressed == true) {
			removeObject(babyCurrYValue, babyCurrXValue);// removes the first
															// baby at current
															// position.
			removeObject(babyCurrYValue + 6, babyCurrXValue);// removes the
																// second baby
																// at current
																// position.
			removeObject(babyCurrYValue + 3, babyCurrXValue);// removes the
																// third baby at
																// current
																// position.

			panelButton[babyCurrYValue - moveValue][babyCurrXValue]
					.setIcon(baby1);// Sets the first baby at the user specified
									// position.
			panelButton[babyCurrYValue + 6 - moveValue][babyCurrXValue]
					.setIcon(baby1);// Sets the second baby at the user
									// specified position.
			panelButton[babyCurrYValue + 3 - moveValue][babyCurrXValue]
					.setIcon(baby1);// sets the third baby at the user specified
									// position.

			yBaby3 -= moveValue;// Assigning new yValue for first baby.
			yBaby5 -= moveValue;// Assigning new y coordinate value for second
								// baby.
			yBaby1 -= moveValue;// Assigning new y coordinate value for third
								// baby.
		}

	}

	/**
	 * Gets three parameters as below and sets the image of the baby2
	 * accordingly.
	 * 
	 * @param babyCurrYValue
	 * @param babyCurrXValue
	 * @param moveValue
	 */
	public void moveBaby2(int babyCurrYValue, int babyCurrXValue, int moveValue) {

		// If the user presses twoPlayers button then this condition becomes
		// true and following code gets executed.
		if (twoPlayerButtonPressed == true) {
			removeObject(babyCurrYValue, babyCurrXValue);// To remove the baby
															// from current
															// position.
			panelButton[babyCurrYValue - moveValue][babyCurrXValue]
					.setIcon(baby2);// this sets the baby at new position.

			yBaby2 -= moveValue; // Sets the new y coordinate for first baby2
		}

		// If the user presses four player button then this condition gets
		// executed.
		if (fourPlayerButtonPressed == true) {
			removeObject(babyCurrYValue, babyCurrXValue);// Remove the first
															// baby2 from the
															// current
															// coordinate.
			removeObject(babyCurrYValue + 6, babyCurrXValue);// Remove the
																// second baby2
																// from the
																// current
																// coordinate.
			panelButton[babyCurrYValue - moveValue][babyCurrXValue]
					.setIcon(baby2);// Sets the icon of first baby2 at the user
									// desired moving position.
			panelButton[babyCurrYValue + 6 - moveValue][babyCurrXValue]
					.setIcon(baby2);// sets the icon of second baby2 at the user
									// defined position.
			yBaby4 -= moveValue;// Sets the new y coordinate for first baby2.
			yBaby6 -= moveValue;// Sets the new y coordinate for second baby2.
		}
		// If the user presses multi player button below condition will be
		// executed.
		if (multiPlayerButtonPressed == true) {
			removeObject(babyCurrYValue, babyCurrXValue);// removes the first
															// baby2 at the
															// given position.
			removeObject(babyCurrYValue + 6, babyCurrXValue);// removes the
																// second baby2
																// at the given
																// position.
			removeObject(babyCurrYValue + 3, babyCurrXValue);// removes the
																// third baby2
																// at the given
																// position.
			panelButton[babyCurrYValue - moveValue][babyCurrXValue]
					.setIcon(baby2);// sets the first baby2 at the given
									// position.
			panelButton[babyCurrYValue + 6 - moveValue][babyCurrXValue]
					.setIcon(baby2);// sets the second baby2 at the player
									// desired position.
			panelButton[babyCurrYValue + 3 - moveValue][babyCurrXValue]
					.setIcon(baby2);// Sets the third baby2 at the player
									// desired position.
			yBaby4 -= moveValue;// Sets the new y coordinate for the second
								// baby2
			yBaby6 -= moveValue;// sets the new y coordinate for the third baby2
			yBaby2 -= moveValue;// Sets the new y coordinate for the first
								// baby2.
		}
	}
	
	public void setScoreZero(){
		baby1Score = 0;
		baby2Score = 0;
		baby1ScoreTextField.setForeground(Color.white);
		baby2ScoreTextField.setForeground(Color.white);		
		baby1ScoreTextField.setText(""+baby1Score);
		baby2ScoreTextField.setText(""+baby2Score);
	}

	
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();// gets the source which invoked the
										// actionPerformed.

		if (source == runButton) {
			if (startButtonPressed == true) { // If the startButtonPressed is
												// initially true set false.
												// else sets true.
				startButtonPressed = false;
			}
			if (startButtonPressed == false) {
				startButtonPressed = true;
			}
		}
		if (startButtonPressed == true) {
			// If source is backwardButton y coordinate doesn't changes
			// but x Coordinate must decrease.
			if (source == backwardButton) {
				xPassed = 1;
				yPassed = 0;
			}
			// If source is forwardButton y coordinate doesn't changes
			// but x coordinate must increase.
			if (source == forwardButton) {
				xPassed = -1;
				yPassed = 0;
			}
			// If source is upButton x coordinate doesn't changes
			// but y coordinate must decrease.
			if (source == upButton) {
				xPassed = 0;
				yPassed = 1;
			}

			// If source is downButton x coordinate is unchanged
			// but y coordinate must increase.
			if (source == downButton) {
				xPassed = 0;
				yPassed = -1;
			}

			// If source is Timer named time then following condition gets
			// executed.
			if (source == time) {
				// To display second of game being played.
				secondTextField.setText("" + (timeInSecond % 60));
				// To display minutes of game being started.
				minuteTextField.setText("" + (timeInSecond / 60));
				// to display how many hours have passed since the game has
				// started
				hourTextField.setText("" + (timeInSecond / 3600));
				// Increases the time everytime time Timer has been executed/
				timeInSecond = timeInSecond + 1;
			}
			// If the source is ballMotion following condition gets executed.
			if (source == ballMotion) {
				if (resetButtonClicked == false) {
					checkCollision(y, x);// Checks the collision on wall or the
											// baby.
					kickBall(yPassed, xPassed);// Moves the ball by these value
												// every time code gets
												// executed.
				}
			}
		}
		// If source is exitButton
		if (source == exitButton) {
			System.exit(1);// The frame gets exited.

		}

		if (source == actButton) {
			checkCollision(y, x);// Checks the collision every time.
			kickBall(yPassed, xPassed);// Moves the ball as per the xPassed and
										// yPassed value.
		}

		// This condition gets executed if our source is resetButton
		if (source == resetButton) {
			removeObject(y, x);// Remove the object at the position.
			x = 7;// x value set for ball.
			y = 6;// y value set for the ball.
			xPassed = 1;// value through the x coordinate must change.
			yPassed = 0;
			panelButton[y][x].setIcon(ballIcon);// Sets the ball to the
												// panelButton.
			startButtonPressed = false;// Disable startButton fourPlayerButton
										// and multiplayerButton
			twoPlayerButtonPressed = true;// enable only two player button.
			fourPlayerButtonPressed = false;
			multiPlayerButtonPressed = false;

			// Sets all the panel containing the icon of baby to null.
			panelButton[yBaby3][xBaby1].setIcon(null);
			panelButton[yBaby4][xBaby2].setIcon(null);
			panelButton[yBaby3 + 6][xBaby1].setIcon(null);
			panelButton[yBaby4 + 6][xBaby2].setIcon(null);
			panelButton[yBaby3 + 3][xBaby1].setIcon(null);
			panelButton[yBaby4 + 3][xBaby2].setIcon(null);

			// Assign the y coordinate for both baby1 and baby2 as 6.
			yBaby1 = 6;
			yBaby2 = 6;
			panelButton[yBaby1][xBaby1].setIcon(baby1);// Sets baby1 at the
														// panelButton with give
														// x and y coordinate.
			panelButton[yBaby2][xBaby2].setIcon(baby2);// Sets baby2 at the
														// panelButton with give
														// x and y coordinate.
		}

		// If the x coordinate is 7, 8, 9 or 10 addBricks() gets executed.
		if (x > 6 && x < 11) {
			addBricks();
		}

		// Code gets executed if fourPlayerButton is pressed.
		if (source == fourPlayerButton) {
			multiPlayerButtonPressed = false;
			twoPlayerButtonPressed = false;
			fourPlayerButtonPressed = true;
			
			setScoreZero();
			panelButton[yBaby1][xBaby1].setIcon(null);
			panelButton[yBaby2][xBaby2].setIcon(null);
			panelButton[yBaby3 + 3][xBaby1].setIcon(null);
			panelButton[yBaby4 + 3][xBaby2].setIcon(null);
			panelButton[yBaby3][xBaby1].setIcon(baby1);
			panelButton[yBaby4][xBaby2].setIcon(baby2);
			panelButton[yBaby5][xBaby1].setIcon(baby1);
			panelButton[yBaby6][xBaby2].setIcon(baby2);
			optionTextField.setText("Four players");
		}

		// Code gets executed if twoPlayerButton is pressed.
		if (source == twoPlayerButton) {
			twoPlayerButtonPressed = true;
			fourPlayerButtonPressed = false;
			multiPlayerButtonPressed = false;
 
			setScoreZero();
			panelButton[yBaby3][xBaby1].setIcon(null);
			panelButton[yBaby4][xBaby2].setIcon(null);
			panelButton[yBaby3 + 6][xBaby1].setIcon(null);
			panelButton[yBaby4 + 6][xBaby2].setIcon(null);
			panelButton[yBaby3 + 3][xBaby1].setIcon(null);
			panelButton[yBaby4 + 3][xBaby2].setIcon(null);

			yBaby1 = 6;
			yBaby2 = 6;
			panelButton[yBaby1][xBaby1].setIcon(baby1);
			panelButton[yBaby2][xBaby2].setIcon(baby2);
			optionTextField.setText("two players");
		}
		// Code gets executed if multiPlayerButton is pressed.
		if (source == multiPlayerButton) {
			twoPlayerButtonPressed = false;
			fourPlayerButtonPressed = false;
			multiPlayerButtonPressed = true;
			setScoreZero();
			panelButton[yBaby3][xBaby1].setIcon(null);
			panelButton[yBaby4][xBaby2].setIcon(null);
			panelButton[yBaby3 + 6][xBaby1].setIcon(null);
			panelButton[yBaby4 + 6][xBaby2].setIcon(null);
			panelButton[yBaby3 + 3][xBaby1].setIcon(null);
			panelButton[yBaby4 + 3][xBaby2].setIcon(null);

			yBaby1 = 6;
			yBaby2 = 6;

			panelButton[yBaby3][xBaby1].setIcon(baby1);
			panelButton[yBaby4][xBaby2].setIcon(baby2);
			panelButton[yBaby3 + 6][xBaby1].setIcon(baby1);
			panelButton[yBaby4 + 6][xBaby2].setIcon(baby2);
			panelButton[yBaby3 + 3][xBaby1].setIcon(baby1);
			panelButton[yBaby4 + 3][xBaby2].setIcon(baby2);
			optionTextField.setText("Six players");
		}
	}

	/**
	 * this is the method that is called to ensure wall is not images are not
	 * lost if ball passes through the wall.
	 */
	public void addBricks() {
		// If x coordinate for ball is 8 this condition gets executed.
		if (x == 8) {
			for (int l = 0; l < 13; l++) {
				for (int k = 9; k < 10; k++) {
					// This replaces the wall icon at the x coordinate 9.
					panelButton[l][k].setIcon(wall);
				}
			}
		}
		// If the x coordinate is 9 following code gets executed.
		if (x == 9) {
			for (int l = 0; l < 13; l++) {
				for (int k = 8; k > 7; k--) {
					panelButton[l][k].setIcon(wall);// This sets the wall icon
													// at the x coordinate 8.
				}
			}
		}
		// If the x coordinate is 7 or 10 following condition gets executed.
		if (x == 7 || x == 10) {
			for (int l = 0; l < 13; l++) {
				for (int k = 8; k < 10; k++) {
					panelButton[l][k].setIcon(wall);// This sets the wall icon
													// at x coordinate 8 and 9.
				}
			}
		}
	}

	
	public void stateChanged(ChangeEvent changeEvent) {
		int motionTime = slider.getValue();//Gets the value from the slider.
		int moveTime = 1050 - motionTime;
		ballMotion.setDelay(moveTime);//assign the value received from slider to timer ballMotion.
	}


	public void keyTyped(KeyEvent e) {
	}

	//This listens to the key presses from the keyboard.

	public void keyPressed(KeyEvent e) {
		
		//If twoPlayerButton is pressed these conditions gets executed.
		if (twoPlayerButtonPressed == true) {
		
			if (e.getKeyCode() == KeyEvent.VK_W && yBaby1 > 0) {
				moveBaby1(yBaby1, xBaby1, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_S && yBaby1 < 12) {
				moveBaby1(yBaby1, xBaby1, -1);

			}
			if (e.getKeyCode() == KeyEvent.VK_UP && yBaby2 > 0) {
				moveBaby2(yBaby2, xBaby2, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && yBaby2 < 12) {
				moveBaby2(yBaby2, xBaby2, -1);
			}
			fourPlayerButtonPressed = false;
			multiPlayerButtonPressed = false;
		}
//If the fourPlayerButton has been pressed following condition will be true.
		if (fourPlayerButtonPressed == true) {
			if (e.getKeyCode() == KeyEvent.VK_W && yBaby3 > 0) {
				moveBaby1(yBaby3, xBaby1, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_S && yBaby5 < 12) {
				moveBaby1(yBaby3, xBaby1, -1);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP && yBaby4 > 0) {
				moveBaby2(yBaby4, xBaby2, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && yBaby6 < 12) {
				moveBaby2(yBaby4, xBaby2, -1);
			}
			twoPlayerButtonPressed = false;
			multiPlayerButtonPressed = false;
		}
//If the multiPlayerButton has been pressed this condition will be true.
		if (multiPlayerButtonPressed == true) {
			if (e.getKeyCode() == KeyEvent.VK_W && yBaby3 > 0) {
				moveBaby1(yBaby3, xBaby1, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_S && yBaby5 < 12) {
				moveBaby1(yBaby3, xBaby1, -1);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP && yBaby4 > 0) {
				moveBaby2(yBaby4, xBaby2, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && yBaby6 < 12) {
				moveBaby2(yBaby4, xBaby2, -1);
			}
			twoPlayerButtonPressed = false;//Setting twoPlayerButtonPressed boolean to false.
			fourPlayerButtonPressed = false;//Setting fourPlayerButtonPressed boolean to false.
		}
	}


	public void keyReleased(KeyEvent event) {

	}

}
