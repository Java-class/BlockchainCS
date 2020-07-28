package entity;

import org.web3j.tuples.generated.Tuple10;

import java.math.BigInteger;

public class Peer {
    private int id;
    private String public_address;
    private long totalSpace;
    private long maxBandwidth;
    private int maxUser;
    private int uptimePercentage;
    private String availableTimeRange;
    private String description;
    private String date;
    private PeerStatus status;

    public Peer(Tuple10<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger, String, String, String, BigInteger> value) {
        this.id = value.component1().intValue();
        this.public_address = value.component2();
        this.totalSpace = value.component3().longValue();
        this.maxBandwidth = value.component4().longValue();
        this.maxUser = value.component5().intValue();
        this.uptimePercentage = value.component6().intValue();
        this.availableTimeRange = value.component7();
        this.description = value.component8();
        this.date = value.component9();
        this.status = PeerStatus.toEnum(value.component10().intValue());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublic_address() {
        return public_address;
    }

    public void setPublic_address(String public_address) {
        this.public_address = public_address;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Peer{" +
                "id=" + id +
                ", public_address='" + public_address + '\'' +
                ", totalSpace=" + totalSpace +
                ", maxBandwidth=" + maxBandwidth +
                ", maxUser=" + maxUser +
                ", uptimePercentage=" + uptimePercentage +
                ", availableTimeRange='" + availableTimeRange + '\'' +
                ", description='" + description + '\'' +
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

