package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;
/**
 * InsertDAO InsertActionがDBにアクセスするためのDAOクラス
 * @author Arima Genki
 * @since 2015/06/18
 * @version 1.0
 */
public class InsertDAO extends ActionSupport {
	/**
	 * res 実行結果
	 */
	private boolean res = false;
	/**
	 * アプリを追加するメソッド
	 * @author Arima Genki
	 * @since 2015/06/18
	 * @param siteName アプリ名
	 * @param url アプリURL
	 * @return res レスポンスを返す
	 */
	public boolean insert(String siteName, String url){
		Connection con = DBconnector.getConnection();
		try {
			String sql = "insert into site(id,name,url) select max(id) + 1, ?, ? from site ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, siteName);
			ps.setString(2, url);
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
