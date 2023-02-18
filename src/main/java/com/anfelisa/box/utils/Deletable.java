package com.anfelisa.box.utils;

import java.util.List;

import com.anfelisa.box.models.BoxModel;
import com.anfelisa.category.models.UserAccessToCategoryModel;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class Deletable {

	private static boolean atLeastOneUserHasWriteAccess(List<UserAccessToCategoryModel> accesses) {
		if (accesses.size() == 0) {
			return false;
		}
		for (UserAccessToCategoryModel access : accesses) {
			if (access.getEditable()) {
				return true;
			}
		}
		return false;
	}

	private static boolean atLeastOneUserHasReadAccess(List<UserAccessToCategoryModel> accesses) {
		if (accesses.size() == 0) {
			return false;
		}
		for (UserAccessToCategoryModel access : accesses) {
			if (!access.getEditable()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBoxDeletable(IDaoProvider daoProvider, PersistenceHandle readonlyHandle,
			String categoryId, Boolean reverse, String userId) {
		List<UserAccessToCategoryModel> otherUsersWithAccess = daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndNotMine(readonlyHandle, categoryId, userId);
		if (reverse) {
			return true;
		}
		if (Deletable.atLeastOneUserHasWriteAccess(otherUsersWithAccess)) {
			return true;
		} else {
			if (Deletable.atLeastOneUserHasReadAccess(otherUsersWithAccess)) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean onDeleteBoxDeleteCategory(IDaoProvider daoProvider, PersistenceHandle readonlyHandle,
			BoxModel box) {
		if (box.getReverse()) {
			return false;
		}
		List<UserAccessToCategoryModel> otherUsersWithAccess = daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndNotMine(readonlyHandle, box.getCategoryId(), box.getUserId());
		return otherUsersWithAccess.size() == 0;
	}

}
