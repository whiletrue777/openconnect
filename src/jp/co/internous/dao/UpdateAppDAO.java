package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;

/**
 * UpdateAppDAO UpdateAppActionがDBにアクセスするためのDAOクラス
 * @author Arima Genki
 * @since 2015/06/18
 * @version 1.0
 */
public class UpdateAppDAO {
	/**
	 * res 実行結果
	 */
	private boolean res = false;
	/**
	 * アプリを編集するメソッド
	 * @author Arima Genki
	 * @since 2015/06/18
	 * @param id アプリID
	 * @param siteName アプリ名
	 * @param url アプリURL
	 * @return res レスポンスを返す
	 */
	public boolean update(int id, String siteName, String url) {
		Connection con = DBconnector.getConnection();
		try {
			String sql = "update site set name=?,url=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, siteName);
			ps.setString(2, url);
			ps.setInt(3, id);
			int rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				res = true;
			}
		} catch (Exception e) {
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
