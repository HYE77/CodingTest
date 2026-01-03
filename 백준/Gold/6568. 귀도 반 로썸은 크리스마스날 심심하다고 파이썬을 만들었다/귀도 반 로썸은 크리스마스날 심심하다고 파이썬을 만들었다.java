import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int[] memory = new int[32];

            // 첫 번째 명령어 저장
            memory[0] = Integer.parseInt(line.trim(), 2);

            // 나머지 31개 줄 읽어서 메모리 채우기
            for (int i = 1; i < 32; i++) {
                memory[i] = Integer.parseInt(br.readLine().trim(), 2);
            }

            // 초기화
            int adder = 0;
            int pc = 0;
            boolean halted = false;

            // 실행
            while (!halted) {
                int instruction = memory[pc]; // Fetch
                pc = (pc + 1) % 32;           // Increment PC (미리 증가)

                int opcode = instruction >> 5;   // 상위 3비트만 남기고 밀어버리기
                int operand = instruction & 31;  // 하위 5비트 값만 마스킹

                switch (opcode) {
                    case 0: // STA X
                        memory[operand] = adder;
                        break;
                    case 1: // LDA X
                        adder = memory[operand];
                        break;
                    case 2: // BEQ X
                        if (adder == 0) pc = operand;
                        break;
                    case 3: // NOP
                        break;
                    case 4: // DEC
                        adder = (adder + 255) % 256;
                        break;
                    case 5: // INC
                        adder = (adder + 1) % 256;
                        break;
                    case 6: // JMP X
                        pc = operand;
                        break;
                    case 7: // HLT
                        halted = true;
                        break;
                }
            }

            // 결과 출력 (8자리 이진수 포맷)
            System.out.println(formatBinary8(adder));
        }
    }

    private static String formatBinary8(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append((n >> i) & 1);
        }
        return sb.toString();
    }
}