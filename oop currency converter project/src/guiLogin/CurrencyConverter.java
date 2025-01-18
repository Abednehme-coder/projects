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
import java.awt.FlowLayout;

public class CurrencyConverter extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private Currency Dl ;
	private Currency Ll ;
	private Currency Eu ;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JButton btnNewButton;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public CurrencyConverter(Currency Dl,Currency Ll, Currency Eu) {
		this.Dl= Dl;
		this.Ll= Ll;
		this.Eu= Eu;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,508,336);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(contentPane);
		
		textField = new JTextField();
		textField.setBounds(55, 95, 120, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String []choices = {"","$ to L.L.","$ to €","L.L. to $","L.L. to €","€ to L.L.","€ to $"};
		comboBox = new JComboBox(choices);
		
		comboBox.setBounds(185, 95, 92, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("enter the amount you want to convert");
		lblNewLabel.setBounds(55, 70, 207, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("enter the amount");
		lblNewLabel_1.setBounds(142, 153, 207, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("convert");
		btnNewButton.setBounds(287, 95, 105, 27);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Currnecy Exchanger");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(153, 10, 185, 26);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton.addActionListener(this);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		double x = Double.parseDouble(text);
		if(e.getSource()==btnNewButton) {
		String selected = comboBox.getSelectedItem().toString();
		DecimalFormat formatter1 = new DecimalFormat("0.00000000");
		
		
		if(selected.equalsIgnoreCase("") || text=="") {
			lblNewLabel_1.setText("please fill the feild above");	
		}
		else if(selected.equalsIgnoreCase("$ to L.L.")) {
			x = (int) (x*Dl.to_LL());
			//String s = Double.toString(x);
			//int result = s.indexOf(".");
			//String output = s.substring(0,result+3);
			DecimalFormat formatter = new DecimalFormat("0.00");
			String output = formatter.format(x);

			lblNewLabel_1.setText(output + " L.L.");
		}
		else if(selected.equalsIgnoreCase("$ to €")) {
			x = x*Dl.to_Euro();
			String s = Double.toString(x);
			int result = s.indexOf(".");
			String output = s.substring(0,result+3);
			lblNewLabel_1.setText(output+" €");
			}
		else if(selected.equalsIgnoreCase("L.L. to $")) {
			x = x*Ll.to_Dollar();
			String output = formatter1.format(x);
			lblNewLabel_1.setText(output+" $");
			}
		else if(selected.equalsIgnoreCase("L.L. to €")) {
			x = x*Ll.to_Euro();
			String output = formatter1.format(x);
			lblNewLabel_1.setText(output+" €");
			}
		else if(selected.equalsIgnoreCase("€ to L.L.")) {
			x = x* Eu.to_LL();
			//String s = Double.toString(x);
			//int result = s.indexOf(".");
			//String output = s.substring(0,result+3);
			DecimalFormat formatter = new DecimalFormat("0.00");
			String output = formatter.format(x);

			lblNewLabel_1.setText(output + " L.L.");
			}
		else if(selected.equalsIgnoreCase("€ to $")) {
			x = x*Eu.to_Dollar();
			String s = Double.toString(x);
			int result = s.indexOf(".");
			String output = s.substring(0,result+3);
			lblNewLabel_1.setText(output+" $");
			}
		}
		}
	}

