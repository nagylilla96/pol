/**
 * Creates the GUI for the Polinom class
 *
 * @author Nagy Lilla
 * @version 12 Mar 2017
 */

package polinom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class GUI extends JFrame{

	/**
	 *
	 * GUI constructor, which calls the initUI method
	 *
	 * @param panelMain JPanel
	 * @see GUI
	 */
	public GUI(JPanel panelMain) {
		initUI(panelMain);
	}

	/**
	 *
	 * This methods sets all buttons from the list to enabled/disabled, based on the boolean's value
	 *
	 * @param List<JButton> buttons, boolean value
	 * @see GUI
	 */
	private void setButtons(List<JButton> buttons, boolean value) {
		for (JButton b: buttons) {
			b.setEnabled(value);
		}
	}

	/**
	 *
	 * Sets the background of all buttons to null
	 *
	 * @param List<JButton> buttons
	 * @see GUI
	 */
	private void setBackgroud(List<JButton> buttons) {
		for (JButton b: buttons) {
			b.setBackground(null);
		}
	}

	/**
	 *
	 * Based on the JTextField values, adds either 0 or the integer value of the coefficient to the new monom 
	 * that is to be returned, than added
	 *
	 * @param JTextField coeff, JTextField grad
	 * @return Monom
	 * @see GUI
	 */
	private Monom addButton(JTextField coeff, JTextField grad) throws NumberFormatException {
		String coeff1 = coeff.getText();
		String grad1 = grad.getText();
		Integer c;
		Integer g;
		if (coeff1.equals("")) {
			c = 0;
		} else {
			c = Integer.parseInt(coeff1);
		}
		if (grad1.equals("")) {
			g = 0;
		} else {
			g = Integer.parseInt(grad1);
		}
		Monom m = new MonomInt(c, g);
		return m;		
	}

	/**
	 *
	 * Returns the polinom as a string (or as "0" if it's empty)
	 *
	 * @param Polinom polinom
	 * @return String
	 * @see GUI
	 */
	private String retResult(Polinom polinom) {
		if (polinom.getMonoms().isEmpty()) {
			return "0";
		}
		return polinom.printPolinom(polinom);
	}

	/**
	 *
	 * Initializes the UI 
	 *
	 * @param JPanel panelMain
	 * @see GUI
	 */
	private void initUI(JPanel panelMain) {
		setTitle("Polynomials");
		setSize(480, 320);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createLayout(panelMain);
	}

	/**
	 *
	 * Creates the layout and adds the ActionListener
	 *
	 * @param JPanel panelMain
	 * @see GUI
	 */
	private void createLayout(JPanel panelMain) {
		JPanel panelPol1 = new JPanel();
		panelPol1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panelMon1 = new JPanel();
		panelMon1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPol2 = new JPanel();
		panelPol2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panelMon2 = new JPanel();
		panelMon2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(2, 4));
		JPanel panelResult = new JPanel();
		panelResult.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panelReset = new JPanel();
		panelReset.setLayout(new FlowLayout());
		panelMain.add(panelPol1);
		panelMain.add(panelMon1);
		panelMain.add(panelPol2);
		panelMain.add(panelMon2);
		panelMain.add(panelButtons);
		panelMain.add(panelResult);
		panelMain.add(panelReset);
		JLabel polinom1Text = new JLabel("polinom 1: ");
		JLabel polinom1Result = new JLabel();
		panelPol1.add(polinom1Text);
		panelPol1.add(polinom1Result);
		JLabel monom1TextCoeff = new JLabel("monom1 coeff: ");
		JTextField coeff1 = new JTextField(5);
		JLabel monom1TextGrad = new JLabel("grad: ");
		JTextField grad1 = new JTextField(5);
		JButton add1 = new JButton("Add");
		panelMon1.add(monom1TextCoeff);
		panelMon1.add(coeff1);
		panelMon1.add(monom1TextGrad);
		panelMon1.add(grad1);
		panelMon1.add(add1);
		JLabel polinom2Text = new JLabel("polinom 2: ");
		JLabel polinom2Result = new JLabel();
		panelPol2.add(polinom2Text);
		panelPol2.add(polinom2Result);
		JLabel monom2TextCoeff = new JLabel("monom2 coeff: ");
		JTextField coeff2 = new JTextField(5);
		JLabel monom2TextGrad = new JLabel("grad: ");
		JTextField grad2 = new JTextField(5);
		JButton add2 = new JButton("Add");
		panelMon2.add(monom2TextCoeff);
		panelMon2.add(coeff2);
		panelMon2.add(monom2TextGrad);
		panelMon2.add(grad2);
		panelMon2.add(add2);
		JButton addPol = new JButton("Add");
		JButton subtractPol = new JButton("Subtract");
		JButton multiplyPol = new JButton("Multiply");
		JButton dividePol = new JButton("Divide");
		JButton diffPol1 = new JButton("Diff 1");
		JButton diffPol2 = new JButton("Diff 2");
		JButton intPol1 = new JButton("Integrate 1");
		JButton intPol2 = new JButton("Integrate 2");
		List<JButton> buttons = new ArrayList<>();
		buttons.add(addPol);
		buttons.add(subtractPol);
		buttons.add(multiplyPol);
		buttons.add(dividePol);
		buttons.add(diffPol1);
		buttons.add(diffPol2);
		buttons.add(intPol1);
		buttons.add(intPol2);
		for (JButton b : buttons) {
			panelButtons.add(b);
		}
		JLabel resultText = new JLabel("result: ");
		JLabel result = new JLabel();
		JLabel restText = new JLabel("rest: ");
		JLabel rest = new JLabel();
		panelResult.add(resultText);
		panelResult.add(result);
		panelResult.add(restText);
		panelResult.add(rest);
		JButton reset = new JButton("Reset");
		panelReset.add(reset);
		Polinom polinom1 = new Polinom();
		Polinom polinom2 = new Polinom();		

		class Action implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					if (e.getSource() == add1) {
						System.out.println("Add 1 clicked");
						Monom m = addButton(coeff1, grad1);
						if (!polinom1.getMonoms().contains(m)) {
							polinom1.addMonom(m);
						}			
						polinom1Result.setText(retResult(polinom1));
					}	
					if (e.getSource() == add2) {
						System.out.println("Add 2 clicked");
						Monom m = addButton(coeff2, grad2);
						if (!polinom2.getMonoms().contains(m)) {
							polinom2.addMonom(m);
						}					
						polinom2Result.setText(retResult(polinom2));
					}	
					if (e.getSource() == addPol) {
						Polinom polinomRes = new Polinom();
						System.out.println("AddPol clicked");
						polinomRes = polinom1.addPolinom(polinom2);			
						result.setText(retResult(polinomRes));
						addPol.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == subtractPol) {
						Polinom polinomRes = new Polinom();
						System.out.println("SubtractPol clicked");
						polinomRes = polinom1.subtractPolinom(polinom2);			
						result.setText(retResult(polinomRes));
						subtractPol.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == multiplyPol) {
						Polinom polinomRes = new Polinom();
						System.out.println("MultiplyPol clicked");
						polinomRes = polinom1.multiplyPolinom(polinom2);			
						result.setText(retResult(polinomRes));
						multiplyPol.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == dividePol) {
						Polinom polinomRes = new Polinom();
						System.out.println("DividePol clicked");
						resultText.setText("quotient: ");
						Polinom polinomRest = new Polinom();
						List<Polinom> resultList = polinom1.dividePolinom(polinom2);
						if (resultList == null) {
							result.setText("Division by zero!");
						} 
						else {
							polinomRes = resultList.get(0);
							result.setText(retResult(polinomRes));
							polinomRest = resultList.get(1);
							rest.setText(retResult(polinomRest));
							dividePol.setBackground(Color.cyan);
							setButtons(buttons, false);
						}	 

					}
					if (e.getSource() == diffPol1) {
						Polinom polinomRes = new Polinom();
						System.out.println("DiffPol1 clicked");
						polinomRes = polinom1.differentiatePolinom();			
						result.setText(retResult(polinomRes));
						diffPol1.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == diffPol2) {
						Polinom polinomRes = new Polinom();
						System.out.println("DiffPol2 clicked");
						polinomRes = polinom2.differentiatePolinom();			
						result.setText(retResult(polinomRes));
						diffPol2.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == intPol1) {
						Polinom polinomRes = new Polinom();
						System.out.println("IntPol1 clicked");
						polinomRes = polinom1.integratePolinom();			
						result.setText(retResult(polinomRes));
						intPol1.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == intPol2) {
						Polinom polinomRes = new Polinom();
						System.out.println("IntPol2 clicked");
						polinomRes = polinom2.integratePolinom();			
						result.setText(retResult(polinomRes));
						intPol2.setBackground(Color.cyan);
						setButtons(buttons, false);
					}
					if (e.getSource() == reset) {
						polinom1Result.setText(null);
						polinom1.getMonoms().clear();
						polinom2.getMonoms().clear();
						coeff1.setText(null);
						grad1.setText(null);
						polinom2Result.setText(null);
						coeff2.setText(null);
						grad2.setText(null);
						result.setText(null);
						setButtons(buttons, true);
						setBackgroud(buttons);
					}
				}
				catch(NumberFormatException ex) {
					System.out.println("NumberFormatException: " + ex.getMessage());
				}
			}
		}
		Action action = new Action();	
		add1.addActionListener(action);
		add2.addActionListener(action);
		addPol.addActionListener(action);
		subtractPol.addActionListener(action);
		multiplyPol.addActionListener(action);
		dividePol.addActionListener(action);
		diffPol1.addActionListener(action);
		diffPol2.addActionListener(action);
		intPol1.addActionListener(action);
		intPol2.addActionListener(action);
		reset.addActionListener(action);

	};

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {		
			JPanel panelMain = new JPanel();
			GUI gui = new GUI(panelMain);
			panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
			gui.setContentPane(panelMain);
			gui.setVisible(true);
		});
	}
}