package Implementation;

import Model.Enum.TierType;
import Model.GoldUser;
import Model.PlatinumUser;
import Model.SilverUser;
import Model.User;

class UserFactory {
    public static User createUser(String username, String password, TierType tier) {
        return switch (tier) {
            case PLATINUM -> new PlatinumUser(username, password);
            case GOLD -> new GoldUser(username, password);
            case SILVER -> new SilverUser(username, password);
            default -> throw new IllegalArgumentException("Invalid user tier: " + tier);
        };
    }
}
