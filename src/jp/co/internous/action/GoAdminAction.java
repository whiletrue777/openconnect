package jp.co.internous.action;

import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dao.GetAddressDAO;
import jp.co.internous.dao.LoginAdminDAO;
import jp.co.internous.dto.GetAddressDTO;

import com.opensymphony.xwork2.ActionSupport;
/**
 * GoAdminAction 管理者画面にログインするためのアクション
 * @author Sakai Shinya
 * @since  2015/06/17
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GoAdminAction extends ActionSupport{
	/**
	 * adminName 管理者名
	 * adminPass 管理者パスワード
	 * result 実行結果
	 * siteInfoList サイト情報リスト
	 */
	private String adminName;
	private String adminPass;
	private String result = ERROR;
	private List<GetAddressDTO> siteInfoList = new ArrayList<GetAddressDTO>();
	/**
	 * 実行メソッド
	 * @author Sakai Shinya
	 * @since 2015/06/17
	 * @return result
	 */
	public String execute(){
		LoginAdminDAO dao = new LoginAdminDAO();
		if(dao.select(adminName, adminPass)){
			result = SUCCESS;
			GetAddressDAO getAddressDao = new GetAddressDAO();
			siteInfoList.addAll(getAddressDao.select());
		}
		return result;
	}
	/**
	 * 管理者名格納メソッド
	 * @author Mizuno Kaito
	 * @param adminName 管理者名
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * 管理者パスワード格納メソッド
	 * @author Mizuno Kaito
	 * @param adminPass 管理者パスワード
	 */
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	/**
	 * サイト情報リスト取得メソッド
	 * @author Mizuno kaito
	 * @return siteInfoList
	 */
	public List<GetAddressDTO> getSiteInfoList() {
		return siteInfoList;
	}
}