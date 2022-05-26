package com.javaex.phone2;



import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		/*****************************
		 * if문으로 작성
		 * 괄호안에서 변수가 없어지므로 같은 이름의 변수를 쓸수 있다
		*****************************/
		
		
		
		// PhoneDao 생성
		PhoneDao phoneDao = new PhoneDao();

		// 스캐너
		Scanner sc = new Scanner(System.in);

		// 시작화면 출력
		System.out.println("******************************************");
		System.out.println("*          전화번호 관리 프로그램        *");
		System.out.println("******************************************");

		// while 시작
		while (true) {
			// 메뉴 출력6
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호: ");

			// 메뉴 입력
			int menuNum = sc.nextInt();
			sc.nextLine(); // 숫자 다음에 문자오면 나타내는 에러해결

			if (menuNum == 1) {
				System.out.println("<1.리스트>");
				List<PersonVo> personList = phoneDao.getPersonList();

				for (PersonVo vo : personList) {
					System.out.print(vo.getPersonId() + ".   ");
					System.out.print(vo.getName() + "\t");
					System.out.print(vo.getHp() + "\t");
					System.out.print(vo.getCompany() + "\t");
					System.out.println("");
				}
				
			} else if (menuNum == 2) {

				System.out.println("<2.등록>");
				// 이름받기
				System.out.print("이름 > ");
				String name = sc.nextLine();
				// 휴대전화 받기
				System.out.print("휴대전화 > ");
				String hp = sc.nextLine();
				// 회사번호받기
				System.out.print("회사번호 > ");
				String company = sc.nextLine();

				PersonVo insertVo = new PersonVo(name, hp, company);

				int count = phoneDao.personInsert(insertVo);
				System.out.println("[" + count + "건 등록되었습니다.]");

			} else if (menuNum == 3) {
				System.out.println("<3.수정>");
				// personId
				System.out.print("번호 > ");
				int personId = sc.nextInt();
				sc.nextLine();
				// 이름받기
				System.out.print("이름 > ");
				String name = sc.nextLine();
				// 휴대전화 받기
				System.out.print("휴대전화 > ");
				String hp = sc.nextLine();
				// 회사번호받기
				System.out.print("회사번호 > ");
				String company = sc.nextLine();

				PersonVo updateVo = new PersonVo(personId, name, hp, company);
				int count = phoneDao.personUpdate(updateVo);
				System.out.println("[" + count + "건 수정되었습니다.]");

			} else if (menuNum == 4) {
				System.out.println("<4.삭제>");
				System.out.print(">번호 : ");
				int personId = sc.nextInt();
				int count = phoneDao.personDelete(personId);
				System.out.println("[" + count + "건 삭제되었습니다.]");

			} else if (menuNum == 5) {
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

			} else if (menuNum == 6) {
				break;

			} else {
				System.out.println("[다시 입력해주세요.]");
				
			}

		} // while 종료

		// 종료화면
		System.out.println("");
		System.out.println("******************************************");
		System.out.println("*                   감사합니다           *");
		System.out.println("******************************************");

		sc.close();
	}

}