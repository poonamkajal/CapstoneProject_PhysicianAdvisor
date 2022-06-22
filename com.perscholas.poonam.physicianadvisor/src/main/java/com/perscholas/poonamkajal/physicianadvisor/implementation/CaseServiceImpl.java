package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;
import com.perscholas.poonamkajal.physicianadvisor.repository.CaseRepository;
import com.perscholas.poonamkajal.physicianadvisor.utils.CopyUtilities;

@Service
public class CaseServiceImpl {

	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private CopyUtilities copyUtilities;

	public List<CaseDto> getAllCase() {

		List<CaseDto> caseDtos = new ArrayList<CaseDto>();
		caseRepository.findAll().forEach(c -> {
			CaseDto cdto = new CaseDto();
			copyUtilities.copyCaseDto(c, cdto);
			caseDtos.add(cdto);
		});

		return caseDtos;
	}

	public CaseDto getCaseById(Long id) {
		Optional<Case> c = caseRepository.findById(id);
		CaseDto cdto = new CaseDto();
		if (c.isPresent()) {
			copyUtilities.copyCaseDto(c.get(), cdto);
		}
		return cdto;
	}

	public void addCase(CaseDto cases) {
		Case c = new Case();
		copyUtilities.copyCase(cases, c);

        System.out.println("Saving hospital " + c.toString());
        caseRepository.save(c);
	}

	public void updateCase(long id, CaseDto cases) {
		Optional<Case> caseData = caseRepository.findById(id);

		if (caseData.isPresent()) {
			Case c = caseData.get();
			copyUtilities.copyCase(cases, c);
			System.out.println("Updating Case " + c.toString());
			caseRepository.saveAndFlush(c);
		}
	}

	public void deleteCase(long id) {
		caseRepository.deleteById(id);
	}


	public ResponseEntity<CaseDto> findById(Long id) {
		try {
			Optional<Case> cases = caseRepository.findById(id);

			if (cases.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				CaseDto cdto = new CaseDto();
				copyUtilities.copyCaseDto(cases.get(), cdto);
			return new ResponseEntity<>(cdto, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
