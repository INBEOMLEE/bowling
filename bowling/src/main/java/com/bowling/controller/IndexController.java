package com.bowling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	@RequestMapping("/bowling")
	public String index() {
		log.info("##### 인덱스 페이지 출력");
		return "index";
	}
}
