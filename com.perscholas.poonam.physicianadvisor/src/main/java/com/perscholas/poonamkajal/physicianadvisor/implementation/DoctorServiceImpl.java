package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl {
	@Autowired
	private DoctorRepository doctorRepository;

	public List<DoctorDto> getAllDoctor() {

		List<DoctorDto> doctorDtos = new ArrayList<DoctorDto>();
		doctorRepository.findAll().forEach(d -> {
			DoctorDto ddto = new DoctorDto();
			BeanUtils.copyProperties(d, ddto);
			doctorDtos.add(ddto);
		});

		return doctorDtos;
	}

	public DoctorDto getDoctorById(Long id) {
		Optional<Doctor> d = doctorRepository.findById(id);
		DoctorDto ddto = new DoctorDto();
		if (d.isPresent()) {
			BeanUtils.copyProperties(d.get(), ddto);
		}
		return ddto;
	}

	public void addDoctor(DoctorDto doctor) {
		Doctor d = new Doctor();
		BeanUtils.copyProperties(doctor, d);
		System.out.println("Saving doctor" + d);
		doctorRepository.save(d);
	}

	public void updateDoctor(long id, DoctorDto doctor) {
		Optional<Doctor> doctorData = doctorRepository.findById(id);

		if (doctorData.isPresent()) {
			Doctor d = doctorData.get();
			BeanUtils.copyProperties(doctor, d);
			System.out.println("Updating Case " + d.toString());
			doctorRepository.saveAndFlush(d);
		}
	}

	public void deleteDoctor(long id) {
		doctorRepository.deleteById(id);
	}

	public ResponseEntity<DoctorDto> findById(Long id) {
		try {
			Optional<Doctor> doctor = doctorRepository.findById(id);

			if (doctor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				DoctorDto ddto = new DoctorDto();
				BeanUtils.copyProperties(doctor, ddto);
				return new ResponseEntity<>(ddto, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
