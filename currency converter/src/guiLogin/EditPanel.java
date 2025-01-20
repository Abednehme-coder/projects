package guiLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditPanel extends JFrame implements ActionListener{
	
	private static Dollar Dl ;
	private static LL Ll ;
	private static Euro Eu ;
	
	private static Gold Gl;
	private static Oil Ol;
	private static Silver Sl;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2;
	private JButton btnShow;
	private double value;
	private  String s;
	private int result;
	private String output;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public EditPanel(Dollar Dl,LL Ll, Euro Eu,Gold Gl,Oil Ol,Silver Sl) {
		this.Dl= Dl;
		this.Ll= Ll;
		this.Eu= Eu;
		
		this.Gl = Gl;
		this.Ol = Ol;
		this.Sl = Sl;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,508,336);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(contentPane);
		
		String []choices = {"","$ to gold","$ to silver","$ to oil","Oz. of gold to $","Oz. of silver to $","Brent of oil to $","$ to L.L.","$ to €","L.L. to $","L.L. to €","€ to L.L.","€ to $"};
		
		comboBox = new JComboBox(choices);
		comboBox.setBounds(38, 78, 122, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Rates Editor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(95, 11, 302, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter the rate that you want to change ");
		lblNewLabel_1.setBounds(38, 55, 193, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("the old value was :");
		lblNewLabel_2.setBounds(38, 111, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("00");
		lblNewLabel_3.setBounds(38, 136, 137, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(38, 190, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("enter the new rate");
		lblNewLabel_4.setBounds(38, 161, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Change");
		btnNewButton.setBounds(38, 221, 89, 23);
		contentPane.add(btnNewButton);
		
		btnShow = new JButton("Show");
		btnShow.setBounds(143, 132, 89, 23);
		contentPane.add(btnShow);
		
		btnNewButton.addActionListener(this);
		btnShow.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		double x = Double.parseDouble(text);
		String selected = comboBox.getSelectedItem().toString();
		if(e.getSource()==btnShow) {
			
			if(selected.equalsIgnoreCase("")) {
				lblNewLabel_4.setText("please fill the feild above");	
				
			}
			else {
				DecimalFormat formatter = new DecimalFormat("0.000000");
		            switch (selected.toLowerCase()) {
	                case "$ to l.l.":
	                	value = Dl.to_LL();
	        			output = formatter.format(value);
	                	lblNewLabel_3.setText((int)value+" L.L.");
	                    break;
	                case "$ to €":
	                	value =Dl.to_Euro();
		        		output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" €");
	                    break;
	                case "l.l. to $":
	                
	                	 value =Ll.to_Dollar();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" $");
	                    break;
	                case "l.l. to €":
	               
	                	 value =Ll.to_Euro();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" €");
	                    break;
	                case "€ to l.l.":
	                	value =Eu.to_LL();
	                	output = formatter.format(value);
	        			lblNewLabel_3.setText((int)value+" L.L.");
	                    break;
	                case "€ to $":
	                	 value =Eu.to_Dollar();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" $");
	                    break;
	                case "$ to gold":
	                	 value =Gl.to_Ore();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" Oz. of gold");
	                    break;
	                case "$ to silver":
	                	 value =Sl.to_Ore();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" Oz. of silver");
	                    break;
	                case "$ to oil":
	                	 value =Ol.to_Ore();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" Leters of oil");
	                    break;
	                case "oz. of gold to $":
	                	 value =Gl.to_Dollar();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" $");
	                    break;
	                case "oz. of silver to $":
	                	 value =Sl.to_Dollar();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" $");
	                    break;
	                case "brent of oil to $":
	                	 value =Ol.to_Dollar();
	                	 output = formatter.format(value);
	        			lblNewLabel_3.setText(output+" $");
	                    break;
	                default:
	                    lblNewLabel_4.setText("Invalid selection");
	                    break;
	            
			}}}
		else if(e.getSource()==btnNewButton) {
		
		/*Dollar newDl = new Dollar(1,x,Dl.to_Euro());
			setDl(newDl);
*/
		
		if(selected.equalsIgnoreCase("") || text.isEmpty()) {
			lblNewLabel_4.setText("please fill the feild above");	
		}
		else {
			DecimalFormat formatter = new DecimalFormat("0.000000");
	            switch (selected.toLowerCase()) {
                case "$ to l.l.":
                	
        			Dl.setToLL(x);
                    break;
                case "$ to €":
                	Dl.setToEuro(x);
                    break;
                case "l.l. to $":
                
                	Ll.setToDollar(x);
                    break;
                case "l.l. to €":
               
                	Ll.setToEuro(x);
                    break;
                case "€ to l.l.":
                	Eu.setToLL(x);
                    break;
                case "€ to $":
                	Eu.setToDollar(x);
                    break;
                case "$ to gold":
                	Gl.setToGold(x);
                    break;
                case "$ to silver":
                	Sl.setToSilver(x);
                    break;
                case "$ to oil":
                	Ol.setToOil(x);
                    break;
                case "oz. of gold to $":
                	Gl.setToDollar(x);
                    break;
                case "oz. of silver to $":
                	Sl.setToDollar(x);
                    break;
                case "brent of oil to $":
                	Ol.setToDollar(x);
                    break;
                default:
                    lblNewLabel_4.setText("Invalid selection");
                    break;
            
		}}}
		
}

	public static Dollar getDl() {
		return Dl;
	}

	public static void setDl(Dollar dl) {
		Dl = dl;
	}

	public static LL getLl() {
		return Ll;
	}

	public static void setLl(LL ll) {
		Ll = ll;
	}

	public static Euro getEu() {
		return Eu;
	}

	public static void setEu(Euro eu) {
		Eu = eu;
	}

	public static Gold getGl() {
		return Gl;
	}

	public static void setGl(Gold gl) {
		Gl = gl;
	}

	public static Oil getOl() {
		return Ol;
	}

	public static void setOl(Oil ol) {
		Ol = ol;
	}

	public static Silver getSl() {
		return Sl;
	}

	public static void setSl(Silver sl) {
		Sl = sl;
	}

	
	
	}
