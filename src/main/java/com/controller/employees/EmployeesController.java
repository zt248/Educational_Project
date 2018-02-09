package com.controller.employees;

import com.dao.AddressDAO;
import com.dao.DaoException;
import com.dao.DepartmentDAO;
import com.dao.EmployeeDAO;
import com.model.Address;
import com.model.Department;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private DepartmentDAO departmentDAO;


    @Autowired
    private AddressDAO addressDAO;

    @RequestMapping(value = "/employee/getEmployeesList", method = RequestMethod.GET)
    public String getEmployeesList(Model model) throws DaoException {
        model.addAttribute("listEmployees", this.employeeDAO.getAll());
        return "views/employee/jobEmployees";
    }


    //Добаление записи
    @RequestMapping(value = "/employees/newEmployees")
    public ModelAndView newEmployees() {
        return new ModelAndView("views/employee/newEmployee", "employee", new AddEmployeesForm());
    }


    @RequestMapping(value = "/employees/addEmployees", method = RequestMethod.POST)
    public String addEmployeesSpring(AddEmployeesForm addEmployeesForm) throws DaoException {
        Employee employee = new Employee();
        Address address = new Address();
        employee.setFirstName(addEmployeesForm.getFirstName());
        employee.setLastName(addEmployeesForm.getLastName());
        address.setCountry(addEmployeesForm.getCountry());
        address.setCity(addEmployeesForm.getCity());
        address.setStreet(addEmployeesForm.getStreet());
        address.setPostCode(addEmployeesForm.getPostCode());
        employee.setAddress(address);
        String[] depIds = addEmployeesForm.getDepartments();
        if (depIds != null) {
            Set<Department> departments = new HashSet<>();
            for (String id : depIds) {
                departments.add(departmentDAO.getById(Long.valueOf(id)));
            }
            employee.setDepartments(departments);
        }
        employeeDAO.add(employee);
        return "redirect:/employee/getEmployeesList";
    }


    //Редактирование записи
    @RequestMapping(value = "/employees/update/{id}")
    public String updateFormEmployees(@PathVariable("id") Long id, Model model) throws DaoException {
        Employee employee = employeeDAO.getById(id);
        UpdateEmployeesForm updateEmployeesForm = new UpdateEmployeesForm();
        updateEmployeesForm.setId(employee.getId().toString());
        updateEmployeesForm.setLastName(employee.getLastName());
        updateEmployeesForm.setFirstName(employee.getFirstName());
        updateEmployeesForm.setCity(employee.getAddress().getCity());
        updateEmployeesForm.setCountry(employee.getAddress().getCountry());
        updateEmployeesForm.setStreet(employee.getAddress().getStreet());
        updateEmployeesForm.setPostCode(employee.getAddress().getPostCode());

        Set<Department> departments = employee.getDepartments();
        String[] depIds = new String[departments.size()];
        int i = 0;
        for(Department dep: departments){
            depIds[i] = dep.getId().toString();
            i++;
        }
        updateEmployeesForm.setDepartments(depIds);

        model.addAttribute("employee", updateEmployeesForm);
        model.addAttribute("departments", departmentDAO.getAll());
        return "views/employee/updateEmployee";
    }

    //Обновить запись
//    @RequestMapping(value = "/employees/employeesUpdate")
//    public String employeesUpdate(@ModelAttribute("employees") Employee employee, @ModelAttribute("departments") Set<Department> departments) throws DaoException {


//        Employee employee = new Employee();
//        Address address = new Address();
//        employee.setFirstName(request.getParameter("firstName"));
//        employee.setLastName(request.getParameter("lastName"));
//        address.setCountry(request.getParameter("country"));
//        address.setCity(request.getParameter("city"));
//        address.setStreet(request.getParameter("street"));
//        address.setPostCode(request.getParameter("postCode"));
//        employee.setAddress(address);
//        String[] depIds = request.getParameterValues("departments");
//        if (depIds != null) {
//            Set<Department> departments = new HashSet<>();
//            for (String id : depIds) {
//                departments.add(departmentDAO.getById(Long.valueOf(id)));
//            }
//            employee.setDepartments(departments);
//        }

    //        employee.setDepartments(departments);
//        employeeDAO.update(employee);
//        return "redirect:/employee/getEmployeesList";
//    }
//
    @RequestMapping(value = "/employees/employeesUpdate", method = RequestMethod.POST)
    public String employeesUpdate(UpdateEmployeesForm updateEmployeesForm) throws DaoException {
        Employee employee = employeeDAO.getById(Long.valueOf(updateEmployeesForm.getId()));
        Address address = employee.getAddress();
        employee.setFirstName(updateEmployeesForm.getFirstName());
        employee.setLastName(updateEmployeesForm.getLastName());
        address.setCountry(updateEmployeesForm.getCountry());
        address.setCity(updateEmployeesForm.getCity());
        address.setStreet(updateEmployeesForm.getStreet());
        address.setPostCode(updateEmployeesForm.getPostCode());
        employee.setAddress(address);
        String[] depIds = updateEmployeesForm.getDepartments();
        if (depIds != null) {
            Set<Department> departments = new HashSet<>();
            for (String id : depIds) {
                departments.add(departmentDAO.getById(Long.valueOf(id)));
            }
            employee.setDepartments(departments);
        }
        addressDAO.update(address);
        employeeDAO.update(employee);
        return "redirect:/employee/getEmployeesList";
    }


    //Удаление с Ajax
    @RequestMapping(value = "/employees/delete/{id}")
    @ResponseBody
    public String deleteEmployees(@PathVariable("id") Long id) throws DaoException {
        Employee employee = new Employee();
        employee.setId(id);
        employeeDAO.remove(employee);
        return "/employee/getEmployeesList";
    }


    @ModelAttribute("department")
    public List<Department> departmentsList() throws DaoException {
        return departmentDAO.getAll();
    }
}
