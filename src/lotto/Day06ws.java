package lotto;

import java.util.Scanner;

public class Day06ws {

	public static void main(String[] args) {

		// LottoNumber Input
		Scanner sc = new Scanner(System.in);
		System.out.println("1~45의 숫자 중 중복없이 6개의 숫자를 입력하세요.");
		Integer userlottoNumber[] = new Integer[6];
		for (int i = 0; i < userlottoNumber.length; i++) {
			userlottoNumber[i] = Integer.parseInt(sc.nextLine());
		}
		for (int i : userlottoNumber) {
			System.out.print("내   번호는 :" + i + "\t");
		}
		System.out.println();
		////////////////////////////////
		// LottoNumber Create;
		////////////////////////////////
		Integer lottoNumber[] = new Integer[45];
		for (int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = i + 1;
		}
		////////////////////////////////
		// LottoNumber Mix;
		////////////////////////////////
		for (int i = 0; i < 10000000; i++) {
			int loc = (int) ((Math.random() * 44) + 1);
			int tmp = lottoNumber[0];
			lottoNumber[0] = lottoNumber[loc];
			lottoNumber[loc] = tmp;
		}
		////////////////////////////////
		// LottoNumber Select
		////////////////////////////////
		Integer selectLottoNumber[] = new Integer[6];
		for (int i = 0; i < 6; i++) {
			selectLottoNumber[i] = lottoNumber[i];
		}
		for (int i : selectLottoNumber) {
			System.out.print("당첨 번호는 :" + i + "\t");
		}
		System.out.println();
		////////////////////////////////
		// LottoNumber Check
		////////////////////////////////
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (userlottoNumber[i] == selectLottoNumber[j]) {
					count++;
				}
			}
		}
		System.out.println("맞는 번호의 숫자 :" + count);
		////////////////////////////////
		// Lotto Prize Creat;
		////////////////////////////////
		double prize = (Math.random() * 9000000000L) + 1000000000L;
		String str = String.format("%,7.0f", prize);
		System.out.println("총 당첨금     : " + str + "원 입니다.");

		/*
		 * BigDecimal random = new BigDecimal(Math.random()); BigDecimal gop = new
		 * BigDecimal("9000000000"); BigDecimal hop = new BigDecimal("1000000000");
		 * BigDecimal tmpval = random.multiply(gop); BigDecimal prize = tmpval.add(hop);
		 * System.out.println("총 당첨금은 :" + prize); BigDecimal zero = new
		 * BigDecimal("0"); BigDecimal fourth = new BigDecimal("0.05"); BigDecimal third
		 * = new BigDecimal("0.1"); BigDecimal second = new BigDecimal("0.2");
		 * BigDecimal first = new BigDecimal("0.5");
		 */

		// Lotto Win Result
		switch (count) {
		case 0:
			prize = prize * 0;
			break;
		case 1:
			prize = prize * 0;
			break;
		case 2:
			prize = prize * 0;
			break;
		case 3:
			prize = prize * 0.05;
			break;
		case 4:
			prize = prize * 0.1;
			break;
		case 5:
			prize = prize * 0.2;
			break;
		case 6:
			prize = prize * 0.5;
			;
			break;
		}
		String str2 = String.format("%,6.1f", prize);
		System.out.println("당신의 당첨금 : " + str2 + "원 입니다.");

		sc.close();
	}
}