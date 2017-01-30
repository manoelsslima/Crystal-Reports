package com.lister.Project.service;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;

import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;
import com.lister.Project.dao.EmployeeDao;
import com.lister.Project.dao.GenerateReport;
import com.lister.Project.domain.Employee;

/**
 * @author souvik.p
 *
 */
public class EmployeeService {
	EmployeeDao empdao;
	Resource r;
	BeanFactory factory;
	GenerateReport gr;
	//AnnotationConfiguration configuration;
	public EmployeeService(){
		r=new ClassPathResource("DefaultServlet-servlet.xml");  
	    factory=new XmlBeanFactory(r);  
	    empdao=(EmployeeDao)factory.getBean("d");
	    //configuration.configure("DefaultServlet-servlet.xml");
	}
	/**
	 * @param emp
	 */
	public void addemployee(Employee emp){
		empdao.saveEmployee(emp);
	}
	/**
	 * @param id
	 */
	public void removeEmployeeByID(int id){
		empdao.deleteEmployee(empdao.getById(id));
	}
	/**
	 * @return
	 */
	public List<Employee> getEmployeeList(){
	    return empdao.getEmployees();
	}
	/**
	 * @param name
	 * @return
	 */
	public List<Employee> getEmployeeList(String name){
	    return empdao.getEmployeeByName(name);
	}
	/**
	 * @return
	 * @throws ReportSDKException
	 * @throws IOException
	 */
	public boolean generate() throws ReportSDKException, IOException{
		gr=new GenerateReport();
		return gr.generate();
	}
}
