package jp.co.internous.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.internous.twitter.TwitterAccessToken;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginTwitterAction
 * ログインツイッターアクションクラス
 * @author 北山知輝
 * @since 2015/03/16
 * @version 1.0
 */

public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{

	public Map<String, Object> sessionMap;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String[] userData=new String[2];

	/**
	 * 実行メソッド
	 * @author 北山知輝
	 * @since 2015/03/16
	 * @return SUCCESS 結果
	 */
	public String execute() throws IOException{

		TwitterAccessToken twitter = new TwitterAccessToken();

		try {
		userData = twitter.loginOAuth(response, request);
		} catch (Exception e) {
			return ERROR;
		}


		sessionMap.put("NAME", userData[0]);
		sessionMap.put("USERID", userData[1]);
		return SUCCESS;
	}

	/**
	 * レスポンス格納メソッド
	 * @author 北山知輝
	 * @since 2015/03/16
	 * @param response httpれ
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * リクエスト格納メソッド
	 * @author 北山知輝
	 * @since 2015/03/16
	 * @param request httpリクエスト
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	/**
	 * セッション格納メソッド
	 * @author 北山知輝
	 * @since 2015/03/16
	 * @param sessionMap セッションに保存するMap
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;

	}


}
