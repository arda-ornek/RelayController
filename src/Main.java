import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Controller c = new Controller();
		ResponseController r = new ResponseController();
		r.setController(c);
		Scanner input = new Scanner(System.in);
		
		while(true) {
			printMenu();
			int in = input.nextInt();
			
			switch (in) {
			case 1:
				c.sendCheckAlive();
				r.checkAliveResponse();
				break;
			case 2:
				c.sendGetAllBit();
				r.getAllBitResponse();
				break;
			case 3:
				c.sendGetBatteryBit();
				r.getBatteryBitResponse();
				break;
			case 4:
				c.sendSetFirstRelay(1);
				r.setFirstRelayResponse();
				break;
			case 5:
				c.sendSetSecondRelay(1);
				r.setSecondRelayResponse();
				break;
			case 6:
				c.sendGetSurgeProtectStatus();
				r.getSurgeProtectStatusResponse();
				break;
			case 7:
				c.sendSoftRestart();
				r.softRestartResponse();
				break;
			case 8:
				c.sendChangeNetworkSettings("127.0.0.1","127.0.1.1","127.1.1.1");
				r.changeNetworkSettingsResponse();
				break;
			case 9:
				c.sendChangeMacAddress("00:00:5e:00:53:af");
				r.changeMacAddressResponse();
				break;
			case 10:
				c.sendGetSWVersion();
				r.getSWVersionResponse();
				break;

			}
			if (in == 0) {
				break;
			}
		}
		
		System.out.println("The program closed!");

	}
	
	public static void printMenu() {
		System.out.println("0. Check writeHeader method.");
		System.out.println("1. Check checkAlive method.");
		System.out.println("2. Check getAllBit method.");
		System.out.println("3. Check getBatteryBit method.");
		System.out.println("4. Check setFirstDelay method.");
		System.out.println("5. Check setSecondDelay method.");
		System.out.println("6. Check getSurgeProtectStatus method.");
		System.out.println("7. Check softRestart method.");
		System.out.println("8. Check changeNetworkSettings method.");
		System.out.println("9. Check changeMacAddress method.");
		System.out.println("10. Check getSWVersion method.");
		System.out.print("Enter the method number that you want to use: ");
		
	}

}
