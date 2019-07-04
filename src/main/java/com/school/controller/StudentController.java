package com.school.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.school.constants.PaginationConstants;
import com.school.model.PagerModel;
import com.school.model.Student;
import com.school.repository.StudentPagingDaoImpl;
import com.school.service.EntityService;
@Controller
@RequestMapping("student")
public class StudentController  extends BaseController<Student>{
private static final Logger log = LogManager.getLogger("com.school.controller.StudentController");
PaginationConstants pg = new PaginationConstants();
//install servicse
	@Autowired(required = true)
	@Qualifier(value = "studentServiceImpl")
	private EntityService<Student> std;
	
	//install pagination services
	@Autowired(required = true)
	@Qualifier(value = "studentPagingServiceImpl")
	private EntityService<Student> stdp;
	
	
	StudentPagingDaoImpl sp;
	
	//get form
	@GetMapping(value = "/")
	@Override
		public ModelAndView getForm(ModelAndView md) {
		 md.addObject("student",new Student());
		md.setViewName("registerStudent");
		return md;
		}
	@Override
	@PostMapping(value = "/student")
	public ModelAndView addItem(@Valid Student stud, BindingResult result, ModelAndView md, RedirectAttributes red) {
		red.addFlashAttribute("message", "Failed");
	    red.addFlashAttribute("alertClass", "alert-danger");
		if (result.hasErrors()) {
			md.setViewName("add-user");
            return md;
        }
        std.addItem(stud);
        md.addObject("student",new Student());
        md.setViewName("registerStudent");
        red.addFlashAttribute("message", "Success");
        red.addFlashAttribute("alertClass", "alert-success");
        return md;
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
	
	 @GetMapping("/studentslist")
	    public ModelAndView listPagination(@RequestParam("pageSize") Optional<Integer> pageSize,
	            @RequestParam("page") Optional<Integer> page){
//	        if(clientrepository.count()!=0){
//	            ;//pass
//	        }else{
//	            addtorepository();
//	        }
	        ModelAndView modelAndView = new ModelAndView("StudentList");
	        //
	        // Evaluate page size. If requested parameter is null, return initial
	        // page size
	        int evalPageSize = pageSize.orElse(pg.getINITIAL_PAGE_SIZE());
	        // Evaluate page. If requested parameter is null or less than 0 (to
	        // prevent exception), return initial size. Otherwise, return value of
	        // param. decreased by 1.
	        int evalPage = (page.orElse(0) < 1) ? pg.getINITIAL_PAGE() : page.get() - 1;
	        // print repo
	        System.out.println("here is client repo " + stdp.getAllItems());
	       
	        Page<Student> studlist = sp.findAll(new PageRequest(evalPage, evalPageSize));
	        
	        		System.out.println("client list get total pages" + studlist.getTotalPages() + "Student list get number " + studlist.getNumber());
	        PagerModel pager = new PagerModel(studlist.getTotalPages(),studlist.getNumber(),pg.getBUTTONS_TO_SHOW());
	        // add Student
	        modelAndView.addObject("studentlist",studlist);
	        // evaluate page size
	        modelAndView.addObject("selectedPageSize", evalPageSize);
	        // add page sizes
	        modelAndView.addObject("pageSizes", pg.getPAGE_SIZES());
	        // add pager
	        modelAndView.addObject("pager", pager);
	        return modelAndView;
	    }
	}
