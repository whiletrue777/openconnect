package jp.co.internous.action;

import jp.co.internous.dao.InsertDAO;

import com.opensymphony.xwork2.ActionSupport;
/**
 * InsertAction 管理者画面からサイト情報を追加する為のアクション
 * @author Arima Genki
 * @since 2015/06/16
 * @version 1.0
 */
public class InsertAction extends ActionSupport {
	/**
	 * result 結果
	 * siteName サイト名
	 * url サイトURL
	 * insertErrormsg エラーメッセージ
	 */
	private String result = ERROR;;
	private String siteName;
	private String url;
	private String insertErrormsg;
	/**
	 * 入力された値をDBに登録し、resultを返すメソッド
	 * @author Arima Genki
	 * @since 2015/06/16
	 * @return result
	 * @throws Exception
	 * @see InsertDAO
	 */

	public String execute(){
		InsertDAO dao = new InsertDAO();
		if(dao.insert(siteName,url)){
			result = "success";
			insertErrormsg = "";
		} else {
			insertErrormsg = "*入力された情報が正しくありません。";
		}
		return result;
	}
	/**
	 * サイト名格納メソッド
	 * @author Arima Genki
	 * @since 2016/06/016
	 * @param siteName
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * URL格納メソッド
	 * @author Arima Genki
	 * @since 2016/06/016
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * エラーメッセージ取得メソッド
	 * @author Mizuno kaito
	 * @return エラーメッセージを返す
	 */
	public String getInsertErrormsg() {
		return insertErrormsg;
	}
}
