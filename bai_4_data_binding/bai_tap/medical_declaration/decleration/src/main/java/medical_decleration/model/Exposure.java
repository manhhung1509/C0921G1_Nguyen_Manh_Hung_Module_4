package medical_decleration.model;

public class Exposure {
    private Boolean tiepXucDongVat;
    private Boolean tiepXucBenhNhan;

    public Exposure() {
    }

    public Exposure(Boolean tiepXucDongVat, Boolean tiepXucBenhNhan) {
        this.tiepXucDongVat = tiepXucDongVat;
        this.tiepXucBenhNhan = tiepXucBenhNhan;
    }

    public Boolean getTiepXucDongVat() {
        return tiepXucDongVat;
    }

    public void setTiepXucDongVat(Boolean tiepXucDongVat) {
        this.tiepXucDongVat = tiepXucDongVat;
    }

    public Boolean getTiepXucBenhNhan() {
        return tiepXucBenhNhan;
    }

    public void setTiepXucBenhNhan(Boolean tiepXucBenhNhan) {
        this.tiepXucBenhNhan = tiepXucBenhNhan;
    }
}
