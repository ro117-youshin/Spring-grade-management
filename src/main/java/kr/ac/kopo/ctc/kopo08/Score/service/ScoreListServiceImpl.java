package kr.ac.kopo.ctc.kopo08.Score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;
import kr.ac.kopo.ctc.kopo08.Score.dto.Pagination;
import kr.ac.kopo.ctc.kopo08.Score.repository.ScoreListRepository;

@Service
public class ScoreListServiceImpl implements ScoreListService {
	
	@Autowired
	ScoreListRepository scoreListRepository;
	
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) {
		// TODO Auto-generated method stub
		Pagination pagination = new Pagination();
		// 현재 페이지가 양의 정수 이상일 경우에만 시작
		if (currPage <= 0) {
			currPage = 1;
		}
		// 페이지 사이즈 결정
		pagination.setPageSize(pageSize);
		
		int ppPage = 0; // << 화살표, 첫 페이지로
		// << 화살표는 무조건 1로
		pagination.setPpPage(ppPage);
		
		int fristPage = ((currPage - 1) / pageSize) * pageSize + 1; // 페이지 사이즈의 첫 페이지
		int backPage = fristPage - pageSize; // 앞으로 넘어갈 때

		// < 화살표
		int pPage; // < 화살표, 이전 페이지로
		if (fristPage == 1) {
			pPage = fristPage;
		} else {
			pPage = backPage;
		}
		pagination.setpPage(pPage);

		int lastPage; // 마지막 페이지 구하기, >> 화살표
		if (totalCount % countPerPage == 0) {
			lastPage = (totalCount / countPerPage);
		} else {
			lastPage = ((totalCount / countPerPage) + 1);
		}

		// > 화살표
		int nPage; // > 화살표, 다음 페이지로
		int nextPage = fristPage + pageSize;
		if (nextPage >= lastPage) {
			nPage = lastPage;
		} else {
			nPage = nextPage;
		}
		pagination.setnPage(nPage);

		// 현재 페이지가 마지막 페이지 보다 많은 수가 들어갈 경우 현재페이지는 마지막 페이지로
		if (currPage > lastPage) {
			currPage = lastPage;
		}
		
		// >> 화살표
		pagination.setNnPage(lastPage);
		// 현재 페이지
		pagination.setcPage(currPage);
		
		pagination.setsPage(fristPage);
		
		int endPage = ((currPage - 1) / pageSize) * pageSize + pageSize;
		pagination.setePage(endPage);

		return pagination;
	}
	
	public int autoSaveStudentId() {
		List<ScoreList> scoreList = scoreListRepository.findSortedStudentId();
		
		int studentId = 0; // 최종 부여할 학번
		int lowestNumber = 209901; // 학번 최솟값
		
		for (int index = 0; index < scoreList.size(); index++) {
			int id = scoreList.get(index).getStudentid();
			if (id == lowestNumber) {
				lowestNumber = lowestNumber + 1;
			} else {
				break;
			}
		}
		studentId = lowestNumber;
		return studentId;
	}
	
	public ScoreList findStudentId(Integer studentid) {
		// TODO Auto-generated method stub
		List<ScoreList> scoreList = scoreListRepository.findSortedStudentId();
		if (scoreList.size() != 0) {
			for (int index = 0; index < scoreList.size(); index++) {
				int listSID = scoreList.get(index).getStudentid();
				if (listSID == studentid) {
					return scoreList.get(index);
				}
			}
		}
		return null;
	}
	
	public Page<ScoreList> findAll(Pageable pageable) {
		Page<ScoreList> List = scoreListRepository.findAll(pageable);		
		return List;
	}
}
