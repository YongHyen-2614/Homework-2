package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Double> resultHistory;

    public Calculator() {
        this.resultHistory = new ArrayList<>();
    }

    public Calculator(List<Double> resultHistory) {
        this.resultHistory = resultHistory;
    }

    public int calculate(int num1, int num2, char operator)
            throws InvalidOperatorException, DivideByZeroException {
        int result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    throw new DivideByZeroException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                }
                yield num1 / num2;
            }
            default -> throw new InvalidOperatorException("유효하지 않은 연산자입니다: " + operator);
        };

        // 계산 결과를 내부 리스트에 저장
        resultHistory.add((double) result);
        // 결과 반환
        return result;
    }
    // 가장 오래된 결과 삭제
    public void removeResult() {
        if (!resultHistory.isEmpty()) {
            resultHistory.removeFirst();
        }
    }
    // 연산 결과 전체 조회 기능
    public void inquiryResults() {
        System.out.println("저장된 연산 결과 목록:");
        if (resultHistory.isEmpty()) {
            System.out.println("(저장된 결과가 없습니다.)");
            return;
        }
        // 결과값 출력
        for (Double result : resultHistory) {
            System.out.println(result);
        }
    }
}
