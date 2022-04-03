package sahara.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sahara.pojo.DonorInfoTbl;
import sahara.pojo.Manager;
import sahara.pojo.OrganizationInfoTbl;
@Repository
public interface MyDonorInfoTblRepository extends JpaRepository<DonorInfoTbl, Integer> {
	
	
	List<DonorInfoTbl> findAll();
	@Query(value = "select * from donor_info_tbl a  where  a.donor_username =:UserName",nativeQuery = true)
	 public DonorInfoTbl findByUserName(@Param("UserName") String donorUsername);
	
	 DonorInfoTbl findById(int id);
	
	// void delete(int id);
	



}
