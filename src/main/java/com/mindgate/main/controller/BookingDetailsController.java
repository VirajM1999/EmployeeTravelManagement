package com.mindgate.main.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.service.BookingDetailsServiceInterface;
import com.mindgate.main.service.EmailSenderService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingDetailsController {
	
	Logger logger = LoggerFactory.getLogger(BookingDetailsController.class);
	
	@Autowired
	private BookingDetailsServiceInterface bookingDetailsServiceInterface;
	@Autowired
	private EmailSenderService emailSenderService;
	
	@RequestMapping("viewTravelRequestDeails/{travelRequestId}")
	public String getTravelRequestDetails(@PathVariable("travelRequestId") String travelRequestId, Model model, HttpSession httpSession) {
		BookingDetails bookingDetails = bookingDetailsServiceInterface.viewTBookingDetails(travelRequestId);
		httpSession.setAttribute("viewTravelRequestDetails", bookingDetails);
		return "redirect:/viewBookingDetails";
	}
	
	@RequestMapping("viewBookingDetails")
	public String showViewTravelRequestPage(Model model, HttpSession httpSession) {
		BookingDetails bookingDetails = (BookingDetails) httpSession.getAttribute("viewTravelRequestDetails");
		System.out.println(bookingDetails);
		model.addAttribute("viewTravelRequest", bookingDetails);
		return "viewTravelRequestDetails";
	}
	
	
	
	@RequestMapping("backtohomepage")
	public String back(HttpSession httpSession) {
		EmployeeTravelDetails employeeTravelDetails = (EmployeeTravelDetails) httpSession.getAttribute("travelDetails");
		String role = (String) httpSession.getAttribute("role");
		if (role.equalsIgnoreCase("Employee")) {
			return "redirect:/EmployeeTravelHomePagee";
		} else  {
			return "redirect:/managerHomePagee";
		} 

	}
	@RequestMapping("downloadBookingTicket")
	public void dowmloadTicket (HttpServletResponse response,HttpSession httpSession) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Or any pattern you prefer

        BookingDetails bookingDetails = (BookingDetails)
                  httpSession.getAttribute("viewTravelRequestDetails");
        
         response.setContentType("application/pdf");
         response.setHeader("Content-Disposition", "attachment; filename=\"travel_request_" + bookingDetails.getBookingId() + ".pdf\"");

         // Create the PDF document
         PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
         PdfDocument pdfDocument = new PdfDocument(pdfWriter);
         Document document = new Document(pdfDocument);

         // Add content to the PDF
         document.add(new Paragraph("Booking Ticket"));

         // Create a table with 2 columns
         Table table = new Table(2);
         table.addCell("Booking ID");
         table.addCell(bookingDetails.getBookingId());
         table.addCell("From Date");
         table.addCell(bookingDetails.getFromDate().format(formatter));
         table.addCell("To Date");
         table.addCell(bookingDetails.getToDate().format(formatter));
         table.addCell("Travel Mode");
         table.addCell(bookingDetails.getTravelMode());
         table.addCell("Destination");
         table.addCell(bookingDetails.getDestination());
         table.addCell("Region");
         table.addCell(bookingDetails.getRegion());
         table.addCell("Travel Mode Name");
         table.addCell(bookingDetails.getTravelModeName());
         table.addCell("Accommodation");
         table.addCell(bookingDetails.getAccomodation());

         // Add the table to the document
         document.add(table);

         // Close the document
         document.close();
	}
	
	
}