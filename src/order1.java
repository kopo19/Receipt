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

						System.out.print("��ǰ ��ȣ�� �Է��ϼ��� : ");
						inputNo = myInput.nextInt();
						
						Statement stmt = conn.createStatement();
						ResultSet rset = stmt.executeQuery("SELECT * FROM goods WHERE no=" + inputNo);

						if (rset.next()) {
							name = rset.getString(2);
							price = rset.getInt(3);
						} else {
							System.out.println("�ش��ϴ� ��ǰ�� �����ϴ�.");
						}
						rset.close();
						stmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

					System.out.print("���� ���� : ");
					count = myInput.nextInt();
					total = price * count;
                    totalPrice += total; 
					
					orderList.add(item);

					arrName.add(name);
					arrPrice.add(price);
					arrCount.add(count);
					arrTotal.add(total);
				

					System.out.println("���ΰ���, ���̼�");
					System.out.println("(��)�Ƽ����̼�.�д������");
					System.out.println("��ȭ:031-712-6018");
					System.out.println("����:���� ������ ���μ�ȯ�� 2748 (���)");
					System.out.println("��ǥ:������,��ȣ�� 213-81-52063");
					System.out.println("����:��⵵ ������ �д籸 ������ 165���� 38(������, �������� û����ȣ����Ʈ)");
					System.out.println("===========================================================");
					System.out.println("                  �Һ����߽ɰ濵(CCM) �������                   ");
					System.out.println("                ISO 9001 ǰ���濵�ý��� �������                 ");
					System.out.println("===========================================================");
					System.out.println("                  ��ȯ/ȯ�� 14��(06��15��)�̳�,                 ");
					System.out.println("            (����)������, ����ī�� ������ ���Ը��忡�� ����           ");
					System.out.println("                 ����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�                ");
					System.out.println("                  üũī�� ��� �� �ִ� 7�� �ҿ�                  ");
					System.out.println("===========================================================");
					System.out.println("POS 1014233                             2021.06.01 17:29:49");
					System.out.printf("     %s %s %s %s \n", "��ǰ��", "�ܰ�", "����", "�ݾ�");
					System.out.println("-------------------------------------------------------------");
					for (int i = 0; i < arrName.size(); i++) {
						System.out.printf("%-15s %21s %7d %10s\n", arrName.get(i), arrPrice.get(i), arrCount.get(i),
								                                   arrTotal.get(i));
					}
					int type;
					System.out.print("1. �߰�����, 2. �������� : ");
					type = myInput.nextInt();
					//myInput.close();
					if (type == 2) {
						for (int i = 0; i < arrName.size(); i++) {
							System.out.printf("%-15s %21s %7d %10s\n", arrName.get(i), arrPrice.get(i), arrCount.get(i),
									arrTotal.get(i));
						}
						System.out.println("-------------------------------------------------------------");
						System.out.printf("�հ� �ݾ�                                              %d\n", totalPrice);
						System.out.printf("���� �ݾ�                                                %d\n", 0);
						System.out.println("-------------------------------------------------------------");
						System.out.println("  ** ���γ��� :                                             ����");
						System.out.println("===========================================================");
						System.out.printf("�ſ�ī��                                             ", totalPrice);
						System.out.println("-----------------------------------------------------------");
						System.out.println("����ī��                                   515594************");
						System.out.printf("���ι�ȣ 39480525(0)                            ", totalPrice);
						System.out.println("-----------------------------------------------------------");
						System.out.println("���̼Ҹ����                                         1000659494");
						System.out.println("������� �����ݾ�: 11,000");
						System.out.println("�������ε�: 11                                  ��������Ʈ: 1,632");
						System.out.println("===========================================================");
						System.out.println("              2021. 06. 01  17:29:49 �д������               ");
						System.out.println("��ǰ �� ��Ÿ ���� : 1522-4400                                  ");
						System.out.println("����� �� �����̼� ���� ���� : 1599-2211                          ");
						System.out.println("                     2116300110214233                      ");
						break;
					}
				}// while (true);
				myInput.close();
			}
		}
	//}
//}