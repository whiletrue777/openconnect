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
	 * res レスポンス
	 */
	private boolean res;
	/**入力された情報とDB内の情報を照合するためのメソッド
	 * @author Sakai Shinya
	 *
	 * @param adminName
	 * @param adminPass
	 * @return res
	 * @see DBconnector
	 */
	public boolean select(String adminName, String adminPass){
		res = false;
		Connection con = DBconnector.getConnection();
		String sql = "SELECT * FROM admin WHERE admin_name = ? AND admin_pass = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, adminName);
			ps.setString(2, adminPass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
