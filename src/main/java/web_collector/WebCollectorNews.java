package web_collector;

import cn.edu.hfut.dmic.contentextractor.News;

public class WebCollectorNews extends News {


    private String source="";
    private String MK="";
    private String charset="";
    private String oilField = "";
    private String siteSource="";
    private String Output="";
    private String oil="";
    private String company="";
    private String basin="";
    private String contentWithP="";
    private String html="";
    private int webWeight;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getOilField() {
        return oilField;
    }

    public void setOilField(String oilField) {
        this.oilField = oilField;
    }

    public String getSiteSource() {
        return siteSource;
    }

    public void setSiteSource(String siteSource) {
        this.siteSource = siteSource;
    }

    public String getOutput() {
        return Output;
    }

    public void setOutput(String output) {
        Output = output;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBasin() {
        return basin;
    }

    public void setBasin(String basin) {
        this.basin = basin;
    }

    public String getContentWithP() {
        return contentWithP;
    }

    public void setContentWithP(String contentWithP) {
        this.contentWithP = contentWithP;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getWebWeight() {
        return webWeight;
    }

    public void setWebWeight(int webWeight) {
        this.webWeight = webWeight;
    }
}
