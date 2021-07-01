package order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class order1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputNo;
		String name = null;
		int price = 0;
		int count;
		int total;
		int totalPrice = 0;
		Scanner myInput = new Scanner(System.in);
		ArrayList<ArrayList> orderList = new ArrayList<ArrayList>();
		ArrayList<String> arrName = new ArrayList<String>();
		ArrayList<Integer> arrCount = new ArrayList<Integer>();
		ArrayList<Integer> arrPrice = new ArrayList<Integer>();
		ArrayList<Integer> arrTotal = new ArrayList<Integer>();
	
		//while (true) {
			//arrName.clear();
			//arrCount.clear();
			//arrPrice.clear();

			while (true) {
				ArrayList item = new ArrayList();
				//do {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goodslist", "root",
								"hbe0476");

						System.out.print("상품 번호를 입력하세요 : ");
						inputNo = myInput.nextInt();
						
						Statement stmt = conn.createStatement();
						ResultSet rset = stmt.executeQuery("SELECT * FROM goods WHERE no=" + inputNo);

						if (rset.next()) {
							name = rset.getString(2);
							price = rset.getInt(3);
						} else {
							System.out.println("해당하는 상품이 없습니다.");
						}
						rset.close();
						stmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

					System.out.print("구매 갯수 : ");
					count = myInput.nextInt();
					total = price * count;
                    totalPrice += total; 
					
					orderList.add(item);

					arrName.add(name);
					arrPrice.add(price);
					arrCount.add(count);
					arrTotal.add(total);
				

					System.out.println("국민가게, 다이소");
					System.out.println("(주)아성다이소.분당수내점");
					System.out.println("전화:031-712-6018");
					System.out.println("본사:서울 강남구 남부순환로 2748 (도곡동)");
					System.out.println("대표:박정부,신호섭 213-81-52063");
					System.out.println("매장:경기도 성남시 분당구 내정로 165번길 38(수내동, 양지마을 청구금호아파트)");
					System.out.println("===========================================================");
					System.out.println("                  소비자중심경영(CCM) 인증기업                   ");
					System.out.println("                ISO 9001 품질경영시스템 인증기업                 ");
					System.out.println("===========================================================");
					System.out.println("                  교환/환불 14일(06월15일)이내,                 ");
					System.out.println("            (전자)영수증, 결제카드 지참후 구입매장에서 가능           ");
					System.out.println("                 포장/가격 택 훼손시 교환/환불 불가                ");
					System.out.println("                  체크카드 취소 시 최대 7일 소요                  ");
					System.out.println("===========================================================");
					System.out.println("POS 1014233                             2021.06.01 17:29:49");
					System.out.printf("     %s %s %s %s \n", "상품명", "단가", "수량", "금액");
					System.out.println("-------------------------------------------------------------");
					for (int i = 0; i < arrName.size(); i++) {
						System.out.printf("%-15s %21s %7d %10s\n", arrName.get(i), arrPrice.get(i), arrCount.get(i),
								                                   arrTotal.get(i));
					}
					int type;
					System.out.print("1. 추가구매, 2. 구매종료 : ");
					type = myInput.nextInt();
					//myInput.close();
					if (type == 2) {
						for (int i = 0; i < arrName.size(); i++) {
							System.out.printf("%-15s %21s %7d %10s\n", arrName.get(i), arrPrice.get(i), arrCount.get(i),
									arrTotal.get(i));
						}
						System.out.println("-------------------------------------------------------------");
						System.out.printf("합계 금액                                              %d\n", totalPrice);
						System.out.printf("할인 금액                                                %d\n", 0);
						System.out.println("-------------------------------------------------------------");
						System.out.println("  ** 할인내역 :                                             없음");
						System.out.println("===========================================================");
						System.out.printf("신용카드                                             ", totalPrice);
						System.out.println("-----------------------------------------------------------");
						System.out.println("신한카드                                   515594************");
						System.out.printf("승인번호 39480525(0)                            ", totalPrice);
						System.out.println("-----------------------------------------------------------");
						System.out.println("다이소멤버십                                         1000659494");
						System.out.println("적립대상 결제금액: 11,000");
						System.out.println("적립포인드: 11                                  가용포인트: 1,632");
						System.out.println("===========================================================");
						System.out.println("              2021. 06. 01  17:29:49 분당수내점               ");
						System.out.println("상품 및 기타 문의 : 1522-4400                                  ");
						System.out.println("멤버십 및 샵다이소 관련 문의 : 1599-2211                          ");
						System.out.println("                     2116300110214233                      ");
						break;
					}
				}// while (true);
				myInput.close();
			}
		}
	//}
//}