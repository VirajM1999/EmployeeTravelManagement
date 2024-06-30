package com.mindgate.main.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.ManagerTravelDetailsServiceInterface;
import com.mindgate.main.service.TravelRequestDetailsServiceInterface;
import jakarta.servlet.http.HttpSession;

@Controller
public class ManagerTravelDetailsController {

	Logger logger = LoggerFactory.getLogger(ManagerTravelDetailsController.class);
	@Autowired
	private ManagerTravelDetailsServiceInterface managerTravelDetailsServiceInterface;
	@Autowired
	private TravelRequestDetailsServiceInterface travelRequestDetailsServiceInterface;

	@RequestMapping("managerHomePagee")
	public String showManagerHomePage(Model model, HttpSession httpSession) {
		EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails) httpSession.getAttribute("travelDetails");
		String employeeId = employeeTravelDetails.getEmployeeId();
		List<TravelRequestDetails> employeePendingList = travelRequestDetailsServiceInterface
				.showAllManagerPendingRequest(employeeId);
		List<TravelRequestDetails> travelAgentApproveRequest = travelRequestDetailsServiceInterface
				.showAllPreviousRequest(employeeId);
		List<TravelRequestDetails> ownPendingRequest = travelRequestDetailsServiceInterface
				.showAllPendingRequest(employeeId);
		List<TravelRequestDetails> approveRequest = travelRequestDetailsServiceInterface
				.allManagerApproveRequest(employeeId);
		List<TravelRequestDetails> rejectedRequest = travelRequestDetailsServiceInterface
				.showManagerRejectedRequest(employeeId);

		model.addAttribute("employeependingreuqest", employeePendingList);
		model.addAttribute("travelAgentApproveRequest", travelAgentApproveRequest);
		model.addAttribute("pendingrequest", ownPendingRequest);
		model.addAttribute("employeeId", employeeId);
		model.addAttribute("allApproveRequest", approveRequest);
		model.addAttribute("allrejectedRequest", rejectedRequest);

		return "managerHomePage";
	}
	

	@RequestMapping("managerApproved/{travelRequestId}")
	public String managerApprovedTravelRequestDetails(@PathVariable("travelRequestId") String travelRequestId,
			Model model, HttpSession httpSession) {
		boolean result = managerTravelDetailsServiceInterface.managerApprovedTravelRequestDetails(travelRequestId);
		System.out.println(result);
		EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails) httpSession.getAttribute("travelDetails");
		return "redirect:/managerHomePagee";
	}

	@RequestMapping("managerRejected/{travelRequestId}")
	public String managerRejectedTravelRequestDetails(@PathVariable("travelRequestId") String travelRequestId,
			Model model) {
		boolean result = managerTravelDetailsServiceInterface.managerRejectedTravelRequestDetails(travelRequestId);
		return "redirect:/managerHomePagee";
	}


	@RequestMapping("manager/Notifications")
    public String managernotifications(Model model) {
        List<TravelRequestDetails> managerNotifications= travelRequestDetailsServiceInterface.getAllTravelRequestDetails();
        model.addAttribute("notification", managerNotifications);
        return "notifications";
    }
	
	@RequestMapping("manager/backtomanagerhome")
	public String back() {
		return "redirect:/managerHomePagee";
	}
	
	@RequestMapping("managerlogout")
	public String logout(HttpSession httpSession) {
	httpSession.invalidate();
		return "redirect:/";
	}
	
	

}
