package com.codegym.controller.web;

import com.codegym.dao.INewDAO;
import com.codegym.model.NewModel;
import com.codegym.service.ICategoryService;
import com.codegym.service.INewService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
	@Inject
	private ICategoryService categoryService;
@Inject
private INewService newService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "Bai viet 4";
		String content = "baiviet4";
		Long categoryid = 1L;
		NewModel newModel = new NewModel();
		newModel.setTitle(title);
		newModel.setContent(content);
		newModel.setCategoryId(categoryid);
		newService.save(newModel);
//		request.setAttribute("news",newService.findByCategoryId(categoryId));
		request.setAttribute("categories",categoryService.findAll());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/home.jsp");
		requestDispatcher.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
