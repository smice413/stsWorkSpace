package board1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board1.model.Board;
import board1.model.ReplyBoard;
import board1.service.BoardService;
import board1.service.ReplyBoardService;

@Controller
public class ReplyBoardController {
	@Autowired
	private ReplyBoardService rbs;
	@Autowired
	private BoardService bs;

	@RequestMapping("/slist/num/{num}")	// 댓글 목록 구하기
	public String slist(@PathVariable int num, Model model) {
		Board board = bs.select(num);			// 부모글의 상세정보
		List<ReplyBoard> slist = rbs.list(num); // 댓글 목록
		model.addAttribute("slist", slist);
		model.addAttribute("board", board);
		return "slist";
	}

	@RequestMapping("/sInsert")			// 댓글 입력
	public String sInsert(ReplyBoard rb, Model model) {
		rbs.insert(rb);					// 댓글 입력 완료
		return "redirect:slist/num/" + rb.getBno();
	}

	@RequestMapping("/repDelete")		// 댓글 삭제
	public String delete(ReplyBoard rb, Model model) {
		rbs.delete(rb.getRno());		// 댓글 삭제 완료
		return "redirect:slist/num/" + rb.getBno(); //hidden을 통해 매개변수로 전달된 부모글 번호(rb.getBno())를 다시 댓글 목록 구하는 곳으로 보냄
	}

	@RequestMapping("/repUpdate")		// 댓글 내용 수정
	public String repUpdate(ReplyBoard rb, Model model) {
		rbs.update(rb);					// 댓글 내용 수정완료
		return "redirect:slist/num/" + rb.getBno(); // 댓글 수정후 댓글 목록 다시 요청
	}
}