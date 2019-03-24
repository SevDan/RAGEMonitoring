package listentities;

import java.io.Serializable;

public class RageServerAttributesEntity implements Serializable {
    private static final long serialVersionUID = 1;

    private String name;
    private String gamemode;

    private String url;
    private String lang;
    private boolean voiceChat;
    private int resourcesWeight;
    private int players;
    private int peak;
    private int maxplayers;
    private int[] playersHistory;

    public RageServerAttributesEntity() { }

    public RageServerAttributesEntity(String name, String gamemode, String url, String lang, boolean voiceChat, int resourcesWeight, int players, int peak, int maxplayers, int[] playersHistory) {
        this.name = name;
        this.gamemode = gamemode;
        this.lang = lang;
        this.voiceChat = voiceChat;
        this.resourcesWeight = resourcesWeight;
        this.players = players;
        this.peak = peak;
        this.maxplayers = maxplayers;
        this.playersHistory = playersHistory;
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setVoiceChat(boolean voiceChat) {
        this.voiceChat = voiceChat;
    }

    public void setResourcesWeight(int resourcesWeight) {
        this.resourcesWeight = resourcesWeight;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public void setPeak(int peak) {
        this.peak = peak;
    }

    public void setMaxplayers(int maxplayers) {
        this.maxplayers = maxplayers;
    }

    public void setPlayersHistory(int[] playersHistory) {
        this.playersHistory = playersHistory;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getGamemode() {
        return gamemode;
    }

    public String getLang() {
        return lang;
    }

    public boolean isVoiceChat() {
        return voiceChat;
    }

    public int getResourcesWeight() {
        return resourcesWeight;
    }

    public int getPlayers() {
        return players;
    }

    public int getPeak() {
        return peak;
    }

    public int getMaxplayers() {
        return maxplayers;
    }

    public int[] getPlayersHistory() {
        return playersHistory;
    }


}
