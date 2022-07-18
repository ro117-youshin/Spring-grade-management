package kr.ac.kopo.ctc.kopo08.Score.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;
import kr.ac.kopo.ctc.kopo08.Score.service.ScoreListService;

@SpringBootTest
class ScoreListControllerTest {

	@Autowired
	private ScoreListService scoreListService;
	
	@Test
	void page(Model model, Pageable pageable) {
		Page<ScoreList> page = scoreListService.findAll(pageable);
		assertEquals(1, pageable.getPageNumber());
	}

}
