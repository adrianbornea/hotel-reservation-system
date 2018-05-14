public class Room {

    private String roomName;
    private double roomPrice;
    private boolean roomStatus;

    public Room() {

    }

    public Room(String roomName, double roomPrice, boolean roomStatus) {
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.roomStatus = roomStatus;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public boolean isItAvailable() {
        if (this.roomStatus) {
            return true;
        } else {
            return false;
        }
    }

    public double getRoomPrice() {
        return this.roomPrice;
    }

}
