package test;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.NejikoLogic;
import model.NejikoMileage;

public class NejikoLogicTest {

	public static void main(String[] args) {

		findMileageTest();
		registMileageTest();

	}

	public static void findMileageTest(){
		NejikoLogic nejikoLogic = new NejikoLogic();

		try{

			String ranking = nejikoLogic.findMileage();
			System.out.println(ranking);
		}catch(JsonProcessingException e){
			e.printStackTrace();
		}
	}

	public static void registMileageTest(){
		NejikoMileage testScore = new NejikoMileage("テストロジック",10);

		NejikoLogic logic = new NejikoLogic();
		boolean result = logic.registMileage(testScore);

		if(result){
			System.out.println("書き込み成功");
		}else{
			System.out.println("書き込み失敗");
		}
	}

}
