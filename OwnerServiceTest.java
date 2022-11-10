package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
@SuppressWarnings("unused")



@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);
	
	@Autowired
	private OwnerService ownerService;
	
	/**
	 * 
	 */
	
	/*@Test
	 * public void testFindOwnerById(){
	 	
	 	long ID = 1
	 	String NAME = "Marco";
	 	Owner owner = null;
	 	
	 	try {
	 		owner = ownerService.findById(ID);
	 	} catch (OwnerNotFoundException e){
	 		fail(e.getMessage());
	 	}
	 	logger.info(""+owner);
	 	
	 	asseTthat(owner.getName(), is(NAME));
	  }
	 */
	@Test
	public void testUpdateOwner() {
		
		String FIRST_NAME = "Marco";
		String LAST_NAME = "Bustos";
		String ADDRESS = "Miraflores";
		String CITY = "Lima";
		String TELEPHONE = "945897756";
		
		String UP_FIRST_NAME = "Marco";
		String UP_LAST_NAME = "Bustos";
		String UP_ADDRESS = "Callao";
		String UP_CITY = "Ayacucho";
		String UP_TELEPHONE = "945189790";
		
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create1(owner);
		logger.info(">>" + ownerCreated);
		
		ownerCreated.setFirst_name(UP_FIRST_NAME);
		ownerCreated.setLast_name(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);
		
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);
		
		assertThat(upgradeOwner.getFirst_name(), is(UP_FIRST_NAME));
		assertThat(upgradeOwner.getLast_name(), is(UP_LAST_NAME));
		assertThat(upgradeOwner.getAddress(), is(UP_ADDRESS));
		assertThat(upgradeOwner.getCity(), is(UP_CITY));
		assertThat(upgradeOwner.getTelephone(), is(UP_TELEPHONE));		
	}
	
}
