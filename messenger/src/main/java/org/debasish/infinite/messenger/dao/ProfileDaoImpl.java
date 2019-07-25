package org.debasish.infinite.messenger.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.debasish.infinite.messenger.database.DatabaseClass;
import org.debasish.infinite.messenger.model.Profile;

public class ProfileDaoImpl {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileDaoImpl() {
		profiles.put("data1", new Profile(1, "facebook", "FirstName1", "LastName1"));
		profiles.put("data2", new Profile(2, "twitter", "FirstName2", "LastName2"));
	}
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());		
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}else {
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
}
