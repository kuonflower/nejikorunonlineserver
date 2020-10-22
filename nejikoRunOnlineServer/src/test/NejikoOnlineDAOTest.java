package test;

import java.util.List;

import dao.NejikoOnlineDAO;
import model.NejikoMileage;

public class NejikoOnlineDAOTest {

	public static void main(String[] args) {

		findNejikoMileageTest();
		resistNejikoMileageTest();

	}

	public static void findNejikoMileageTest(){
		NejikoOnlineDAO dao = new NejikoOnlineDAO();

		List<NejikoMileage> ranking = dao.findNejikoMileage();

		for(NejikoMileage score: ranking){
			System.out.println("Name : " + score.getName());

			System.out.println("Score : " + score.getScore());

		}
	}

	public static void resistNejikoMileageTest(){
		NejikoMileage testScore = new NejikoMileage("テスト",10);

		NejikoOnlineDAO dao = new NejikoOnlineDAO();
		boolean result = dao.registNejikoMileage(testScore);

		if(result){
			System.out.println("書き込み成功");
		}else{
			System.out.println("書き込み失敗");
		}
	}

}
