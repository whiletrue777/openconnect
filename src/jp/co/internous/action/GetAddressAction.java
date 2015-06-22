package jp.co.internous.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dao.GetAddressDAO;
import jp.co.internous.dto.GetAddressDTO;

import com.opensymphony.xwork2.ActionSupport;

public class GetAddressAction extends ActionSupport {
	
	private List<GetAddressDTO> siteInfoList = new ArrayList<GetAddressDTO>();
	
	public String execute(){
		String result = ERROR;

		
		GetAddressDAO dao = new GetAddressDAO();
		
		try {
			siteInfoList.addAll(dao.select());
			result = SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public List<GetAddressDTO> getSiteInfoList() {
		return siteInfoList;
	}

}
