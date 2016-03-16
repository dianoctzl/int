package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TelaExtrato extends JFrame implements ActionListener{
	JPanel painelAcesso;
	String sconta;
	JLabel lconta;
	JLabel lcliente;
	JLabel lext;
	JTable text;
	JButton bsair;
	String titulo;
	ResourceBundle bn;
	Connection conn;
	
	public TelaExtrato() throws SQLException 
	{
		Container c = getContentPane();
		 c.setLayout(new GridLayout(1,1));
		 setContentPane(c);
		 bn = Util.getBundle();
		 
		 sconta = "xxx.xxx-z";
		 lext = new JLabel(bn.getString("TelaExtrato.lext"));
		 lconta = new JLabel(""+Util.getCli().getConta());
		 lcliente = new JLabel(Util.getContaDAO().getNome(Util.getConta()));
		 text = new JTable(5,2);
		 bsair= new JButton(bn.getString("TelaExtrato.bsair"));
		 
		 
		 painelAcesso = new JPanel();
		 
		 painelAcesso.add(lcliente);
		 painelAcesso.add(lconta);
		 painelAcesso.add(lext);
		 painelAcesso.add(text);
		 painelAcesso.add(bsair);
		 
		 bsair.addActionListener(this);
		 
		 c.add(painelAcesso);
			
		 setDefaultLookAndFeelDecorated(true);
		 setTitle(bn.getString("TelaExtrato.titulo"));
			setLocation(400,400); 
			setSize(170,180); 
			
	}

	public void iniciar()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bsair)
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
	}
}
