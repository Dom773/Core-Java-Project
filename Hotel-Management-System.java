
import java.util.Scanner;

class Customer {
    String name;
    String address;
    String phone;
    String fromDate;
    String toDate;
    float paymentAdvance;
    int bookingId;
}

class Room {
    String ac;
    String type;
    String stype;
    int roomNumber;
    int rent;
    int status; // 0: Available, 1: Booked
    Customer cust = new Customer();

    // Method to add a room
    Room addRoom(int rno) {
        Room room = new Room();
        room.roomNumber = rno;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nType AC/Non-AC (A/N): ");
        room.ac = sc.next();
        System.out.print("\nType Comfort (S/N): ");
        room.type = sc.next();
        System.out.print("\nType Size (B/S): ");
        room.stype = sc.next();
        System.out.print("\nDaily Rent: ");
        room.rent = sc.nextInt();
        room.status = 0;

        System.out.println("\n Room Added Successfully!");
        return room;
    }

    // Method to search a room
    void searchRoom(int rno, Room[] rooms, int count) {
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (rooms[i].roomNumber == rno) {
                found = 1;
                System.out.println("Room Details");
                if (rooms[i].status == 1) {
                    System.out.println("\nRoom is Reserved");
                } else {
                    System.out.println("\nRoom is available");
                }
                displayRoom(rooms[i]);
                break;
            }
        }
        if (found == 0) {
            System.out.println("\nRoom not found");
        }
    }

    // Method to display room details
    void displayRoom(Room room) {
        System.out.println("\nRoom Number: " + room.roomNumber);
        System.out.println("Type AC/Non-AC: " + room.ac);
        System.out.println("Type Comfort: " + room.type);
        System.out.println("Type Size: " + room.stype);
        System.out.println("Rent: " + room.rent);
    }
}

class HotelMgmt extends Room {
    int count = 0;
    Room[] rooms = new Room[100];

    // Method for guest check-in
    void checkIn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Room number: ");
        int rno = sc.nextInt();
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (rooms[i].roomNumber == rno) {
                found = 1;
                if (rooms[i].status == 1) {
                    System.out.println("\nRoom is already Booked");
                    return;
                }
                System.out.print("\nEnter booking id: ");
                rooms[i].cust.bookingId = sc.nextInt();
                System.out.print("\nEnter Customer Name (First Name): ");
                rooms[i].cust.name = sc.next();
                System.out.print("\nEnter Address (only city): ");
                rooms[i].cust.address = sc.next();
                System.out.print("\nEnter Phone: ");
                rooms[i].cust.phone = sc.next();
                System.out.print("\nEnter From Date: ");
                rooms[i].cust.fromDate = sc.next();
                System.out.print("\nEnter To Date: ");
                rooms[i].cust.toDate = sc.next();
                System.out.print("\nEnter Advance Payment: ");
                rooms[i].cust.paymentAdvance = sc.nextFloat();
                rooms[i].status = 1;
                System.out.println("\nCustomer Checked-in Successfully..");
                break;
            }
        }
        if (found == 0) {
            System.out.println("\nRoom not found");
        }
    }

    // Method to display available rooms
    void getAvailRoom() {
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (rooms[i].status == 0) {
                displayRoom(rooms[i]);
                found = 1;
            }
        }
        if (found == 0) {
            System.out.println("\nAll rooms are reserved");
        }
    }

    // Method to search a customer
    void searchCustomer(String name) {
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (rooms[i].status == 1 && rooms[i].cust.name.equals(name)) {
                System.out.println("\nCustomer Name: " + rooms[i].cust.name);
                System.out.println("Room Number: " + rooms[i].roomNumber);
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("\nPerson not found.");
        }
    }

    // Method for guest check-out
    void checkOut(int rno) {
        int found = 0;
        int days;
        float billAmount;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            if (rooms[i].status == 1 && rooms[i].roomNumber == rno) {
                System.out.print("\nEnter Number of Days: ");
                days = sc.nextInt();
                billAmount = days * rooms[i].rent;

                System.out.println("\n#### CheckOut Details ####");
                System.out.println("Customer Name: " + rooms[i].cust.name);
                System.out.println("Room Number: " + rooms[i].roomNumber);
                System.out.println("Total Amount Due: " + billAmount);
                System.out.println("Advance Paid: " + rooms[i].cust.paymentAdvance);
                System.out.println("Total Payable: " + (billAmount - rooms[i].cust.paymentAdvance) + " only");
                rooms[i].status = 0;
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("\nRoom not found");
        }
    }

    // Method to display guest summary report
    void guestSummaryReport() {
        if (count == 0) {
            System.out.println("\nNo Guest in Hotel!");
        } else {
            for (int i = 0; i < count; i++) {
                if (rooms[i].status == 1) {
                    System.out.println("\nCustomer Name: " + rooms[i].cust.name);
                    System.out.println("Room Number: " + rooms[i].roomNumber);
                    System.out.println("Phone: " + rooms[i].cust.phone);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HotelMgmt hm = new HotelMgmt();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n######## Hotel Management #########");
            System.out.println("1. Manage Rooms");
            System.out.println("2. Check-In Room");
            System.out.println("3. Available Rooms");
            System.out.println("4. Search Customer");
            System.out.println("5. Check-Out Room");
            System.out.println("6. Guest Summary Report");
            System.out.println("7. Exit");
            System.out.print("\nEnter Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEnter Room Number: ");
                    int rno = sc.nextInt();
                    boolean roomExists = false;
                    for (int i = 0; i < hm.count; i++) {
                        if (hm.rooms[i].roomNumber == rno) {
                            roomExists = true;
                            break;
                        }
                    }
                    if (!roomExists) {
                        hm.rooms[hm.count] = new Room().addRoom(rno);
                        hm.count++;
                    } else {
                        System.out.println("\nRoom Number is already present. Please enter a unique number.");
                    }
                    break;
                case 2:
                    if (hm.count == 0) {
                        System.out.println("\nRooms data is not available. Please add the rooms first.");
                    } else {
                        hm.checkIn();
                    }
                    break;
                case 3:
                    if (hm.count == 0) {
                        System.out.println("\nRooms data is not available. Please add the rooms first.");
                    } else {
                        hm.getAvailRoom();
                    }
                    break;
                case 4:
                    if (hm.count == 0) {
                        System.out.println("\nRooms are not available. Please add the rooms first.");
                    } else {
                        System.out.print("Enter Customer Name: ");
                        String pname = sc.next();
                        hm.searchCustomer(pname);
                    }
                    break;
                case 5:
                    if (hm.count == 0) {
                        System.out.println("\nRooms are not available. Please add the rooms first.");
                    } else {
                        System.out.print("Enter Room Number: ");
                        int roomNum = sc.nextInt();
                        hm.checkOut(roomNum);
                    }
                    break;
                case 6:
                    hm.guestSummaryReport();
                    break;
                case 7:
                    System.out.println("\nTHANK YOU! FOR USING THE SOFTWARE");
                    break;
                default:
                    System.out.println("\nPlease Enter correct option");
                    break;
            }
        } while (option != 7);
    }
}
