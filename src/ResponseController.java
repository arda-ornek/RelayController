
public class ResponseController {
	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}

	private static final byte[] header = { (byte) 0xAA, (byte) 0x55, (byte) 0xAA, (byte) 0x55 };

	private final byte[] addToMessage(byte[] msg, byte[] payload, int index) {
		for (int i = 0; i < payload.length; i++) {
			msg[i + index] = payload[i];
		}
		return msg;
	}

	private final byte[] intToByteArray(int value) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			int offset = (b.length - 1 - i) * 8;
			b[i] = (byte) ((value >>> offset) & 0xFF);
		}
		return b;
	}

	private final byte[] calculateCRC() {
		byte[] crc = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };
		return crc;
	}

	private void sendMessage(byte[] cmdCode, byte[] arr) {
		byte[] payloadSizeInBytes = intToByteArray(arr.length);
		byte[] crc = calculateCRC();
		byte[] msg = new byte[16 + arr.length];
		msg = addToMessage(msg, header, 0);
		msg = addToMessage(msg, cmdCode, 4);
		msg = addToMessage(msg, payloadSizeInBytes, 8);
		msg = addToMessage(msg, arr, 12);
		msg = addToMessage(msg, crc, 12 + arr.length);
		controller.parse(msg);
		System.out.println(" --> send from card");
		for (int i = 0; i < msg.length; i++) {
			System.out.print(String.format("0x%02X", msg[i]) + " ");
		}
		System.out.println();
	}

	public final void checkAliveResponse() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x02 };
		sendMessage(cmdCode, new byte[0]);
	}

	public final void getBatteryBitResponse() {
		byte[] payload = new byte[56];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x22 };
		byte[] AbsStateOfChargeID = { (byte) 0x00, (byte) 0x04, (byte) 0x07, (byte) 0x00 };
		payload = addToMessage(payload, AbsStateOfChargeID, 0);
		byte[] AverageCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x06, (byte) 0x00 };
		payload = addToMessage(payload, AverageCurrentID, 8);
		byte[] CurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x04, (byte) 0x00 };
		payload = addToMessage(payload, CurrentID, 16);
		byte[] VoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x05, (byte) 0x00 };
		payload = addToMessage(payload, VoltageID, 24);
		byte[] RelStateOfChargeID = { (byte) 0x00, (byte) 0x04, (byte) 0x02, (byte) 0x00 };
		payload = addToMessage(payload, RelStateOfChargeID, 32);
		byte[] RemainingCapacityID = { (byte) 0x00, (byte) 0x04, (byte) 0x08, (byte) 0x00 };
		payload = addToMessage(payload, RemainingCapacityID, 40);
		byte[] TemperatureID = { (byte) 0x00, (byte) 0x04, (byte) 0x03, (byte) 0x00 };
		payload = addToMessage(payload, TemperatureID, 48);

		sendMessage(cmdCode, payload);
	}

	public final void getAllBitResponse() {
		byte[] payload = new byte[256];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x12 };
		byte[] BoardCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x13, (byte) 0x00 };
		payload = addToMessage(payload, BoardCurrentID, 0);
		byte[] BoardHumidityID = { (byte) 0x00, (byte) 0x04, (byte) 0x11, (byte) 0x00 };
		payload = addToMessage(payload, BoardHumidityID, 8);
		byte[] BoardTemperatureID = { (byte) 0x00, (byte) 0x04, (byte) 0x12, (byte) 0x00 };
		payload = addToMessage(payload, BoardTemperatureID, 16);
		byte[] BoardVoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x14, (byte) 0x00 };
		payload = addToMessage(payload, BoardVoltageID, 24);
		byte[] BoardElapsedTimeID = { (byte) 0x00, (byte) 0x04, (byte) 0x15, (byte) 0x00 };
		payload = addToMessage(payload, BoardElapsedTimeID, 32);
		byte[] BatteryTypeID = { (byte) 0x00, (byte) 0x04, (byte) 0x16, (byte) 0x00 };
		payload = addToMessage(payload, BatteryTypeID, 40);

		byte[] AbsStateOfChargeID = { (byte) 0x00, (byte) 0x04, (byte) 0x07, (byte) 0x00 };
		payload = addToMessage(payload, AbsStateOfChargeID, 48);
		byte[] AverageCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x06, (byte) 0x00 };
		payload = addToMessage(payload, AverageCurrentID, 56);
		byte[] CurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x04, (byte) 0x00 };
		payload = addToMessage(payload, CurrentID, 64);
		byte[] VoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x05, (byte) 0x00 };
		payload = addToMessage(payload, VoltageID, 72);
		byte[] RelStateOfChargeID = { (byte) 0x00, (byte) 0x04, (byte) 0x02, (byte) 0x00 };
		payload = addToMessage(payload, RelStateOfChargeID, 80);
		byte[] RemainingCapacityID = { (byte) 0x00, (byte) 0x04, (byte) 0x08, (byte) 0x00 };
		payload = addToMessage(payload, RemainingCapacityID, 88);
		byte[] TemperatureID = { (byte) 0x00, (byte) 0x04, (byte) 0x03, (byte) 0x00 };
		payload = addToMessage(payload, TemperatureID, 96);
		byte[] UpsInputVoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x21, (byte) 0x00 };
		payload = addToMessage(payload, UpsInputVoltageID, 104);
		byte[] UpsInputCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x22, (byte) 0x00 };
		payload = addToMessage(payload, UpsInputCurrentID, 112);
		byte[] UpsOutputVoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x23, (byte) 0x00 };
		payload = addToMessage(payload, UpsOutputVoltageID, 120);
		byte[] UpsOutputCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x24, (byte) 0x00 };
		payload = addToMessage(payload, UpsOutputCurrentID, 128);
		byte[] UpsBatteryVoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x25, (byte) 0x00 };
		payload = addToMessage(payload, UpsBatteryVoltageID, 136);
		byte[] UpsBatteryCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x26, (byte) 0x00 };
		payload = addToMessage(payload, UpsBatteryCurrentID, 144);
		byte[] UpsAuxVoltageID = { (byte) 0x00, (byte) 0x04, (byte) 0x27, (byte) 0x00 };
		payload = addToMessage(payload, UpsAuxVoltageID, 152);
		byte[] UpsAuxCurrentID = { (byte) 0x00, (byte) 0x04, (byte) 0x28, (byte) 0x00 };
		payload = addToMessage(payload, UpsAuxCurrentID, 160);
		byte[] UpsExtTemperatureID = { (byte) 0x00, (byte) 0x04, (byte) 0x29, (byte) 0x00 };
		payload = addToMessage(payload, UpsExtTemperatureID, 168);
		byte[] UpsBatteryResistantID = { (byte) 0x00, (byte) 0x04, (byte) 0x2A, (byte) 0x00 };
		payload = addToMessage(payload, UpsBatteryResistantID, 176);
		byte[] UpsBatChargePercID = { (byte) 0x00, (byte) 0x04, (byte) 0x2B, (byte) 0x00 };
		payload = addToMessage(payload, UpsBatChargePercID, 184);
		byte[] UpsBatChargeCapID = { (byte) 0x00, (byte) 0x04, (byte) 0x2C, (byte) 0x00 };
		payload = addToMessage(payload, UpsBatChargeCapID, 192);
		byte[] UpsBootCycleID = { (byte) 0x00, (byte) 0x04, (byte) 0x31, (byte) 0x00 };
		payload = addToMessage(payload, UpsBootCycleID, 200);
		byte[] UpsOperatingTimeID = { (byte) 0x00, (byte) 0x04, (byte) 0x32, (byte) 0x00 };
		payload = addToMessage(payload, UpsOperatingTimeID, 208);
		byte[] UpsBatOperateTimeID = { (byte) 0x00, (byte) 0x04, (byte) 0x33, (byte) 0x00 };
		payload = addToMessage(payload, UpsBatOperateTimeID, 216);
		byte[] UpsState4000ID = { (byte) 0x00, (byte) 0x04, (byte) 0x34, (byte) 0x00 };
		payload = addToMessage(payload, UpsState4000ID, 224);
		byte[] UpsState4010ID = { (byte) 0x00, (byte) 0x04, (byte) 0x35, (byte) 0x00 };
		payload = addToMessage(payload, UpsState4010ID, 232);
		byte[] UpsState4020ID = { (byte) 0x00, (byte) 0x04, (byte) 0x36, (byte) 0x00 };
		payload = addToMessage(payload, UpsState4020ID, 240);
		byte[] UpsState4030ID = { (byte) 0x00, (byte) 0x04, (byte) 0x37, (byte) 0x00 };
		payload = addToMessage(payload, UpsState4030ID, 248);

		sendMessage(cmdCode, payload);
	}

	public final void setFirstRelayResponse() {
		byte[] payload = new byte[4];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x32 };
		sendMessage(cmdCode, payload);
	}

	public final void setSecondRelayResponse() {
		byte[] payload = new byte[4];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x42 };
		sendMessage(cmdCode, payload);
	}

	public final void getSurgeProtectStatusResponse() {
		byte[] payload = new byte[4];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x52 };
		sendMessage(cmdCode, payload);
	}

	public final void softRestartResponse() {
		byte[] payload = new byte[0];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x62 };
		sendMessage(cmdCode, payload);
	}

	public final void changeNetworkSettingsResponse() {
		byte[] payload = new byte[12];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x72 };
		sendMessage(cmdCode, payload);
	}

	public final void changeMacAddressResponse() {
		byte[] payload = new byte[4];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x82 };
		sendMessage(cmdCode, payload);
	}

	public final void getSWVersionResponse() {
		byte[] payload = new byte[12];
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x92 };
		sendMessage(cmdCode, payload);
	}
}
