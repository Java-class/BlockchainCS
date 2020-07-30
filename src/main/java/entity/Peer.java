package entity;

import org.web3j.tuples.generated.Tuple11;

import java.math.BigInteger;
import java.util.Date;

public class Peer {
    private int id;
    private String owner;
    private String url;
    private long totalSpace;
    private long usedSpace;
    private long maxBandwidth;
    private int maxUser;
    private int uptimePercentage;
    private String availableTimeRange;
    private String date;
    private PeerStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public long getMaxBandwidth() {
        return maxBandwidth;
    }

    public void setMaxBandwidth(long maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }

    public int getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(int maxUser) {
        this.maxUser = maxUser;
    }

    public int getUptimePercentage() {
        return uptimePercentage;
    }

    public void setUptimePercentage(int uptimePercentage) {
        this.uptimePercentage = uptimePercentage;
    }

    public String getAvailableTimeRange() {
        return availableTimeRange;
    }

    public void setAvailableTimeRange(String availableTimeRange) {
        this.availableTimeRange = availableTimeRange;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PeerStatus getStatus() {
        return status;
    }

    public void setStatus(PeerStatus status) {
        this.status = status;
    }



    public Peer(Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> value) {
        this.id = value.component1().intValue();
        this.owner = value.component2();
        this.url = value.component3();
        this.totalSpace = value.component4().longValue();
        this.usedSpace = value.component5().longValue();
        this.maxBandwidth = value.component6().longValue();
        this.maxUser = value.component7().intValue();
        this.uptimePercentage = value.component8().intValue();
        this.availableTimeRange = value.component9();
        this.date = value.component10();
        this.status = PeerStatus.toEnum(value.component11().intValue());
    }

    public Peer(String url, long totalSpace, long maxBandwidth, int maxUser, int uptimePercentage, String availableTimeRange) {
        this.url = url;
        this.totalSpace = totalSpace;
        this.maxBandwidth = maxBandwidth;
        this.maxUser = maxUser;
        this.uptimePercentage = uptimePercentage;
        this.availableTimeRange = availableTimeRange;
        date = new Date().toString();
    }

    @Override
    public String toString() {
        return "Peer{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", url='" + url + '\'' +
                ", totalSpace=" + totalSpace +
                ", usedSpace=" + usedSpace +
                ", maxBandwidth=" + maxBandwidth +
                ", maxUser=" + maxUser +
                ", uptimePercentage=" + uptimePercentage +
                ", availableTimeRange='" + availableTimeRange + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }

    public enum PeerStatus{
        ACTIVE,
        BLOCKED,
        SUSPENDED;

        public static PeerStatus toEnum(int id){
          if(id==1)
              return ACTIVE;
          else if(id==2)
              return BLOCKED;
          else
              return SUSPENDED;
        }
    }
}

