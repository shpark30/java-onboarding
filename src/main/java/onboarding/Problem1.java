package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /* 예외 사항 */
        if (except(pobi) | except(crong)) {
            return -1;
        }

        /* 점수 목록 */
        List<Integer> scoresPobi = merge(mapToSum(pobi), mapToMul(crong));
        List<Integer> scoresCrong = merge(mapToSum(crong), mapToMul(crong));

        /* 최대 점수 */
        int maxPobi = Collections.max(scoresPobi);
        int maxCrong = Collections.max(scoresCrong);

        /* 결과 반환 */
        int answer = 0;
        if (maxPobi < maxCrong) {
            answer = 2;
        } else if (maxPobi > maxCrong) {
            answer = 1;
        }
        return answer;
    }

    static boolean except(List<Integer> pageList) {
        /* pageList의 길이 = 2 */
        if (pageList.size()!=2) {
            return true;
        }
        /* left는 홀수, right는 짝수 */
        if (pageList.get(0)%2!=1 | pageList.get(1)%2!=0) {
            return true;
        }
        /* left = right - 1 */
        if (pageList.get(1)-pageList.get(0)!=1) {
            return true;
        }
        /* 1 <= left page <= 399 and 2 <= right page <= 400 */
        if (pageList.get(0)<1 | pageList.get(0)>399 | pageList.get(1)<2 | pageList.get(1)>400) {
            return true;
        }
        return false;
    }

    static int sumDigits(int digits){
        /* 정수 digit가 주어졌을 때 자리수별 숫자의 합을 return */
        int sum = 0;
        while(digits!=0) {
            sum += digits%10;   // digit를 10으로 나눈 나머지(자리수 숫자)를 sum에 더한다.
            digits /= 10;   // digit를 10으로 나눈 몫을 digit에 저장한다.
        }
        return sum;
    }

    static int multiplyDigits(int digits) {
        /* 숫자 digit가 주어졌을 때 자리수별 숫자의 곱을 return */
        int mul = 1;
        while(digits!=0) {
            mul *= digits%10;   // digit를 10으로 나눈 나머지(자리수 숫자)를 mul에 곱한다.
            digits /= 10;   // digit를 10으로 나눈 볷을 digit에 저장한다.
        }
        return mul;
    }

    static List<Integer> mapToSum(List<Integer> intList) {
        List<Integer> sumList =  new ArrayList<>(intList);
        sumList.replaceAll(i -> sumDigits(i));
        return sumList;
    }

    static List<Integer> mapToMul(List<Integer> intList) {
        List<Integer> mulList =  new ArrayList<>(intList);
        mulList.replaceAll(i -> multiplyDigits(i));
        return mulList;
    }

    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        return merged;
    };
}