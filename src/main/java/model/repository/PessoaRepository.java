package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Pessoa;

public class PessoaRepository implements BaseRepository<Pessoa> {

	@Override
	public Pessoa salvar(Pessoa novaPessoa) {
		String query = "INSERT INTO pessoa (nome, datanascimento, sexo, cpf) VALUES (?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			//TODO este bloco repete-se no alterar().... refatorar!
			preencherParametrosParaInsertOuUpdate(pstmt, novaPessoa);
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao salvar novo jogador");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return novaPessoa;
	}

	private void preencherParametrosParaInsertOuUpdate(PreparedStatement pstmt, Pessoa novaPessoa) throws SQLException {
		pstmt.setInt(1,novaPessoa.getId());
		pstmt.setString(2, novaPessoa.getNome());
		pstmt.setDate(3, Date.valueOf(novaPessoa.getDtaNascimento()));
		pstmt.setString(4, novaPessoa.getSexo());
		pstmt.setString(5, novaPessoa.getCpf());
	}

	@Override
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM pessoa WHERE id = " + id;
		try {
			if(stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir pessoa");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	@Override
	public boolean alterar(Pessoa novaPessoa) {
		boolean alterou = false;
		String query = " UPDATE jogador "
					 + " SET   nome=?, data_nascimento=?, "
				     + "       sexo=?, cpf=? "
				     + " WHERE id=?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		try {
			//TODO este bloco repete-se no salvar().... refatorar!
			pstmt.setInt(1, novaPessoa.getId());
			pstmt.setString(2, novaPessoa.getNome());
			pstmt.setDate(3, Date.valueOf(novaPessoa.getDtaNascimento()));
			pstmt.setString(4, novaPessoa.getSexo());
			pstmt.setString(5, novaPessoa.getCpf());
			
			
			alterou = pstmt.executeUpdate() > 0;
		} catch (SQLException erro) {
			System.out.println("Erro ao atualizar pessoa");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return alterou;
	}

	@Override
	public Pessoa consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		Pessoa pessoa= new Pessoa();
		String query = " SELECT * FROM jogador WHERE id = " + id;
		
		try{
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
				//TODO este bloco repete-se no consultarTodos().... refatorar!
				pessoa.setId(Integer.parseInt(resultado.getString("ID")));
				pessoa.setNome(resultado.getString("NOME"));
				pessoa.setDtaNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate()); 
				pessoa.setSexo(resultado.getString("SEXO"));
				pessoa.setCpf(resultado.getString("CPF"));
			}
		} catch (SQLException erro){
			System.out.println("Erro ao executar consultar jogador com id (" + id + ")");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoa;
	}

	@Override
	public ArrayList<Pessoa> consultarTodos() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		String query = " SELECT * FROM pessoa";
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				Pessoa pessoa = new Pessoa();
				
				//TODO este bloco repete-se no consultarTodos().... refatorar!
				pessoa.setId(Integer.parseInt(resultado.getString("ID")));
				pessoa.setNome(resultado.getString("NOME"));
				pessoa.setDtaNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate()); 
				pessoa.setSexo(resultado.getString("TOTAL_PARTIDAS"));
				pessoa.setCpf(resultado.getString("PERCENTUAL_VITORIAS"));
				pessoas.add(pessoa);
			}
		} catch (SQLException erro){
			System.out.println("Erro ao executar consultar todas as pessoas");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}
	
}
