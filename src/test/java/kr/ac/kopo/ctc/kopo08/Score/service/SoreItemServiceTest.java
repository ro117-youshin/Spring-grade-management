package kr.ac.kopo.ctc.kopo08.Score.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.kopo08.Score.dto.Pagination;

@SpringBootTest
class ScoreItemServiceTest {
	
	@Autowired
	private ScoreListService scoreListService;
	
	@Test	
	void testGetPagination1() {
		Pagination p = scoreListService.getPagination(-1, 20, 15, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 16);
		assertEquals(p.getNnPage(), 52);
		assertEquals(p.getcPage(), 1);
	}
 
	@Test
	void testGetPagination2() {
		Pagination p = scoreListService.getPagination(1, 20, 15, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 16);
		assertEquals(p.getNnPage(), 52);
		assertEquals(p.getcPage(), 1);
	}

	@Test
	void testGetPagination3() {
		Pagination p = scoreListService.getPagination(52, 20, 15, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 31);
		assertEquals(p.getnPage(), 52);
		assertEquals(p.getNnPage(), 52);
		assertEquals(p.getcPage(), 52);
	}

	@Test
	void testGetPagination4() {
		Pagination p = scoreListService.getPagination(53, 20, 15, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 31);
		assertEquals(p.getnPage(), 52);
		assertEquals(p.getNnPage(), 52);
		assertEquals(p.getcPage(), 52);
	}

	@Test
	void testGetPagination5() {
		Pagination p = scoreListService.getPagination(25, 20, 15, 1025);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 31);
		assertEquals(p.getNnPage(), 52);
		assertEquals(p.getcPage(), 25);
	}

	@Test
	void testGetPagination6() {
		Pagination p = scoreListService.getPagination(1, 20, 15, 102);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 6);
		assertEquals(p.getNnPage(), 6);
		assertEquals(p.getcPage(), 1);
	}

	@Test
	void testGetPagination7() {
		Pagination p = scoreListService.getPagination(6, 20, 15, 102);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 6);
		assertEquals(p.getNnPage(), 6);
		assertEquals(p.getcPage(), 6);
	}

	@Test
	void testGetPagination8() {
		Pagination p = scoreListService.getPagination(-1, 20, 15, 102);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 6);
		assertEquals(p.getNnPage(), 6);
		assertEquals(p.getcPage(), 1);
	}

	@Test
	void testGetPagination9() {
		Pagination p = scoreListService.getPagination(7, 20, 15, 102);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 6);
		assertEquals(p.getNnPage(), 6);
		assertEquals(p.getcPage(), 6);
	}

	@Test
	void testGetPagination10() {
		Pagination p = scoreListService.getPagination(3, 20, 15, 102);
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getnPage(), 6);
		assertEquals(p.getNnPage(), 6);
		assertEquals(p.getcPage(), 3);
	}
	
}
