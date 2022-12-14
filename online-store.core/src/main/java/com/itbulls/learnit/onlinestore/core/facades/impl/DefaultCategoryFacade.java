package com.itbulls.learnit.onlinestore.core.facades.impl;

import java.util.List;

import com.itbulls.learnit.onlinestore.core.facades.CategoryFacade;
import com.itbulls.learnit.onlinestore.persistence.dao.CategoryDao;
import com.itbulls.learnit.onlinestore.persistence.dao.impl.JpaCategoryDao;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.CategoryDtoToCategoryConverter;
import com.itbulls.learnit.onlinestore.persistence.entities.Category;

public class DefaultCategoryFacade implements CategoryFacade {
	
	private static DefaultCategoryFacade instance;
	
	private CategoryDao categoryDao = new JpaCategoryDao();
	private CategoryDtoToCategoryConverter categoryConverter = new CategoryDtoToCategoryConverter();

	public static synchronized DefaultCategoryFacade getInstance() {
		if (instance == null) {
			instance = new DefaultCategoryFacade();
		}
		return instance;
	}

	@Override
	public List<Category> getCategories() {
		return categoryConverter.convertCategoryDtosToCategories(categoryDao.getCategories());
	}

}
