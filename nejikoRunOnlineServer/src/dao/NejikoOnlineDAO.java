package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NejikoMileage;

public class NejikoOnlineDAO {

	private final String DB_PATH = "jdbc:mysql://localhost:3306/nejiko_online_20191216";


	private final String DB_CHARACTER_ENCODE = "?useUnicode=true&characterEncoding=utf8";

	private final String DB_USERNAME = "root";

	private final String DB_PASSWORD = "root";

	public NejikoOnlineDAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public List<NejikoMileage> findNejikoMileage(){

		List<NejikoMileage> result = new ArrayList<NejikoMileage>();

		try(Connection conn = DriverManager.getConnection(DB_PATH +DB_CHARACTER_ENCODE,DB_USERNAME,DB_PASSWORD);){


			String sql = "";

			sql += "SELECT";
			sql += " name,score";
			sql += " FROM";
			sql += " ranking";
			sql += " ORDER BY";
			sql += " score DESC LIMIT 3;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();



			while(rs.next()){
				String name = rs.getString("name");
				int score = rs.getInt("score");

				NejikoMileage record = new NejikoMileage(name,score);
				result.add(record);
			}

			return result;
		}catch(SQLException e ){
			e.printStackTrace();
		}

		return null;
	}

	public boolean registNejikoMileage(NejikoMileage mileage){
		String name = mileage.getName();
		int score = mileage.getScore();

		try(Connection conn = DriverManager.getConnection(DB_PATH + DB_CHARACTER_ENCODE,DB_USERNAME,DB_PASSWORD);){

			String sql = "";
			sql += "INSERT";
			sql += " INTO";
			sql += " ranking (name,score)";
			sql += " VALUES";
			sql += " (?,?);";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,name);
			pStmt.setInt(2, score);

			System.out.println("NejikoDAO/DBへ送信するSQL:" + pStmt.toString() );

			pStmt.executeUpdate();

			return true;
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return false;
	}
}
