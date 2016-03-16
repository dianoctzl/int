package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Conta;
import to.ContaTO;
import dao.ContaDAO;
import factory.ConnectionFactory;

public class TelaAcesso extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField tconta;
	TextField tlogin;
	TextField tsenha;
	Label lconta;
	Label llogin;
	Label lsenha;
	Label text;
	JButton blogar;
	JButton bcancelar;
	JPanel painelAcesso;
	String titulo;
	ResourceBundle bn;
	Locale local;
	Connection conn;

	Locale Local;
	public TelaAcesso() {
		bn = Util.getBundle();        // ResourceBundle.getBundle("ling",l );	
		conn = Util.getConn();
		// local = l;
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 2));
		setContentPane(c);
		titulo ="";
		tconta = new TextField(20);
		tlogin = new TextField(20);
		tsenha = new TextField(20);
		text = new Label(bn.getString("TelaAcesso.text"));
		Label text1 = new Label("            ");
		lconta = new Label(bn.getString("TelaAcesso.lsenha"));
		llogin = new Label(bn.getString("TelaAcesso.llogin"));
		lsenha = new Label(bn.getString("TelaAcesso.lconta"));
		blogar = new JButton(bn.getString("TelaAcesso.blogar"));
		bcancelar = new JButton(bn.getString("TelaAcesso.bcancelar"));
		
		blogar.addActionListener(this);
		
		painelAcesso = new JPanel();

		painelAcesso.add(text);
		painelAcesso.add(text1);
		painelAcesso.add(llogin);
		painelAcesso.add(tlogin);
		painelAcesso.add(lsenha);
		painelAcesso.add(tsenha);
		painelAcesso.add(lconta);
		painelAcesso.add(tconta);
		painelAcesso.add(blogar);
		painelAcesso.add(bcancelar);
		
		c.add(painelAcesso);

		setTitle(bn.getString("TelaAcesso.titulo"));
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400, 400);
		setSize(245, 180);
		

	}
	
	public void iniciar()
	{
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == blogar)
		{
			
			Conta conta = new Conta(Integer.parseInt(tsenha.getText()));
			ContaDAO dao = new ContaDAO();
			ContaTO to = dao.carregar(Integer.parseInt(tsenha.getText()));
			conta.carrega();
			
			@SuppressWarnings("unused")
			ConnectionFactory bd = new ConnectionFactory();
			try {
				conn = ConnectionFactory.obtemConexao();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Util.setConn(conn);
			Util.setCli(conta);
			Util.setConta(to);
			Util.setContaDAO(dao);
			//	cliente.setConta(Long.parseLong(tconta.getText()));
			System.out.println("Login");
			setVisible(false);
			try {
				TelaInicial c = new TelaInicial();
				c.inicar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		/*	ArquivoLogin login = new ArquivoLogin();
			if(login.verificaUsuario(cliente) != null){
				System.out.println("Login");
				setVisible(false);
				TelaInicial c = new TelaInicial();
			}
			System.out.println("nao login");*/
			
		}
	}

}
