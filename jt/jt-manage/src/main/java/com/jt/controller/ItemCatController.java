package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.EasyUI_Tree;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/queryItemName")
//	@ResponseBody
	public String findItemCatName(Long itemCatId) {
		return itemCatService.findItemNameById(itemCatId).getName();
	}
	
	@RequestMapping("/list")
//	@ResponseBody
	public List<EasyUI_Tree> findItemCatByParentId
	(@RequestParam(name = "id",defaultValue = "0") Long id) {
		return itemCatService.findItemCatByParentId(id);
	}
	
	
}
