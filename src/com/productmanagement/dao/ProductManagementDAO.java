package com.productmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.productmanagement.dbutil.DBUtil;
import com.productmanagement.pojo.Product;

public class ProductManagementDAO {

	private static final String ALL_PRODUCT_QUERY = "SELECT *FROM PRODUCT";
	private static final String PRODUCT_BY_ID_QUERY = "SELECT *FROM PRODUCT WHERE id = ?";
	private static final String ADD_PRODUCT_QUERY = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
	private static final String UPDATE_PRODUCT_QUERY = "UPDATE PRODUCT SET pName = ?, pCategory=?, pPrice = ? WHERE id = ?";
	private static final String DELETE_PRODUCT_QUERY = "DELETE FROM PRODUCT WHERE id = ?";

	public static List<Product> getAllProducts() {

		List<Product> productList = new ArrayList<>();

		try (Connection conn = DBUtil.GetConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(ALL_PRODUCT_QUERY)) {

			while (rs.next()) {
				Product product = new Product(rs.getString("id"), rs.getString("pName"), rs.getString("pCategory"),
						rs.getInt("pPrice"));
				productList.add(product);
			}

			DBUtil.CloseDatabase(conn);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productList;
	}

	// get product by entering product id

	public static Product getProductById(String pid) {

		Product product = null;
		// product = new
		try (Connection conn = DBUtil.GetConnection();
				PreparedStatement ps = conn.prepareStatement(PRODUCT_BY_ID_QUERY)) {
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString("id"), rs.getString("pName"), rs.getString("pCategory"),
						rs.getInt("pPrice"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return product;

	}

	// add product item to the database
	public static int addProduct(Product product) {
		int status = 0;
		Connection conn = DBUtil.GetConnection();
		try (PreparedStatement ps = conn.prepareStatement(ADD_PRODUCT_QUERY)) {
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
			DBUtil.CloseDatabase(conn);

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;

	}

	// update product item
	public static int updateProdcut(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.GetConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE_PRODUCT_QUERY);
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
			DBUtil.CloseDatabase(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

	// delete product item

	public static boolean deleteProduct(String pid) {
		boolean status = false;
		try (Connection conn = DBUtil.GetConnection();
				PreparedStatement ps = conn.prepareStatement(DELETE_PRODUCT_QUERY)) {
			ps.setString(1, pid);
			status = ps.execute();
			DBUtil.CloseDatabase(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

}
