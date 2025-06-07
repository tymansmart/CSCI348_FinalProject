
public interface RoomState {
	
	public String checkStatus(); // method to check the status of a room
	public void cleanRoom(Room room); // method to clean a room
	public void checkIn(Room room);// method to check into a room
	public void checkOut(Room room);// method to check out of a room

}
