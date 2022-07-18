package kr.ac.kopo.ctc.kopo08.Score.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreItem;

@SpringBootTest
class ScoreItemRepositoryTest {

	@Autowired
	private ScoreItemRepository scoreItemRepository;

	@Test
	void insert() {
		for (int index = 0; index < 100; index++) {
			ScoreItem inputScoreItem = new ScoreItem();
			inputScoreItem.setKor((int) (Math.random() * 100));
			inputScoreItem.setEng((int) (Math.random() * 100));
			inputScoreItem.setMat((int) (Math.random() * 100));
			scoreItemRepository.save(inputScoreItem);
		}
//		ScoreItem scoreItem = scoreItemRepository.findById(1L).get();
	}

//	@Test
//	void findOne() {
//		scoreItemRepository.findOneByName("김유신");
//	}

//	@Test
//	void read() {
//		Optional<ScoreItem> scoreItem = scoreItemRepository.findById(4L);
//		
//		scoreItem.ifPresent(selectedScoreItem -> {
//			System.out.println(selectedScoreItem);
//		});
//	}

//	@Test
//	void findAll() {
//		PageRequest pageable = PageRequest.of(0, 10);
//		Page<ScoreItem> pagedResult = scoreItemRepository.findAll(pageable);
//
//		for (ScoreItem s : pagedResult) {
//			System.out.println(s.getName());
//		}
//	}

	@Test
	void update() {
		Optional<ScoreItem> inputScoreItem = scoreItemRepository.findById(1L);

		inputScoreItem.ifPresent(set -> {
//			set.setName("김테스트");
//			set.setStudentid(209901);
			set.setKor(0);
			set.setEng(0);
			set.setMat(0);
			scoreItemRepository.save(set);
		});
	}

	@Test
	void delete() {
		Optional<ScoreItem> inputScoreItem = scoreItemRepository.findById(1L);

		inputScoreItem.ifPresent(selectedScoreItem -> {
			scoreItemRepository.delete(selectedScoreItem);
		});
	}

}
