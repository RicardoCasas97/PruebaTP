
package com.example.pruebatp.Entidades;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListaReferencias {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("arrayReferences")
    @Expose
    private List<ArrayReference> arrayReferences = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ArrayReference> getArrayReferences() {
        return arrayReferences;
    }

    public void setArrayReferences(List<ArrayReference> arrayReferences) {
        this.arrayReferences = arrayReferences;
    }

}
