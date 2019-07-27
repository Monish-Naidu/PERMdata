package blog.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Timestamp;

import blog.model.*;
import blog.model.Advertisements.AdvertiseMeans;

public class AdvertisementsDao {
	protected ConnectionManager connectionManager;

	private static AdvertisementsDao instance = null;

	protected AdvertisementsDao() {
		connectionManager = new ConnectionManager();
	}

	public static AdvertisementsDao getInstance() {
		if (instance == null) {
			instance = new AdvertisementsDao();
		}
		return instance;
	}

	public Advertisements create(Advertisements advertisement) throws SQLException {
		String insertAdvertisement = "INSERT INTO Advertisements(Means,StartDate,EndDate,JobID) "
				+ "VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAdvertisement, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, advertisement.getMeans().name());
			insertStmt.setTimestamp(2, advertisement.getStartDate().getTime());
			insertStmt.setTimestamp(3, advertisement.getEndDate().getTime());
			insertStmt.setLong(4, advertisement.getJob().getJobId());
			insertStmt.executeUpdate();

			resultKey = insertStmt.getGeneratedKeys();
			int advertisementId = -1;
			if (resultKey.next()) {
				advertisementId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			advertisement.setAdvertisementId(advertisementId);
			return advertisement;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
			if (resultKey != null) {
				resultKey.close();
			}
		}
	}

	public Advertisements updateAdvertisementMeans(Advertisements advertisement, Advertisements.AdvertiseMeans newMeans) throws SQLException {
		String updateAdvertisement = "UPDATE Advertisements SET Means=? WHERE AdvertisementId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAdvertisement);
			updateStmt.setString(1, newMeans.name());
			updateStmt.setLong(2, advertisement.getAdvertisementId());
			updateStmt.executeUpdate();

			advertisement.setMeans(newMeans);

			return advertisement;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	public Advertisements delete(Advertisements advertisement) throws SQLException {
		String deleteAdvertisement = "DELETE FROM Advertisements WHERE AdvertisementId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteAdvertisement);
			deleteStmt.setLong(1, advertisement.getAdvertisementId());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the BlogComments instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	public Advertisements getAdvertisementById(int advertisementId) throws SQLException {
		String selectAdvertisement = "SELECT AdvertisementId,Means,StartDate,EndDate,JobID "
				+ "FROM Advertisements " + "WHERE AdvertisementId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAdvertisement);
			selectStmt.setInt(1, advertisementId);
			results = selectStmt.executeQuery();

			JobsDao jobsDao = JobsDao.getInstance();
			
			if (results.next()) {
				long resultAdvertisementId = results.getLong("AdvertisementId");
				Advertisements.AdvertiseMeans means = Advertisements.AdvertiseMeans.valueOf(results.getString("Means"));
				Date start = results.getTime("StartDate");
				Date end = results.getTime("EndState");
				Long jobId = results.getLong("JobId");
				Jobs job = jobsDao.getJobById(jobId);
				Advertisements advertisement = new Advertisements(resultAdvertisementId,means,start,end,job);
				return advertisement;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

}
