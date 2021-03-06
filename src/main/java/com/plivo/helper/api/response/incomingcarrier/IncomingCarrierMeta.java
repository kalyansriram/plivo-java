package com.plivo.helper.api.response.incomingcarrier;

import com.google.gson.annotations.SerializedName;

public class IncomingCarrierMeta {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public IncomingCarrierMeta() {
        // empty
    }

}