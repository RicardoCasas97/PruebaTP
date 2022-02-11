
package com.example.pruebatp.Entidades;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrayReference {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("aliasbank")
    @Expose
    private String aliasbank;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAliasbank() {
        return aliasbank;
    }

    public void setAliasbank(String aliasbank) {
        this.aliasbank = aliasbank;
    }

}
