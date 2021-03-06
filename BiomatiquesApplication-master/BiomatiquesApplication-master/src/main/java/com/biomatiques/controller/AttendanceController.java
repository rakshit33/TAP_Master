package com.biomatiques.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biomatiques.model.Attendance;
import com.biomatiques.service.AttendanceService;

@RestController
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@RequestMapping(value="/attendance",method=RequestMethod.POST,headers="Accept=application/json")
	public void addAttendance(@RequestBody byte[] irisId) throws ParseException {
		attendanceService.addAttendance(irisId);
	}
	
	@RequestMapping(value="/attendance",method=RequestMethod.GET)
	public List<Attendance> getAttendance() {
		return attendanceService.getAllAttendance();
	}
	
	@RequestMapping(value="/attendance/{employeeId}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Attendance> getAttendanceByEmployeeId(@PathVariable long employeeId) {
		return attendanceService.getAttendanceByEmployeeId(employeeId);
	}
	
	@RequestMapping(value="/attendance/employee/{firstName}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Attendance> getAttendanceByEmployeeFirstName(@PathVariable String firstName) {
		return attendanceService.getAttendanceByEmployeeFirstName(firstName);
	}
	
	@RequestMapping(value="/attendance/attended_date/{date}", method=RequestMethod.GET,headers="Accept=application/json")
		public List<Attendance> getAttendanceByDate(@PathVariable("date") String date){
			return attendanceService.getAttendanceByDate(date);
		}
	
	
}
