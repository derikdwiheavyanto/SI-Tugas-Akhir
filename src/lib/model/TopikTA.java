package lib.model;

import java.io.ObjectInputFilter;
import lib.Status;

/**
 * *********************************************************************
 * Module: TopikTA.java Author: ASUS Purpose: Defines the Class TopikTA
 **********************************************************************
 */
public class TopikTA {

    public String topik;
    public Status status;
    public String jadwalSidang;

    /**
     *
     * @param topikTA
     */
    public TopikTA(String topikTA) {
        topik = topikTA;
        status = Status.BelumMengajukan;
    }

}

