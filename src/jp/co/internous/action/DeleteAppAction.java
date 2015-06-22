package jp.co.internous.action;

import jp.co.internous.dao.DeleteAppDAO;

/**
 * InsertAction 管理者画面からサイト情報を削除する為のアクション
 * @author Arima Genki
 * @since 2015/06/17
 * @version 1.0
 */
public class DeleteAppAction {
	/**
	 * result 結果
	 * id アプリID
	 * errormsg エラーメッセージ
	 */
	private String result = "error";
	private int id;
	public String errormsg = null;
	/**
	 * 入力された値をDから削除し、resultを返すメソッド
	 * @author Arima Genki
	 * @since 2015/06/17
	 * @return result 実行結果を返す
	 */
	public String execute() {
		DeleteAppDAO dao = new DeleteAppDAO();
		if (dao.delete(id)) {
			result = "success";
			errormsg = "";
		} else {
			errormsg = "入力された値が正しくありません";
		}
		return result;
	}
	/**
	 * ID格納メソッド
	 * @author Arima Genki
	 * @since 2015/06/17
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}