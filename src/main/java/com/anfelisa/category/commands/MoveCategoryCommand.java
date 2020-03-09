package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class MoveCategoryCommand extends AbstractMoveCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryCommand.class);

	public MoveCategoryCommand(ICategoryMoveData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IUserAccessToCategoryModel accessToMovedCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle,  commandData.getMovedCategoryId(), commandData.getUserId());
		if (accessToMovedCategory == null || accessToMovedCategory.getEditable() == false) {
			throwUnauthorized();
		}
		IUserAccessToCategoryModel accessToTargetCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle,  commandData.getTargetCategoryId(), commandData.getUserId());
		if (accessToTargetCategory == null || accessToTargetCategory.getEditable() == false) {
			throwUnauthorized();
		}

		ICategoryModel movedCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, 
				commandData.getMovedCategoryId());

		ICategoryModel targetCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, 
				commandData.getTargetCategoryId());

		if (movedCategory == null || targetCategory == null) {
			throwBadRequest("categories must not be null");
		}

		if (!movedCategory.getRootCategoryId().equals(targetCategory.getRootCategoryId())) {
			throwBadRequest("categories must be in same root category");
		}
		
		if (targetCategory.getCategoryId().equals(movedCategory.getCategoryId())) {
			throwBadRequest("cannot move category to itself");
		}

		if (isChildOf(movedCategory, targetCategory, readonlyHandle)) {
			throwBadRequest("cannot move category to one of its children");
		}
		
		if (targetCategory.getCategoryId().equals(movedCategory.getParentCategoryId())) {
			commandData.setOutcome(noMove);
		} else {
			this.commandData.setCategoryIndexWhereRemoved(movedCategory.getCategoryIndex());
			this.commandData.setParentCategoryIdWhereRemoved(movedCategory.getParentCategoryId());

			Integer cardIndexInTargetCategory = this.daoProvider.getCardDao().selectMaxIndexInCategory(readonlyHandle, 
					commandData.getTargetCategoryId());
			if (cardIndexInTargetCategory == null) {
				cardIndexInTargetCategory = 0;
			} else {
				cardIndexInTargetCategory++;
			}
			movedCategory.setCategoryIndex(cardIndexInTargetCategory);
			movedCategory.setParentCategoryId(this.commandData.getTargetCategoryId());

			this.commandData.setMovedCategory(movedCategory);

			this.commandData.setOutcome(ok);
		}
	}

	private boolean isChildOf(ICategoryModel parent, ICategoryModel child, PersistenceHandle readonlyHandle) {
		if (child.getParentCategoryId() == null) {
			return false;
		}
		if (child.getParentCategoryId().equals(parent.getCategoryId())) {
			return true;
		}
		return isChildOf(parent, this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, 
				child.getParentCategoryId()), readonlyHandle);
	}

}

/* S.D.G. */
