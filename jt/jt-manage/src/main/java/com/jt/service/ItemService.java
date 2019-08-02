package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.EasyUI_Table;

public interface ItemService {

	EasyUI_Table findItemByPage(Integer page, Integer rows);

	void saveItem(Item item);

	void update(Item item);
	
}
