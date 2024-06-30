package com.mindgate.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.EmailSenderService;
import com.mindgate.main.service.EmployeeTravelDetailsServiceInterface;
import com.mindgate.main.service.TravelAgentDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class TravelAgentDetailsController {

	Logger logger = LoggerFactory.getLogger(TravelAgentDetailsController.class);

	@Autowired
	private TravelAgentDetailsServiceInterface travelAgentDetailsServiceInterface;
	
	@Autowired
	private EmployeeTravelDetailsServiceInterface employeeDetailsServiceInterface;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	
	
	@RequestMapping("travelagent/checkSlabPage")
	public String showCheckSlabPage(Model model, HttpSession httpSession) {
		TravelRequestDetails travelRequestDetails = (TravelRequestDetails) httpSession.getAttribute("travelRequest");
		model.addAttribute("travelRequestDetailsKey", travelRequestDetails);
		return "checkSlab";
	}
	
	@RequestMapping("travelagent/viewdetails/{travelRequestId}")
	public String viewDetails(@PathVariable("travelRequestId") String travelRequestId, Model model, HttpSession httpSession) {
		TravelRequestDetails travelRequestDetails = travelAgentDetailsServiceInterface.getOneTravelRequestDetail(travelRequestId);
		httpSession.setAttribute("travelRequest", travelRequestDetails);
		return "redirect:/travelagent/checkSlabPage";
	}
	
	@RequestMapping("travelagent/checkslabdetails")
	public String checkSlab(@RequestParam("travelRequestId") String travelRequestId, @RequestParam("amount") String amountTxt, Model model, HttpSession httpSession) {
		TravelRequestDetails travelRequestDetails = travelAgentDetailsServiceInterface.getOneTravelRequestDetail(travelRequestId);
		String employeeId = travelRequestDetails.getEmployeeTravelDetails().getEmployeeId();
		EmployeeTravelDetails employeeTravelDetails = employeeDetailsServiceInterface.getOneEmployeeTravelDetail(employeeId);
		travelRequestDetails.setEmployeeTravelDetails(employeeTravelDetails);
		
		double amount = Double.parseDouble(amountTxt);
		boolean slabMatch = travelAgentDetailsServiceInterface.checkSlab(travelRequestDetails, amount);
		if((slabMatch) && (amount>0))  {
			model.addAttribute("slabMatch", true);
		}
		else {
			model.addAttribute("slabNotMatch", true);
		}
		model.addAttribute("travelRequestDetailsKey", travelRequestDetails);
		return "checkSlab";
	}
	
	@RequestMapping("travelagent/bookingPage")
	public String showBookingPage(Model model, HttpSession httpSession) {
		String travelRequestId = httpSession.getAttribute("travelRequestId").toString();
	
		TravelRequestDetails travelRequestDetails = travelAgentDetailsServiceInterface.getOneTravelRequestDetail(travelRequestId);
		httpSession.setAttribute("travelRequestDetails", travelRequestDetails);
	
		BookingDetails bookingDetails = new BookingDetails();
		
		bookingDetails.setTravelRequestDetails(travelRequestDetails);
		
		
		model.addAttribute("bookingDetailsKey", bookingDetails);
		return "bookingpage";
	}
	
	@RequestMapping("travelagent/bookticket/{travelRequestId}")
	public String bookTicket(@PathVariable("travelRequestId") String travelRequestId, HttpSession httpSession) {
		httpSession.setAttribute("travelRequestId", travelRequestId);
		return "redirect:/travelagent/bookingPage";
	}
	
	@RequestMapping("travelagent/addBookingDetails")
	public String addBookingDetails(@ModelAttribute("bookingDetailsKey") BookingDetails bookingDetails, Model model, HttpSession httpSession) {
		boolean result = travelAgentDetailsServiceInterface.bookTicket(bookingDetails);
		System.err.println("bookingDetails"+bookingDetails);
		TravelRequestDetails travelRequestDetails=(TravelRequestDetails) httpSession.getAttribute("travelRequestDetails");
		
		if(result) {
			EmployeeTravelDetails employeeTravelDetails = employeeDetailsServiceInterface.getOneEmployeeTravelDetail(travelRequestDetails.getEmployeeTravelDetails().getEmployeeId());
			
			String toMail=employeeTravelDetails.getEmailId();
			
			
			
			emailSenderService.sendEmail(toMail, "Booking Details", "Download Your Ticket");

			httpSession.removeAttribute("travelRequestId");
			return "redirect:/travelagent";
		}
		return "redirect:/travelagent/bookingPage";
	}
	
	
	@RequestMapping("travelagent/contactdirector/{travelRequestId}")
	public String contactDirector(@PathVariable("travelRequestId") String travelRequestId, Model model) {
		travelAgentDetailsServiceInterface.contactDirector(travelRequestId);
		
		logger.info(travelRequestId + " travel id");
		return "redirect:/travelagent";
	}

	@RequestMapping("travelAgentlogout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
}
