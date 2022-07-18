package kr.ac.kopo.ctc.kopo08.Score.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;

@Repository
public interface ScoreListRepository extends JpaRepository<ScoreList, Long> {
	
	Page<ScoreList> findAll(Pageable pageable);
	
	ScoreList findOneById(Long id);
	
	@Query(value = "SELECT * FROM score_list ORDER BY studentid", nativeQuery = true)
	List<ScoreList> findSortedStudentId();
	
	ScoreList findByStudentidOrderByStudentidAsc(Integer studentid);
	ScoreList findByStudentid(Integer studentid);
	ScoreList deleteByStudentid(Integer studentid);
}
