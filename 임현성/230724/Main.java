import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [Input]
 * Line 1 : 상근이의 숫자 카드 개수
 * Line 2 : 상근이의 숫자 카드 배열 (" "로 분리되어 있음)
 * Line 3 : 찾아야할 숫자 카드 개수
 * Line 4 : 찾아야할 숫자 카드 배열 (" "로 분리되어 있음)
 * [Output]
 * Line 1 : 찾은 숫자 카드 개수 배열 (" "로 분리되어 있음)
 * [Algorithm]
 * 자료 구조
 * 정렬
 * 이분 탐색
 * 해시를 사용한 집합과 맵
 * [Result]
 * 메모리 : 165524 kb
 * 수행시간 : 1312 ms
 */
public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        numberCard2();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static List<String> stringToArray(String source, String regex){
        return Arrays.stream(source.split(regex)).collect(Collectors.toList());
    }

    private static void numberCard2() {
        readInput();
        StringTokenizer cardList = new StringTokenizer(readInput(), " ");
        readInput();
        ArrayList<String> matchList = (ArrayList<String>) stringToArray(readInput(), " ");

        writeOutput(findingCardCount(cardList, matchList));
    }

    private static String findingCardCount(StringTokenizer cardList, ArrayList<String> matchList) {
        HashMap<String, Integer> matchMap = new HashMap<>();
        matchList.forEach(n -> matchMap.put(n, 0));
        while (cardList.hasMoreTokens()){
            String card = cardList.nextToken();
            Integer cnt = matchMap.get(card);
            if(cnt != null) matchMap.replace(card, cnt+1);
        }
        StringBuilder sb = new StringBuilder();
        matchList.forEach(n -> sb.append(matchMap.get(n)).append(" "));
        return sb.substring(0, sb.length()-1);
    }
}