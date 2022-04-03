package sahara.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sahara.repository.MyDonorInfoTblRepository;

import sahara.pojo.DonorInfoTbl;
import sahara.pojo.Manager;
import sahara.pojo.OrganizationInfoTbl;


@Service
public class DonorInfoTblDao {

	@Autowired
	MyDonorInfoTblRepository repo;
	
	/*
	 * @Autowired MyRepositoryDoner repo2;
	 */
	/*
	 * public void addDoner(int doner_id, String doner_firstname, String
	 * doner_lastname, String doner_username, String doner_password, String
	 * doner_email, String doner_contactno, String doner_area, String doner_address,
	 * int doner_pincode) { DonerInfoTbl DI= new DonerInfoTbl( doner_id,
	 * doner_firstname, doner_lastname, doner_username, doner_password, doner_email,
	 * doner_contactno, doner_area, doner_address, doner_pincode); repo.save(DI);
	 * 
	 * }
	 */
	

	public boolean LoginValidation(String donor_username, String donor_password) {
		DonorInfoTbl donor=repo.findByUserName(donor_username);
		if(donor!=null) 
		{
		if(donor.getDonorUsername().equals(donor_username) && donor.getDonorPassword().equals(donor_password))
		return true;
		else
			return false;
		}
		else
			return false;
	}
	
	public List<DonorInfoTbl> getAll() {
		 
		return repo.findAll();
	}

	public void insertData(DonorInfoTbl orgtbl) {
		
		repo.save(orgtbl);
		 
	}
   
	
	/*
	 * public void addDonation(int doner_id, int donation_quantity, String
	 * donation_pickup_address, int donation_pincode, Date donation_date, String
	 * doner_contactno, Time donation_pickuptime, String donation_comments, String
	 * donation_status) { DonationTbl DT= new DonationTbl(doner_id,
	 * donation_quantity,donation_pickup_address,donation_pincode,donation_date,
	 * doner_contactno,donation_pickuptime,donation_comments,donation_status);
	 * repo2.save(DT);
	 * 
	 * }
	 */

	
	/*
	 * public void insertData(Donati orgtbl) {
	 * 
	 * repo.save(orgtbl);
	 * 
	 * }
	 */
	
	public DonorInfoTbl findbyId(int id)
	{
		DonorInfoTbl obj=repo.findById(id);
		
		
		return  obj;
	}
	public void delete(int id) {
		
		repo.deleteById(id);
	}
}
