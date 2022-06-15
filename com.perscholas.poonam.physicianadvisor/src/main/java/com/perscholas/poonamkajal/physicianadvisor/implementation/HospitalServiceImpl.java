package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;
import com.perscholas.poonamkajal.physicianadvisor.repository.DoctorRepository;
import com.perscholas.poonamkajal.physicianadvisor.repository.HospitalRepository;

@Service
public class HospitalServiceImpl {
	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> getAllHospital() {

	       List<Hospital> hospital = new ArrayList<Hospital>();
	       hospitalRepository.findAll().forEach(hospital::add);
	       return hospital;
	   }

	public Optional<Hospital> getHospitalById(Long id) {
		return hospitalRepository.findById(id);
	}

	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void updateHospital(long id, Hospital hospital) {
		Optional<Hospital> hospitalData = hospitalRepository.findById(id);

		if (hospitalData.isPresent()) {
			Hospital _hospital = hospitalData.get();
			_hospital.setName(hospital.getName());
			_hospital.setFacilityName(hospital.getFacilityName());
			_hospital.setAddress(hospital.getAddress());
			hospitalRepository.save(_hospital);
		}
	}
	public void deleteHospital(Long id) {
	       hospitalRepository.deleteById(id);
	   }
	public void deleteAllHospital() {
	       hospitalRepository.deleteAll();
	   }
	 public ResponseEntity<Optional<Hospital>> findById() {
	       try {
	           Optional<Hospital> hospital = hospitalRepository.findById(null);

	           if (hospital.isEmpty()) {
	               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	           }
	           return new ResponseEntity<>(hospital, HttpStatus.OK);
	       } catch (Exception e) {
	           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       }
	   }
	}



