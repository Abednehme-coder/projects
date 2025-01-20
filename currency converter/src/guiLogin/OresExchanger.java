package guiLogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.Color;

public class OresExchanger extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private Ores Gl ;
	private Ores Ol ;
	private Ores Sl ;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JButton btnNewButton;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public OresExchanger(Ores Gl,Ores Ol,Ores Sl ) {
		this.Gl=Gl;
		this.Ol=Ol;
		this.Sl=Sl;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,508,335);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(contentPane);
		
		textField = new JTextField();
		textField.setBounds(55, 95, 120, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String []choices = {"","$ to gold","$ to silver","$ to oil","Oz. of gold to $","Oz. of silver to $","Brent of oil to $"};
		comboBox = new JComboBox(choices);
		
		comboBox.setBounds(185, 95, 92, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("put the amount you want to convert");
		lblNewLabel.setBounds(55, 70, 207, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("enter the amount");
		lblNewLabel_1.setBounds(142, 153, 207, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("convert");
		btnNewButton.setBounds(287, 95, 105, 27);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Currency Exchanger");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(153, 10, 185, 22);
		contentPane.add(lblNewLabel_2);
		
		
		//comboBox.addActionListener(this);
		btnNewButton.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		double x = Double.parseDouble(text);
		if(e.getSource()==btnNewButton) {
		String selected = comboBox.getSelectedItem().toString();
		DecimalFormat formatter = new DecimalFormat("0.00000000");
		
		
		if(selected.equalsIgnoreCase("") || text=="") {
			lblNewLabel_1.setText("please fill the feild above");	
		}
		else if(selected.equalsIgnoreCase("$ to gold")) {
			x = x*Gl.to_Ore();
			String output = formatter.format(x);

			lblNewLabel_1.setText(output + " Oz. of gold");
		}
		else if(selected.equalsIgnoreCase("$ to silver")) {
			x = x*Sl.to_Ore();
			String output = formatter.format(x);
			lblNewLabel_1.setText(output+" Oz. of silver");
			}
		else if(selected.equalsIgnoreCase("$ to oil")) {
			x = x*Ol.to_Ore();
			String output = formatter.format(x);
			lblNewLabel_1.setText(output+" leters of oil");
			}
		else if(selected.equalsIgnoreCase("Oz. of gold to $")) {
			x = x*Gl.to_Dollar();
			String s = Double.toString(x);
			int result = s.indexOf(".");
			String output = s.substring(0,result+3);
			lblNewLabel_1.setText(output+" $");
			}
		else if(selected.equalsIgnoreCase("Oz. of silver to $")) {
			x = x* Sl.to_Dollar();
			String s = Double.toString(x);
			int result = s.indexOf(".");
			String output = s.substring(0,result+3);
			lblNewLabel_1.setText(output+" $");

			}
		else if(selected.equalsIgnoreCase("brent of oil to $")) {
			x = x*Ol.to_Dollar();
			String s = Double.toString(x);
			int result = s.indexOf(".");
			String output = s.substring(0,result+3);
			lblNewLabel_1.setText(output+" $");
			}
		}
		}
	}

