package com.controller.department;

import com.dao.DaoException;
import com.dao.DepartmentDAO;
import com.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {


    @Autowired
    private DepartmentDAO departmentDAO;


    //Чтение записей
    @RequestMapping(value = "/department/getListDepartment", method = RequestMethod.GET)
    public String listDepartment(Model model) throws DaoException {
        model.addAttribute("listDepartment", this.departmentDAO.getAll());
        return "views/department/jobDepartment";
    }

    //Чтение записи по Id
    @RequestMapping(value = "/department/getByIdDepartment/{id}", method = RequestMethod.GET)
    public String getByIdDepartment(@PathVariable("id") long id, Model model) throws DaoException {
        model.addAttribute("department", departmentDAO.getById(id));
        return "views/department/getByIdDepartment";
    }

    //Добавление записи
    @RequestMapping(value = "/department/getAddDepartmentForm", method = RequestMethod.GET)
    public ModelAndView getAddDepartmentForm() {
        return new ModelAndView("views/department/newDepartment", "command", new Department());
    }


    @RequestMapping(value = "/department/newDepartment", method = RequestMethod.POST)
    public String newDepartment(@ModelAttribute("department") Department department, Model model) throws DaoException {
        model.addAttribute("position", department.getPosition());
        this.departmentDAO.add(department);
        return "redirect:/department/getListDepartment";
    }

    //Обновить запись
    @RequestMapping(value = "/department/getUpdateDepartmentForm/{id}")
    public ModelAndView getUpdateDepartmentForm(@PathVariable("id") Long id) throws DaoException {
        Department department = this.departmentDAO.getById(id);
        return new ModelAndView("views/department/updateDepartment", "command", department);
    }

    @RequestMapping(value = "/department/updateDepartment", method = RequestMethod.POST)
    public String updateDepartment(@ModelAttribute("department") Department department) throws DaoException {
        this.departmentDAO.update(department);
        return "redirect:/department/getListDepartment";
    }

    //Удалить запись
    @RequestMapping(value = "/department/deleteDepartment/{id}")
    public String deleteIdDepartment(@PathVariable("id") long id) throws DaoException {
        Department department = new Department();
        department.setId(id);
        this.departmentDAO.remove(department);
        return "redirect:/department/getListDepartment";
    }


}
