package kr.ac.kopo.ctc.kopo08.Score.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // DB의 table로 인식하겠다는 것이다.
public class ScoreItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column // table에서의 column을 의미
	private Long id;
	
	private String name;
	private int kor;
	private int eng;
	private int mat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	// fetch 디폴드 값은 EAGER
	@JsonBackReference
	@ManyToOne(optional=false)
	@JoinColumn(name="score_list_id") // 괄호 안의 부분은 DB상에서의 네임
	private ScoreList scoreList;

	public ScoreList getScoreList() {
		return scoreList;
	}

	public void setScoreList(ScoreList scoreList) {
		this.scoreList = scoreList;
	}

	@Override
	public String toString() {
		String result = "[scoreItem_"+id+"]" + kor;
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
