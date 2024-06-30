package com.mindgate.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.TravelRequestDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeTravelDetailsController {

	Logger logger = LoggerFactory.getLogger(EmployeeTravelDetailsController.class);
	
	@Autowired
	private TravelRequestDetailsServiceInterface travelRequestDetailsServiceInterface;

	@RequestMapping("EmployeeTravelHomePagee")
	public String backToHomePage(HttpSession httpSession, Model model) {
		EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails) httpSession.getAttribute("travelDetails");
		String employeeId = employeeTravelDetails.getEmployeeId();
		httpSession.setAttribute("travelDetails", employeeTravelDetails);
		List<TravelRequestDetails> travelRequestDetailsPendingStatus = travelRequestDetailsServiceInterface
				.pendingRequestDetails(employeeId);
		List<TravelRequestDetails> travelRequestDetails = travelRequestDetailsServiceInterface
				.showAllRequest(employeeId);
		List<TravelRequestDetails> approveRequestDetails = travelRequestDetailsServiceInterface
				.approveRequestDetails(employeeId);
		List<TravelRequestDetails> rejectedRequestDetails = travelRequestDetailsServiceInterface
				.RejectedRequestDetails(employeeId);
		model.addAttribute("pendingstatus", travelRequestDetailsPendingStatus);
		model.addAttribute("showAllDetails", travelRequestDetails);
		model.addAttribute("ApproveDetails", approveRequestDetails);
		model.addAttribute("RejectedDetails", rejectedRequestDetails);

		return "EmployeeTravelHomePage";
	}
	
	
	@RequestMapping("employeelogout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("travelagent")
	public String showTravelAgentPage(Model model ,HttpSession httpSession) {
		List<TravelRequestDetails> allTravelAgentPendingRequest = travelRequestDetailsServiceInterface.showAllTravelAgentPendingRequest();
		List<TravelRequestDetails> allTravelAgentDirectorRequest = travelRequestDetailsServiceInterface.showAllTravelAgentDirectorRequest();
		
		model.addAttribute("travelAgentPendingRequestKey", allTravelAgentPendingRequest);
		model.addAttribute("travelAgentDirectorRequestKey", allTravelAgentDirectorRequest);
		
		return "travelAgentHomePage";
	}

}
