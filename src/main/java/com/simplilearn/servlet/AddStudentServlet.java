package com.simplilearn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.JavaStudent;
import com.simplilearn.entity.PhoneNumbers;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JavaStudent student = populateStudent(request);
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.save(student);
		
		txn.commit();
		
		session.close();
		
		request.getRequestDispatcher("student-added-success.html").forward(request, response);
		
	}

	private JavaStudent populateStudent(HttpServletRequest request) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String number1 = request.getParameter("phone_1");
		String type1 = request.getParameter("type_1");
		
		String number2 = request.getParameter("phone_2");
		String type2 = request.getParameter("type_2");
		
		
		String number3 = request.getParameter("phone_3");
		String type3 = request.getParameter("type_3");
		
		
		JavaStudent student = new JavaStudent();
		
		PhoneNumbers phone1 = new PhoneNumbers();
		phone1.setPhonenumber(number1);
		phone1.setPhonetype(type1);
		phone1.setStudent(student);
		
		
		PhoneNumbers phone2 = new PhoneNumbers();
		phone2.setPhonenumber(number2);
		phone2.setPhonetype(type2);
		phone2.setStudent(student);
		

		PhoneNumbers phone3 = new PhoneNumbers();
		phone3.setPhonenumber(number3);
		phone3.setPhonetype(type3);
		phone3.setStudent(student);
		
		
		
		List<PhoneNumbers> phones = new ArrayList<PhoneNumbers>();
		phones.add(phone1);
		phones.add(phone2);
		phones.add(phone3);	
		
		
	
	    student.setFname(fname);
		student.setLname(lname);
		student.setPhonenumbers(phones);
		return student;
	}

}
