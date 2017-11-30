/*
*Grupo: Lucas Andrade Rodrigues, Luan dos Santos Cantalice
*
*/

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class entrar{
	public static void main(String[] args)throws Exception {
		String letra = JOptionPane.showInputDialog("informe a letra:\n a-->Logar\n b-->Criar conta");
		//por enquanto só cria usuario
		if(letra.equals("b")){
			usuario user = new usuario();
			user.email = JOptionPane.showInputDialog("Email:");
			user.nome = JOptionPane.showInputDialog("Nome do Usuario:");
			user.senha = JOptionPane.showInputDialog("Senha:");
			user.data_nascimento = JOptionPane.showInputDialog("Data de nascimento:(xx/xx/xxxx)");
			user.area = JOptionPane.showInputDialog("Nome sua Àrea da Informatica:");
	
			String sql = "insert into dadosUser values(?,?,?,?,?)";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			try(Connection con = DriverManager.getConnection(url, "ldev", "ld");
			PreparedStatement stm = con.prepareStatement(sql)){
			stm.setString(1, user.email);
			stm.setString(2, user.nome);
			stm.setString(3, user.senha);
			stm.setString(4, user.data_nascimento);
			stm.setString(5, user.area);
			stm.addBatch();
			stm.executeBatch();
			}
	
		}
	}
}