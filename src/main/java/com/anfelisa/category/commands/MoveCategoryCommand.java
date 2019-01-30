package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class MoveCategoryCommand extends AbstractMoveCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryCommand.class);

	public MoveCategoryCommand(ICategoryMoveData actionData, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(actionData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IUserAccessToCategoryModel accessToMovedCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(getHandle(), commandData.getMovedCategoryId(), commandData.getUserId());
		if (accessToMovedCategory == null) {
			throwUnauthorized();
		}
		IUserAccessToCategoryModel accessToTargetCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(getHandle(), commandData.getTargetCategoryId(), commandData.getUserId());
		if (accessToTargetCategory == null) {
			throwUnauthorized();
		}

		ICategoryModel movedCategory = this.daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getMovedCategoryId());

		ICategoryModel targetCategory = this.daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
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

		if (isChildOf(movedCategory, targetCategory)) {
			throwBadRequest("cannot move category to one of its children");
		}
		
		if (targetCategory.getCategoryId().equals(movedCategory.getParentCategoryId())) {
			commandData.setOutcome(noMove);
		} else {
			this.commandData.setCategoryIndexWhereRemoved(movedCategory.getCategoryIndex());
			this.commandData.setParentCategoryIdWhereRemoved(movedCategory.getParentCategoryId());

			Integer cardIndexInTargetCategory = this.daoProvider.getCardDao().selectMaxIndexInCategory(getHandle(),
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

	private boolean isChildOf(ICategoryModel parent, ICategoryModel child) {
		if (child.getParentCategoryId() == null) {
			return false;
		}
		if (child.getParentCategoryId().equals(parent.getCategoryId())) {
			return true;
		}
		return isChildOf(parent, this.daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				child.getParentCategoryId()));
	}

}

/* S.D.G. */
