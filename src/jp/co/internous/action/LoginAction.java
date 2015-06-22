package jp.co.internous.action;

import java.util.Map;

import jp.co.internous.dao.LoginDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * クラス名：LoginAction
 * クラスの説明：Login用のアクションクラス
 */
public class LoginAction extends ActionSupport implements SessionAware{

	private String password;
	private String username;
	private String result;

	//struts.xmlの情報を元に、executeメソッドが実行される
	public String execute(){

		System.out.println("★LoginAction実行");

		System.out.println("★JSPに入力されたusername = " + username);
		System.out.println("★JSPに入力されたpassword = " + password);

		//return値の初期値をERRORに設定
		result = ERROR;

		//LoginDAOクラスをインスタンス化
		LoginDAO logindao = new LoginDAO();

		//LoginDAOクラスのselectメソッドを実行し、return値をboolean型のresultDAOに格納
		boolean res = logindao.select(username,password);

		//データベースの検索結果がtrueならば、変数resultの値をSUCCESSに変更
		if(res){
			result = SUCCESS;
		}
		return result;

	}
        //DAOをインスタンス化
	public String backtomain() {
		result="success";
		return result;
	}


	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}


	//遷移元のjspからformのname属性を取得
	public String setPassword(String password){
		System.out.println("★LoginActionのsetPasswordメソッド実行");
		return this.password = password;
	}


	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username セットする username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}


}
