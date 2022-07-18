package kr.ac.kopo.ctc.kopo08.Score.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreItem;

@Repository
// JpaRepository는 이전에 작성했던 ##Impl.java랑 동일하다.
// 여기서 domain이름을 ScoreItem자리에 지정해주기만 하면 된다. 

public interface ScoreItemRepository extends JpaRepository<ScoreItem, Long> {
	Optional<ScoreItem> findById(String id);
	Page<ScoreItem> findAll(Pageable pageable);
}