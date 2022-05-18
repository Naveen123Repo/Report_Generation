package com.Report.restController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Report.reports.ExcelGenerator;
import com.Report.reports.PdfGenerator;
import com.Report.request.SearchRequest;
import com.Report.response.SearchResponse;
import com.Report.service.ReportService;

@RestController
public class ReportsController {

	@Autowired
	private ReportService service;
	
	@GetMapping("/planNames")
	public List<String> getPlans() {
		return service.getPlanNames();
	}
	
	@GetMapping("/planStatus")
	public List<String> getPlanStatus(){
		return service.getPlanStatus();	
	}
	
	@GetMapping("/search")
	public List<SearchResponse> searchDetails(@RequestBody SearchRequest request){
		return service.searchPlans(request);
		
	}
	@GetMapping("/excel")
	  public void generateExcel(HttpServletResponse response) throws Exception {

	    response.setContentType("application/octet-stream");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Plans.xls";
	    response.setHeader(headerKey, headerValue);

	    List<SearchResponse> records = service.searchPlans(null);
	    ExcelGenerator excel = new ExcelGenerator();
	    excel.generateExcel(records, response);
	  }
	
	@GetMapping("/pdf")
	  public void generatePdf(HttpServletResponse httpResponse) throws Exception {

	    httpResponse.setContentType("application/pdf");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Plans.pdf";
	    httpResponse.setHeader(headerKey, headerValue);

	    List<SearchResponse> records = service.searchPlans(null);
	    PdfGenerator pdfGen = new PdfGenerator();
	    pdfGen.generatePdf(records, httpResponse);
	  }
	
	
	
}
