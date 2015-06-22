package jp.co.internous.action;

import jp.co.internous.dao.LoginAdminDAO;

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
	 * 管理者名
	 */
	public String adminName;
	/**
	 * 管理者パスワード
	 */
	public String adminPass;
	/**
	 * 結果
	 */
	private String result = ERROR;
	/**
	 * 実行メソッド
	 * @author Sakai Shinya
	 * @since 2015/06/17
	 * @return result
	 */
	public String execute(){
		LoginAdminDAO dao = new LoginAdminDAO();
		boolean ret = dao.select(adminName, adminPass);
		if(ret){
			result = SUCCESS;
		}
		return result;
	}
}