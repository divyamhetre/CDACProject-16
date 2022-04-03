package sahara.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sahara.pojo.DonationTbl;
import sahara.pojo.DonorInfoTbl;
import sahara.pojo.OrganizationInfoTbl;
import sahara.repository.MyDonationRequestRepository;




@Service
public class DonationRequestDao {

	@Autowired
	MyDonationRequestRepository repo;
	

	
	
	public List<DonationTbl> getAll() {
		 
		return repo.findAll();
	}

	public void addDonationRequest(int donationId, String donationComments, Date donationDate, String donationPickupAddress,
			String donationPickuptime, int donationPincode, int donationQuantity, String donationStatus,
			DonorInfoTbl donorInfoTbl1) {
		// TODO Auto-generated method stub
		DonationTbl donation= new DonationTbl(donationId, donationComments, donationDate, donationPickupAddress, donationPickuptime, donationPincode, donationQuantity, donationStatus, donorInfoTbl1);
		
		repo.save(donation);
		
	}
	
	
	
	
	public void addDonationRequest2(int donationId, String donationComments, Date donationDate, String donationPickupAddress,
			String donationPickuptime, int donationPincode, int donationQuantity, String donationStatus,
			DonorInfoTbl donorInfoTbl1) {
		// TODO Auto-generated method stub
		DonationTbl donation= new DonationTbl(donationId, donationComments, donationDate, donationPickupAddress, donationPickuptime, donationPincode, donationQuantity, donationStatus, donorInfoTbl1);
		
		repo.save(donation);
		
	}
	public DonationTbl findbyId(int id)
	{
		DonationTbl obj=repo.findById(id);
		
		
		return  obj;
	}
	public void delete(int id) {
		
		repo.deleteById(id);
	}
	
}
