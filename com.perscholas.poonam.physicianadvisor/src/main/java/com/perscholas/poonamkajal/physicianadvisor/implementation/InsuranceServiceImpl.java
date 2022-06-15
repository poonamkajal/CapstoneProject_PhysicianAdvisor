package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.perscholas.poonamkajal.physicianadvisor.models.Insurance;
import com.perscholas.poonamkajal.physicianadvisor.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl {
	@Autowired
	private InsuranceRepository insuranceRepository;

	public List<Insurance> getAllInsurance() {

	       List<Insurance> insurance = new ArrayList<Insurance>();
	       insuranceRepository.findAll().forEach(insurance::add);
	       return insurance;
	   }

	public Optional<Insurance> getInsuranceById(Long id) {
		return insuranceRepository.findById(id);
	}

	public void addInsurance(Insurance insurance) {
		insuranceRepository.save(insurance);
	}

	public void updateInsurance(long id, Insurance insurance) {
		Optional<Insurance> insuranceData = insuranceRepository.findById(id);

		if (insuranceData.isPresent()) {
			Insurance _insurance = insuranceData.get();
			_insurance.setProviderName(insurance.getProviderName());
			_insurance.setInsuranceId(insurance.getInsuranceId());
			_insurance.setGroupId(insurance.getGroupId());
			_insurance.setContactNo(insurance.getContactNo());
			_insurance.setEffectiveDate(insurance.getEffectiveDate());
			_insurance.setExpirationDate(insurance.getEffectiveDate());
			_insurance.setDetails(insurance.getDetails());
			insuranceRepository.save(_insurance);
		}
	}
	public void deleteInsurance(Long id) {
	       insuranceRepository.deleteById(id);
	   }
	public void deleteAllInsurance() {
	       insuranceRepository.deleteAll();
	   }
	 public ResponseEntity<Optional<Insurance>> findById() {
	       try {
	           Optional<Insurance> insurance = insuranceRepository.findById(null);

	           if (insurance.isEmpty()) {
	               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	           }
	           return new ResponseEntity<>(insurance, HttpStatus.OK);
	       } catch (Exception e) {
	           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       }
	   }

}
