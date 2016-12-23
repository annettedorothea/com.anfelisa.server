package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.data.UserCreationData;
import com.anfelisa.user.data.UserUpdateData;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.UserDao;

public class UserView {

	public BiConsumer<UserCreationData, Handle> createUser = (dataContainer, handle) -> {
		UserDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<UserUpdateData, Handle> updateUser = (dataContainer, handle) -> {
		CustomUserDao.update(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<AddCoursesData, Handle> addCourses = (dataContainer, handle) -> {
		CustomUserDao.addCoursesToUser(handle, dataContainer, dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
