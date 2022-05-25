package com.javaex.phone;

import java.util.List;
import java.util.Scanner;


public class PhoneApp {

	public static void main(String[] args) {
		
		PhoneDao phoneDao = new PhoneDao();
		
		String name = null;
		String hp = null;
		String company = null;
		int id = 0;
		
		//프로그램 시작
		
		Scanner sc = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("*	  전화번호 관리 프로그램          *");
		System.out.println("*******************************************");
		
		//반복시작
		while(true) {
			System.out.println("");
			System.out.println("1. 리스트  2.등록  3.수정  4.삭제  5.검색 6. 종료");
			System.out.println("-------------------------------------------");
			System.out.print(">메뉴번호: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 6) {
				//프로그램 종료 
				System.out.println("*******************************************");
				System.out.println("*	               감사합니다         *");
				System.out.println("*******************************************");
				break;
			} else if(menu == 1) {
				//리스트 출력
				System.out.println("<1.리스트>");
				List<PersonVo> personList = phoneDao.personSelect();
				
				for(int i=0; i<personList.size(); i++) {
				System.out.println(personList.get(i).getPersonId() + ".\t" + personList.get(i).getName() + "\t"
				 + personList.get(i).getHp() + "\t" + personList.get(i).getCompany());
				}
			} else if(menu == 2) {
				//신규등록
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				name = sc.nextLine();
				System.out.print(">휴대전화: ");
				hp = sc.nextLine();
				System.out.print(">회사전화: ");
				company = sc.nextLine();
				
				PersonVo v02 = new PersonVo(name, hp, company);
				phoneDao.personInsert(v02);

				System.out.println("[1건 등록되었습니다.]");
				
			} else if(menu == 3) {
				//수정
				System.out.println("3.수정");
				System.out.print("번호 > ");
				id = sc.nextInt();
				sc.nextLine(); 
				System.out.print("이름 > ");
				name = sc.nextLine();
				System.out.print("휴대전화 > ");
				hp = sc.nextLine();
				System.out.print("회사번호 > ");
				company = sc.nextLine();

				PersonVo v03 = new PersonVo(id, name, hp, company);
				phoneDao.personUpdate(v03);

				System.out.println();
			}
			else if(menu == 4) {
				//삭제
				System.out.println("<4.삭제>");
				System.out.print(">번호 : ");
				int num = sc.nextInt();
				sc.nextLine();
				
				phoneDao.personDelete(menu);
				System.out.println("[1건 삭제되었습니다.]");
				
			} else if(menu == 5) {
				//검색기능
				System.out.println("<5.검색>");
				System.out.print("검색어 > ");
				String keyword = sc.nextLine();
				
				List<PersonVo> personList = phoneDao.personSearch(keyword);
				
				for (int i = 0; i < personList.size(); i++) {
					String serchName = personList.get(i).getName();
					if (serchName.contains(keyword)) {
						System.out.print(personList.get(i).getPersonId() + "\t");
						System.out.print(personList.get(i).getName() + "\t");
						System.out.print(personList.get(i).getHp() + "\t");
						System.out.print(personList.get(i).getCompany() + "\t");
						System.out.println("");
					}
				}
				continue;
			} else {
				//메뉴에 없는 번호입력
				System.out.println("[다시 입력해 주세요.]");
			}
			
		}
		
		
		
		
		
		
		
		sc.close();
	}

}
