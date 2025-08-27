package com.swaiba.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.swaiba.student.dao.StudentDAO;
import com.swaiba.student.model.Student;

@WebServlet("/list-students")
public class ListStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE=10;
  private StudentDAO dao=new StudentDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. figure out which page we are on (default 1)
			int page=1;
			String pageParam=request.getParameter("page");
			if(pageParam!=null && !pageParam.isEmpty()) {
				page=Integer.parseInt(pageParam);
			}
			// 2. calculate offset
			int offset=(page-1)*PAGE_SIZE;
			// 3. normalize filters
			List<Student> students;
			int totalStudents;
			String keyword=normalize(request.getParameter("keyword"));
			String section =normalize(request.getParameter("section"));
			String program= normalize(request.getParameter("program"));
			
			if(keyword.isEmpty() && section.isEmpty() && program.isEmpty() ){
				// no filters → fetch all students paginated
				students=dao.listStudents(offset, PAGE_SIZE);
				totalStudents=dao.getTotalStudents();
			}
			else {
				// with filters → search students paginated
				students=dao.searchStudents(keyword,section,program,offset,PAGE_SIZE);
				totalStudents = dao.getTotalSearchStudents(keyword, section, program);
			}
			// 4. calculate total pages
            int totalPages = (int) Math.ceil((double) totalStudents / PAGE_SIZE);
			request.setAttribute("studentList", students);
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPages",totalPages);
			request.setAttribute("keyword", keyword);
            request.setAttribute("section", section);
            request.setAttribute("program", program);
         // forward to JSP
			request.getRequestDispatcher("/list-students.jsp").forward(request, response);
			
		}
		catch(SQLException e) {
			throw new ServletException("Error fetching students", e);
		}
	}
	private String normalize(String param) {
        return (param == null) ? "" : param.trim();
    }

}
