package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl {
	

		@Autowired
		private DoctorRepository doctorRepository;

		public List<Doctor> getAllDoctor() {

		       List<Doctor> doctor = new ArrayList<Doctor>();
		       doctorRepository.findAll().forEach(doctor::add);
		       return doctor;
		   }

		public Optional<Doctor> getDoctorById(Long id) {
			return doctorRepository.findById(id);
		}

		public void addDoctor(Doctor doctor) {
			doctorRepository.save(doctor);
		}

		public void updateDoctor(long id, Doctor doctor) {
			Optional<Doctor> doctorData = doctorRepository.findById(id);

			if (doctorData.isPresent()) {
				Doctor _doctor = doctorData.get();
				_doctor.setFirstName(doctor.getFirstName());
				_doctor.setLastName(doctor.getLastName());
				_doctor.setSpeciality(doctor.getSpeciality());
				doctorRepository.save(_doctor);
			}
		}
		public void deleteDoctor(Long id) {
		       doctorRepository.deleteById(id);
		   }
		public void deleteAllDoctor() {
		       doctorRepository.deleteAll();
		   }
		 public ResponseEntity<Optional<Doctor>> findById() {
		       try {
		           Optional<Doctor> doctor = doctorRepository.findById(null);

		           if (doctor.isEmpty()) {
		               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		           }
		           return new ResponseEntity<>(doctor, HttpStatus.OK);
		       } catch (Exception e) {
		           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		       }
		   }
		}






