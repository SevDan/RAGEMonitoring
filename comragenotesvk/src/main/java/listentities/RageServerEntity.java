package listentities;

import java.io.Serializable;

public class RageServerEntity implements Comparable<RageServerEntity>, Serializable {
    private static final long serialVersionUID = 1;

    private String fullAddress;
    private RageServerAttributesEntity entity;

    public RageServerEntity () { }

    public RageServerEntity(String fullAddress, RageServerAttributesEntity entity) {
        this.fullAddress = fullAddress;
        this.entity = entity;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public RageServerAttributesEntity getEntity() {
        return entity;
    }

    public void setEntity(RageServerAttributesEntity entity) {
        this.entity = entity;
    }

    @Override
    public int compareTo(RageServerEntity o) {
        return Integer.compare(o.entity.getPlayers(), this.entity.getPlayers());
    }
}
