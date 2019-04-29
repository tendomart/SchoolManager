package com.school.controller;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class BaseController<Item>{
	public BaseController() {}
	
	public ModelAndView getForm(ModelAndView md) {
		return md;
		}
	
	public ModelAndView addItem(@Valid @ModelAttribute Item it, BindingResult result, ModelAndView md,
	        RedirectAttributes red) {
				return md;
		
		}
	
	public ModelAndView updateItem(HttpServletRequest request){
		return null;
		}
	public ModelAndView getAllStudents(ModelAndView md) {
		return null;
		}
	public ModelAndView getItemById(@PathVariable("id") int id, ModelAndView md) {
		return null;
		}
	public ModelAndView getItemByName(@RequestParam("name") String name, ModelAndView md){
		return null ;
		}
	
	public ModelAndView removeItem(HttpServletRequest request){
		return null;};
	
	public ModelAndView removeItemByName(String Name){
		return null;};
	
	public ModelAndView removeAllItems(ModelAndView md) {
		return null;};
}
