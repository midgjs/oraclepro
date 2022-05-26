package com.javaex.phone1;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		/*****************************
		 * switch case문으로 작성
		 * case에 괄호가 없어서 변수가 계속 유지된다.
		 * 변수를 공통으로 쓰거나 다른 이름으로 써야 된다
		*****************************/
		
		
		
		// PhoneDao 생성
		PhoneDao phoneDao = new PhoneDao();

		// 스캐너
		Scanner sc = new Scanner(System.in);
		
		// 공통변수
		
		int personId;
		String name;
		String hp;
		String company;
		int count; 

		// 시작화면 출력
		System.out.println("******************************************");
		System.out.println("*          전화번호 관리 프로그램        *");
		System.out.println("******************************************");

		// while 시작
		boolean run = true;
		while (run) {
			// 메뉴 출력6
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호: ");

			// 메뉴 입력
			int menuNum = sc.nextInt();
			sc.nextLine(); // 숫자 다음에 문자오면 나타내는 에러해결

			// switch() 시작
			switch (menuNum) {

			// 1(리스트)
			case 1:
				System.out.println("<1.리스트>");
				List<PersonVo> personList = phoneDao.getPersonList();

				for (PersonVo vo : personList) {
					System.out.print(vo.getPersonId() + ".   ");
					System.out.print(vo.getName() + "\t");
					System.out.print(vo.getHp() + "\t");
					System.out.print(vo.getCompany() + "\t");
					System.out.println("");
				}
				break;

			// 2(등록)
			case 2:
				System.out.println("<2.등록>");
				// 이름받기
				System.out.print("이름 > ");
				name = sc.nextLine();
				// 휴대전화 받기
				System.out.print("휴대전화 > ");
				hp = sc.nextLine();
				// 회사번호받기
				System.out.print("회사번호 > ");
				company = sc.nextLine();
				
				PersonVo insertVo = new PersonVo(name, hp, company);
				
				count = phoneDao.personInsert(insertVo);
				System.out.println("["+ count + "건 등록되었습니다.]");
				break;

			// 3(수정)
			case 3:
				System.out.println("<3.수정>");
				// personId
				System.out.print("번호 > ");
				personId = sc.nextInt();
				sc.nextLine();
				// 이름받기
				System.out.print("이름 > ");
				name = sc.nextLine();
				// 휴대전화 받기
				System.out.print("휴대전화 > ");
				hp = sc.nextLine();
				// 회사번호받기
				System.out.print("회사번호 > ");
				company = sc.nextLine();
				
				PersonVo updateVo = new PersonVo(personId,  name, hp, company);
				count = phoneDao.personUpdate(updateVo);
				System.out.println("["+ count + "건 수정되었습니다.]");
				break;

			// 4(삭제)
			case 4:
				System.out.println("<4.삭제>");
				System.out.print(">번호 : ");
				personId = sc.nextInt();
				count = phoneDao.personDelete(personId);
				System.out.println("["+ count + "건 삭제되었습니다.]");
				break;

			// 5(검색)
			case 5:
				System.out.println("<5.검색>");
				System.out.print("검색어 > ");
				String keword = sc.nextLine();
				
				List<PersonVo> searchPersonList = phoneDao.getPersonList(keword);

				for (PersonVo vo : searchPersonList) {
					System.out.print(vo.getPersonId() + ".   ");
					System.out.print(vo.getName() + "\t");
					System.out.print(vo.getHp() + "\t");
					System.out.print(vo.getCompany() + "\t");
					System.out.println("");
				}
				break;

			// 6(종료)
			case 6:
				run = false;
				break;

			// 없는 번호일때
			default:
				System.out.println("[다시 입력해주세요.]");
				break;

			}// switch() 종료

		} // while 종료

		// 종료화면
		System.out.println("");
		System.out.println("******************************************");
		System.out.println("*                   감사합니다           *");
		System.out.println("******************************************");

		sc.close();
	}

}