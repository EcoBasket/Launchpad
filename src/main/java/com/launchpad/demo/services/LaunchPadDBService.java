package com.launchpad.demo.services;

import com.launchpad.demo.models.dynamodb.LaunchPadDB;

import java.util.Collection;
import java.util.Optional;

public interface LaunchPadDBService {

    Optional<LaunchPadDB> getLaunchPadItem(String id);

    Collection<LaunchPadDB> getAllLaunchPadItems();

    LaunchPadDB createLaunchPadItem(LaunchPadDB launchPadDB);

    void deleteLaunchPadItem(String id);

    LaunchPadDB updateLaunchPadItem(LaunchPadDB launchPadDB);
}
