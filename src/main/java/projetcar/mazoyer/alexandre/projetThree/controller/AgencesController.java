package projetcar.mazoyer.alexandre.projetThree.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetcar.mazoyer.alexandre.projetThree.repository.AgencesRepository;
import projetcar.mazoyer.alexandre.projetThree.request.AgencesRequest;
import projetcar.mazoyer.alexandre.projetThree.response.MessageResponse;
import projetcar.mazoyer.alexandre.projetThree.service.AgencesService;

@RestController
@CrossOrigin
@RequestMapping("/api/agences")
public class AgencesController {

	@Autowired
	AgencesRepository agencesRepository;

	@Autowired
	AgencesService agencesService;

	@PostMapping("/")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> registerAgence(@Valid @RequestBody AgencesRequest agencesRequest) {

		if (agencesRepository.existsByName(agencesRequest.getName())) {

			return ResponseEntity.badRequest().body(new MessageResponse("name agence already in use."));
		}

		try {
			return agencesService.register(agencesRequest);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAgences(@Valid @RequestBody AgencesRequest agencesRequest) {

		try {
			return agencesService.getAgences(agencesRequest);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

}
