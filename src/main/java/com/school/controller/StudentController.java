package com.school.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.school.model.Student;
import com.school.service.EntityService;
@Controller
@RequestMapping("student")
public class StudentController  extends BaseController<Student>{
private static final Logger log = LogManager.getLogger("com.sacco.controller.ClientSavingsController");
	
	@Autowired(required = true)
	@Qualifier(value = "studentServiceImpl")
	private EntityService<Student> std;
	
	//get form
	@GetMapping(value = "/")
	@Override
		public ModelAndView getForm(ModelAndView md) {
		md.setViewName("Student");
		//mav.addObject("savings", new );
		return md;
		}
	@Override
	@PostMapping(value = "/student")
	public ModelAndView addItem(@Valid Student it, BindingResult result, ModelAndView md, RedirectAttributes red) {
			return super.addItem(it, result, md, red);
		}
	@Override
		public ModelAndView updateItem(HttpServletRequest request) {
			// TODO Auto-generated method stub
			return super.updateItem(request);
		}
	//Get Client By ID
	@GetMapping("/{id}")
	@Override
		public ModelAndView getItemById(int id, ModelAndView md) {
          Optional<Student> byId = std.getItemById(id);
		
		if (byId == null) {
			log.info("Sorry Requested Id is not available");
			return null;
		}
		md.addObject("result", byId);
		md.setViewName("Student");
		return md;
		}
	@DeleteMapping(value = "/{id}")
	@Override
		public ModelAndView removeItem(HttpServletRequest request) {
		int Id = Integer.parseInt(request.getParameter("id"));
		Optional<Student> stud = std.getItemById(Id);
	 std.removeItem(Id);
		return new ModelAndView("redirect:/").addObject("student", stud);
		}
	@GetMapping(value = "/students")
	@Override
		public ModelAndView getAllStudents(ModelAndView md) {
		md.addObject("StudentList", std.getAllItems());
		md.setViewName("StudentList");
		return md;
		}
	//Delete all students
	@DeleteMapping(value = "/")
	@Override
		public ModelAndView removeAllItems(ModelAndView md) {
		std.removeAllItems();
		md.addObject("StudentList", std.getAllItems());
		md.setViewName("StudentList");
		return md;
		}
	}
