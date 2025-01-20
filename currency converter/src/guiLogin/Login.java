package guiLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener {
	
	private static Dollar Dl ;
	private static LL Ll ;
	private static Euro Eu ;
	
	private static Gold Gl;
	private static Oil Ol;
	private static Silver Sl;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
public Login(Dollar Dl,LL Ll, Euro Eu,Gold Gl,Oil Ol,Silver Sl) {
	this.Dl= Dl;
	this.Ll= Ll;
	this.Eu= Eu;
	
	this.Gl = Gl;
	this.Ol = Ol;
	this.Sl = Sl;
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100,100,508,336);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5,5,5,5));
	
	setContentPane(contentPane);
	
	
	contentPane.setLayout(null);
	
	this.setLocationRelativeTo(contentPane);
	
	
	JLabel lblNewLabel = new JLabel("Username :");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblNewLabel.setBounds(10, 78, 118, 23);
	getContentPane().add(lblNewLabel);
	
	textField = new JTextField();
	textField.setBounds(138, 76, 237, 29);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblPassword.setBounds(10, 169, 118, 23);
	getContentPane().add(lblPassword);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(138, 167, 237, 29);
	getContentPane().add(passwordField);
	
	btnNewButton = new JButton("Login");
	btnNewButton.setBounds(138, 221, 215, 29);
	contentPane.add(btnNewButton);
	
	lblNewLabel_1 = new JLabel("Please Enter Your Username And Passoword");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(33, 0, 377, 44);
	contentPane.add(lblNewLabel_1);
	
	btnNewButton.addActionListener(this);
	
	this.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	String user = textField.getText();
	String password = new String(passwordField.getPassword());


	
	if(user.equals("abed")&& password.equals("123")||user.equals("wafik")&& password.equals("456") ) {
		
		new EditPanel( Dl, Ll,  Eu, Gl, Ol, Sl);
		this.setVisible(false);
	}
}
}
