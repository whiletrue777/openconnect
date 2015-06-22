package jp.co.internous.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.AppDTO;
import jp.co.internous.util.DBconnector;
/**
 * SelectItemDAO ItemAllActionがDBに接続するためのDAOクラス
 * @author Osumi Haruka
 * @since2015/05/18
 * @version 1.0
 */
public class SelectAppDAO {


 Connection con = null;
 String rsgsql = null;
 PreparedStatement ps2 = null;
 public List<AppDTO> AppList=new ArrayList<AppDTO>();
 private boolean result=false;
/**
 * @author Osumi Haruka
 * @since2015/05/18
 * DBgoodsId  DB格納用商品ID
 * DBgoodsName  DB格納用商品名
 * DBunitPrice  DB格納用単価
 */
public int DBid=0;
 public String DBsiteName=null;
 public String DBurl=null;

/**
 * @param goodsName  商品名
 * @param stock  在庫数
 * @param unitprice  単価
 * @return result  例外処理に入らなければレスポンスを返す
 * @throws Exception
 * @see DBconnector
 * @see ItemDTO
 */
public boolean select(int id,String siteName,String url) throws Exception{
  con=DBconnector.getConnection();

  try {
   String sql="select * from site" + "where id=? and name=? and url=? ";
   ps2=con.prepareStatement(sql);

   ResultSet rs=ps2.executeQuery();
   while(rs.next()) {

    AppDTO dto=new AppDTO();
    result=true;

    dto.setId(rs.getInt(1));
    DBid=dto.getId();
    dto.setSiteName(rs.getString(2));
    DBsiteName=dto.getSiteName();
    dto.setUrl(rs.getString(3));
    DBurl=dto.getUrl();

   }

   }catch (Exception e){
    e.printStackTrace();
   }finally{
    con.close();
   }

   return result;
  }
 }
