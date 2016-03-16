package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaTf extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String titulo;
	TextField tagencia;
	TextField tconta;
	TextField tvalor;
	JPanel painelAcesso;
	String sconta;
	JLabel lconta;
	JLabel lcliente;
	JLabel ltf;
	JLabel lagencia;
	JLabel lconta2;
	JLabel lvalor;
	JLabel ldados;
	JButton bconfirma;
	JButton bcancela;
	ResourceBundle bn;
	Connection conn;
	
	public TelaTf() throws SQLException
	{
		Container c = getContentPane();
		 c.setLayout(new GridLayout(1,1));
		 setContentPane(c);
		 bn = Util.getBundle();
		 conn = Util.getConn();
		 sconta = "xxx.xxx-z";
		 tagencia = new TextField(7);
		 tconta = new TextField(7); 
		 tvalor = new TextField(7);
		 lconta = new JLabel(""+Util.getCli().getConta());
		 lcliente = new JLabel(Util.getContaDAO().getNome(Util.getConta()));
		 ltf =  new JLabel(bn.getString("TelaTf.ltf"));
		 lagencia = new JLabel(bn.getString("TelaTf.lagencia"));
		 lconta2 = new JLabel(bn.getString("TelaTf.lconta2"));
		 lvalor =  new JLabel(bn.getString("TelaTf.lvalor"));
		 ldados =  new JLabel(bn.getString("TelaTf.ldados"));
		 bconfirma = new JButton(bn.getString("TelaTf.bconfirma"));
		 bcancela = new JButton(bn.getString("TelaTf.bcancela"));
		
		 painelAcesso = new JPanel();
		 
		 painelAcesso.add(lcliente);
		 painelAcesso.add(lconta);
		 painelAcesso.add(ltf);
		 painelAcesso.add(ldados);
		 painelAcesso.add(lagencia);
		 painelAcesso.add(tagencia);
		 painelAcesso.add(lconta2);
		 painelAcesso.add(tconta);
		 painelAcesso.add(lvalor);
		 painelAcesso.add(tvalor);
		 painelAcesso.add(bconfirma);
		 painelAcesso.add(bcancela);
		 
		 bcancela.addActionListener(this);
		 
		 c.add(painelAcesso);
		
		setDefaultLookAndFeelDecorated(true);
		setTitle(bn.getString("TelaTf.titulo")); 
		setLocation(400,400); 
		setSize(170,300); 
		
	}

	public void iniciar()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bcancela)
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
