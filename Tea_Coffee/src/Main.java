import javax.swing.*;
import java.util.Date;
import java.util.Calendar;
import java.awt.FlowLayout;
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
	JButton btnTeaCoffee = new JButton();
	JButton btnTees = new JButton();
	JButton btnProv3 = new JButton();
	JButton btnProv10 = new JButton();
	JButton btnProv20 = new JButton();
	JButton btnUsedBalls1 = new JButton();
	JButton btnUsedBalls5 = new JButton();
	JButton btnSave = new JButton();

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
	
	PrintWriter totalOuput;

	

	public static void main(String[] args) {

		new Main();
		
		


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
	
	// date
	private static String getDate() {
		
		//gets date
		Date today = Calendar.getInstance().getTime();
		
		//format it to any type
		SimpleDateFormat formatter = new SimpleDateFormat("YY-mm-dd");
		
		//format it to string
		String folderName = formatter.format(today);
		return folderName;
		
		
	}

	public void Gui() {
		JPanel myPanel = new JPanel();
		
		myPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,80,15));

		// TextArea Set txt
		txtTeaCoffee.setText("    Total €0");
		
		txtTees.setText("    Total €0");
		txtProv3.setText("    Total €0");
		txtProv10.setText("    Total €0");
		txtProv20.setText("    Total €0");
		txtUsedBalls1.setText("    Total €0");
		txtUsedBalls5.setText("    Total €0");

		// Button text set
		btnTeaCoffee.setText("Tea/Coffee €1");
		btnTeaCoffee.setSize(10, 10);
		
		btnTees.setText("Tee's");
		btnTees.setSize(200, 200);
		
		btnProv3.setText("ProV €3");
		btnProv10.setText("ProV €10");
		btnProv20.setText("ProV €20");
		btnUsedBalls1.setText("Used Balls €1");
		btnUsedBalls5.setText("Used Balls €5");
		btnSave.setText("Save");

		// Listerners
		ListenForButton lForButton = new ListenForButton();

		btnTeaCoffee.addActionListener(lForButton);
		btnTees.addActionListener(lForButton);
		btnProv3.addActionListener(lForButton);
		btnProv10.addActionListener(lForButton);
		btnProv20.addActionListener(lForButton);
		btnUsedBalls1.addActionListener(lForButton);
		btnUsedBalls5.addActionListener(lForButton);
		btnSave.addActionListener(lForButton);

		// Adding to panel
		myPanel.add(btnTeaCoffee);
		myPanel.add(txtTeaCoffee);

		myPanel.add(btnTees);
		myPanel.add(txtTees);

		myPanel.add(btnProv3);
		myPanel.add(txtProv3);

		myPanel.add(btnProv10);
		myPanel.add(txtProv10);

		myPanel.add(btnProv20);
		myPanel.add(txtProv20);

		myPanel.add(btnUsedBalls1);
		myPanel.add(txtUsedBalls1);

		myPanel.add(btnUsedBalls5);
		myPanel.add(txtUsedBalls5);
		myPanel.add(btnSave);

		// adding Panel to frame
		this.add(myPanel);
		this.setVisible(true);
	}// END GUI

	private class ListenForButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnTeaCoffee) {
				counterTeaCoffee++;
				txtTeaCoffee.setText("    Total €" + counterTeaCoffee);

			}
			if (e.getSource() == btnTees) {
				counterTees = counterTees + 2;
				txtTees.setText("    Total €" + counterTees);

			}
			if (e.getSource() == btnProv3) {
				counterProv3 = counterProv3 + 3;
				txtProv3.setText("    Total €" + counterProv3);

			}
			if (e.getSource() == btnProv10) {
				counterProv10 = counterProv10 + 10;
				txtProv10.setText("    Total €" + counterProv10);

			}
			if (e.getSource() == btnProv20) {
				counterProv20 = counterProv20 + 20;
				txtProv20.setText("    Total €" + counterProv20);

			}
			if (e.getSource() == btnUsedBalls1) {
				counterUsedballs1++;
				txtUsedBalls1.setText("    Total €" + counterUsedballs1);

			}
			if (e.getSource() == btnUsedBalls5) {
				counterUsedBalls5 = counterUsedBalls5 + 5;
				txtUsedBalls5.setText("    Total €" + counterUsedBalls5);

			}
			if (e.getSource() == btnSave) {
				total = counterTeaCoffee + counterTees + counterProv3 + counterProv10 + counterProv20
						+ counterUsedballs1 + counterUsedBalls5;
				
				//Printwriter
				 totalOuput = Main.writeToFile("\\Users\\keith\\Desktop\\TeaCoffee.txt");
				
				
				createTotals(total,totalOuput);

			}

		}
	}// end listerner method

	private static PrintWriter writeToFile(String fileName) {


		try {
			
			File totalCount = new File(fileName);
			
			PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(totalCount)));
			
			return infoToWrite;
			
			

		} catch (IOException e) {
			System.out.println("Unable to write to file.");
			
			System.exit(0);
		}
		return null;

	}// end Writetofile class
	
	private static void createTotals(int totals, PrintWriter totalOutPut) {
		
		
		String convertToString = Integer.toString(totals);
		
		//using PrintWriter
		totalOutPut.println("Date\t" + getDate() + "\tTotal Taking \t€" + totals);
		
		totalOutPut.close();
		
	}

}//END MAIN