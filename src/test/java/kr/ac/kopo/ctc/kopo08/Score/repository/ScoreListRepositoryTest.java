package kr.ac.kopo.ctc.kopo08.Score.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;

@SpringBootTest
class ScoreListRepositoryTest {

	@Autowired
	private ScoreItemRepository scoreItemRepository;

	@Autowired
	private ScoreListRepository scoreListRepository;

	@Test
	void test() {
		// 부모인 ScoreList에 학생 한 명 추가
		for (int index = 0; index < 100; index++) {
			ScoreList inputScoreList = new ScoreList();
			inputScoreList.setName("학생" + (index+1));
			inputScoreList.setStudentid(209901 + index);
			scoreListRepository.save(inputScoreList);

			// 부모인 ScoreList에 학생에 대한 성적1, ScoreItem 추가
			ScoreItem inputScoreItem = new ScoreItem();
			inputScoreItem.setScoreList(inputScoreList); // 연결
			
			inputScoreItem.setName("첫번째 시험");
			inputScoreItem.setKor((int) (Math.random() * 100));
			inputScoreItem.setEng((int) (Math.random() * 100));
			inputScoreItem.setMat((int) (Math.random() * 100));
			scoreItemRepository.save(inputScoreItem);

			// 부모인 ScoreList에 학생에 대한 성적2, ScoreItem 추가
			ScoreItem inputScoreItem2 = new ScoreItem();
			inputScoreItem2.setScoreList(inputScoreList); // 연결
			
			inputScoreItem2.setName("두번째 시험");
			inputScoreItem2.setKor((int) (Math.random() * 100));
			inputScoreItem2.setEng((int) (Math.random() * 100));
			inputScoreItem2.setMat((int) (Math.random() * 100));
			scoreItemRepository.save(inputScoreItem2);

			// 부모인 ScoreList에 학생에 대한 성적3, ScoreItem 추가
			ScoreItem inputScoreItem3 = new ScoreItem();
			inputScoreItem3.setScoreList(inputScoreList); // 연결
			
			inputScoreItem3.setName("세번째 시험");
			inputScoreItem3.setKor((int) (Math.random() * 100));
			inputScoreItem3.setEng((int) (Math.random() * 100));
			inputScoreItem3.setMat((int) (Math.random() * 100));
			scoreItemRepository.save(inputScoreItem3);
		}
	}

	// 1. ScoreItem에서 ScoreList를 가지고 와서 확인하기
	// 2. ScoreList에서 ScoreItem을 가지고 와서 확인
//	@Test
	void findScoreList() {
		ScoreList scoreList = scoreListRepository.findById(1L).get();
		System.out.println("1");
	}

//	@Test
//	@Transactional
	void deleteScoreList() {
		scoreListRepository.deleteById(1L);
		Optional<ScoreList> scoreList = scoreListRepository.findById(1L);
	}

//	@Test
	void deleteScoreItem() {
		scoreItemRepository.deleteById(1L);
		ScoreList scoreList = scoreListRepository.findById(1L).get();
		scoreList = scoreListRepository.save(scoreList);
	}

//	@Test 
//	void findScoreItem() {
//		ScoreItem scoreItem = scoreItemRepository.findById(1L).get();
//		System.out.println("스프링 줘 패기");	
//	}

}
