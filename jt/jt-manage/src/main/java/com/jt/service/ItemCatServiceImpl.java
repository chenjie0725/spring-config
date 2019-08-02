package com.jt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUI_Tree;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Override
	public ItemCat findItemNameById(Long itemCatId) {
		ItemCat itemCat = itemCatMapper.selectById(itemCatId);
	
		return itemCat;
	}

	@Override
	public List<EasyUI_Tree> findItemCatByParentId(Long id) {
		List<EasyUI_Tree> treeList = new ArrayList<>();
	    List<ItemCat> itemCatList = 
	    		findItemCatList(id); 
		for(ItemCat itemCat:itemCatList) {
			Long itemId = itemCat.getId();
			String text = itemCat.getName();
			String state = itemCat.getIsParent()?"closed":"open";
			EasyUI_Tree tree = new EasyUI_Tree(itemId, text, state);
			treeList.add(tree);
		}
		return treeList;
	}

	public List<ItemCat> findItemCatList(Long id) {
		// TODO Auto-generated method stub
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("parent_id",id);
		return itemCatMapper.selectList(queryWrapper);
	}
	

}
