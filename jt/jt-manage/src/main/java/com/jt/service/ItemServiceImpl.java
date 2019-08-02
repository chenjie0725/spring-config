package com.jt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.vo.EasyUI_Table;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public EasyUI_Table findItemByPage(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		Integer count = itemMapper.selectCount(null);
		Integer start = (page-1)*rows;
		List<Item> itemlList = itemMapper.selectByPage(start,rows);
		
		return new EasyUI_Table(count,itemlList);
	}

	@Transactional
	@Override
	public void saveItem(Item item) {
		item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());
		itemMapper.insert(item);
	}

	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub
		item.setUpdated(new Date());
		itemMapper.updateById(item);
	}
	
	
	
	
	
	
	
}
