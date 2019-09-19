package com.bowling.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bowling.service.BowlingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/bowling/*")
@Controller
public class BowlingController {
	
	@Inject
	private BowlingService service;
	
	@RequestMapping(value="/newgame", method=RequestMethod.GET)
	public String newGame() {
		log.info("##### 새로하기 페이지 출력");
		return "newgame";
	}
	
	@RequestMapping(value="/scoreboard", method=RequestMethod.POST)
	public String scoreBoard(int player, HttpServletRequest request, Model model) {
		log.info("##### 스코어보드 페이지 출력");
		
		service.setScoreboard(player);
		
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < player; i++) {
			list.add(request.getParameter("player_name_" + i));
		}
		
		model.addAttribute("player", player);
		model.addAttribute("list", list);
		
		return "scoreboard";
	}
	
	@ResponseBody
	@RequestMapping(value="/arrayReset", method = RequestMethod.POST)
	public void arrayReset() {
		service.arrayReset();
	}
	
	@ResponseBody
	@RequestMapping(value="/setScore", method = RequestMethod.POST)
	public void setScore(int curPlayer, int curFrame, int curRoll, int curPins) {
		service.setScore(curPlayer, curFrame, curRoll, curPins);
	}
	
	@ResponseBody
	@RequestMapping(value="/getFrameScore", method = RequestMethod.POST)
	public int[][] getFrameScore(int curPlayer) {
		return service.getFrameScore(curPlayer);
	}
	
	@ResponseBody
	@RequestMapping(value="/getFinalScore", method = RequestMethod.POST)
	public int getFinalScore(int curPlayer) {
		return service.getFinalScore(curPlayer);
	}
}
