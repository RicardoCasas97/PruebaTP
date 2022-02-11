
package com.example.pruebatp.Entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("url3X3")
    @Expose
    private String url3X3;
    @SerializedName("url4X4")
    @Expose
    private String url4X4;
    @SerializedName("url5X5")
    @Expose
    private String url5X5;
    @SerializedName("url6X6")
    @Expose
    private String url6X6;
    @SerializedName("url7X7")
    @Expose
    private String url7X7;

    public String getUrl3X3() {
        return url3X3;
    }

    public void setUrl3X3(String url3X3) {
        this.url3X3 = url3X3;
    }

    public String getUrl4X4() {
        return url4X4;
    }

    public void setUrl4X4(String url4X4) {
        this.url4X4 = url4X4;
    }

    public String getUrl5X5() {
        return url5X5;
    }

    public void setUrl5X5(String url5X5) {
        this.url5X5 = url5X5;
    }

    public String getUrl6X6() {
        return url6X6;
    }

    public void setUrl6X6(String url6X6) {
        this.url6X6 = url6X6;
    }

    public String getUrl7X7() {
        return url7X7;
    }

    public void setUrl7X7(String url7X7) {
        this.url7X7 = url7X7;
    }

}
