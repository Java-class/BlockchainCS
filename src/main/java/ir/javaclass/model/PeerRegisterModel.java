package ir.javaclass.model;

public class PeerRegisterModel {
    private String publicKey;
    private String privateKey;
    private String availableRange;
    private long totalSpace;
    private int maxUserCount;
    private long maxBandwidth;
    private int upTimePercentage;
    private String url;

    public PeerRegisterModel(String publicKey, String privateKey, String availableRange, long totalSpace, int maxUserCount, long maxBandwidth, int upTimePercentage, String url) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.availableRange = availableRange;
        this.totalSpace = totalSpace;
        this.maxUserCount = maxUserCount;
        this.maxBandwidth = maxBandwidth;
        this.upTimePercentage = upTimePercentage;
        this.url = url;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAvailableRange() {
        return availableRange;
    }

    public void setAvailableRange(String availableRange) {
        this.availableRange = availableRange;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public int getMaxUserCount() {
        return maxUserCount;
    }

    public void setMaxUserCount(int maxUserCount) {
        this.maxUserCount = maxUserCount;
    }

    public long getMaxBandwidth() {
        return maxBandwidth;
    }

    public void setMaxBandwidth(long maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }

    public int getUpTimePercentage() {
        return upTimePercentage;
    }

    public void setUpTimePercentage(int upTimePercentage) {
        this.upTimePercentage = upTimePercentage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
