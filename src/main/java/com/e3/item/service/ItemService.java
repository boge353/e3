package com.e3.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.cart.mapper.TbItemMapper;
import com.e3.cart.pojo.TbItem;
@Service
public class ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	
	public TbItem getItemById(Long itemId) {
		return tbItemMapper.selectByPrimaryKey(itemId);
	}
	

}
