package com.bowling.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BowlingDAO {
	@Inject 
	private SqlSession sqlSession;

	public void setScore(int curPins) {
		sqlSession.insert("bowling.insert", curPins);
	}
	
}
