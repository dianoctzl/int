package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame implements ActionListener{

	JButton bdebito;
	JButton btf;
	JButton bextrato;
	JButton bsaque;
	JButton bsaldo;
	JButton bsair;
	JLabel lcliente;
	JLabel lconta;
	JPanel painelAcesso ;
	String conta;
	String titulo;
	Locale local;
	ResourceBundle bn;
	Connection conn;
	
	public TelaInicial() throws SQLException
	{
		Container c = getContentPane();
		 c.setLayout(new GridLayout(1,2));
		 setContentPane(c);
		 bn = Util.getBundle();
		// local = l;
		 
		 conta = "xxx.xxx-z";
		 lcliente = new JLabel( Util.getContaDAO().getNome(Util.getConta()));
		 lconta = new JLabel(""+Util.getCli().getConta());
		 bdebito = new JButton(bn.getString("TelaInicial.bdebito"));
		 btf = new JButton(bn.getString("TelaInicial.btf"));
		 bextrato = new JButton(bn.getString("TelaInicial.bextrato"));
		 bsaque = new JButton(bn.getString("TelaInicial.bsaque"));
		 bsaldo	= new JButton(bn.getString("TelaInicial.bsaldo"));
		 bsair = new JButton(bn.getString("TelaInicial.bsair"));
		 painelAcesso = new JPanel();
		 
		 
		 painelAcesso.add(lcliente);
		 painelAcesso.add(lconta);
		 painelAcesso.add(bsaldo);
		 painelAcesso.add(bdebito);
		 painelAcesso.add(bextrato);
		 painelAcesso.add(bsaque);
		 painelAcesso.add(btf);
		 painelAcesso.add(bsair);
		 
		 bsair.addActionListener(this);
		 btf.addActionListener(this);
		 bextrato.addActionListener(this);
		 bsaque.addActionListener(this);
		 bsaldo.addActionListener(this);
		 bdebito.addActionListener(this);
		 
		 
		 
		 c.add(painelAcesso);
		 
		 setTitle(bn.getString("TelaInicial.titulo"));
		
		 setDefaultLookAndFeelDecorated(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE); 
		 setLocation(400,400); 
		 setSize(225,180); 
		 
	}
	
	public void inicar()
	{
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == bsair)
		{
			System.exit(0);
		}
		
		if(e.getSource() == bsaldo)
		{
			try {
				TelaSaldo a = new TelaSaldo();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		if(e.getSource() == bsaque)
		{
			try {
				TelaSaque a = new TelaSaque();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == btf)
		{
			try {
				TelaTf a = new TelaTf();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		if(e.getSource() == bextrato)
		{
			try {
				TelaExtrato a = new TelaExtrato();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == bdebito)
		{
			try {
				TelaDebito a = new TelaDebito();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

		
	
}
