package jp.co.internous.action;

import jp.co.internous.dao.UpdateAppDAO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * UpdateGoodsAction 管理者画面から商品情報を編集する為のアクション
 * @author Arima Genki
 * @since 2015/06/15
 * @version 1.0
 */
public class UpdateAppAction extends ActionSupport {
	/**
	 * id アプリID
	 * siteName アプリ名
	 * url アプリURL
	 * updateErrormsg エラーメッセージ
	 */
	private int id;
	private String siteName;
	private String url;
	public String updateErrormsg = null;
	/**
	 * 入力された値をDBに登録されている商品に反映し、resultを返すメソッド
	 * @author Arima Genki
	 * @since 2015/06/15
	 * @return 実行結果を返す
	 */
	public String execute(){
		String result = ERROR;
		UpdateAppDAO updateAppDao = new UpdateAppDAO();
		if (updateAppDao.update(id, siteName, url)) {
				result = "success";
				updateErrormsg ="";
		} else {
			updateErrormsg = "*正しい値を入力してください。";
		}
		return result;
	}
	/**
	 * ID格納メソッド
	 * @author Arima Genki
	 * @since 2016/06/016
	 * @param Id アプリID
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * サイト名格納メソッド
	 * @author Arima Genki
	 * @since 2016/06/016
	 * @param siteName アプリ名
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * URL格納メソッド
	 * @author Arima Genki
	 * @since 2016/06/016
	 * @param url アプリURL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * エラーメッセージ取得メソッド
	 * @author Mizuno Kaito
	 * @return エラーメッセージを返す
	 */
	public String getUpdateErrormsg() {
		return updateErrormsg;
	}
}
