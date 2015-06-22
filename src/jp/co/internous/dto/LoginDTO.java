package jp.co.internous.dto;

/**
 * クラス名：LoginDTO
 * クラスの説明：データベース検索結果格納用のDTOクラス
 */
public class LoginDTO {

	//LoginDTO用の変数
	private static String userID;
	private static String password;
//	private static String userNameik;
	public static String getUserID() {
		return userID;
	}
	public String setUserID(String userID) {
		return LoginDTO.userID = userID;
	}
	public static String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return LoginDTO.password = password;
	}


}