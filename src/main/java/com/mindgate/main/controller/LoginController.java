package com.mindgate.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelAgentDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.EmployeeTravelDetailsServiceInterface;
import com.mindgate.main.service.TravelRequestDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private EmployeeTravelDetailsServiceInterface employeeTravelDetailsServiceInterface;
	
	@Autowired
	private TravelRequestDetailsServiceInterface travelRequestDetailsServiceInterface;

	@RequestMapping("/")
	public String homepage() {
		return "homepage";
	}

	@RequestMapping("login")
	public String showloginpage() {
		return "loginpage";
	}

	@RequestMapping("submit")
	public String loginpage(@RequestParam("employeeId") String employeeId, @RequestParam("password") String password,
			@RequestParam("role") String role, Model model, HttpSession employeeSession) {
		employeeSession.setAttribute("role", role);
		if (role.equals("Travel Agent")) {
			TravelAgentDetails travelAgentDetails = (TravelAgentDetails) employeeTravelDetailsServiceInterface.validateEmployeeLogin(employeeId, password, role);
			if(travelAgentDetails != null) {
				employeeSession.setAttribute("loginId", travelAgentDetails.getUserName());
			
				return "redirect:/travelagent";
			}
			}
			
		else {
			EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails) employeeTravelDetailsServiceInterface
					.validateEmployeeLogin(employeeId, password, role);

			if (employeeTravelDetails != null) {

				if (employeeTravelDetails.getRole().equalsIgnoreCase("Employee")) {
					employeeSession.setAttribute("travelDetails", employeeTravelDetails);
					return "redirect:/EmployeeTravelHomePagee";
				} else if (role.equals("Manager")) {
					employeeSession.setAttribute("travelDetails", employeeTravelDetails);
					return "redirect:/managerHomePagee";

				} else if (role.equals("Director")) {
					employeeSession.setAttribute("travelDetails", employeeTravelDetails);
					return "redirect:/directorHomePage";
				}
			}

		}

		model.addAttribute("invalidLogin", true);
		return "loginpage";
	}
	
	
	@RequestMapping("newemployeeTravelRequest")
	public String ShowRequestForm(Model model) {
		TravelRequestDetails travelRequestDetails = new TravelRequestDetails();
		model.addAttribute("addNewRequest", travelRequestDetails);
		return "raiseTicket";
	}

	@RequestMapping("raiseATicket")
	public String raiserequest(@ModelAttribute("addNewRequest") TravelRequestDetails travelRequestDetails,
			HttpSession httpSession, Model model) {

		EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails) httpSession.getAttribute("travelDetails");
		String role = (String) httpSession.getAttribute("role");

		if (role.equalsIgnoreCase("Employee")) {
			travelRequestDetails.setStatus("Pending");
			TravelRequestDetails travelRequestDetails2 = travelRequestDetailsServiceInterface
					.raiseTicket(travelRequestDetails);


			return "redirect:/EmployeeTravelHomePagee";
		} else  {
			travelRequestDetails.setStatus("Pending (Manager)");
			TravelRequestDetails travelRequestDetails2 = travelRequestDetailsServiceInterface
					.raiseTicket(travelRequestDetails);

			return "redirect:/managerHomePagee";
		}
	}
}