import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.StringTokenizer;

public class Controller {

	BitInformation info = new BitInformation();

	ResponseModel model = new ResponseModel();

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

	public byte[] Tokenizer(String s) {
		StringTokenizer stringTokenizer = new StringTokenizer(s, ".");
		byte[] sBytes = new byte[stringTokenizer.countTokens()];
		for (int i = 0; i < sBytes.length; i++) {
			sBytes[i] = (byte) Integer.parseInt((String) stringTokenizer.nextElement());
		}
		return sBytes;
	}

	public void parse(byte[] receivedmessage) {
		byte[] bytes = new byte[4];

		if (header[0] == receivedmessage[0] && header[1] == receivedmessage[1] && header[2] == receivedmessage[2]
				&& header[3] == receivedmessage[3]) {
			System.out.println("Header is correct");

			if (receivedmessage[7] == (byte) 0x02) {
				System.out.println("Message name is: Check Alive Response");
			}
			if (receivedmessage[7] == (byte) 0x22) {
				System.out.println("Message name is: Get Battery Bit Response");

				if (receivedmessage[14] == (byte) 0x07) {
					int j = 0;
					for (int i = 16; i < 20; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setAbsStateOfCharge(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[22] == (byte) 0x06) {
					int j = 0;
					for (int i = 24; i < 28; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setAverageCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[30] == (byte) 0x04) {
					int j = 0;
					for (int i = 32; i < 36; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[38] == (byte) 0x05) {
					int j = 0;
					for (int i = 40; i < 44; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[46] == (byte) 0x02) {
					int j = 0;
					for (int i = 48; i < 52; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setRelStateOfCharge(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[54] == (byte) 0x08) {
					int j = 0;
					for (int i = 56; i < 60; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setRemainingCapacity(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[62] == (byte) 0x03) {
					int j = 0;
					for (int i = 64; i < 68; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setTemperature(ByteBuffer.wrap(bytes).getFloat());
				}
			}
			if (receivedmessage[7] == (byte) 0x32) {
				System.out.println("Message name is: Set First Relay Response");

				int j = 0;
				for (int i = 12; i < 16; i++) {
					bytes[j] = receivedmessage[i];
				}
				model.setFirstRelayStatus(new String(bytes));

			}
			if (receivedmessage[7] == (byte) 0x42) {
				System.out.println("Message name is: Set Second Relay Response");

				int j = 0;
				for (int i = 12; i < 16; i++) {
					bytes[j] = receivedmessage[i];
				}
				model.setSecondRelayStatus(new String(bytes));
			}
			if (receivedmessage[7] == (byte) 0x52) {
				System.out.println("Message name is: Get Surge Protect Status Response");

				int j = 0;
				for (int i = 12; i < 16; i++) {
					bytes[j] = receivedmessage[i];
				}
				model.setSurgeProtectStatus(new String(bytes));
			}
			if (receivedmessage[7] == (byte) 0x62) {
				System.out.println("Message name is: Soft Restart Response");
			}
			if (receivedmessage[7] == (byte) 0x72) {
				System.out.println("Message name is: Change Network Settings Response");

				int j = 0;
				for (int i = 12; i < 16; i++) {
					bytes[j] = receivedmessage[i];
				}
				String ipResp = "";
				for (int i = 0; i < bytes.length; i++) {
					ipResp += String.format("%02X", bytes[i]) + ".";
				}
				model.setIPResp(ipResp.substring(0, ipResp.length() - 1));
				int k = 0;
				for (int i = 16; i < 20; i++) {
					bytes[k] = receivedmessage[i];
				}
				String gatewayResp = "";
				for (int i = 0; i < bytes.length; i++) {
					gatewayResp += String.format("%02X", bytes[i]) + ".";
				}
				model.setGatewayResp(gatewayResp.substring(0, gatewayResp.length() - 1));
				int l = 0;
				for (int i = 20; i < 24; i++) {
					bytes[l] = receivedmessage[i];
				}
				String subnetResp = "";
				for (int i = 0; i < bytes.length; i++) {
					subnetResp += String.format("%02X", bytes[i]) + ".";
				}
				model.setSubnetResp(subnetResp.substring(0, subnetResp.length() - 1));
			}
			if (receivedmessage[7] == (byte) 0x82) {
				System.out.println("Message name is: Change Mac Address Response");

				int j = 0;
				for (int i = 12; i < 16; i++) {
					bytes[j] = receivedmessage[i];
				}
				String macResp = "";
				for (int i = 0; i < bytes.length; i++) {
					macResp += String.format("%02X", bytes[i]) + ":";
				}
				model.setMacResp(macResp.substring(0, macResp.length() - 1));
			}
			if (receivedmessage[7] == (byte) 0x92) {
				System.out.println("Message name is: Get SW Version Response");

				byte[] arr = new byte[12];
				int j = 0;
				for (int i = 12; i < 24; i++) {
					arr[j] = receivedmessage[i];
				}
				byte[] major = new byte[4];
				byte[] minor = new byte[4];
				byte[] patch = new byte[4];
				for (int i = 12; i < 16; i++) {
					major[j] = receivedmessage[i];
				}
				for (int i = 16; i < 20; i++) {
					minor[j] = receivedmessage[i];
				}
				for (int i = 20; i < 24; i++) {
					patch[j] = receivedmessage[i];
				}
				String majorResp = String.format("%02d",ByteBuffer.wrap(major).getInt());
				String minorResp = String.format("%02d",ByteBuffer.wrap(minor).getInt());
				String patchResp = String.format("%04d",ByteBuffer.wrap(patch).getInt());;
				model.setMajorMinorPatch(majorResp + "." + minorResp + "." + patchResp);
			}
			if (receivedmessage[7] == (byte) 0x12) {
				System.out.println("Message name is: Get All Bit Response");

				if (receivedmessage[14] == (byte) 0x13) {
					int j = 0;
					for (int i = 16; i < 20; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setBoardCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[22] == (byte) 0x11) {
					int j = 0;
					for (int i = 24; i < 28; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setBoardHumidity(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[30] == (byte) 0x12) {
					int j = 0;
					for (int i = 32; i < 36; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setBoardTemperature(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[38] == (byte) 0x14) {
					int j = 0;
					for (int i = 40; i < 44; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setBoardVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[46] == (byte) 0x15) {
					int j = 0;
					for (int i = 48; i < 52; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setBoardElapsedTime(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[54] == (byte) 0x16) {
					int j = 0;
					for (int i = 56; i < 60; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setBatteryType(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[62] == (byte) 0x07) {
					int j = 0;
					for (int i = 64; i < 68; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setAbsStateOfCharge(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[70] == (byte) 0x06) {
					int j = 0;
					for (int i = 72; i < 76; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setAverageCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[78] == (byte) 0x04) {
					int j = 0;
					for (int i = 80; i < 84; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[86] == (byte) 0x05) {
					int j = 0;
					for (int i = 88; i < 92; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[94] == (byte) 0x02) {
					int j = 0;
					for (int i = 96; i < 100; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setRelStateOfCharge(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[102] == (byte) 0x08) {
					int j = 0;
					for (int i = 104; i < 108; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setRemainingCapacity(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[110] == (byte) 0x03) {
					int j = 0;
					for (int i = 112; i < 116; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setTemperature(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[118] == (byte) 0x21) {
					int j = 0;
					for (int i = 120; i < 124; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsInputVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[126] == (byte) 0x22) {
					int j = 0;
					for (int i = 128; i < 132; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsInputCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[134] == (byte) 0x23) {
					int j = 0;
					for (int i = 136; i < 140; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsOutputVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[142] == (byte) 0x24) {
					int j = 0;
					for (int i = 144; i < 148; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsOutputCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[150] == (byte) 0x25) {
					int j = 0;
					for (int i = 152; i < 156; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBatteryVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[158] == (byte) 0x26) {
					int j = 0;
					for (int i = 160; i < 164; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBatteryCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[166] == (byte) 0x27) {
					int j = 0;
					for (int i = 168; i < 172; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsAuxVoltage(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[174] == (byte) 0x28) {
					int j = 0;
					for (int i = 176; i < 180; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsAuxCurrent(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[182] == (byte) 0x29) {
					int j = 0;
					for (int i = 184; i < 188; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsExtTemperature(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[190] == (byte) 0x2A) {
					int j = 0;
					for (int i = 192; i < 196; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBatteryResistant(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[198] == (byte) 0x2B) {
					int j = 0;
					for (int i = 200; i < 204; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBatChargePerc(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[206] == (byte) 0x2C) {
					int j = 0;
					for (int i = 208; i < 212; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBatChargeCap(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[214] == (byte) 0x31) {
					int j = 0;
					for (int i = 216; i < 220; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBootCycle(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[222] == (byte) 0x32) {
					int j = 0;
					for (int i = 224; i < 228; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsOperatingTime(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[230] == (byte) 0x33) {
					int j = 0;
					for (int i = 232; i < 236; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsBatOperateTime(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[238] == (byte) 0x34) {
					int j = 0;
					for (int i = 240; i < 244; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsState4000(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[246] == (byte) 0x35) {
					int j = 0;
					for (int i = 248; i < 252; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsState4010(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[254] == (byte) 0x36) {
					int j = 0;
					for (int i = 256; i < 260; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsState4020(ByteBuffer.wrap(bytes).getFloat());
				}
				if (receivedmessage[262] == (byte) 0x37) {
					int j = 0;
					for (int i = 264; i < 268; i++) {
						bytes[j] = receivedmessage[i];
					}
					model.getInfo().setUpsState4030(ByteBuffer.wrap(bytes).getFloat());
				}
			}
		} else
			System.out.println("Header is NOT correct!!!");

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

		for (int i = 0; i < msg.length; i++) {
			System.out.print(String.format("0x%02X", msg[i]) + " ");
		}
		System.out.println();
	}

	public final void sendCheckAlive() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x01 };
		sendMessage(cmdCode, new byte[0]);
	}

	public void sendGetAllBit() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x11 };
		sendMessage(cmdCode, new byte[0]);
	}

	public final void sendGetBatteryBit() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x21 };
		sendMessage(cmdCode, new byte[0]);
	}

	public void sendSetFirstRelay(int value) {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x31 };
		byte[] payload = intToByteArray(value);
		sendMessage(cmdCode, payload);
	}

	public void sendSetSecondRelay(int value) {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x41 };
		byte[] payload = intToByteArray(value);
		sendMessage(cmdCode, payload);
	}

	public final void sendGetSurgeProtectStatus() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x51 };
		sendMessage(cmdCode, new byte[0]);
	}

	public final void sendSoftRestart() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x61 };
		sendMessage(cmdCode, new byte[0]);
	}

	public void sendChangeNetworkSettings(String ip, String gateway, String subnet) {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x71 };
		byte[] payload = new byte[12];
		byte[] ipBytes = Tokenizer(ip);
		byte[] gatewayBytes = Tokenizer(gateway);
		byte[] subnetBytes = Tokenizer(subnet);
		payload = addToMessage(payload, ipBytes, 0);
		payload = addToMessage(payload, gatewayBytes, 4);
		payload = addToMessage(payload, subnetBytes, 8);
		sendMessage(cmdCode, payload);
	}

	public void sendChangeMacAddress(String address) {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x81 };
		byte[] payload = new byte[8];

		StringTokenizer stringTokenizer = new StringTokenizer(address, ":");
		byte[] addressBytes = new byte[stringTokenizer.countTokens()];
		String hexString = "";
		for (int i = 0; i < addressBytes.length; i++) {
			hexString = hexString + (String) stringTokenizer.nextElement();
		}
		addressBytes = HexFormat.of().parseHex(hexString);
		payload = addToMessage(payload, addressBytes, 0);
		sendMessage(cmdCode, payload);
	}

	public final void sendGetSWVersion() {
		byte[] cmdCode = { (byte) 0x00, (byte) 0xBA, (byte) 0x00, (byte) 0x91 };
		sendMessage(cmdCode, new byte[0]);
	}
}
