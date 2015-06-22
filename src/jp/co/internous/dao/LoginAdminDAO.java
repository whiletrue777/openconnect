package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;
import jp.co.internous.util.DaoClass;
/**
 * LoginAdminDAO ログイン情報を照会するためのDAOクラス
 * @author Sakai Shinya
 * @since  2015/06/16
 * @version 1.0
 */
public class LoginAdminDAO extends DaoClass{
	/**
	 * レスポンス
	 */
	private boolean res;
	/**
	 * コネクション
	 */
	private Connection con;
	/**
	 * SQL文の基となる文字列
	 */
	private String sql;
	/**
	 * 文字列をSQL文として格納
	 */
	private PreparedStatement ps;
	/**
	 * 結果
	 */
	private ResultSet rs;
	/**入力された情報とDB内の情報を照合するためのメソッド
	 * @author Sakai Shinya
	 *
	 * @param admin_name
	 * @param admin_pass
	 * @return res
	 * @throws SQLException
	 * @see DBconnector
	 */
	public boolean select(String admin_name, String admin_pass){
		res = false;
		con = DBconnector.getConnection();
		sql = "SELECT * FROM admin WHERE admin_name = ? AND admin_pass = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, admin_name);
			ps.setString(2, admin_pass);
			rs = ps.executeQuery();
			while(rs.next()){
				res = true;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
