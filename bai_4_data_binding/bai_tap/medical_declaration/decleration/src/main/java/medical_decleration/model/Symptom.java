package medical_decleration.model;

public class Symptom {
    private Boolean sot;
    private Boolean ho;
    private Boolean khoTho;
    private Boolean dauHong;
    private Boolean non;
    private Boolean tieuChay;
    private Boolean xuatHuyet;
    private Boolean noiBan;

    public Symptom() {
    }

    public Symptom(Boolean sot, Boolean non) {
        this.sot = sot;
        this.non = non;
    }

    public Symptom(Boolean sot, Boolean ho, Boolean khoTho, Boolean dauHong, Boolean non, Boolean tieuChay, Boolean xuatHuyet, Boolean noiBan) {
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.dauHong = dauHong;
        this.non = non;
        this.tieuChay = tieuChay;
        this.xuatHuyet = xuatHuyet;
        this.noiBan = noiBan;
    }

    public Boolean getSot() {
        return sot;
    }

    public void setSot(Boolean sot) {
        this.sot = sot;
    }

    public Boolean getHo() {
        return ho;
    }

    public void setHo(Boolean ho) {
        this.ho = ho;
    }

    public Boolean getKhoTho() {
        return khoTho;
    }

    public void setKhoTho(Boolean khoTho) {
        this.khoTho = khoTho;
    }

    public Boolean getDauHong() {
        return dauHong;
    }

    public void setDauHong(Boolean dauHong) {
        this.dauHong = dauHong;
    }

    public Boolean getNon() {
        return non;
    }

    public void setNon(Boolean non) {
        this.non = non;
    }

    public Boolean getTieuChay() {
        return tieuChay;
    }

    public void setTieuChay(Boolean tieuChay) {
        this.tieuChay = tieuChay;
    }

    public Boolean getXuatHuyet() {
        return xuatHuyet;
    }

    public void setXuatHuyet(Boolean xuatHuyet) {
        this.xuatHuyet = xuatHuyet;
    }

    public Boolean getNoiBan() {
        return noiBan;
    }

    public void setNoiBan(Boolean noiBan) {
        this.noiBan = noiBan;
    }
}
