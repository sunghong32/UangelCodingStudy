package baekjoon.algorithm.simulation;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * [Algorithm]
 * 구현
 * 문자열
 * 파싱
 * [Result]
 * 메모리 : 18692 kb
 * 수행시간 : 236 ms
 */
public class YearProgressBar {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        yearProgressBar();
        stop();
    }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void yearProgressBar() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime date = LocalDateTime.parse(readInput(), formatter);
        double total = date.toLocalDate().lengthOfYear() * 1440.0;
        double now = (date.getDayOfYear()-1) * 1440.0 + date.getHour() * 60.0 + date.getMinute();
        writeOutput(String.valueOf(now/total*100.0));
    }
}