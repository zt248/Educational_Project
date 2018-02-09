package com.controller.address;

import com.dao.DaoException;
import com.model.Address;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;



    @RequestMapping(value = "/address/menu", method = RequestMethod.GET)
    public String listAddress(Model model) throws DaoException {
        model.addAttribute("listAddress", this.addressService.getAll());
        return "views/address/jobAddress";
    }

    //Чтение записи по Id
    @RequestMapping(value = "/address/getByIdAddress/{id}", method = RequestMethod.GET)
    public String getByIdAddress(@PathVariable("id") Long id, Model model) throws DaoException {
        model.addAttribute("address", addressService.getById(id));
        return "views/address/getByIdAddress";
    }

    //Добавление записи
    @RequestMapping(value = "/address/newAddress", method = RequestMethod.GET)
    public ModelAndView newAddress() {
        return new ModelAndView("views/address/newAddress", "command", new Address());
    }



    /*добавление с помощью Ajax*/
    @RequestMapping(value = "/address/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public String addAddressAjax(HttpServletRequest request, @ModelAttribute("address") Address address) throws DaoException {
        addressService.add(address);
        return "/address/menu";
    }


    //Редактирование записи
    @RequestMapping(value = "/address/updateAddress/{id}")
    public ModelAndView updateAddress(@PathVariable("id") Long id) throws DaoException {
        Address address = this.addressService.getById(id);
        return new ModelAndView("views/address/updateAddressForm", "command", address);
    }


    //Обновление с помощью Ajax
    @RequestMapping(value = "/address/getUpdateAddressAjax", method = RequestMethod.POST)
    @ResponseBody
    public String getUpdateAddress(HttpServletRequest request, @ModelAttribute("address") Address address, Model model) throws DaoException {
        this.addressService.update(address);
//        return UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString()).replacePath("/address/menu").build().toUriString();
        return "/address/menu";
    }


    //Удаление записи с помозью Ajax
    @RequestMapping(value = "/address/delete/{id}")
    @ResponseBody
    public String deleteAddressAjax(@PathVariable("id") Long id) throws DaoException {
        Address address = new Address();
        address.setId(id);
        this.addressService.remove(address);
        return "/address/menu";
    }


}
