package com.swaiba.student.dao;
import com.swaiba.student.db.DBConnection;
import com.swaiba.student.model.Student;
import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
    public void addStudent(Student s) throws SQLException{
        String query="INSERT INTO students(name,email,dob,gpa,section,program) VALUES(?,?,?,?,?,?)";
        try
                (Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(query);)
        { pst.setString(1,s.getName());
            pst.setString(2,s.getEmail());
            pst.setDate(3, Date.valueOf(s.getDob()));
            pst.setDouble(4,s.getGpa());
            pst.setString(5,s.getSection() );
            pst.setString(6, s.getProgram());
            pst.executeUpdate();
        }
    }
    public Student getStudentById(int id) throws SQLException{
        String query="SELECT * FROM students WHERE id=?";
        try(Connection con= DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query)){
            pst.setInt(1,id);
            try(ResultSet rs= pst.executeQuery()){
                if(rs.next()){
                    return mapResultSetToStudent(rs);
                }
            }
        }
        return null;
    }
    public List<Student> getAllStudent() throws SQLException{
        String query="SELECT * FROM students";
        List<Student> list= new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
            ResultSet rs= st.executeQuery(query)){
            while (rs.next()){
                list.add(mapResultSetToStudent(rs));
            }
        }
        return list;
    }
    public boolean updateStudent(Student s)throws SQLException{
        String query="UPDATE students SET name=?,email=?,dob=?,gpa=?,section=?,program=? WHERE id=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query)){
            pst.setString(1,s.getName());
            pst.setString(2,s.getEmail());
            pst.setDate(3,Date.valueOf(s.getDob()));
            pst.setDouble(4,s.getGpa());
            pst.setString(5, s.getSection());
            pst.setString(6, s.getProgram());
            pst.setInt(7, s.getId());
            return pst.executeUpdate()>0;
        }
    }
    public boolean deleteStudent(int id) throws SQLException{
        String query="DELETE FROM students where id=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query) ){
            pst.setInt(1,id);
            return pst.executeUpdate()>0;
        }
    }

    private Student mapResultSetToStudent(ResultSet rs) throws SQLException{
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setEmail(rs.getString("email"));
        Date dob= rs.getDate("dob");
        if(dob!=null){
            s.setDob(dob.toLocalDate());
        }
        s.setGpa(rs.getDouble("gpa"));
        s.setSection(rs.getString("section"));
        s.setProgram(rs.getString("program"));
        return s;
    }
    public List<Student> searchStudents(String keyword,String section,String program) throws SQLException{
    	List<Student> students=new ArrayList<>();
    	String sql="SELECT * from students WHERE (name LIKE ? OR email LIKE ?)"
    			+"AND(section =? OR ?='')"
    			+ "AND(program =? OR ?='')";
    	try(Connection con=DBConnection.getConnection();
    			PreparedStatement pst=con.prepareStatement(sql)){
    		String likeKeyword="%"+keyword+"%";
    		pst.setString(1,likeKeyword );
    		pst.setString(2, likeKeyword);
    		pst.setString(3,section);
    		pst.setString(4, section);
    		pst.setString(5, program);
    		pst.setString(6, program);
    		ResultSet rs=pst.executeQuery();
    	while(rs.next()) {
    		Student s= new Student(
    				rs.getString("name"),
    				rs.getString("email"),
    				rs.getDate("dob").toLocalDate(),
    		       rs.getDouble("gpa"),
    		       rs.getString("section"),
                  rs.getString("program")
    				);
    		s.setId(rs.getInt("id"));
    		students.add(s);
    	}	
    	}
    	return students;
    } 
}
