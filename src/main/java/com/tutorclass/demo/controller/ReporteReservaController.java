package com.tutorclass.demo.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import com.tutorclass.demo.model.Reserva;
import com.tutorclass.demo.repository.ICarreraRepository;
import com.tutorclass.demo.repository.IReservaRepository;

@Controller
public class ReporteReservaController {
	@Autowired
	private DataSource dataSource;
	@RequestMapping("/{reportName}")
	public void demoReport1(@PathVariable("reportName") final String reportName,
			@RequestParam(required = false) Map<String, Object> parameters,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
	parameters = parameters == null ? new HashMap<>() : parameters;
	System.out.println(reportName);
	ClassPathResource resource = new ClassPathResource("reportes" + File.separator + reportName + ".jasper");
	InputStream jasperStream = resource.getInputStream();
	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition", "inline;");
	final OutputStream outputStream = response.getOutputStream();
	JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
}
