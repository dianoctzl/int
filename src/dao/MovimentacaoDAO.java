package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.MovimentacaoTO;

public class MovimentacaoDAO {

	ResultSet rs;
	
	public MovimentacaoTO carregar(int seq)
	{
		MovimentacaoTO to = new MovimentacaoTO();
		String sqlSelect = "SELECT cliente,sequencia,conta_conta,valor,operacao,agencia,data FROM movimentacao WHERE movimentacao.sequencia = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, seq);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString(1));
					to.setSeq(rs.getInt(2));
					to.setConta(rs.getInt(3));
					to.setValor(rs.getDouble(4));
					to.setOperacao(rs.getString(5));
					to.setAgencia(rs.getInt(6));
					to.setData(rs.getDate(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
}
