package data.interfaces;

import java.util.Date;

public interface Expirable {
    Date getExpiryDate();
    void setExpiryDate(Date expiryDate);
}
