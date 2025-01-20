package guiLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;

public class Menu extends JFrame implements ActionListener{
	private static Dollar Dl ;
	private static LL Ll ;
	private static Euro Eu ;
	
	private static Gold Gl;
	private static Oil Ol;
	private static Silver Sl;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton_2_1;

	public Menu(Dollar Dl,LL Ll, Euro Eu,Gold Gl,Oil Ol,Silver Sl) {
		this.Dl= Dl;
		this.Ll= Ll;
		this.Eu= Eu;
		
		this.Gl = Gl;
		this.Ol = Ol;
		this.Sl = Sl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(contentPane);
		
		btnNewButton = new JButton("currency exchange");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(244, 132, 317, 49);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("ores exchange");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(244, 203, 317, 49);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("exit ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(244, 345, 317, 49);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Welcome to our Exchnager menu!!");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(244, 36, 317, 22);
		contentPane.add(lblNewLabel);
		
		btnNewButton_2_1 = new JButton("edit rates");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1.setBounds(244, 274, 317, 49);
		contentPane.add(btnNewButton_2_1);
		
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2_1.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	  if (e.getSource() == btnNewButton) {
		CurrencyConverter converter = new CurrencyConverter( Dl, Ll,  Eu);
	    converter.setVisible(true);
	    converter.requestFocus(); 
	  } else if (e.getSource() == btnNewButton_1) {
		    OresExchanger exchanger = new OresExchanger(Gl, Ol, Sl);
		    exchanger.setVisible(true);
		    exchanger.requestFocus(); 
		  }
	  else if (e.getSource() == btnNewButton_2_1) {
		    Login l1 = new Login( Dl, Ll,  Eu, Gl, Ol, Sl);
		    l1.setVisible(true);
		  }else {
	    System.exit(0);
	  }
	}
}
