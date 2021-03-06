package com.dotridge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.beans.HospitalBean;
import com.dotridge.service.HospitalService;

@Controller
@RequestMapping("/hospitalMgmt")
public class HospitalController {
	
	

	@Autowired
	private HospitalService hospService;

	@RequestMapping(value = "/getAllHospitals")
	public String viewAllHospital(Model model) {
		try {
			List<HospitalBean> uiHospList = hospService.getAllHospitals();
			model.addAttribute("uiHospList", uiHospList);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "getHospitalBoard";

	}

	@RequestMapping("/getHospitalRegForm")
	public String getHospitalRegForm(Model model) {
		HospitalBean hospBean = new HospitalBean();
		model.addAttribute("hospName", hospBean);
		return "addHospitalFormDef";
	}

	@RequestMapping(value = "/addHospital")
	public String addHospital(
			@ModelAttribute("hospName") HospitalBean hospBean, Model model) {
		hospBean = hospService.addHospital(hospBean);
		System.out.println(hospBean.toString());
		if (hospBean.getHospitalId() > 0) {
			List<HospitalBean> uiHospList = hospService.getAllHospitals();
			model.addAttribute("uiHospList", uiHospList);
		}
		return "getHospitalBoard";
	}

	@RequestMapping(value = "/editHospital")
	public String editHospital(HttpServletRequest request, Model model) {
		String hospId = request.getParameter("hospId");
		// System.out.println("Hospital Id is"+hospId);
		HospitalBean hospBean = hospService.getHospitalById(Integer
				.valueOf(hospId));
		model.addAttribute("hospBean", hospBean);
		System.out.println("hospBean is:" + hospBean.toString());
		return "editHospitalDef";
	}

	@RequestMapping(value = "/updateHospital", method = RequestMethod.POST)
	public String updateHospital(
			@ModelAttribute("hospBean") HospitalBean hospBean, Model model) {
		// System.out.println(hospitalBean.getHospitalId()+"this hospital id in controller3");
		System.out.println("hospBean is:" + hospBean.toString());
		hospBean = hospService.updateHospital(hospBean);

		try {
			List<HospitalBean> list = hospService.getAllHospitals();
			// System.out.println(list.size());
			model.addAttribute("uiHospList", list);
			return "getHospitalBoard";
		} catch (Exception e) {

		}
		System.out.println("Error");
		return "getHospitalBoard";

		}

	@RequestMapping("/deleteHospital")
	public String deleteHospitl(HttpServletRequest request, Model model) {
		String hospId = request.getParameter("hospId");
		boolean result = hospService.deleteHospital(Integer.valueOf(hospId));
		if (result) {
			List<HospitalBean> uiHospList = hospService.getAllHospitals();
			model.addAttribute("uiHospList", uiHospList);
			return "getHospitalBoard";
		} else {
			System.out.println("record not deleted");
			return "getHospitalBoard";
		}
	}

	@RequestMapping("/searchHospital")
	public String searchHospitals(HttpServletRequest request, Model model) {
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		if (searchKey != null && !searchKey.isEmpty() && searchValue != null
				&& !searchValue.isEmpty()) {
			if (searchKey.equalsIgnoreCase("hospitalName")) {
				List<HospitalBean> hospitalByName = hospService
						.getHospitalByName(searchValue);
				if (hospitalByName != null && !hospitalByName.isEmpty()) {
					model.addAttribute("uiHospList", hospitalByName);
					return "getHospitalBoard";
				}
				System.out.println("Error");
				return "getHospitalBoard";

			}

			else if (searchKey.equalsIgnoreCase("email"))
			{
				List<HospitalBean> hospitalByEmail = hospService
						.getHospitalByEmail(searchValue);
				if (hospitalByEmail != null && !hospitalByEmail.isEmpty())
				{
					model.addAttribute("uiHospList", hospitalByEmail);
					return "getHospitalBoard";
				}
				System.out.println("Error");
				return "getHospitalBoard";
			}
			else if(searchKey.equalsIgnoreCase("phone")){

				List<HospitalBean> hospitalByPhone = hospService.getHospitalByPhone(Long.parseLong(searchValue));
				if(hospitalByPhone!=null && !hospitalByPhone.isEmpty()){
					model.addAttribute("uiHospList", hospitalByPhone);
					return "getHospitalBoard";
				}
				return "getHospitalBoard";

			}
		}

		return null;
	}
}
