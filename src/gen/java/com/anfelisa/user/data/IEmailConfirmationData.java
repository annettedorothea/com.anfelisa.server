package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IEmailConfirmationModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=EmailConfirmationData.class)
public interface IEmailConfirmationData extends IEmailConfirmationModel, IDataContainer {

}

/*       S.D.G.       */
