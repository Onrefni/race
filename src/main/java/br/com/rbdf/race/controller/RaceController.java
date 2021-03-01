package br.com.rbdf.race.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.race.race.vo.v1.RaceVO;
import br.com.rbdf.race.exception.AplicacaoException;
import br.com.rbdf.race.service.StatusRace;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "RaceEndPoint")
@RestController
@RequestMapping("/race/v1")
public class RaceController {

	@Autowired
	private StatusRace service;

	@ApiOperation(value = "Retorna o estatus da corrida.")
	@GetMapping
	public ResponseEntity<RaceVO> statusRace() {
		try {
			return ResponseEntity.ok(service.retornaStatus());
		} catch ( AplicacaoException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
