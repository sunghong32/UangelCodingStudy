import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
 * 2023.10.20
 * BAEKJOON 1340번:연도 진행바
 * 메모리 : 18912 KB
 * 시간 : 240 ms
 * */

public class YearProgressBar {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException, ParseException {
    String str = br.readLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.US);
    LocalDateTime date = LocalDateTime.parse(str, formatter);
    double total = date.toLocalDate().lengthOfYear() * 24 * 60;
    double currentTime =
        (date.getDayOfYear() - 1) * 24 * 60 + date.getHour() * 60 + date.getMinute();
    bw.write((currentTime * 100.0 / total) + "");
    br.close();
    bw.close();
  }
}
