package com.mindgate.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.DirectorTravelDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class DirectorTravelDetailsController {
	
	@Autowired
	private DirectorTravelDetailsServiceInterface directorTravelDetailsServiceInterface;
	
	
	
	@RequestMapping("directorHomePage")
	public String directorHomePage(HttpSession httpSession,Model model)
	{
		
		 EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails)httpSession.getAttribute("travelDetails");
		 String employeeId = employeeTravelDetails.getEmployeeId();
		 List<TravelRequestDetails> travelRequestDetailsPendingStatus = new ArrayList<TravelRequestDetails>();
		 List<TravelRequestDetails> travelRequestDetails1 = new ArrayList<TravelRequestDetails>(); 
		 List<TravelRequestDetails> allRequestRejectedByTravelAgent =new ArrayList<TravelRequestDetails>();
		
		 travelRequestDetailsPendingStatus = directorTravelDetailsServiceInterface.showPendingStatusOfDirector(employeeTravelDetails.getEmployeeId());
		 travelRequestDetails1 = directorTravelDetailsServiceInterface .showHistoryOfDirector(employeeTravelDetails.getEmployeeId());
		 allRequestRejectedByTravelAgent=directorTravelDetailsServiceInterface. showRequestRejectedByTravelAgent();
		 
		 model.addAttribute("RequestRejectedByTravelAgentKey", allRequestRejectedByTravelAgent);
		 model.addAttribute("PendingStatusOfDirectorKey",travelRequestDetailsPendingStatus);
		 model.addAttribute("HistoryOfDirectorKey", travelRequestDetails1);
		 
		
				
		return "directorpage";
	}
	
	@RequestMapping("Accepted/{travelRequestId}") 
	public String acceptedByDirector(@PathVariable("travelRequestId") String travelRequestId,HttpSession httpSession, Model model)
	{
	  boolean result =directorTravelDetailsServiceInterface.acceptStatus(travelRequestId);
	  System.out.println(result); 
	  return "redirect:/directorHomePage"; 
    }
	  
	 @RequestMapping("Rejected/{travelRequestId}") 
	 public String	rejectedByDirector(@PathVariable("travelRequestId") String travelRequestId)
	 {
	   boolean result = directorTravelDetailsServiceInterface.rejectStatus(travelRequestId);
	   System.out.println(result); 
	   return "redirect:/directorHomePage";
	   }
	 
	 
	 @RequestMapping("directorlogout")
		public String logout(HttpSession httpSession) {
		httpSession.invalidate();
			return "redirect:/";
		}
		
	 
}
