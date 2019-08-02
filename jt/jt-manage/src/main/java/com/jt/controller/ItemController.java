package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.service.ItemService;
import com.jt.vo.EasyUI_Table;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/query")
//	@ResponseBody
	public EasyUI_Table findItemByPage(Integer page,Integer rows) {
		return itemService.findItemByPage(page,rows);
	}
	@RequestMapping("/save")
//	@ResponseBody
	public SysResult saveItem(Item item) {
		try {
			itemService.saveItem(item);
			return SysResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.fail();
		}
	}
	@RequestMapping("update")
	public SysResult updateitem(Item item) {
		itemService.update(item);
		return SysResult.success();
	}
}
