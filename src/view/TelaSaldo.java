package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TelaSaldo extends JFrame implements ActionListener {

	JLabel lcliente;
	JLabel lconta;
	JLabel lconsultar;
	JLabel lsaldo;
	JButton bvolta;
	JButton bsair;
	JPanel painelAcesso ;
	String conta;
	NumberFormat numberFormatter;
	private double saldo;
	String titulo;
	ResourceBundle bn;
	Connection conn;
	public TelaSaldo() throws SQLException
	{
		Container c = getContentPane();
		 c.setLayout(new GridLayout(1,2));
		 setContentPane(c);
		 bn = Util.getBundle();
		conn = Util.getConn();
		saldo = Util.getConta().getSaldo();
		NumberFormat currencyFormatter = NumberFormat
				.getCurrencyInstance(bn.getLocale());
		
				
		conta = "xxx.xxx-z";
		lcliente = new JLabel (Util.getContaDAO().getNome(Util.getConta()));
		lconta = new JLabel (""+Util.getCli().getConta());
		lconsultar = new JLabel (bn.getString("TelaSaldo.lconsultar"));
		lsaldo = new JLabel(bn.getString("TelaSaldo.lsaldo")+": "+currencyFormatter.format(saldo));
		bvolta = new JButton(bn.getString("TelaSaldo.bvolta"));
		bsair = new JButton(bn.getString("TelaSaldo.bsair"));
		
		painelAcesso = new JPanel();
		
		painelAcesso.add(lcliente);
		painelAcesso.add(lconta);
		painelAcesso.add(lconsultar);
		painelAcesso.add(lsaldo);
		painelAcesso.add(bvolta);
		painelAcesso.add(bsair);
		
		bvolta.addActionListener(this);
		bsair.addActionListener(this);
		c.add(painelAcesso);
		
		setTitle(bn.getString("TelaSaldo.titulo"));
		setDefaultLookAndFeelDecorated(true);
		setLocation(400,400); 
		setSize(225,180); 
		
	}
	
	public void iniciar()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bvolta)
		{
			try {
				TelaInicial i = new TelaInicial();
				i.inicar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == bsair)
		{
			System.exit(0);
		}
	}

	
}
