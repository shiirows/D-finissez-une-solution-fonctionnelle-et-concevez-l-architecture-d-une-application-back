package projetcar.mazoyer.alexandre.projetThree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projetcar.mazoyer.alexandre.projetThree.models.Agences;
import projetcar.mazoyer.alexandre.projetThree.repository.AgencesRepository;
import projetcar.mazoyer.alexandre.projetThree.request.AgencesRequest;
import projetcar.mazoyer.alexandre.projetThree.response.MessageResponse;

@Service
public class AgencesService {
	
	@Autowired
	AgencesRepository agencesRepository;
	
	public ResponseEntity<?> register(AgencesRequest agencesRequest) throws Exception {
		
		Agences agences = new Agences();
		
		agences.setName(agencesRequest.getName());
		agences.setAdress(agencesRequest.getAdress());
		agences.setCountry(agencesRequest.getCountry());
		agences.setCity(agencesRequest.getCity());
		
		agencesRepository.save(agences);
		
		return new ResponseEntity<>(new MessageResponse("The agences" + agences.getName() + "was successfully added :"), HttpStatus.ACCEPTED);;
	}
	
	public ResponseEntity<?> getAgences(AgencesRequest agencesRequest) throws Exception {
		return null;
	}

}
