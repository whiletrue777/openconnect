package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.internous.dto.LoginDTO;

/**
 * クラス名：LoginDAO
 * クラスの説明：データベース接続用のDAOクラス
 */
public class LoginDAO {

	//IDとPassに紐づくUserNameの格納
	private String DBuserName;

	//データベース検索結果判定用の変数
	private boolean resultDAO = false;

	//LoginActionクラスから渡された引数を元にselectメソッドを実行
	public boolean select(String userID, String password){

		System.out.println("★LoginDAO実行");

		try {
				//データベース接続実施
				Class.forName("com.mysql.jdbc.Driver");
				Connection con;
				con = DriverManager.getConnection("jdbc:mysql://localhost/prototype201411", "root", "mysql");

				//SQL文作成
				String sql = "SELECT * FROM login where userID = \"";
				sql += userID + "\" AND password = \"" + password + "\"" ;
//				AND userName = \"" + userName + "\""

				System.out.println("★実行するSQL文確認 = " + sql);

				//接続情報とSQL文を格納する
				PreparedStatement ps = con.prepareStatement(sql);

				System.out.println("★接続情報とSQL文を格納する");

				//接続情報を元にSQL文実行
				ResultSet rs = ps.executeQuery();

				//検索結果を判定
				while(rs.next()){

					//DB検索成功なので結果判定用の変数をtrueに変更
					resultDAO = true;

					//LoginDTOクラスをインスタンス化
					LoginDTO logindto = new LoginDTO();

					//LoginDTOをのメソッドを実行し、DBから取得した値を格納
					String DBuserID = logindto.setUserID(rs.getString(1));
					String DBpassword = logindto.setPassword(rs.getString(2));
//					String DBuserName = logindto.setUserName(rs.getString(3));
					DBuserName=rs.getString(3);
					//検索結果をコンソールで確認
					System.out.println("DBから取得したuserID =" + DBuserID );
					System.out.println("DBから取得したuserPassword =" + DBpassword );
					System.out.println("DBから取得したuserName =" + DBuserName );
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//DB検索判定をLoginActionにリターンする
		return resultDAO;
	}

	public String dbname(){
		return DBuserName;
	}

}
