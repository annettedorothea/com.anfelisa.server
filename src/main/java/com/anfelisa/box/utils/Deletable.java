package com.anfelisa.box.utils;

import java.util.List;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IMinimalBoxModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class Deletable {

	private static boolean atLeastOneUserHasWriteAccess(List<IUserAccessToCategoryModel> accesses) {
		if (accesses.size() == 0) {
			return false;
		}
		for (IUserAccessToCategoryModel access : accesses) {
			if (access.getEditable()) {
				return true;
			}
		}
		return false;
	}

	private static boolean atLeastOneUserHasReadAccess(List<IUserAccessToCategoryModel> accesses) {
		if (accesses.size() == 0) {
			return false;
		}
		for (IUserAccessToCategoryModel access : accesses) {
			if (!access.getEditable()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBoxDeletable(IDaoProvider daoProvider, PersistenceHandle readonlyHandle,
			IMinimalBoxModel box, String userId) {
		List<IUserAccessToCategoryModel> otherUsersWithAccess = daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndNotMine(readonlyHandle, box.getCategoryId(), userId);
		if (box.getReverse()) {
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
			IBoxModel box) {
		if (box.getReverse()) {
			return false;
		}
		List<IUserAccessToCategoryModel> otherUsersWithAccess = daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndNotMine(readonlyHandle, box.getCategoryId(), box.getUserId());
		return otherUsersWithAccess.size() == 0;
	}

}
