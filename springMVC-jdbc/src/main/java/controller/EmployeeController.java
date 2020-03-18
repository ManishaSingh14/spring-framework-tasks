package controller;

import DAO.EmployeeDAO;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class EmployeeController {

    @Autowired
    public EmployeeDAO employeeDAO;

    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Employee> employeeList = employeeDAO.list();
        model.addObject("listContact", employeeList);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute Employee employee) {
        employeeDAO.update(employee);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Employee employee) {
        employeeDAO.insert(employee);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.delete(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.get(id);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);

        return model;
    }
}
