package io.github.derec4.guests;

import java.io.*;
import java.util.*;

public class GuestListManager {
    private final File guestListFile;
    private final Set<UUID> guestUUIDs;

    public GuestListManager(Guests plugin) {
        this.guestListFile = new File(plugin.getDataFolder(), "guest-uuids.txt");
        this.guestUUIDs = new HashSet<>();
        loadGuestList();
    }

    private void loadGuestList() {
        if (!guestListFile.exists()) {
            try {
                guestListFile.getParentFile().mkdirs();
                guestListFile.createNewFile();
            } catch (IOException ignored) {
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(guestListFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    try {
                        guestUUIDs.add(UUID.fromString(line));
                    } catch (IllegalArgumentException ignored) {
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    private void saveGuestList() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(guestListFile))) {
            for (UUID uuid : guestUUIDs) {
                writer.write(uuid.toString());
                writer.newLine();
            }
        } catch (IOException ignored) {
        }
    }

    public boolean addGuest(UUID uuid) {
        if (guestUUIDs.add(uuid)) {
            saveGuestList();
            return true;
        }
        return false;
    }

    public boolean removeGuest(UUID uuid) {
        if (guestUUIDs.remove(uuid)) {
            saveGuestList();
            return true;
        }
        return false;
    }

    public boolean isGuest(UUID uuid) {
        return guestUUIDs.contains(uuid);
    }
}

