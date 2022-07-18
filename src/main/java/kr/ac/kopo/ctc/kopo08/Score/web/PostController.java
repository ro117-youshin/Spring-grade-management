package kr.ac.kopo.ctc.kopo08.Score.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;
import kr.ac.kopo.ctc.kopo08.Score.service.ScoreListService;

@RestController
public class PostController {
	@Autowired private ScoreListService scoreListService;
	
	@GetMapping(value="/ScoreList/api", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Page<ScoreList>> getScoreList(Pageable pageable) {
		Page<ScoreList> lists = scoreListService.findAll(pageable);
		
		return new ResponseEntity<Page<ScoreList>>(lists, HttpStatus.OK);
	}
	
}