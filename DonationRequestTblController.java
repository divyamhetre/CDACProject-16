package sahara.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sahara.dao.DonationRequestDao;
import sahara.dao.DonorInfoTblDao;
import sahara.pojo.DonationTbl;
import sahara.pojo.DonorInfoTbl;
import sahara.pojo.OrganizationInfoTbl;
import sahara.pojo.OrganizationRequestTbl;

@CrossOrigin
@RestController
@RequestMapping("/DonationRequest")
public class DonationRequestTblController {

	@Autowired
	DonationRequestDao donationRequestDao;

	@Autowired 
	DonorInfoTblDao donorInfoTblDao;

	@GetMapping("/getAll")
	public List<DonationTbl> getAllDetails()
	{
		
		 return donationRequestDao.getAll();
	}
	
	
	
	@PutMapping("/insertDonationRequest/{donorId}")
	public String insertDonationRequest(@RequestBody DonationTbl DonationRequest,@PathVariable int donorId)
	{
		if(donorId==0)
		{
			System.out.println();
		return "Enter Donor Id";	
		}
		else
		{
			System.out.println(donorId);
		DonorInfoTbl DonorObj=donorInfoTblDao.findbyId(donorId);
		System.out.println(DonorObj);
		//System.out.println(orgtbl.getOrganizationName());
		donationRequestDao.addDonationRequest2(DonationRequest.getDonationId(), DonationRequest.getDonationComments(), DonationRequest.getDonationDate(), DonationRequest.getDonationPickupAddress(),DonationRequest.getDonationPickuptime(),DonationRequest.getDonationPincode(), DonationRequest.getDonationQuantity(), DonationRequest.getDonationStatus(), DonorObj);
	
		
		return "Data inserted successfully" ;
	}
	}
	
	@DeleteMapping("/Delete/{id}")
	public String Delete(@PathVariable int id) {
		donationRequestDao.delete (id);
		return "Deleted successfully";
	}
}
