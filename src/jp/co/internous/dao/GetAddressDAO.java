package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.GetAddressDTO;
import jp.co.internous.util.DBconnector;
/**
 * GetAddressDAO DBのsiteテーブルからサイト情報を取得してくるクラス
 * @since 2015/06/21
 * @author Mizuno Kaito
 */
public class GetAddressDAO {
	/**
	 * DBのsiteテーブルからサイト情報を取得してくるメソッド
	 * @author Mizuno Kaito
	 * @return サイト情報リストを返す
	 */
	public List<GetAddressDTO> select() {
		List<GetAddressDTO> siteInfoList = new ArrayList<GetAddressDTO>();
		Connection con = DBconnector.getConnection();

		try {
			String sql = "select * from site";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetAddressDTO dto = new GetAddressDTO();
				dto.setId(rs.getInt(1));
				dto.setSiteName(rs.getString(2));
				dto.setUrl(rs.getString(3));
				siteInfoList.add(dto);
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
		return siteInfoList;
	}
}
