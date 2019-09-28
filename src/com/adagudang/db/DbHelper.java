package com.adagudang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.adagudang.constant.Constant;
import com.adagudang.obj.TestObj;
public class DbHelper {
	private static final Logger LOG = Logger.getLogger(DbHelper.class.getName());
	private static DbHelper queryInstance = null;


	public static DbHelper getInstance() {
		if (queryInstance == null) {
			queryInstance = new DbHelper();
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				LOG.info("Exception on dbhelper getinstance, message:"+e.getMessage());
			}
		}
		return queryInstance;
	}



	public List<TestObj> getBannerList() throws SQLException{
		ArrayList<TestObj> bannerList = new ArrayList<TestObj>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {

			//connection = DriverManager.getConnection(Constant.Connection.toString(),Constant.User.toString(),Constant.Password.toString());


//			statement = connection.createStatement();
//			resultSet = statement.executeQuery("SELECT * FROM master.m_banner");
//			while (resultSet.next()) {
//				TestObj banObj=new TestObj(resultSet.getInt("id"),resultSet.getString("title"));
//				bannerList.add(banObj);
//			}
			bannerList.add(new TestObj(1, "a"));
			bannerList.add(new TestObj(2, "b"));
			
		}catch (Exception e) {
			LOG.info("Exception on getBannerList, message"+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			if(connection!=null) {
				connection.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(resultSet!=null) {
				resultSet.close();
			}
		}

		return bannerList;
	}


}
