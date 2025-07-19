package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (InvalidOperatorException | DivideByZeroException e) {
                System.out.println("오류: " + e.getMessage());
            }

            // 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String removeInput = sc.next();
            if (removeInput.equalsIgnoreCase("remove")) {
                calculator.removeResult();
                System.out.println("삭제 완료.");
            }

            // 조회 (inquiry 입력 시 메서드 호출)
            System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 출력)");
            String inquiryInput = sc.next();
            if (inquiryInput.equalsIgnoreCase("inquiry")) {
                calculator.inquiryResults(); // 메서드 활용
            }

            // 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitInput = sc.next();
            if (exitInput.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        sc.close();
    }
}
