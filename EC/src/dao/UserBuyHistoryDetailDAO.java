package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import base.DBManager;
import beans.BuyDataBeans;
import beans.BuyDetailDataBeans;

public class UserBuyHistoryDetailDAO {
	/**
	 * 購入履歴参照
	 * @param bdb 購入履歴
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
    public static ArrayList<BuyDataBeans> buyDateList(int usersId) throws SQLException{

    	ArrayList<BuyDataBeans> buyDataList = new ArrayList<BuyDataBeans>();
        Connection con = null;
        PreparedStatement st = null;


        try {
            // データベースへ接続
            con = DBManager.getConnection();


            // SELECT文を準備
            st = con.prepareStatement("SELECT * FROM t_buy WHERE user_id = ?");
			st.setInt(1, usersId);

             // SELECTを実行し、結果表を取得

            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int totalPrice = rs.getInt("total_price");
                int deriveryMethodId = rs.getInt("delivery_method_id");
                Date buyDate = rs.getTimestamp("create_date");

                BuyDataBeans bdb = new BuyDataBeans();

                bdb.setId(id);
                bdb.setUserId(userId);
                bdb.setTotalPrice(totalPrice);
                bdb.setDelivertMethodId(deriveryMethodId);
                bdb.setBuyDate(buyDate);



                if(bdb != null) {
                	 st = con.prepareStatement("SELECT * FROM m_delivery_method WHERE id = ?");
         			st.setInt(1, deriveryMethodId);

         			 ResultSet rs2 = st.executeQuery();
         			 while (rs2.next()) {

                         String deriveryMethodName = rs2.getString("name");
                         int deriveryMethodPrice = rs2.getInt("price");

                         int allTotalPrice = totalPrice + deriveryMethodPrice;

                         bdb.setDeliveryMethodName(deriveryMethodName);
                         bdb.setDeliveryMethodPrice(deriveryMethodPrice);
                         bdb.setAllTotalPrice(allTotalPrice);




                         buyDataList.add(bdb);
         			 }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return buyDataList;
    }
    public static ArrayList<BuyDataBeans> buyDateId (int usersId) throws SQLException{

    	ArrayList<BuyDataBeans> buyDataList = new ArrayList<BuyDataBeans>();
        Connection con = null;
        PreparedStatement st = null;


        try {
            // データベースへ接続
            con = DBManager.getConnection();


            // SELECT文を準備
            st = con.prepareStatement("SELECT * FROM t_buy WHERE id = ?");
			st.setInt(1, usersId);

             // SELECTを実行し、結果表を取得

            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int totalPrice = rs.getInt("total_price");
                int deriveryMethodId = rs.getInt("delivery_method_id");
                Date buyDate = rs.getTimestamp("create_date");

                BuyDataBeans bdb = new BuyDataBeans();

                bdb.setId(id);
                bdb.setUserId(userId);
                bdb.setTotalPrice(totalPrice);
                bdb.setDelivertMethodId(deriveryMethodId);
                bdb.setBuyDate(buyDate);



                if(bdb != null) {
                	 st = con.prepareStatement("SELECT * FROM m_delivery_method WHERE id = ?");
         			st.setInt(1, deriveryMethodId);

         			 ResultSet rs2 = st.executeQuery();
         			 while (rs2.next()) {

                         String deriveryMethodName = rs2.getString("name");
                         int deriveryMethodPrice = rs2.getInt("price");

                         int allTotalPrice = totalPrice + deriveryMethodPrice;

                         bdb.setDeliveryMethodName(deriveryMethodName);
                         bdb.setDeliveryMethodPrice(deriveryMethodPrice);
                         bdb.setAllTotalPrice(allTotalPrice);




                         buyDataList.add(bdb);
         			 }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return buyDataList;
    }

    public static ArrayList<BuyDetailDataBeans> buyDateDetail (int usersId) throws SQLException{

    	ArrayList<BuyDetailDataBeans> buyDateDetail = new ArrayList<BuyDetailDataBeans>();
        Connection con = null;
        PreparedStatement st = null;


        try {
            // データベースへ接続
            con = DBManager.getConnection();


            // SELECT文を準備
            st = con.prepareStatement("SELECT * FROM t_buy_detail WHERE buy_id = ?");
			st.setInt(1, usersId);

             // SELECTを実行し、結果表を取得

            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                int itemId = rs.getInt("item_id");


                BuyDetailDataBeans bdb = new BuyDetailDataBeans();

                bdb.setId(id);
                bdb.setItemId(itemId);




                if(bdb != null) {
                	 st = con.prepareStatement("SELECT * FROM m_item WHERE id = ?");
         			st.setInt(1, itemId);

         			 ResultSet rs2 = st.executeQuery();
         			 while (rs2.next()) {

                         String itemName = rs2.getString("name");
                         int itemPrice = rs2.getInt("price");



                         bdb.setItemName(itemName);
                         bdb.setItemPrice(itemPrice);





                         buyDateDetail.add(bdb);
         			 }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return buyDateDetail;
    }

}

