package com.phodu.tambola.profile.manage;

import com.phodu.tambola.profile.Profile;
import com.phodu.tambola.profile.data.ProfileDAO;

public class ProfileManagementService {
	private static ProfileDAO profileRepository = new ProfileDAO();
	
	public long createProfile() {
		Profile profile = new Profile();
		profileRepository.create(profile);
		return profile.getId();
	}
	
	public Profile loadProfile(long id) {
		return profileRepository.load(id);
	}

}
