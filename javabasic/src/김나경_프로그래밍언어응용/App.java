package 김나경_프로그래밍언어응용;

// 자동차(Car), 기차(Train) - 클래스
// 탈것(Vehicle): 가속, 정차, 시동 - 인터페이스

// Car

// 공통속성
// 차량번호(vin): String
// 색상(dolor): String
// 시동상태(isStart): boolean

// 수동변속기자동차(ManualCar)
// 기어 상태(gear): int - setGear
// 수동 변속기 자동차는 0-6까지의 정수를 입력 받아 기어 상태를 변경할 수 있는 기능, 기어 변속 기능이 존재한다.

// 가속: accelerate - "수동 변속기 자동차가 가속합니다!"
// 정차: stop - "수동 변속기 자동차가 정차합니다!"
// 시동: setStart - 각 객체에 독립적으로 존재하는 시동 상태를 부정 값으로 변경
// 기어변속: 

// 자동변속기자동차(AutomaticCar)
//가속: accelerate - "자동 변속기 자동차가 가속합니다!"
//정차: stop - "자동 변속기 자동차가 정차합니다!"
//시동: setStart - 각 객체에 독립적으로 존재하는 시동 상태를 부정 값으로 변경

// Train

// 공통속성
// 열차번호(trainNumber): String
// 출발역(depatureStation): String
// 도착역(arrivalStation): String
// 시동상태(isStart): boolean

// 여객열차(PassengerTrain)
// 탑승객 수(passengerCount): int

//가속: accelerate - "여객 열차가 천천히 가속합니다!"
//정차: stop - "여객 열차가 천천히 정차합니다!"
//시동: setStart - 각 객체에 독립적으로 존재하는 시동 상태를 부정 값으로 변경

// 화물열차(FreightTrain)
// 화물무게(cargoWeight): double

//가속: accelerate - "화물 열차가 천천히 가속합니다!"
//정차: stop - "화물 열차가 천천히 정차합니다!"
//시동: setStart - 각 객체에 독립적으로 존재하는 시동 상태를 부정 값으로 변경

abstract class Car {
	protected String vin;
	protected String color;
	protected boolean isStart;
	
	void carInformation () {
		System.out.println("차량번호 : " + vin);
		System.out.println("색상 : " + color);
	}
	
}

class ManualCar extends Car implements ManualCarVehicle {
	protected int gear;
	
	ManualCar (String vin, String color) {
		this.vin = vin;
		this.color = color;
	}
	
	public void vehicle () {
		System.out.println("시동상태 : " + setStart);
		System.out.println(accelerate);
		System.out.println(stop);
	}
	
	void setGear(int gear) {
		if (gear < 0 && gear > 6) return;
		this.gear = gear;
		System.out.println("기어변속 : " + gear);
	}
	
}

class AutomaticCar extends Car implements AutomaticCarVehicle {
	
	AutomaticCar (String vin, String color) {
		this.vin = vin;
		this.color = color;
	}
		
	public void vehicle () {
		System.out.println("시동상태 : " + setStart);
		System.out.println(accelerate);
		System.out.println(stop);
	}
}

abstract class Train {
	protected String trainNumber;
	protected String depatureStation;
	protected String arrivalStation;
	protected boolean isStart;
	
	void trainInformation () {
		System.out.println("열차번호 : " + trainNumber);
		System.out.println("출발역 : " + arrivalStation);
		System.out.println("도착역 : " + depatureStation);
	}
}

class PassengerTrain extends Train implements PassengerTrainVehicle {
	private int passengerCount;
	
	PassengerTrain (String trainNumber, String depatureStation, String arrivalStation) {
		this.trainNumber = trainNumber;
		this.depatureStation = depatureStation;
		this.arrivalStation = arrivalStation;
	}
	
	public void vehicle () {
		System.out.println("시동상태 : " + setStart);
		System.out.println(accelerate);
		System.out.println(stop);
	}
	
	void setPassengerCount (int passengerCount) {
		this.passengerCount = passengerCount;
		System.out.println("탑승객 수 : " + passengerCount);
	}
}

class FreightTrain extends Train implements FreightTrainVehicle {
	private double cargoWeight;
	
	FreightTrain (String trainNumber, String depatureStation, String arrivalStation) {
		this.trainNumber = trainNumber;
		this.depatureStation = depatureStation;
		this.arrivalStation = arrivalStation;
	}
	
	public void vehicle () {
		System.out.println("시동상태 : " + setStart);
		System.out.println(accelerate);
		System.out.println(stop);
	}
	
	void setcargoWeight (double cargoWeight) {
		this.cargoWeight = cargoWeight;
		System.out.println("화물 무게 : " + cargoWeight);
	}
	
}

public class App {

	public static void main(String[] args) {
		
//		수동 변속기 자동차 { 차량번호 = “10가1234”, 색상 = “blue”, 시동 상태 = false, 기어 상태 = 0}
//		자동 변속기 자동차 { 차량번호 = “10가1234”, 색상 = “blue”, 시동 상태 = false}
//		여객 열차 { 열차번호 = “KTX001”, 출발역 = “서울”, 도착역 = “부산”, 시동 상태 = false, 탑승객 수 = 200 }
//		화물 열차 { 열차번호 = “Cargo001”, 출발역 = “부산”, 도착역 = “구미” 시동 상태 = true, 화물 무게 = 100.0 }
		
		ManualCar manualcar = new ManualCar("10가1234", "blue");
		AutomaticCar automaticcar = new AutomaticCar("10가1234", "blue");
		PassengerTrain passengertrain = new PassengerTrain("KTX001", "서울", "부산");
		FreightTrain freighttrain = new FreightTrain("Cargo001", "부산", "구미");
		
		
		manualcar.setGear(5);
		manualcar.carInformation();
		manualcar.vehicle();
		
		automaticcar.carInformation();
		automaticcar.vehicle();
		
		passengertrain.trainInformation();
		passengertrain.setPassengerCount(200);
		passengertrain.vehicle();
		
		freighttrain.trainInformation();
		freighttrain.setcargoWeight(100.0);
		freighttrain.vehicle();
		

	}

}
