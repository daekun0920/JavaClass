package actor;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import actor.UseUtil;
import dataTable.StoreTable;

public class Owner extends Member {

	static Scanner sc;
	static ArrayList<StoreTable> storeTmp;
	
	static {
		sc = new Scanner(System.in);
		storeTmp = Business.storeList;
	}
	
	Owner(String memberId, String memberPw, String memberType) {
		super(memberId, memberPw, memberType);
		// TODO Auto-generated constructor stub
		
	}
	
	public void storeAdd() {
		//로그인한 점주만이 가능한 기능
		
		String storeId = this.getMemberId();
		String storeName = "";
		String storeAddr = "";
		String storeType = "";
		String storeTel = "";
		Integer favorite = 0;
		String tag = "";
		String menu = "";
		
		Business.title("가게 등록");
		
		System.out.print("식당의 상호를 입력하세요 : ");
		storeName = inAndCheck(storeName);
		
		System.out.print("식당의 주소를 입력하세요 : ");
		storeAddr = inAndCheck(storeAddr);
		
		//한식,일식,중식,양식,분식
		String[] tmp = {"한식", "일식", "양식", "중식", "분식"};
		
		while(true) {
			
			boolean flag = true;
			
			System.out.print("카테고리를 입력해주세요. [한식 | 일식 | 양식 | 중식 | 분식] : ");
			storeType = sc.nextLine();
			
			flag = UseUtil.isString(storeType);
			//문자열이면 true, 숫자면 false
			
			if(flag == true) {
				for(int i=0; i<tmp.length; i++) {
					if(storeType.equals(tmp[i])) {
						//배열 중 값 하나와 일치하면 유효하므로 루프를 탈출한다.
						flag = false;
						break;
					}
				}
				
				if(flag == true) {
					//카테고리 중에 없는 값이므로 재입력 안내를 한다.
					System.out.print("카테고리를 잘못입력하셨습니다. 재입력해주세요");
				} else {
					//카테고리 중 제대로 입력했으므로 루프를 탈출.
					System.out.println("식당 카테고리 입력 성공.");
					break;
				}
				
			} else {
				System.out.println("숫자를 입력하셨습니다, 올바른 식당 카테고리를 입력해주세요.");
			}
			
		}//end While -> 카테고리 선택 완료
		
		
		
		while(true) {
			//전화번호는 숫자만 // 빈문자열 체크, 027775555(9) ~ 01099991111(11) 사이값을 입력
			System.out.print("매장의 전화번호를 입력해주세요. [ex : 01099998888 ] : ");
			storeTel = sc.nextLine();
			//1. 빈문자열, 2 문자열의길이 9~11, 3. 해당문자열이 전체 숫자인지.
			
			
			boolean flag = UseUtil.isNum(storeTel);
			//입력값이 빈문자열이거나 숫자가 아니면 false
			
			if(flag == true) {
				//입력값이 숫자로 이루어짐
				
				if(storeTel.length() >= 9 && storeTel.length() <= 11) {
					//길이가 9~11 인 경우 참으로 전화번호 입력 성공.
					System.out.println("전화번호 입력 완료");
					break;
				} else {
					//전화번호의 길이가 부족하거나 초과한 경우
					System.out.println("전화번호의 길이는 9~11 자리로 입력해주세요.");
				}
				
				
			} else {
				//입력값에 문자가 포함되어졌다면
				System.out.println("전화번호는 숫자만 입력해주세요.");
			}
		}//전화번호 while end
		
		while(true) {
			System.out.println("가게를 나타내는 태그를 하나 입력해주세요. [ex : 달달한]");
			System.out.print("주의사항 : 한글 이외의 문자나 공백은 입력이 불가능합니다 : ");
			tag = sc.nextLine();
			
			boolean flag = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", tag); 
		
			if(flag == true) {
				//오로지 한글로만 이루어진 문자열
				System.out.println("태그 입력에 성공하셨습니다.");
				break;
			} else {
				//한글 이외의 공백이나 문자열이 포함됨
				System.out.println("태그 입력이 잘못됐습니다.");
			}
		}//end while 가게 태그
		
		menu = makeMenuForm(menu) + ";";
		tag = tag + ";";
		
		StoreTable t = new StoreTable(storeId, storeName, storeAddr, storeType, storeTel, favorite, tag, menu);
		storeTmp.add(t);
	}

	/*
	 * 메뉴를 넘겨받을 String 변수를 넘겨주면 메뉴의 유효성 검사를 완료하여
	 * 메뉴-가격 의 형식으로 반환해준다.
	 */
	private String makeMenuForm(String menu) {
		while(true) {
			System.out.print("가게의 대표메뉴를 입력해 주세요.[한글만 입력가능] : ");
			String m = sc.nextLine();
			
			boolean flag = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", m);
			if(flag == true) {
				//메뉴가 한글로만 잘 입력이 된 경우
				menu = m+"-";
				System.out.println("메뉴입력 성공");
				break;
			} else {
				System.out.println("메뉴는 한글입력만 가능합니다.");
			}
		}
		
		
		while(true) {
			System.out.print("대표메뉴의 가격을 입력해주세요.[ex : 10000] : ");
			String price = sc.nextLine();
			

			boolean flag = UseUtil.isNum(price);
			
			if(flag == true) {
				NumberFormat format = NumberFormat.getNumberInstance();
				long l = Long.parseLong(price);
				menu +=format.format(l)+"원";
				
				Business.clearScreen();
				System.out.println("가게 등록이 완료되었습니다.");
				
				break;
			} else {
				System.out.println("가격입력이 잘못됐습니다. 다시 입력해주세요.");
			}
		}
		return menu;
	}

	private String makeTagForm(String tag) {
		while(true) {
			System.out.print("가게의 대표태그를 입력해 주세요.[한글만 입력가능] : ");
			String t = sc.nextLine();
			
			boolean flag = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", t);
			if(flag == true) {
				//메뉴가 한글로만 잘 입력이 된 경우
				tag = t;
				System.out.println("태그입력 성공");
				break;
			} else {
				System.out.println("태그는 한글입력만 가능합니다.");
			}
		}
		return tag;
	}
	
	private String inAndCheck(String input) {
		//한글자 이상의 문자열 입력
		while(true) {
			input = sc.nextLine();
			
			if(input.length() > 0) {
				return input;
			} else {
				System.out.println("한 글자 이상 입력하세요");
			}
		}
	}
	
	public void storeDel() {
		// - 가게 삭제
	 	//>> 가게를 삭제하는 것은 (storeList에서 해당 점주의 아이디와 상호로 인덱스를 검사하고 삭제)
	 	//>> 점주는 본인 가게명을 입력함으로써 삭제할 수 있다.
	 	//>> 점주 본인의 가게가 하나도 없는 경우 삭제를 할 수 없다.
		// 최초 문자열 입력 실패에만 재입력을 받는다.
		
		System.out.print("삭제할 본인의 가게 상호를 입력하세요 : ");
		String storeName = "";
		storeName = inAndCheck(storeName);
		//빈 문자열을 벗어날때까지 입력받음.
		
		while(true) {

			int index = storePresent(storeName);
			//인덱스가 -1인 경우 해당 가게가 존재하지 않음
			//-1 이상인 경우 해당 위치가 찾는 가게 목록
			
			if(index == -1) {
				// 해당가게가 존재하지 않음.
				System.out.printf("[%s]가 가게목록에 존재하지 않습니다. \n", storeName);
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			} else {
				storeTmp.remove(index);
				System.out.printf("[%s] 가게목록에서 삭제했습니다. \n", storeName);
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			}
		}
		
		/*
		for(int i=0; i<storeTmp.size(); i++) {
			//리스트 내부에 해당 상호가 존재하는지 검사.
			
			String tmpStoreName = storeTmp.get(i).getStoreName();
			String tmpId = storeTmp.get(i).getStoreId();
			//저장된 상호와 아이디를 별도로 저장하여 현재 객체 내 변수와 비교한다.
			
			if(this.getMemberId().equals(tmpId) && storeName.equals(tmpStoreName)) {
				//점주 객체의 아이디, 입력한 상호명이 -> 배열내 아이디 상호 모두 일치하는 행을 삭제
				storeTmp.remove(i);
				System.out.printf("[%s] 가게목록에서 삭제했습니다. \n", storeName);
				break;
			}
			if(i == storeTmp.size()-1) {
				//마지막 인덱스까지 체크했는데 못 찾은 경우는 가게가 존재하지 않음.
				System.out.printf("[%s]가 가게목록에 존재하지 않습니다. \n", storeName);
			}
			*/
			//변경 이전코드
	}

	public void menuAdd() {

		//메뉴는 최대 5개까지 저장이 가능하다.
		//메뉴 입력은 빈문자열만 체크
		//메뉴를 읽어들어와 splie 이후 배열의 길이가 <5 면 추가 가능
		//5개의 메뉴 모두 등록되었습니다. 메뉴를 추가할 수 없습니다.
		//점주는 0개 이상의 매장을 가질 수 있으므로 상호를 입력받아 해당 매장을 존재를 먼저 체크한다.
		
		while(true) {
			System.out.print("메뉴를 추가하실 본인의 매장명을 입력하세요 : ");
			String storeName = sc.nextLine();
			
			Integer index = storePresent(storeName);
			if(index == -1) {
				//매장이 존재하지 않습니다.
				System.out.printf("[%s] 매장이 존재하지 않습니다. 이전 메뉴로 돌아갑니다. \n", storeName);
				break;
				
			} else {
				
				//인덱스에서 메뉴 정보를 가져와
				//메뉴만 추린뒤, 해당 메뉴가 있는지 먼저 검사.
				//갈비-12,000원;곱창-10,000원;순대국-5,000원;초계탕-10,000원;얼큰라면-3,000원;
				String[] tmpMenu = storeTmp.get(index).getMenu().split(";");
				for(int i=0; i<tmpMenu.length; i++) {
					String menu = tmpMenu[i].substring(0, tmpMenu[i].indexOf("-"));
					tmpMenu[i] = menu;
					//메뉴만 모두 tmpMenu에 이전
				}
				
				//추린 메뉴의 갯수가 5개인 경우 메뉴가 꽉 찼다며 메소드 종료
				//5개 미만인 경우 -> 새로운 메뉴 문자열을 만들어 index 에 추가.
				if(tmpMenu.length < 5) {
					
					String existingMenu = storeTmp.get(index).getMenu();
					String newMenu = "";
					newMenu = makeMenuForm(newMenu);
					
					//기존메뉴;새로운메뉴 <- 형식으로 변환하여 인덱스의 메뉴값에 넣어준다.
					String totalMenu = existingMenu+newMenu+";";
					storeTmp.get(index).setMenu(totalMenu);
					
					System.out.printf("새로운 메뉴 [%s] 를 추가했습니다. \n", newMenu);
					System.out.println("메뉴추가를 완료했습니다. 이전 메뉴로 돌아갑니다.");
					break;
					
				} else {
					System.out.println("메뉴추가가 더이상 불가능합니다. 이전 메뉴로 돌아갑니다.");
					break;
				}
			}
		}
		
		//내 가게의 유무 메소드
		
		
		
	}
	
	public void menuDel() {
		// - 메뉴 삭제
	 	//> 메뉴는 최소 한개이상 존재해야 한다.
	 	//> 메뉴가 하나뿐이면 삭제할 수 없다.
		//> 삭제 순서
		// 1. id 님이 메뉴를 삭제할 매장을 입력해주세요.
		// 2. id 님이 해당 매장에서 삭제할 메뉴를 입력해주세요.
		System.out.print("메뉴 삭제를 하실 매장명을 입력해주세요 : ");
		
		String storeName = "";
		
		storeName = inAndCheck(storeName);
		//빈 문자열을 벗어날때까지 상호를 입력받음.
		
		while(true) {

			Integer index = storePresent(storeName);
			//인덱스가 -1인 경우 해당 가게가 존재하지 않음
			//-1 이상인 경우 해당 위치가 찾는 가게 목록
			
			
			if(index == -1) {
				// 해당가게가 존재하지 않음.
				System.out.printf("[%s]가 가게목록에 존재하지 않습니다. \n", storeName);
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
				
			} else {
				// 해당가게가 존재하면 메뉴를 찾아 삭제.
				
				System.out.print("삭제하실 메뉴이름을 입력해주세요 : ");
				String delMenu = "";
				delMenu = inAndCheck(delMenu);
				
				//인덱스에서 메뉴 정보를 가져와
				//메뉴만 추린뒤, 해당 메뉴가 있는지 먼저 검사.
				//갈비-12,000원;곱창-10,000원;순대국-5,000원;초계탕-10,000원;얼큰라면-3,000원;
				String[] tmpMenu = storeTmp.get(index).getMenu().split(";");
				String[] tmp = storeTmp.get(index).getMenu().split(";");
				
				if(tmpMenu.length == 1) {
					//대표메뉴는 삭제하실 수 없습니다.
					System.out.println("대표메뉴는 삭제하실 수 없습니다. 이전 메뉴로 돌아갑니다.");
					break;
				} else {
					//메뉴가 2 이상인 경우.
					for(int i=0; i<tmpMenu.length; i++) {
						String menu = tmpMenu[i].substring(0, tmpMenu[i].indexOf("-"));
						tmp[i] = menu;
						//메뉴만 모두 tmpMenu에 이전
					}
				}
				//메뉴만 추린 tmpMenu
				for(int i=0; i<tmp.length; i++) {
					//일치하는 메뉴가 있는지 찾는다. 삭제는 replace 로 범위를 지정해본다.
					if(delMenu.equals(tmp[i])) {
						//삭제할 메뉴가 존재하는 경우
						//전체 메뉴에서 육개장-8,000원;곱창-10,000원;
						//삭제 메뉴가 곱창인 경우.
						//메뉴를 삭제하는 경우는 최소 2개 이상의 메뉴가 존재한다.
						
						//삭제해야할 인덱스를 리플레이스
						String modifyMenu = storeTmp.get(index).getMenu();
						modifyMenu = modifyMenu.replace(tmpMenu[i]+";", "");
						
						storeTmp.get(index).setMenu(modifyMenu);
						
						System.out.println("메뉴삭제를 완료했습니다. 이전 메뉴로 돌아갑니다.");
						break;
						
					}
					if(i == tmp.length-1) {
						System.out.println("해당 메뉴가 존재하지 않습니다. 이전 메뉴로 돌아갑니다.");
					}
				}
				break;

			}
		}
	}
		
	public void tagAdd() {
		
		while(true) {
			System.out.print("태그를 추가하실 본인의 매장명을 입력하세요 : ");
			String storeName = sc.nextLine();
			
			Integer index = storePresent(storeName);
			if(index == -1) {
				//매장이 존재하지 않습니다.
				System.out.printf("[%s] 매장이 존재하지 않습니다. 이전 메뉴로 돌아갑니다. \n", storeName);
				break;
				
			} else {
				
				//인덱스에서 태그 정보를 가져옴
				
				String[] tmpTag = storeTmp.get(index).getTag().split(";");
				
				
				//태그의 갯수가 5개인 경우 메뉴가 꽉 찼다며 메소드 종료
				//5개 미만인 경우 -> 새로운 태그 문자열을 만들어 index 에 추가.
				if(tmpTag.length < 5) {
					
					String existingTag = storeTmp.get(index).getTag();
					String newTag = "";
					newTag = makeTagForm(newTag);
					
					//기존태그;새로운태그 <- 형식으로 변환하여 인덱스의 메뉴값에 넣어준다.
					String totalTag = existingTag+newTag+";";
					storeTmp.get(index).setTag(totalTag);
					
					System.out.printf("새로운 태그 [%s] 를 추가했습니다. \n", newTag);
					System.out.println("태그추가를 완료했습니다. 이전 메뉴로 돌아갑니다.");
					break;
					
				} else {
					System.out.println("태그추가가 더이상 불가능합니다. 이전 메뉴로 돌아갑니다.");
					break;
				}
			}
		}
	}
	
	
	public void tagDel() {
		
		System.out.print("태그 삭제를 하실 매장명을 입력해주세요 : ");
		
		String storeName = "";
		
		storeName = inAndCheck(storeName);
		//빈 문자열을 벗어날때까지 상호를 입력받음.
		
		while(true) {

			Integer index = storePresent(storeName);
			//인덱스가 -1인 경우 해당 가게가 존재하지 않음
			//-1 이상인 경우 해당 위치가 찾는 가게 목록
			
			
			if(index == -1) {
				// 해당가게가 존재하지 않음.
				System.out.printf("[%s]가 가게태그에 존재하지 않습니다. \n", storeName);
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
				
			} else {
				// 해당가게가 존재하면 태그를 찾아 삭제.
				
				System.out.print("삭제하실 태그를 입력해주세요 : ");
				String delTag = "";
				delTag = inAndCheck(delTag);
				
				
				String[] tmpTag = storeTmp.get(index).getTag().split(";");
		
				
				if(tmpTag.length == 1) {
					//대표태그는 삭제하실 수 없습니다.
					System.out.println("대표태그는 삭제하실 수 없습니다. 이전 메뉴로 돌아갑니다.");
					break;
				} else {
					for(int i=0; i<tmpTag.length; i++) {
						//태그가 2개 이상 존재
						if(delTag.equals(tmpTag[i])) {
							//삭제할 메뉴가 존재하는 경우
							//전체 메뉴에서 육개장-8,000원;곱창-10,000원;
							//삭제 메뉴가 곱창인 경우.
							//메뉴를 삭제하는 경우는 최소 2개 이상의 메뉴가 존재한다.
							
							//삭제해야할 인덱스를 리플레이스
							String modifyTag = storeTmp.get(index).getTag();
							modifyTag = modifyTag.replace(tmpTag[i]+";", "");
							
							storeTmp.get(index).setTag(modifyTag);
							
							System.out.println("태그삭제를 완료했습니다. 이전 메뉴로 돌아갑니다.");
							break;
							
						}
						if(i == tmpTag.length-1) {
							System.out.println("해당 태그가 존재하지 않습니다. 이전 메뉴로 돌아갑니다.");
						}
					}
				}
				
				break;
			}
		}
		
		
	}
	
	/*	가게 삭제, 메뉴 추가, 메뉴 삭제, 태그 추가, 태그 삭제
	 *	공통 아이디와 상호값을 통해 해당 매장이 존재하는지 체크
	 *	매장이 존재하면 해당 매장의 인덱스를 반환하여, 바로 이용할 수 있다.
	 *	storeName = 입력받은 상호명
	 *	id	= 현재 점주의 아이디
	 */
	public Integer storePresent(String storeName) {
		
		String id = this.getMemberId(); // 점주 아이디
		
		for(int i=0; i<storeTmp.size(); i++) {
			String tmpId = storeTmp.get(i).getStoreId();
			String tmpStoreName = storeTmp.get(i).getStoreName();
			
			if(id.equals(tmpId) && storeName.equals(tmpStoreName)) {
				//해당하는 매장이 존재한다면
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return	"[" + getMemberId() + " "
				+ getMemberPw() + " " + getMemberType() + "]";
	}
	
	
}
