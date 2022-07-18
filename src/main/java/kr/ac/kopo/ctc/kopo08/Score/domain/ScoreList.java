package kr.ac.kopo.ctc.kopo08.Score.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class ScoreList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	private String name;
	private int studentid;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	@JsonBackReference
	// fetch=FetchType.EAGER LAZY                                                                                                                                                                                                                                                                         
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="scoreList")
	private List<ScoreItem> scoreItems;
	
	public List<ScoreItem> getScoreItems() {
		if (scoreItems == null) {
			scoreItems = new ArrayList<ScoreItem>();
		}
		return scoreItems;
	}
	
	public void setScoreItems(List<ScoreItem> scoreItems) {
		this.scoreItems = scoreItems;
	}
	
	public void addScoreItems(ScoreItem s) {
		List<ScoreItem> scoreItems = getScoreItems();
		scoreItems.add(s);
	}

	@Override
	public String toString() {
		String result = "["+id+"]" + name;
		for(ScoreItem s : getScoreItems()) {
			result += "\n" + s.toString();
		}
		return result;
	}
	
}
