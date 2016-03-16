package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;

import factory.ConnectionFactory;
import to.ContaTO;


public class ContaDAO {
	
	private ResultSet rs;

	public double mostraSaldo(ContaTO To) throws SQLException {
		
		String sqlSelect = "SELECT * FROM conta c WHERE c.conta = ?";
		System.out.println(To.getConta());
		PreparedStatement stm = null;
		ResultSet rs = null;

		double a = 1;
		try {new ConnectionFactory();
	         Connection	conn = ConnectionFactory.obtemConexao();
			stm = conn.prepareStatement(sqlSelect);
			stm.setLong(1, To.getConta());
			rs = stm.executeQuery();
			
			System.out.println(rs.next());
			a = rs.getDouble(5);
			
		}

		catch (Exception e) {
			e.printStackTrace();
			try {Connection	conn = ConnectionFactory.obtemConexao();
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return a;
	}

	public void saque(ContaTO To, double a) throws SQLException {
		// TODO Auto-generated method stub
		if(a <= mostraSaldo(To))
		{	
			
			double b = mostraSaldo(To); 
			To.setSaldo((b-a));
			
			
			String sqlSelect = "update conta set conta.saldo = "+To.getSaldo()+ " where conta.conta = "+To.getConta() ;

			PreparedStatement stm = null;
			setRs(null);
			try {Connection	conn = ConnectionFactory.obtemConexao();
			System.out.println(sqlSelect);
			
			
			stm = conn.prepareStatement(sqlSelect);
		
			stm.executeUpdate();
		
		}
		catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
		}
		}
	
	public String getNome(ContaTO To) throws SQLException {

		
		String sqlSelect = "SELECT * FROM conta c WHERE c.conta = ?";

		PreparedStatement stm = null;
		ResultSet rs = null;

		String a = "---";
		try {Connection	conn = ConnectionFactory.obtemConexao();
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, To.getConta());
			rs = stm.executeQuery();

			if (rs.next()) {
				a = (rs.getString(2));
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return a;
	}

	public ContaTO carregar(int conta)
	{
		ContaTO to = new ContaTO();
		String sqlSelect = "SELECT conta,cliente,saldo,codAcesso,agencia FROM conta WHERE conta.conta = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conta);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setConta(rs.getInt(1));
					to.setCli(rs.getString(2));
					to.setSaldo(rs.getDouble(3));
					to.setSenha(rs.getString(4));
					to.setAgencia(rs.getInt(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}	
		
	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void insereMov(ContaTO to,double valor,String operacao)
	{
		String sqlInsert = "INSERT INTO movimentacao(cliente,conta_conta,valor,operacao,agencia,data) VALUES (?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			Date data = new java.sql.Date(System.currentTimeMillis());
			System.out.println(sqlInsert);
			System.out.println(data);
			stm.setString(1, to.getNome());
			stm.setInt(2, to.getConta());
			stm.setDouble(3, valor);
			stm.setString(4, operacao);
			stm.setInt(5, to.getAgencia());
			stm.setDate(6,data);
			stm.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
