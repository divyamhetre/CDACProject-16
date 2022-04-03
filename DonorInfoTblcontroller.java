package sahara.controller;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sahara.dao.DonorInfoTblDao;
import sahara.pojo.DonorInfoTbl;
import sahara.pojo.OrganizationInfoTbl;

@CrossOrigin
@RestController
@RequestMapping("/Donor")
public class DonorInfoTblcontroller {


		@Autowired
	    DonorInfoTblDao dao;
		
		
		
		@GetMapping("/Login/{donor_username}/{donor_password}")
		public boolean LoginValidation(@PathVariable String donor_username,@PathVariable String donor_password)
		{
			if(donor_username!=null && donor_password!=null  )
			{
			if(dao.LoginValidation(donor_username,donor_password))
			return true;
			}
			return false;
			
		}
		
		
		

		@GetMapping("/getAll")
		public List<DonorInfoTbl> getAllDetails()
		{
			
			 return dao.getAll();
		}
		
		@PostMapping("/insert")
		//@RequestMapping(value="/insert", headers = "Accept=application/json", method = RequestMethod.POST)
		public String insertDetails(@RequestBody DonorInfoTbl donortbl)
		{
		//	System.out.println(donertbl.getDonerName());
			dao.insertData(donortbl);
			
			return "Data inserted successfully" ;
		}
		@DeleteMapping("/Delete/{id}")
		public void Delete(@PathVariable int id) {
			dao.delete (id);
			System.out.println("deleted");
		}
	
		
}
