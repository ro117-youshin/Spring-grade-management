package kr.ac.kopo.ctc.kopo08.Score.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;
import kr.ac.kopo.ctc.kopo08.Score.repository.ScoreItemRepository;
import kr.ac.kopo.ctc.kopo08.Score.repository.ScoreListRepository;


@Controller
public class ScoreItemController {
	
	@Autowired
	ScoreListRepository scoreListRepository;
	
	@Autowired
	ScoreItemRepository scoreItemRepository;
	
	
	@RequestMapping(value = "/ScoreItem/Insert")
	public String insert(Model model, @RequestParam(value="id") Long id) {
		model.addAttribute("listId", id);
		return "InputForm3";
	}
	
	@PostMapping(value = "/ScoreItem/Insert")
	public String insertForm(Model model, HttpServletRequest request) {
		ScoreItem insertItem = new ScoreItem();
		ScoreList insertParentList = scoreListRepository.findById(Long.parseLong(request.getParameter("listId"))).get();
		insertItem.setName(request.getParameter("name"));
		insertItem.setKor(Integer.parseInt(request.getParameter("kor")));
		insertItem.setEng(Integer.parseInt(request.getParameter("eng")));
		insertItem.setMat(Integer.parseInt(request.getParameter("mat")));
		insertItem.setScoreList(insertParentList);
		scoreItemRepository.save(insertItem);
		return "redirect:/ScoreList/OneView?id=" + insertParentList.getId();
	}
	
	@PostMapping(value = "/ScoreItem/Update")
	public String update(Model model, HttpServletRequest request) {
		ScoreItem updateItem = new ScoreItem();
		ScoreList insertParentList = scoreListRepository.findById(Long.parseLong(request.getParameter("listId"))).get();
		
		updateItem.setId(Long.parseLong(request.getParameter("id")));
		updateItem.setName(request.getParameter("name"));
		
		updateItem.setKor(Integer.parseInt(request.getParameter("kor")));
		updateItem.setEng(Integer.parseInt(request.getParameter("eng")));
		updateItem.setMat(Integer.parseInt(request.getParameter("mat")));
		updateItem.setScoreList(insertParentList);
		scoreItemRepository.save(updateItem);
		return "redirect:/ScoreList/OneView?id=" + insertParentList.getId();
	}
	
	@RequestMapping(value = "/ScoreItem/Update")
	public String confirm(Model model, @RequestParam(value="id") Long id) {
		ScoreItem getItem = scoreItemRepository.findById(id).get();
		model.addAttribute("getItem", getItem);
		return "InputForm4";
	}
	
 	@RequestMapping(value = "/ScoreItem/Delete")
	public String delete(Model model, @RequestParam(value = "id") Long id) {
 		ScoreList insertParentList = scoreItemRepository.findById(id).get().getScoreList();
		scoreItemRepository.deleteById(id);
		return "redirect:/ScoreList/OneView?id=" + insertParentList.getId();
	}
	
}
