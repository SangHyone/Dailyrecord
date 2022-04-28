package kr.human.java0428;

public class AccountEx {
	public static void main(String[] args) {
		Account account1 = new Account("011-011", "이몽룡", 20_0000);
		account1.deposit(50000);
		
		System.out.println(account1);

		try {
			System.out.println(account1.withdraw(10_0000) + "원 출금");
			System.out.println(account1.withdraw(50_0000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
