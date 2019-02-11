/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IChangeUserRoleData;
import com.anfelisa.user.data.IDeleteUserData;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

@SuppressWarnings("all")
public interface IUserView {

	void registerUser(IUserRegistrationData data, Handle handle);
	void confirmEmail(IConfirmEmailData data, Handle handle);
	void changeUserRole(IChangeUserRoleData data, Handle handle);
	void deleteUser(IDeleteUserData data, Handle handle);
	void resetPassword(IResetPasswordWithNewPasswordData data, Handle handle);

}




/******* S.D.G. *******/



