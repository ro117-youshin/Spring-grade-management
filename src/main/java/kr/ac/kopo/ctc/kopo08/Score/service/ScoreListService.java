package kr.ac.kopo.ctc.kopo08.Score.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;
import kr.ac.kopo.ctc.kopo08.Score.dto.Pagination;

public interface ScoreListService{
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount);
	public int autoSaveStudentId();
	public ScoreList findStudentId(Integer studentid);
	public Page<ScoreList> findAll(Pageable pageable);
}
