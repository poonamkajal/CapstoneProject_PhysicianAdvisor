package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Address;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;
import com.perscholas.poonamkajal.physicianadvisor.repository.HospitalRepository;

@Service
public class HospitalServiceImpl {
	@Autowired
	private HospitalRepository hospitalRepository;

	public List<HospitalDto> getAllHospital() {

		List<HospitalDto> hospitalDtos = new ArrayList<HospitalDto>();
		hospitalRepository.findAll().forEach(h -> {
			HospitalDto hdto = new HospitalDto();
			BeanUtils.copyProperties(h, hdto);
			hospitalDtos.add(hdto);
		});

		return hospitalDtos;
	}

	public HospitalDto getHospitalById(Long id) {
		Optional<Hospital> h = hospitalRepository.findById(id);
		HospitalDto hdto = new HospitalDto();
		if (h.isPresent()) {
			BeanUtils.copyProperties(h.get(), hdto);
		}
		return hdto;
	}

	public void addHospital(HospitalDto hospital) {
		Hospital h = new Hospital();
		h.setAddress(new Address());
		BeanUtils.copyProperties(hospital, h);
		BeanUtils.copyProperties(hospital.getAddress(), h.getAddress());
		System.out.println("Saving hospital " + h.toString());
		hospitalRepository.save(h);
	}

	public void updateHospital(long id, HospitalDto hospital) {
		Optional<Hospital> hospitalData = hospitalRepository.findById(id);

		if (hospitalData.isPresent()) {
			Hospital h  = hospitalData.get();
			BeanUtils.copyProperties(hospital, h);			
			BeanUtils.copyProperties(hospital.getAddress(), h.getAddress());
			System.out.println("Updating hospital " + h.toString());
			hospitalRepository.saveAndFlush(h);
		}
	}

	public void deleteHospital(long id) {
		hospitalRepository.deleteById(id);
	}

	
	public ResponseEntity<HospitalDto> findById(Long id) {
		try {
			Optional<Hospital> hospital = hospitalRepository.findById(id);

			if (hospital.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				HospitalDto hdto = new HospitalDto();
				BeanUtils.copyProperties(hospital, hdto);
			return new ResponseEntity<>(hdto, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}



