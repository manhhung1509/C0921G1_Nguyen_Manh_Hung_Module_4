package medical_decleration.model;

public class TravelInformation {
    String vehicle;
    String vehicleNumber;
    String seatNumber;
    String dateStart;
    String dateEnd;
    String destination;

    public TravelInformation() {
    }

    public TravelInformation(String vehicle, String vehicleNumber, String seatNumber, String dateStart, String dateEnd, String destination) {
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.destination = destination;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
