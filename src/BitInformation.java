import java.nio.ByteBuffer;

public class BitInformation {
	private int BoardCurrentID;
	private int BoardHumidityID;
	private int BoardTemperatureID;
	private int BoardVoltageID;
	private int BoardElapsedTimeID;
	private int BatteryTypeID;
	private int AbsStateOfChargeID;
	private int AverageCurrentID;
	private int CurrentID;
	private int VoltageID;
	private int RelStateOfChargeID;
	private int RemainingCapacityID;
	private int TemperatureID;
	private int UpsInputVoltageID;
	private int UpsInputCurrentID;
	private int UpsOutputVoltageID;
	private int UpsOutputCurrentID;
	private int UpsBatteryVoltageID;
	private int UpsBatteryCurrentID;
	private int UpsAuxVoltageID;
	private int UpsAuxCurrentID;
	private int UpsExtTemperatureID;
	private int UpsBatteryResistantID;
	private int UpsBatChargePercID;
	private int UpsBatChargeCapID;
	private int UpsBootCycleID;
	private int UpsOperatingTimeID;
	private int UpsBatOperateTimeID;
	private int UpsState0400ID;
	private int UpsState0410ID;
	private int UpsState0420ID;
	private int UpsState0430ID;
	
	private float BoardCurrent;
	private float BoardHumidity;
	private float BoardTemperature;
	private float BoardVoltage;
	private float BoardElapsedTime;
	private float BatteryType;
	private float AbsStateOfCharge;
	private float AverageCurrent;
	private float Current;
	private float Voltage;
	private float RelStateOfCharge;
	private float RemainingCapacity;
	private float Temperature;
	private float UpsInputVoltage;
	private float UpsInputCurrent;
	private float UpsOutputVoltage;
	private float UpsOutputCurrent;
	private float UpsBatteryVoltage;
	private float UpsBatteryCurrent;
	private float UpsAuxVoltage;
	private float UpsAuxCurrent;
	private float UpsExtTemperature;
	private float UpsBatteryResistant;
	private float UpsBatChargePerc;
	private float UpsBatChargeCap;
	private float UpsBootCycle;
	private float UpsOperatingTime;
	private float UpsBatOperateTime;
	private float UpsState4000;
	private float UpsState4010;
	private float UpsState4020;
	private float UpsState4030;
	
	public int getBoardCurrentID() {
		byte [] bytes = { 0x00,0x04,0x13,0x00 };
		BoardCurrentID = ByteBuffer.wrap(bytes).getInt();
		return BoardCurrentID;
	}
	public void setBoardCurrentID(int boardCurrentID) {
		BoardCurrentID = boardCurrentID;
	}
	public int getBoardHumidityID() {
		byte [] bytes = { 0x00,0x04,0x11,0x00 };
		BoardHumidityID = ByteBuffer.wrap(bytes).getInt();
		return BoardHumidityID;
	}
	public void setBoardHumidityID(int boardHumidityID) {
		BoardHumidityID = boardHumidityID;
	}
	public int getBoardTemperatureID() {
		byte [] bytes = { 0x00,0x04,0x12,0x00 };
		BoardTemperatureID = ByteBuffer.wrap(bytes).getInt();
		return BoardTemperatureID;
	}
	public void setBoardTemperatureID(int boardTemperatureID) {
		BoardTemperatureID = boardTemperatureID;
	}
	public int getBoardVoltageID() {
		byte [] bytes = { 0x00,0x04,0x14,0x00 };
		BoardVoltageID = ByteBuffer.wrap(bytes).getInt();
		return BoardVoltageID;
	}
	public void setBoardVoltageID(int boardVoltageID) {
		BoardVoltageID = boardVoltageID;
	}
	public int getBoardElapsedTimeID() {
		byte [] bytes = { 0x00,0x04,0x15,0x00 };
		BoardElapsedTimeID = ByteBuffer.wrap(bytes).getInt();
		return BoardElapsedTimeID;
	}
	public void setBoardElapsedTimeID(int boardElapsedTimeID) {
		BoardElapsedTimeID = boardElapsedTimeID;
	}
	public int getBatteryTypeID() {
		byte [] bytes = { 0x00,0x04,0x16,0x00 };
		BatteryTypeID = ByteBuffer.wrap(bytes).getInt();
		return BatteryTypeID;
	}
	public void setBatteryTypeID(int batteryTypeID) {
		BatteryTypeID = batteryTypeID;
	}
	public int getAbsStateOfChargeID() {
		byte [] bytes = { 0x00,0x04,0x17,0x00 };
		AbsStateOfChargeID = ByteBuffer.wrap(bytes).getInt();
		return AbsStateOfChargeID;
	}
	public void setAbsStateOfChargeID(int absStateOfChargeID) {
		AbsStateOfChargeID = absStateOfChargeID;
	}
	public int getAverageCurrentID() {
		byte [] bytes = { 0x00,0x04,0x06,0x00 };
		AverageCurrentID = ByteBuffer.wrap(bytes).getInt();
		return AverageCurrentID;
	}
	public void setAverageCurrentID(int averageCurrentID) {
		AverageCurrentID = averageCurrentID;
	}
	public int getCurrentID() {
		byte [] bytes = { 0x00,0x04,0x04,0x00 };
		CurrentID = ByteBuffer.wrap(bytes).getInt();
		return CurrentID;
	}
	public void setCurrentID(int currentID) {
		CurrentID = currentID;
	}
	public int getVoltageID() {
		byte [] bytes = { 0x00,0x04,0x05,0x00 };
		VoltageID = ByteBuffer.wrap(bytes).getInt();
		return VoltageID;
	}
	public void setVoltageID(int voltageID) {
		VoltageID = voltageID;
	}
	public int getRelStateOfChargeID() {
		byte [] bytes = { 0x00,0x04,0x02,0x00 };
		RelStateOfChargeID = ByteBuffer.wrap(bytes).getInt();
		return RelStateOfChargeID;
	}
	public void setRelStateOfChargeID(int relStateOfChargeID) {
		RelStateOfChargeID = relStateOfChargeID;
	}
	public int getRemainingCapacityID() {
		byte [] bytes = { 0x00,0x04,0x08,0x00 };
		RemainingCapacityID = ByteBuffer.wrap(bytes).getInt();
		return RemainingCapacityID;
	}
	public void setRemainingCapacityID(int remainingCapacityID) {
		RemainingCapacityID = remainingCapacityID;
	}
	public int getTemperatureID() {
		byte [] bytes = { 0x00,0x04,0x03,0x00 };
		TemperatureID = ByteBuffer.wrap(bytes).getInt();
		return TemperatureID;
	}
	public void setTemperatureID(int temperatureID) {
		TemperatureID = temperatureID;
	}
	public int getUpsInputVoltageID() {
		byte [] bytes = { 0x00,0x04,0x21,0x00 };
		UpsInputVoltageID = ByteBuffer.wrap(bytes).getInt();
		return UpsInputVoltageID;
	}
	public void setUpsInputVoltageID(int upsInputVoltageID) {
		UpsInputVoltageID = upsInputVoltageID;
	}
	public int getUpsInputCurrentID() {
		byte [] bytes = { 0x00,0x04,0x22,0x00 };
		UpsInputCurrentID = ByteBuffer.wrap(bytes).getInt();
		return UpsInputCurrentID;
	}
	public void setUpsInputCurrentID(int upsInputCurrentID) {
		UpsInputCurrentID = upsInputCurrentID;
	}
	public int getUpsOutputVoltageID() {
		byte [] bytes = { 0x00,0x04,0x23,0x00 };
		UpsOutputVoltageID = ByteBuffer.wrap(bytes).getInt();
		return UpsOutputVoltageID;
	}
	public void setUpsOutputVoltageID(int upsOutputVoltageID) {
		UpsOutputVoltageID = upsOutputVoltageID;
	}
	public int getUpsOutputCurrentID() {
		byte [] bytes = { 0x00,0x04,0x24,0x00 };
		UpsOutputCurrentID = ByteBuffer.wrap(bytes).getInt();
		return UpsOutputCurrentID;
	}
	public void setUpsOutputCurrentID(int upsOutputCurrentID) {
		UpsOutputCurrentID = upsOutputCurrentID;
	}
	public int getUpsBatteryVoltageID() {
		byte [] bytes = { 0x00,0x04,0x25,0x00 };
		UpsBatteryVoltageID = ByteBuffer.wrap(bytes).getInt();
		return UpsBatteryVoltageID;
	}
	public void setUpsBatteryVoltageID(int upsBatteryVoltageID) {
		UpsBatteryVoltageID = upsBatteryVoltageID;
	}
	public int getUpsBatteryCurrentID() {
		byte [] bytes = { 0x00,0x04,0x26,0x00 };
		UpsBatteryCurrentID = ByteBuffer.wrap(bytes).getInt();
		return UpsBatteryCurrentID;
	}
	public void setUpsBatteryCurrentID(int upsBatteryCurrentID) {
		UpsBatteryCurrentID = upsBatteryCurrentID;
	}
	public int getUpsAuxVoltageID() {
		byte [] bytes = { 0x00,0x04,0x27,0x00 };
		UpsAuxVoltageID = ByteBuffer.wrap(bytes).getInt();
		return UpsAuxVoltageID;
	}
	public void setUpsAuxVoltageID(int upsAuxVoltageID) {
		UpsAuxVoltageID = upsAuxVoltageID;
	}
	public int getUpsAuxCurrentID() {
		byte [] bytes = { 0x00,0x04,0x28,0x00 };
		UpsAuxCurrentID = ByteBuffer.wrap(bytes).getInt();
		return UpsAuxCurrentID;
	}
	public void setUpsAuxCurrentID(int upsAuxCurrentID) {
		UpsAuxCurrentID = upsAuxCurrentID;
	}
	public int getUpsExtTemperatureID() {
		byte [] bytes = { 0x00,0x04,0x29,0x00 };
		UpsExtTemperatureID = ByteBuffer.wrap(bytes).getInt();
		return UpsExtTemperatureID;
	}
	public void setUpsExtTemperatureID(int upsExtTemperatureID) {
		UpsExtTemperatureID = upsExtTemperatureID;
	}
	public int getUpsBatteryResistantID() {
		byte [] bytes = { 0x00,0x04,0x2A,0x00 };
		UpsBatteryResistantID = ByteBuffer.wrap(bytes).getInt();
		return UpsBatteryResistantID;
	}
	public void setUpsBatteryResistantID(int upsBatteryResistantID) {
		UpsBatteryResistantID = upsBatteryResistantID;
	}
	public int getUpsBatChargePercID() {
		byte [] bytes = { 0x00,0x04,0x2B,0x00 };
		UpsBatChargePercID = ByteBuffer.wrap(bytes).getInt();
		return UpsBatChargePercID;
	}
	public void setUpsBatChargePercID(int upsBatChargePercID) {
		UpsBatChargePercID = upsBatChargePercID;
	}
	public int getUpsBatChargeCapID() {
		byte [] bytes = { 0x00,0x04,0x2C,0x00 };
		UpsBatChargeCapID = ByteBuffer.wrap(bytes).getInt();
		return UpsBatChargeCapID;
	}
	public void setUpsBatChargeCapID(int upsBatChargeCapID) {
		UpsBatChargeCapID = upsBatChargeCapID;
	}
	public int getUpsBootCycleID() {
		byte [] bytes = { 0x00,0x04,0x31,0x00 };
		UpsBootCycleID = ByteBuffer.wrap(bytes).getInt();
		return UpsBootCycleID;
	}
	public void setUpsBootCycleID(int upsBootCycleID) {
		UpsBootCycleID = upsBootCycleID;
	}
	public int getUpsOperatingTimeID() {
		byte [] bytes = { 0x00,0x04,0x32,0x00 };
		UpsOperatingTimeID = ByteBuffer.wrap(bytes).getInt();
		return UpsOperatingTimeID;
	}
	public void setUpsOperatingTimeID(int upsOperatingTimeID) {
		UpsOperatingTimeID = upsOperatingTimeID;
	}
	public int getUpsBatOperateTimeID() {
		byte [] bytes = { 0x00,0x04,0x33,0x00 };
		UpsBatOperateTimeID = ByteBuffer.wrap(bytes).getInt();
		return UpsBatOperateTimeID;
	}
	public void setUpsBatOperateTimeID(int upsBatOperateTimeID) {
		UpsBatOperateTimeID = upsBatOperateTimeID;
	}
	public int getUpsState0400ID() {
		byte [] bytes = { 0x00,0x04,0x34,0x00 };
		UpsState0400ID = ByteBuffer.wrap(bytes).getInt();
		return UpsState0400ID;
	}
	public void setUpsState0400ID(int upsState0400ID) {
		UpsState0400ID = upsState0400ID;
	}
	public int getUpsState0410ID() {
		byte [] bytes = { 0x00,0x04,0x35,0x00 };
		UpsState0410ID = ByteBuffer.wrap(bytes).getInt();
		return UpsState0410ID;
	}
	public void setUpsState0410ID(int upsState0410ID) {
		UpsState0410ID = upsState0410ID;
	}
	public int getUpsState0420ID() {
		byte [] bytes = { 0x00,0x04,0x36,0x00 };
		UpsState0420ID = ByteBuffer.wrap(bytes).getInt();
		return UpsState0420ID;
	}
	public void setUpsState0420ID(int upsState0420ID) {
		UpsState0420ID = upsState0420ID;
	}
	public int getUpsState0430ID() {
		byte [] bytes = { 0x00,0x04,0x37,0x00 };
		UpsState0430ID = ByteBuffer.wrap(bytes).getInt();
		return UpsState0430ID;
	}
	public void setUpsState0430ID(int upsState0430ID) {
		UpsState0430ID = upsState0430ID;
	}
	public float getBoardCurrent() {
		return BoardCurrent;
	}
	public void setBoardCurrent(float boardCurrent) {
		BoardCurrent = boardCurrent;
	}
	public float getBoardHumidity() {
		return BoardHumidity;
	}
	public void setBoardHumidity(float boardHumidity) {
		BoardHumidity = boardHumidity;
	}
	public float getBoardTemperature() {
		return BoardTemperature;
	}
	public void setBoardTemperature(float boardTemperature) {
		BoardTemperature = boardTemperature;
	}
	public float getBoardVoltage() {
		return BoardVoltage;
	}
	public void setBoardVoltage(float boardVoltage) {
		BoardVoltage = boardVoltage;
	}
	public float getBoardElapsedTime() {
		return BoardElapsedTime;
	}
	public void setBoardElapsedTime(float boardElapsedTime) {
		BoardElapsedTime = boardElapsedTime;
	}
	public float getBatteryType() {
		return BatteryType;
	}
	public void setBatteryType(float batteryType) {
		BatteryType = batteryType;
	}
	public float getAbsStateOfCharge() {
		return AbsStateOfCharge;
	}
	public void setAbsStateOfCharge(float absStateOfCharge) {
		AbsStateOfCharge = absStateOfCharge;
	}
	public float getAverageCurrent() {
		return AverageCurrent;
	}
	public void setAverageCurrent(float averageCurrent) {
		AverageCurrent = averageCurrent;
	}
	public float getCurrent() {
		return Current;
	}
	public void setCurrent(float current) {
		Current = current;
	}
	public float getVoltage() {
		return Voltage;
	}
	public void setVoltage(float voltage) {
		Voltage = voltage;
	}
	public float getRelStateOfCharge() {
		return RelStateOfCharge;
	}
	public void setRelStateOfCharge(float relStateOfCharge) {
		RelStateOfCharge = relStateOfCharge;
	}
	public float getRemainingCapacity() {
		return RemainingCapacity;
	}
	public void setRemainingCapacity(float remainingCapacity) {
		RemainingCapacity = remainingCapacity;
	}
	public float getTemperature() {
		return Temperature;
	}
	public void setTemperature(float temperature) {
		Temperature = temperature;
	}
	public float getUpsInputVoltage() {
		return UpsInputVoltage;
	}
	public void setUpsInputVoltage(float upsInputVoltage) {
		UpsInputVoltage = upsInputVoltage;
	}
	public float getUpsInputCurrent() {
		return UpsInputCurrent;
	}
	public void setUpsInputCurrent(float upsInputCurrent) {
		UpsInputCurrent = upsInputCurrent;
	}
	public float getUpsOutputVoltage() {
		return UpsOutputVoltage;
	}
	public void setUpsOutputVoltage(float upsOutputVoltage) {
		UpsOutputVoltage = upsOutputVoltage;
	}
	public float getUpsOutputCurrent() {
		return UpsOutputCurrent;
	}
	public void setUpsOutputCurrent(float upsOutputCurrent) {
		UpsOutputCurrent = upsOutputCurrent;
	}
	public float getUpsBatteryVoltage() {
		return UpsBatteryVoltage;
	}
	public void setUpsBatteryVoltage(float upsBatteryVoltage) {
		UpsBatteryVoltage = upsBatteryVoltage;
	}
	public float getUpsBatteryCurrent() {
		return UpsBatteryCurrent;
	}
	public void setUpsBatteryCurrent(float upsBatteryCurrent) {
		UpsBatteryCurrent = upsBatteryCurrent;
	}
	public float getUpsAuxVoltage() {
		return UpsAuxVoltage;
	}
	public void setUpsAuxVoltage(float upsAuxVoltage) {
		UpsAuxVoltage = upsAuxVoltage;
	}
	public float getUpsAuxCurrent() {
		return UpsAuxCurrent;
	}
	public void setUpsAuxCurrent(float upsAuxCurrent) {
		UpsAuxCurrent = upsAuxCurrent;
	}
	public float getUpsExtTemperature() {
		return UpsExtTemperature;
	}
	public void setUpsExtTemperature(float upsExtTemperature) {
		UpsExtTemperature = upsExtTemperature;
	}
	public float getUpsBatteryResistant() {
		return UpsBatteryResistant;
	}
	public void setUpsBatteryResistant(float upsBatteryResistant) {
		UpsBatteryResistant = upsBatteryResistant;
	}
	public float getUpsBatChargePerc() {
		return UpsBatChargePerc;
	}
	public void setUpsBatChargePerc(float upsBatChargePerc) {
		UpsBatChargePerc = upsBatChargePerc;
	}
	public float getUpsBatChargeCap() {
		return UpsBatChargeCap;
	}
	public void setUpsBatChargeCap(float upsBatChargeCap) {
		UpsBatChargeCap = upsBatChargeCap;
	}
	public float getUpsBootCycle() {
		return UpsBootCycle;
	}
	public void setUpsBootCycle(float upsBootCycle) {
		UpsBootCycle = upsBootCycle;
	}
	public float getUpsOperatingTime() {
		return UpsOperatingTime;
	}
	public void setUpsOperatingTime(float upsOperatingTime) {
		UpsOperatingTime = upsOperatingTime;
	}
	public float getUpsBatOperateTime() {
		return UpsBatOperateTime;
	}
	public void setUpsBatOperateTime(float upsBatOperateTime) {
		UpsBatOperateTime = upsBatOperateTime;
	}
	public float getUpsState4000() {
		return UpsState4000;
	}
	public void setUpsState4000(float upsState4000) {
		UpsState4000 = upsState4000;
	}
	public float getUpsState4010() {
		return UpsState4010;
	}
	public void setUpsState4010(float upsState4010) {
		UpsState4010 = upsState4010;
	}
	public float getUpsState4020() {
		return UpsState4020;
	}
	public void setUpsState4020(float upsState4020) {
		UpsState4020 = upsState4020;
	}
	public float getUpsState4030() {
		return UpsState4030;
	}
	public void setUpsState4030(float upsState4030) {
		UpsState4030 = upsState4030;
	}
}
