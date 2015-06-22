package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;
/**
 * DeleteAppDAO DeleteAppActionがDBにアクセスするためのDAOクラス
 * @author Arima Genki
 * @since 2015/06/18
 * @version 1.0
 */
public class DeleteAppDAO {
	/**
	 * アプリを削除するメソッド
	 * @author Arima Genki
	 * @since 2015/06/18
	 * @param id アプリID
	 * @return res レスポンスを返す
	 */
	public boolean delete(int id) {
		boolean res = false;
		Connection con = DBconnector.getConnection();
		try {
			String sql = "DELETE FROM site WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i > 0){
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
