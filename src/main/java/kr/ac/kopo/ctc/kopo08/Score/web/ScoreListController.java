package kr.ac.kopo.ctc.kopo08.Score.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo08.Score.domain.ScoreList;
import kr.ac.kopo.ctc.kopo08.Score.repository.ScoreListRepository;
import kr.ac.kopo.ctc.kopo08.Score.service.ScoreListService;

@Controller
public class ScoreListController {

	@Autowired
	private ScoreListRepository scoreListRepository;
	
	@Autowired
	private ScoreListService scoreListService;

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/ScoreList/AllView";
	}
	
	@RequestMapping(value = "/ScoreList/InputForm1")
	public String inputForm1() {
		return "InputForm1";
	}
	
	@RequestMapping(value = "/ScoreList/AllView")
	public String allView(Model model, @PageableDefault(size=5) Pageable pageable, 
			@RequestParam(value="page", defaultValue="-1") int currentPage) {
		if (currentPage >= 0) {
			pageable = PageRequest.of(currentPage, 5);
		}
		Page<ScoreList> page = scoreListService.findAll(pageable);
		List<ScoreList> pageToList = page.getContent();
		
		model.addAttribute("scoreList", pageToList);
		model.addAttribute("p", scoreListService.getPagination(pageable.getPageNumber() + 1, 5, pageable.getPageSize(), scoreListRepository.findAll().size()));
		return "AllView";
	}
	
	@RequestMapping(value = "/ScoreList/Insert", method = RequestMethod.POST)
	public String insert(Model model, HttpServletRequest request) {
		ScoreList scoreList = new ScoreList();
		scoreList.setName(request.getParameter("name"));
		scoreList.setStudentid(scoreListService.autoSaveStudentId());
		scoreListRepository.save(scoreList);
		return "redirect:/ScoreList/AllView";
	}
	
	@RequestMapping(value = "/ScoreList/OneView")
	public String requestParam(Model model, @RequestParam(value="id") Long id) {
		List<ScoreItem> items = scoreListRepository.findOneById(id).getScoreItems();
		model.addAttribute("scoreList", items);
		model.addAttribute("get_list", scoreListRepository.findOneById(id));
		return "OneView";
	}
	
	@PostMapping(value = "/ScoreList/Update")
	public String update(HttpServletRequest request) {
		ScoreList updateList = new ScoreList();
		updateList.setId(Long.parseLong(request.getParameter("id")));
		updateList.setName(request.getParameter("name"));
		updateList.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		scoreListRepository.save(updateList);
		return "redirect:/ScoreList/AllView";
	}
	
	@RequestMapping(value = "/ScoreList/Update")
	public String confirm(Model model, @RequestParam(value="id") Long id) {
		ScoreList getList = scoreListRepository.findById(id).get();
		model.addAttribute("getList", getList);
		return "InputForm2";
	}
	
 	@RequestMapping(value = "/ScoreList/Delete")
 	@Transactional
	public String delete(Model model, @RequestParam(value = "id") Long id) {
		scoreListRepository.deleteById(id);
		return "redirect:/ScoreList/AllView";
	}

 	@RequestMapping(value = "/ScoreList/ShowRec")
 	public String showRec(Model model, @RequestParam(value = "search") Integer studentid) {
 		ScoreList scoreList = null;
 		ScoreList findList = null;
 		List<ScoreItem> studentInfo = null;
 		try {
 			scoreList = scoreListRepository.findByStudentid(studentid);
 			studentInfo = scoreList.getScoreItems();
 		} catch (Exception e) {
 			scoreList = null;
 			studentInfo = null;
 			findList = scoreListService.findStudentId(studentid);
 			model.addAttribute("scoreList", scoreList);
 			model.addAttribute("studentInfo", studentInfo);
 			model.addAttribute("studentId", studentid);
 			model.addAttribute("findList", findList);
 			return "ShowRec";
 		}
 		findList = scoreListService.findStudentId(studentid);
 		model.addAttribute("scoreList", scoreList);
 		model.addAttribute("studentInfo", studentInfo);
 		model.addAttribute("studentId", studentid);
 		model.addAttribute("findList", findList);
 		return "ShowRec";
 	}
}
