package org.debasish.infinite.messenger.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.debasish.infinite.messenger.dao.ProfileDaoImpl;
import org.debasish.infinite.messenger.model.Profile;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileServiceImpl {
	
	ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();

	@GET
	public List<Profile> getProfiles() {
		return profileDaoImpl.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileDaoImpl.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileDaoImpl.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileDaoImpl.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		profileDaoImpl.removeProfile(profileName);
	}
}
