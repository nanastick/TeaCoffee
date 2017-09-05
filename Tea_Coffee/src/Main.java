import javax.swing.*;
import java.util.Date;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main extends JFrame {

	// Buttons
	JButton teaCoffee = new JButton();
	JButton tees = new JButton();
	JButton prov3 = new JButton();
	JButton prov10 = new JButton();
	JButton prov20 = new JButton();
	JButton usedBalls1 = new JButton();
	JButton usedBalls5 = new JButton();
	JButton save = new JButton();

	// TextArea
	JTextArea txtTeaCoffee = new JTextArea();
	JTextArea txtTees = new JTextArea();
	JTextArea txtProv3 = new JTextArea();
	JTextArea txtProv10 = new JTextArea();
	JTextArea txtProv20 = new JTextArea();
	JTextArea txtUsedBalls1 = new JTextArea();
	JTextArea txtUsedBalls5 = new JTextArea();

	// counters
	int counterTeaCoffee;
	int counterTees;
	int counterProv3;
	int counterProv10;
	int counterProv20;
	int counterUsedballs1;
	int counterUsedBalls5;
	int total;
	
	
	
	
	
	DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
	Date date = new Date();

	String message = "		Total Takings €";

	// String write = Integer.toString(total);
	public static void main(String[] args) {

		new Main();
		
		 
		 
		 
		
		
		
		
		/*String patteren = "d.m.y";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patteren);
		System.out.println(simpleDateFormat.format(new Date()));*/
		
		

	}// end main

	public Main() {

		//dateFormat.format(date);

		this.setSize(400, 400);
		// Centers screen
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Shop Takings");
		Gui();

	}// end constructour

	public void Gui() {
		JPanel myPanel = new JPanel();

		// TextArea Set txt
		txtTeaCoffee.setText("    Total €0");
		txtTees.setText("    Total €0");
		txtProv3.setText("    Total €0");
		txtProv10.setText("    Total €0");
		txtProv20.setText("    Total €0");
		txtUsedBalls1.setText("    Total €0");
		txtUsedBalls5.setText("    Total €0");

		// Button text set
		teaCoffee.setText("Tea/Coffee €1");
		tees.setText("Tee's");
		prov3.setText("ProV €3");
		prov10.setText("ProV €10");
		prov20.setText("ProV €20");
		usedBalls1.setText("Used Balls €1");
		usedBalls5.setText("Used Balls €5");
		save.setText("Save");

		// Listerners
		ListenForButton lForButton = new ListenForButton();

		teaCoffee.addActionListener(lForButton);
		tees.addActionListener(lForButton);
		prov3.addActionListener(lForButton);
		prov10.addActionListener(lForButton);
		prov20.addActionListener(lForButton);
		usedBalls1.addActionListener(lForButton);
		usedBalls5.addActionListener(lForButton);
		save.addActionListener(lForButton);

		// Adding to panel
		myPanel.add(teaCoffee);
		myPanel.add(txtTeaCoffee);

		myPanel.add(tees);
		myPanel.add(txtTees);

		myPanel.add(prov3);
		myPanel.add(txtProv3);

		myPanel.add(prov10);
		myPanel.add(txtProv10);

		myPanel.add(prov20);
		myPanel.add(txtProv20);

		myPanel.add(usedBalls1);
		myPanel.add(txtUsedBalls1);

		myPanel.add(usedBalls5);
		myPanel.add(txtUsedBalls5);
		myPanel.add(save);

		// adding Panel to frame
		this.add(myPanel);
		this.setVisible(true);
	}// END GUI

	private class ListenForButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == teaCoffee) {
				counterTeaCoffee++;
				txtTeaCoffee.setText("    Total €" + counterTeaCoffee);

			}
			if (e.getSource() == tees) {
				counterTees = counterTees + 2;
				txtTees.setText("    Total €" + counterTees);

			}
			if (e.getSource() == prov3) {
				counterProv3 = counterProv3 + 3;
				txtProv3.setText("    Total €" + counterProv3);

			}
			if (e.getSource() == prov10) {
				counterProv10 = counterProv10 + 10;
				txtProv10.setText("    Total €" + counterProv10);

			}
			if (e.getSource() == prov20) {
				counterProv20 = counterProv20 + 20;
				txtProv20.setText("    Total €" + counterProv20);

			}
			if (e.getSource() == usedBalls1) {
				counterUsedballs1++;
				txtUsedBalls1.setText("    Total €" + counterUsedballs1);

			}
			if (e.getSource() == usedBalls5) {
				counterUsedBalls5 = counterUsedBalls5 + 5;
				txtUsedBalls5.setText("    Total €" + counterUsedBalls5);

			}
			if (e.getSource() == save) {
				total = counterTeaCoffee + counterTees + counterProv3 + counterProv10 + counterProv20
						+ counterUsedballs1 + counterUsedBalls5;
				PrintWriter totalOuput = Main.writeToFile("\\Users\\keith\\Desktop\\TeaCoffee.txt");
				createTotals(total,totalOuput);
				System.out.println(total);

			}

		}
	}// end listerner method

	private static PrintWriter writeToFile(String fileName) {


		try {
			
			File totalCount = new File(fileName);
			
			PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(totalCount)));
			
			return infoToWrite;
			
			
			
			/*FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(date + message + total);

			pw.close();*/

		} catch (IOException e) {
			System.out.println("Unable to write to file.");
			
			System.exit(0);
		}
		return null;

	}// end Writetofile class
	
	private static void createTotals(int totals, PrintWriter totalOutPut) {
		
		String print = Integer.toString(totals);
		
		
		totalOutPut.println(print);
		
	}

}//END MAIN