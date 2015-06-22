package jp.co.internous.action;

import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dao.GetAddressDAO;
import jp.co.internous.dto.GetAddressDTO;

import com.opensymphony.xwork2.ActionSupport;
/**
 * GetAddressAdminAction 管理者画面にDB内のサイト情報を表示させるためのアクション
 * @author Mizuno Kaito
 * @since  2015/06/21
 * @version 1.0
 */
public class GetAddressAdminAction extends ActionSupport {
	/**
	 * siteInfoList サイト情報リスト
	 */
	private List<GetAddressDTO> siteInfoList = new ArrayList<GetAddressDTO>();
	/**
	 * 実行クラス
	 * @author Mizuno Kaito
	 * @return 実行結果を返す
	 */
	public String execute(){
		String result = ERROR;
		GetAddressDAO dao = new GetAddressDAO();
		siteInfoList.addAll(dao.select());
		if(siteInfoList.size() > 0){
			result = SUCCESS;
		}
		return result;
	}
	/**
	 * サイト情報取得メソッド
	 * @author Mizuno Kaito
	 * @return サイト情報リストを返す
	 */
	public List<GetAddressDTO> getSiteInfoList() {
		return siteInfoList;
	}
}
