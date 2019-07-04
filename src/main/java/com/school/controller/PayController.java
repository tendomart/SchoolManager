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

import com.school.model.Pay;
import com.school.service.EntityService;

@Controller
@RequestMapping("pay")
public class PayController  extends BaseController<Pay>{
	public static final Logger log = LogManager.getLogger("com.school.controller.PayController");
	
	//install service
		@Autowired(required = true)
		@Qualifier(value = "payServiceImpl")
		private EntityService<Pay> payServ;
		
		//get form
		@GetMapping(value = "/")
		@Override
			public ModelAndView getForm(ModelAndView md) {
			 md.addObject("pay",new Pay());
			md.setViewName("pay");
			return md;
			}
		@Override
		@PostMapping(value = "/")
		public ModelAndView addItem(@Valid Pay pay, BindingResult result, ModelAndView md, RedirectAttributes red) {
			red.addFlashAttribute("message", "Failed");
		    red.addFlashAttribute("alertClass", "alert-danger");
			if (result.hasErrors()) {
				md.setViewName("add-user");
	            return md;
	        }
	        payServ.addItem(pay);
	        md.addObject("pay",new Pay());
	        md.setViewName("pay");
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
	          Optional<Pay> byId = payServ.getItemById(id);
			
			if (byId == null) {
             log.info("Sorry Requested Id is not available");
				return null;
			}
			md.addObject("result", byId);
			md.setViewName("pay");
			return md;
			}
		@DeleteMapping(value = "/{id}")
		@Override
			public ModelAndView removeItem(HttpServletRequest request) {
			int Id = Integer.parseInt(request.getParameter("id"));
			Optional<Pay> pay = payServ.getItemById(Id);
		 payServ.removeItem(Id);
			return new ModelAndView("redirect:/").addObject("pay", pay);
			}
		@GetMapping(value = "/list")
		@Override
			public ModelAndView getAllStudents(ModelAndView md) {
			md.addObject("PaymentList", payServ.getAllItems());
			md.setViewName("PaymentList");
			return md;
			}
		//Delete all students
		@DeleteMapping(value = "/list")
		@Override
			public ModelAndView removeAllItems(ModelAndView md) {
			payServ.removeAllItems();
			md.addObject("PaymentList", payServ.getAllItems());
			md.setViewName("PaymentList");
			return md;
			}


}
