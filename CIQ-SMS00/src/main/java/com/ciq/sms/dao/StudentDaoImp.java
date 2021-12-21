package com.ciq.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ciq.sms.model.Student;
import com.ciq.sms.queries.StudentQueries;
import com.ciq.sms.util.ConnecctionUtil;

public class StudentDaoImp implements StudentDao {

	public void insert(Student student) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		connection= ConnecctionUtil.getConnection();
		try {
			
			preparedStatement= connection.prepareStatement(StudentQueries.SMS_INSERT_QUERY);
			preparedStatement.setInt(1, student.getSid());
			preparedStatement.setString(2, student.getSname());
			preparedStatement.setDouble(3, student.getSfee());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnecctionUtil.close(preparedStatement, connection);
		}
		
	}

	public void update(Student student) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		connection= ConnecctionUtil.getConnection();
		try {
			
			preparedStatement= connection.prepareStatement(StudentQueries.SMS_UPDATE_QUERY);
			preparedStatement.setString(1, student.getSname());
			preparedStatement.setDouble(2, student.getSfee());
			preparedStatement.setInt(3, student.getSid());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnecctionUtil.close(preparedStatement, connection);
		}
		
	}

	public void delete(int sid) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		connection= ConnecctionUtil.getConnection();
		try {
			
			preparedStatement= connection.prepareStatement(StudentQueries.SMS_FIND_BY_ID_QUERY);
			
			preparedStatement.setInt(1, sid);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnecctionUtil.close(preparedStatement, connection);
		}
		
	}

	public Student findById(int sid) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet= null;
		Student student= null;
		connection= ConnecctionUtil.getConnection();
		try {
			
			preparedStatement= connection.prepareStatement(StudentQueries.SMS_FIND_BY_ID_QUERY);
			
			preparedStatement.setInt(1, sid);

			 resultSet=preparedStatement.executeQuery();
			 if (resultSet .next()) {
				 student= new Student();
				student.setSid(resultSet.getInt("SID"));
				student.setSname(resultSet.getString("SNAME"));
				student.setSfee(resultSet.getDouble("SFEE")); 
				 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
        ConnecctionUtil.close(resultSet, preparedStatement, connection);		
        }
		
		return student;
	}

	public List<Student> findAll() {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet= null;
		List<Student>students=null;
		connection= ConnecctionUtil.getConnection();
		try {
			
			preparedStatement= connection.prepareStatement(StudentQueries.SMS_FIND_BY_ALL_QUERY);
			
			preparedStatement.setInt(1, sid);

			 resultSet=preparedStatement.executeQuery();
			 if (resultSet .next()) {
				Student student= new Student();
				student.setSid(resultSet.getInt("SID"));
				student.setSname(resultSet.getString("SNAME"));
				student.setSfee(resultSet.getDouble("SFEE")); 
				 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
        ConnecctionUtil.close(resultSet, preparedStatement, connection);		
        }
		
		return students;
	}

	public List<Student> findByName(String sname) {
		return null;
	}

}
