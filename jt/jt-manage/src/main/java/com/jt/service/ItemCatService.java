package com.jt.service;

import java.util.List;

import com.jt.pojo.Item;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUI_Tree;

public interface ItemCatService {

	ItemCat findItemNameById(Long itemCatId);

	List<EasyUI_Tree> findItemCatByParentId(Long id);



}
