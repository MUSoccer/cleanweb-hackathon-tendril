package com.tendril.cleanweb.server.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.tendril.cleanweb.domain.CostAndConsumption;
import com.tendril.cleanweb.domain.Fight;
import com.tendril.cleanweb.domain.tendril.TendrilLocation;
import com.tendril.cleanweb.server.GenabilityClient;
import com.tendril.cleanweb.server.TendrilClient;

@Path("/fight")
public class FightResource {

	@Inject
	GenabilityClient genabilityClient;

	@Inject
	TendrilClient tendrilClient;

	@GET
	public Fight fight(@HeaderParam("custom-auth") String auth,
			@QueryParam("zipcode") String zipCode) {
		TendrilLocation tendrilLocation = new TendrilLocation();
		tendrilLocation.setPostalCode("80301");
		// TendrilLocation tendrilLocation = tendrilClient.getLocation(auth);

		CostAndConsumption costAndConsumption = new CostAndConsumption();
		// CostAndConsumption costAndConsumption =
		// tendrilClient.getConsumption(auth);

		Fight fight = new Fight();
		// fight.setLocalScore(genabilityClient.getCost(
		// tendrilLocation.getPostalCode(), costAndConsumption));
		// fight.setComparisonScore(genabilityClient.getCost(zipCode,
		// costAndConsumption));

		return fight;
	}

}
