package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.perscholas.poonamkajal.physicianadvisor.dto.InsuranceDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Insurance;
import com.perscholas.poonamkajal.physicianadvisor.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl {
	@Autowired
	private InsuranceRepository insuranceRepository;

	public List<InsuranceDto> getAllInsurance() {

		List<InsuranceDto> insuranceDtos = new ArrayList<InsuranceDto>();
		insuranceRepository.findAll().forEach(i -> {
			InsuranceDto idto = new InsuranceDto();
			BeanUtils.copyProperties(i, idto);
			insuranceDtos.add(idto);
		});

		return insuranceDtos;
	}

	public InsuranceDto getInsuranceById(Long id) {
		Optional<Insurance> i = insuranceRepository.findById(id);
		InsuranceDto idto = new InsuranceDto();
		if (i.isPresent()) {
			BeanUtils.copyProperties(i.get(), idto);
		}
		return idto;
	}

	public void addInsurance(InsuranceDto insurance) {
		Insurance i = new Insurance();
		BeanUtils.copyProperties(insurance, i);
		insuranceRepository.save(i);
	}

	public void updateInsurance(long id, InsuranceDto insurance) {
		Optional<Insurance> insuranceData = insuranceRepository.findById(id);

		if (insuranceData.isPresent()) {
			Insurance i = insuranceData.get();
			BeanUtils.copyProperties(insurance, i);
			System.out.println("Updating Case " + i.toString());
			insuranceRepository.saveAndFlush(i);
		}
	}

	public void deleteInsurance(long id) {
		insuranceRepository.deleteById(id);
	}

	public ResponseEntity<InsuranceDto> findById(Long id) {
		try {
			Optional<Insurance> insurance = insuranceRepository.findById(id);

			if (insurance.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				InsuranceDto pdto = new InsuranceDto();
				BeanUtils.copyProperties(insurance, pdto);
				return new ResponseEntity<>(pdto, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
