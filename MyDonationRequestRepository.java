package sahara.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sahara.controller.DonationRequestTblController;
import sahara.pojo.DonationTbl;

import sahara.pojo.OrganizationInfoTbl;

@Repository
public interface MyDonationRequestRepository extends JpaRepository<DonationTbl, Integer> {
	
	List<DonationTbl> findAll();
	

	DonationTbl findById(int id);
	
//	void delete(int id);
	


}
