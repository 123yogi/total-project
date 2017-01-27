package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChairService
{
	@Autowired
	private ChairDao chairDao;
	public void addChair(Chair chair)
	{
		chairDao.addChair(chair);
	}
	public List getAllChairs()
	{
		return chairDao.getAllChairs();
	}
	public int deleteChair(int id)
	{
		return chairDao.deleteChair(id);
	}
	public int updateChair(Chair chair) 
	{
			return chairDao.updateChair(chair);
	}
	public Chair getSingleChair(int id){
		return chairDao.getSingleChair(id);
	}
}
