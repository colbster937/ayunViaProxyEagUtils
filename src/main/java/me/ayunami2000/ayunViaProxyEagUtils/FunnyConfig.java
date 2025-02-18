package me.ayunami2000.ayunViaProxyEagUtils;

import com.viaversion.viaversion.util.Config;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class FunnyConfig extends Config {
    public static boolean premiumSkins = false;
    public static boolean eaglerSkins = true;
    public static boolean eaglerVoice = true;
    public static int eaglerServerMode = 0;

    public FunnyConfig(File configFile) {
        super(configFile, Logger.getLogger("FunnyConfig"));
        reload();
    }

    @Override
    public URL getDefaultConfigURL() {
        return getClass().getClassLoader().getResource("vpeagutils.yml");
    }

    @Override
    protected void handleConfig(Map<String, Object> config) {
        if (config == null || getValues() == null) {
            logger.severe("Config is null! This should not happen.");
            return;
        }

        premiumSkins = getBoolean("premium-skins", premiumSkins);
        eaglerSkins = getBoolean("eagler-skins", eaglerSkins);
        eaglerVoice = getBoolean("eagler-voice", eaglerVoice);
        eaglerServerMode = getInt("eagler-server-mode", eaglerServerMode);
    }

    @Override
    public List<String> getUnsupportedOptions() {
        return List.of();
    }
}
